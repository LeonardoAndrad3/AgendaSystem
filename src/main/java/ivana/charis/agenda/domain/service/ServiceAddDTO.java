package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.employee.Work;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public record ServiceAddDTO(
        Long idEmployee,
        Long idClient,
        Work work,
        LocalDate date,
        LocalTime start,
        LocalTime end
) {
}
