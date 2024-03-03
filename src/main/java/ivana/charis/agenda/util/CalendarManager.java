package ivana.charis.agenda.util;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {

    private final List<LocalDateTime> times = new ArrayList<>();
    private final Integer END_SERVICES = 21;

    private LocalDateTime time = null;

    public List<LocalDateTime> generetedTimes(Integer day){

        var datOfMonth = LocalDateTime.now().getDayOfMonth();

        if(day > datOfMonth)
            createAgenda(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).withDayOfMonth(day).withHour(9).withMinute(0));
        else
            createAgenda(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).withDayOfMonth(day));

        return times;
    }


    public void createAgenda(LocalDateTime e){
        while(e.getHour() != END_SERVICES){
            times.add(e);
            e = e.plusMinutes(10);
        }
    }
}
