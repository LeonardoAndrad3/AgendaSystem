package ivana.charis.agenda.domain.service;


import ivana.charis.agenda.util.CalendarManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository rep;

    public List<LocalDateTime> findAgenda(Integer day){

        if(day < LocalDate.now().getDayOfMonth())
            throw new RuntimeException("Day is after in today date");

        CalendarManager c = new CalendarManager();

        var times = c.generetedTimes(day);
        var dateNow = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).withDayOfMonth(day).format(DateTimeFormatter.ISO_LOCAL_DATE);
        var services = rep.findAllByDay(LocalDate.parse(dateNow));

        for(ivana.charis.agenda.domain.service.Service service : services){
           times.removeIf(d -> service.getEnding().isAfter(d) && service.getStart().isBefore(d) );
        }

        return times;
    }

//    public Service addNewService(Integer day, ServiceDTO data){
//
//        Service response = null;
//        var times = rep.f();
//
//        return response;
//    }

}
