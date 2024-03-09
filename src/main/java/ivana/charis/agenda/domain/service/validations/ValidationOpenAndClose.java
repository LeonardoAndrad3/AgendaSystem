package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceNewServiceDTO;
import ivana.charis.agenda.util.InfoSalon;
import jakarta.validation.ValidationException;

public class ValidationOpenAndClose {
    public void valid(ServiceNewServiceDTO data){

        var start = data.start().getHour();
        var end = data.end().getHour();

        if(start < InfoSalon.OPEN || start > InfoSalon.CLOSE || end < InfoSalon.OPEN || end > InfoSalon.CLOSE)
            throw new ValidationException("Sorry, salon not is open.");

    }

}
