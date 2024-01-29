package ivana.charis.agenda.util;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {

    private final List<LocalDateTime> times = new ArrayList<>();
    private final Integer CLOSED_SALON = 22;

    public List<LocalDateTime> generetedTimes(Integer day){

        var time = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        time = time.withDayOfMonth(day).withMinute(0);

        while(time.getHour() != CLOSED_SALON){
            time = time.plusMinutes(10);
            times.add(time);
        }

        return times;
    }

}
