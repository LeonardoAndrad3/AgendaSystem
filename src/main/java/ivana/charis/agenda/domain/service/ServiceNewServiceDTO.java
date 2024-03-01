package ivana.charis.agenda.domain.service;

import java.time.LocalDateTime;

public record ServiceNewServiceDTO(
        Long idEmployee,
        Long idClient,
        LocalDateTime start,
        LocalDateTime end
) {
    public ServiceNewServiceDTO(Service data) {
        this(
                data.getEmployee().getId(),
                data.getClient().getId(),
                data.getStart(),
                data.getEnding()
        );
    }
}
