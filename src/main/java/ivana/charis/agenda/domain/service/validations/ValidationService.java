package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.service.ServiceAddDTO;
import ivana.charis.agenda.domain.service.ServiceNewServiceDTO;

public interface ValidationService {
    void valid(ServiceAddDTO data);
}
