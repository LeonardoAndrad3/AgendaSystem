package ivana.charis.agenda.domain.service;


import ivana.charis.agenda.domain.client.ClientListDTO;
import ivana.charis.agenda.domain.employee.EmployeeListDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public record ServiceListDTO(
        Long id,
        EmployeeListDTO Employee,
        ClientListDTO Client,
        LocalDate date,
        LocalTime start,
        LocalTime end

) {
    public ServiceListDTO(Service data) {
        this(
                data.getId(),
                new EmployeeListDTO(data.getEmployee()),
                new ClientListDTO(data.getClient()),
                data.getDate(),
                data.getStart(),
                data.getEnding()
        );
    }
}
