package ivana.charis.agenda.util;

import ivana.charis.agenda.domain.service.ServiceTimeToWork;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {

    private final List<LocalTime> times = new ArrayList<>();

    //ARRUMAR GERAÇÃO DE HORARIOS

    public List<LocalTime> generetedTimes(List<ServiceTimeToWork> timeToWork){

        var time = LocalTime.of(InfoSalon.OPEN,0);
        createAgenda(time);

        for(ServiceTimeToWork service : timeToWork){
            times.removeIf(t -> t.isAfter(service.start()) && t.isBefore(service.ending()));
        }

        System.out.println(times);

        return times;
    }

    public void createAgenda(LocalTime e){
        while(e.getHour() != InfoSalon.CLOSE){
            times.add(e);
            e = e.plusMinutes(10);
        }
    }
}
