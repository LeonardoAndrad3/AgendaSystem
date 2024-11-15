package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceAddDTO;
import ivana.charis.agenda.util.InfoSalon;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidationOpenAndClose implements ValidationService {

    @Override
    public void valid(ServiceAddDTO data){

        var start = data.start().getHour();
        var end = data.end().getHour();

        if(start < InfoSalon.OPEN || start > InfoSalon.CLOSE || end < InfoSalon.OPEN || end > InfoSalon.CLOSE)
            throw new ValidationException("Sorry, salon not is open.");

    }

}
