package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceAddDTO;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidationHours implements ValidationService {
    @Override
    public void valid(ServiceAddDTO data){
        var start = data.start().getHour();
        var end = data.end().getHour();

        System.out.println(start<end);

        if(start > end){
            throw new ValidationException("Time not valid");
        }
    }
}
