package ivana.charis.agenda.domain.service.validations;

import ivana.charis.agenda.domain.employee.EmployeeRepository;
import ivana.charis.agenda.domain.service.ServiceAddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationServiceAlreadyMarked implements ValidationService {

    @Autowired
    private EmployeeRepository eRep;

    @Override
    public void valid(ServiceAddDTO data) {

        if(!eRep.findAgendaMarked(data.date(), data.start(), data.end(), data.idEmployee()))
            throw new RuntimeException("This date to already marked in us system");
    }
}
