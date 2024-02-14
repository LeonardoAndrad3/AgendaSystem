package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.client.ClientDTO;
import ivana.charis.agenda.domain.employee.EmployeeDTO;

import java.time.LocalDateTime;

public record ServiceDTO(
        ClientDTO client,
        EmployeeDTO employee,
        LocalDateTime start,
        LocalDateTime end
        ) {
}
