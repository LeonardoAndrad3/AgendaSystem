package ivana.charis.agenda.employee;

import ivana.charis.agenda.service.Service;
import ivana.charis.agenda.service.ServiceDTO;

import java.util.List;

public record EmployeeDTO(

        String name,
        String email,
        Float phone,
        String description,
        Work work
) {
}
