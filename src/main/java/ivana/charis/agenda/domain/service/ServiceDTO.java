package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.client.ClientDTO;
import ivana.charis.agenda.domain.employee.EmployeeDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ServiceDTO(
        ClientDTO client,
        EmployeeDTO employee,

        LocalDate date,
        LocalTime start,
        LocalTime end
        ) {
        public ServiceDTO(Service data) {
                this(new ClientDTO(data.getClient()), new EmployeeDTO(data.getEmployee()), data.getDate(), data.getStart(), data.getEnding());
        }
}
