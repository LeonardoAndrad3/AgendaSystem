package ivana.charis.agenda.domain.service;

import java.time.LocalDateTime;

public record ServiceAddDTO(
        Long idEmployee,
        Long idClient,
        LocalDateTime start,
        LocalDateTime end
) {


}
