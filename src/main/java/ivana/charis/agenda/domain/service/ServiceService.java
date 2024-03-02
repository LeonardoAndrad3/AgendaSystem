package ivana.charis.agenda.domain.service;


import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import ivana.charis.agenda.util.CalendarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<LocalDateTime> findAgenda(Integer day, Long idEmployee){

        if(LocalDate.now().getDayOfMonth() > day)
            throw new RuntimeException("Day is after in today date");

        CalendarManager c = new CalendarManager();

        var times = c.generetedTimes(day);

        var date = dateNow.withDayOfMonth(day).format(DateTimeFormatter.ISO_LOCAL_DATE);
        var services = rep.findAllByDayAndEmployee(LocalDate.parse(date), idEmployee);

        for(ivana.charis.agenda.domain.service.Service service : services){
           times.removeIf(d -> service.getStart().isBefore(d) && service.getEnding().isAfter(d));
        }

        return times;
    }

    public Service addNewService(Integer day, ServiceNewServiceDTO data){

//        var date = dateNow.withDayOfMonth(day).format(DateTimeFormatter.ISO_LOCAL_DATE);
//        var services = rep.findAllByDay(LocalDate.parse(date));
//        List<LocalDateTime> times = findAgenda(day).stream().filter( d -> d.isAfter(data.start())&&  d.isBefore(data.end())).toList();

        //This algorithm usage for search service marked in us system
        //PLEASE THIS CODE IS DANGED WITH BIG DATA
//        for(Service service : services){
//            if(
//                    (data.start().isBefore(service.getStart()) && service.getStart().isBefore(data.end()))
//                    ||
//                    (data.start().isBefore(service.getEnding()) && service.getEnding().isBefore(data.end()))
//            )
//                throw new RuntimeException("Sorry, the time marked is exist in us system");
//        }


        System.out.println(eRep.findAgendaMarked(data.start(), data.end(), data.idEmployee()));
            throw new RuntimeException("Sorry, the time you want marked is exist in us system");
    }

    public Page<ServiceListDTO> findAll(Pageable pg) {
        return rep.findAll(pg).map(ServiceListDTO::new);
    }

    public ServiceDTO findById(Long id) {

        var service = rep.findById(id).orElseThrow(() -> new RuntimeException("Id Not found"));

        return new ServiceDTO(service);
    }
}
