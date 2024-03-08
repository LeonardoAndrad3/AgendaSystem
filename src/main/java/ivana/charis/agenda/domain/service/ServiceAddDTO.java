package ivana.charis.agenda.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ServiceAddDTO(
        Long idEmployee,
        Long idClient,

        LocalDate date,
        LocalTime start,
        LocalTime end
) {


}
