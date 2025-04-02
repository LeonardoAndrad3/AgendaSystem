package ivana.charis.agenda.domain.service;


import ivana.charis.agenda.auth.GeneratedUser;
import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.EmployeeListDTO;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import ivana.charis.agenda.domain.employee.Work;
import ivana.charis.agenda.domain.service.validations.ValidationDayOfWeek;
import ivana.charis.agenda.domain.service.validations.ValidationService;
import ivana.charis.agenda.domain.service.validations.ValidationsFindAgenda;
import ivana.charis.agenda.domain.user.UserLogin;
import ivana.charis.agenda.util.CalendarManager;
import ivana.charis.agenda.util.UserSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository rep;

    @Autowired
    private EmployeeRepository eRep;

    @Autowired
    private ClientRepository cRep;

    private LocalDateTime dateNow = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

    @Autowired
    private List<ValidationService> validations;

    @Autowired
    private List<ValidationsFindAgenda> validationsFindAgenda;

    public List<LocalTime> findAgenda(Integer day, Integer month, Long idEmployee){

        if(eRep.existsById(idEmployee)) {

            var date = LocalDate.parse(dateNow.withMonth(month).withDayOfMonth(day).format(DateTimeFormatter.ISO_LOCAL_DATE));
            validationsFindAgenda.forEach(v -> v.valid(date));

            CalendarManager c = new CalendarManager();

            var services = rep.findByDayAndEmployee(date, idEmployee);

            return c.generetedTimes(services, day, month);
        }

        throw new RuntimeException("Id not exist");
    }

    public ServiceNewServiceDTO addNewService(ServiceAddDTO data, HttpServletRequest request){

        var user = UserSession.getUser(request.getSession(false));
        ServiceAddDTO newS = null;



        if(user.getRole().equalsIgnoreCase("client"))
            newS = new ServiceAddDTO(data.idEmployee(),user.getId(),data.work(),data.date(),data.start(),data.start().plusMinutes(45));
        else if (user.getRole().equalsIgnoreCase("employee")) {
            newS = new ServiceAddDTO(user.getId(),data.idClient(),data.work(),data.date(),data.start(),data.start().plusMinutes(45));
        }



        ServiceAddDTO finalNewS = newS;
        validations.forEach(v -> v.valid(finalNewS));

//        if(data.work().name().equalsIgnoreCase(Work.MANICURE.name())){
//            System.out.printf("sim");
//            end = data.start().plusHours(1);
//        }

        var client = cRep.getReferenceById(finalNewS.idClient());
        var employee = eRep.getReferenceById(finalNewS.idEmployee());
        var service = rep.save(new Service(null, employee, client, newS.date(), newS.start(), newS.end(), Status.ENVIADO));

        return new ServiceNewServiceDTO(service);
    }

    public Page<ServiceListDTO> findAll(Pageable pg) {
        return rep.findAll(pg).map(ServiceListDTO::new);
    }

    public Page<ServiceListDTO> findAllById(HttpServletRequest request){
        var user = UserSession.getUser(request.getSession(false));
        System.out.println(user.getAuthorities());
        System.out.println(user.getRole().contentEquals("client"));
        System.out.println(user.getAuthorities());

        System.out.println(user);

        if(user.getRole().contains("CLIENT")){
            var servicesByPerson = cRep.getReferenceById(user.getId()).getWorks().stream().map(ServiceListDTO::new).toList();
            return new PageImpl<ServiceListDTO>(servicesByPerson);
        } else if(user.getRole().contains("EMPLOYEE")){
            var servicesByPerson = eRep.getReferenceById(user.getId()).getServices().stream().map(ServiceListDTO::new).toList();
            return new PageImpl<ServiceListDTO>(servicesByPerson);
        }

        return null;

//        return rep.findAllById(pg, user.getId());


//        if(user.getRole().equalsIgnoreCase("client")) {
//            return cRep.getReferenceById(user.getId()).getWorks().stream().map(ServiceListDTO::new);
//        } else{
//            return eRep.getReferenceById(user.getId()).getServices();
//        }
//    }

//    public Page<ServiceListDTO> findAll() {
//        return rep.findAll().stream().map();
    }


    public ServiceDTO findById(Long id) {

        var service = rep.findById(id).orElseThrow(() -> new RuntimeException("Id Not found"));

        return new ServiceDTO(service);
    }
}
