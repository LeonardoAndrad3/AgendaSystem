package ivana.charis.agenda.util;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {

    private final List<LocalDateTime> times = new ArrayList<>();
    private final Integer END_SERVICES = 21;

    public List<LocalDateTime> generetedTimes(Integer day){

        var time = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        time = time.withDayOfMonth(day);

        while(time.getHour() != END_SERVICES){
            times.add(time);
            time = time.plusMinutes(10);
        }

        return times;
    }
}
