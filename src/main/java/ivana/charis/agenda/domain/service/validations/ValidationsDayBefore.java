package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceAddDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidationsDayBefore implements ValidationService, ValidationsFindAgenda{

    @Override
    public void valid(ServiceAddDTO data) {

        if(data.date().isBefore(LocalDate.now()))
            throw new RuntimeException("we not marked day is before today");

    }

    @Override
    public void valid(LocalDate date) {
        if(date.isBefore(LocalDate.now()))
            throw new RuntimeException("we not marked day is before today");
    }
}
