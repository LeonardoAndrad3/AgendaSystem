package ivana.charis.agenda.service;


import ivana.charis.agenda.util.CalendarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository rep;

    public List<LocalDateTime> findAgenda(Integer date){
        CalendarManager c = new CalendarManager();

        var times = c.generetedTimes(date);
        var dateNow = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).withDayOfMonth(date).format(DateTimeFormatter.ISO_LOCAL_DATE);

        var services = rep.findAllByDay(LocalDate.parse(dateNow));

        for(ivana.charis.agenda.service.Service service : services){
           times.removeIf(d -> service.getStart().isBefore(d) && service.getFinish().isAfter(d));
        }

        System.out.println(times);

        return times;
    }




}
