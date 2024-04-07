package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceNewServiceDTO;
import ivana.charis.agenda.util.InfoSalon;

import java.time.DayOfWeek;

public class ValidationDayOfWeek implements Validation{

    public void valid(ServiceNewServiceDTO data){

        var date = data.date().getDayOfWeek();

        InfoSalon.DayWeekClose.forEach(d -> {
            if(date.compareTo(d) == 0)
                throw new RuntimeException("This day week not valid");

        });

    }

}
