package ivana.charis.agenda.domain.service;


import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import ivana.charis.agenda.domain.service.validations.ValidationDayOfWeek;
import ivana.charis.agenda.domain.service.validations.ValidationService;
import ivana.charis.agenda.domain.service.validations.ValidationsFindAgenda;
import ivana.charis.agenda.util.CalendarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    public ServiceNewServiceDTO addNewService(ServiceAddDTO data){
        validations.forEach(v -> v.valid(data));

        var client = cRep.getReferenceById(data.idClient());
        var employee = eRep.getReferenceById(data.idEmployee());
        var service = rep.save(new Service(null, employee, client, data.date(), data.start(), data.end()));

        return new ServiceNewServiceDTO(service);
    }

    public Page<ServiceListDTO> findAll(Pageable pg) {
        return rep.findAll(pg).map(ServiceListDTO::new);
    }

    public ServiceDTO findById(Long id) {

        var service = rep.findById(id).orElseThrow(() -> new RuntimeException("Id Not found"));

        return new ServiceDTO(service);
    }
}
