package ivana.charis.agenda.service;

import ivana.charis.agenda.client.ClientDTO;
import ivana.charis.agenda.employee.EmployeeDTO;

import java.time.LocalDateTime;

public record ServiceDTO(
        ClientDTO client,
        EmployeeDTO employee,
        LocalDateTime start,
        LocalDateTime finish
        ) {
}
