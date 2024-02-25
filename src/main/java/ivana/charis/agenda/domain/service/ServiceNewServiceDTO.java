package ivana.charis.agenda.domain.service;

import java.time.LocalDateTime;

public record ServiceNewServiceDTO(
        Long id_employee,
        Long id_client,
        LocalDateTime start,
        LocalDateTime end
) {
}
