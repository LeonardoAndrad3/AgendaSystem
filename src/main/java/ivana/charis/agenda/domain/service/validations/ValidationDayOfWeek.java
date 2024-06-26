package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceAddDTO;
import ivana.charis.agenda.util.InfoSalon;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidationDayOfWeek implements ValidationService, ValidationsFindAgenda {

    public void valid(ServiceAddDTO data){

        var date = data.date().getDayOfWeek();

        InfoSalon.DayWeekClose.forEach(d -> {
            if(date.compareTo(d) == 0)
                throw new RuntimeException("This day week not valid");

        });

    }

    @Override
    public void valid(LocalDate date){
        InfoSalon.DayWeekClose.forEach(d -> {
            if(date.getDayOfWeek().compareTo(d) == 0)
                throw new RuntimeException("This day week not valid");
        });
    }
}
