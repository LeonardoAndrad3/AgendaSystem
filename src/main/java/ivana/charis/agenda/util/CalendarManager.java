package ivana.charis.agenda.util;

import ivana.charis.agenda.domain.service.ServiceTimeToWork;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarManager {

    private final List<LocalTime> times = new ArrayList<>();

    //ARRUMAR GERAÇÃO DE HORARIOS

    public List<LocalTime> generetedTimes(List<ServiceTimeToWork> timeToWork, Integer day, Integer month){

        var time = LocalTime.of(InfoSalon.OPEN,0);
        createAgenda(time);

        if(day == LocalDate.now().getDayOfMonth() && month == LocalDate.now().getMonthValue()+1)
            times.removeIf(t -> t.isBefore(LocalTime.now()));

        for(ServiceTimeToWork service : timeToWork){
            times.removeIf(t -> t.isAfter(service.start()) && t.isBefore(service.ending()));
        }


        var listRemove = new ArrayList<>();

        for (int i = 0; i<times.size(); i++){

            var after = times.size()-1 > i ? times.get(i+1) : null;
            var before = i != 0 ? times.get(i-1) : null;

            if(before == null) {
                if (Duration.between(times.get(i), after).toMinutes() != 10) {
                    listRemove.add(times.get(i));
                }
            }
            else if(after == null) {
                if (Duration.between(before, times.get(i)).toMinutes() != 10) {
                    listRemove.add(times.get(i));
                }
            }
            else if(Duration.between(before, times.get(i)).toMinutes() != 10 && Duration.between(times.get(i), after).toMinutes() != 10) {
                listRemove.add(times.get(i));
            }
        }

        times.removeAll(listRemove);

        return times;
    }

    public void createAgenda(LocalTime e){
        while(e.getHour() != InfoSalon.CLOSE){
            times.add(e);
            e = e.plusMinutes(10);
        }
    }
}
