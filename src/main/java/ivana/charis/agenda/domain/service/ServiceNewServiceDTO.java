package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.client.ClientDTO;
import ivana.charis.agenda.domain.employee.EmployeeDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ServiceNewServiceDTO(
        Long id,
        EmployeeDTO idEmployee,
        ClientDTO idClient,
        LocalDate date,
        LocalTime start,
        LocalTime end
) {
    public ServiceNewServiceDTO(Service data) {
        this(
                data.getId(),
                new EmployeeDTO(data.getEmployee()),
                new ClientDTO(data.getClient()),
                data.getDate(),
                data.getStart(),
                data.getEnding()
        );
    }
}
