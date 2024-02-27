package ivana.charis.agenda.domain.service;

import java.time.LocalDateTime;

public record ServiceListDTO(
        Long id,
        Long id_employee,
        Long id_client,
        LocalDateTime start,
        LocalDateTime end
){
    public ServiceListDTO(Service data){
        this(
                data.getId(),
                data.getEmployee().getId(),
                data.getClient().getId(),
                data.getStart(),
                data.getEnding()
        );
    }
}
