package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceNewServiceDTO;
import jakarta.validation.ValidationException;

public class ValidationOpenAndClose {

    private final int OPEN = 7;
    private final int CLOSE = 21;

    public void valid(ServiceNewServiceDTO data){

        var start = data.start().getHour();
        var end = data.end().getHour();

        if(start < OPEN || start > CLOSE || end < OPEN || end > CLOSE)
            throw new ValidationException("Sorry, salon not is open.");

    }

}
