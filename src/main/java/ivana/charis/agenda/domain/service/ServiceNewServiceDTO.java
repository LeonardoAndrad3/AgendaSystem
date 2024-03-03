package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.client.ClientDTO;
import ivana.charis.agenda.domain.employee.EmployeeDTO;

import java.time.LocalDateTime;

public record ServiceNewServiceDTO(
        Long id,
        EmployeeDTO idEmployee,
        ClientDTO idClient,
        LocalDateTime start,
        LocalDateTime end
) {
    public ServiceNewServiceDTO(Service data) {
        this(
                data.getId(),
                new EmployeeDTO(data.getEmployee()),
                new ClientDTO(data.getClient()),
                data.getStart(),
                data.getEnding()
        );
    }
}
