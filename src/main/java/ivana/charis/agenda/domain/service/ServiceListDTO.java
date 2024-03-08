package ivana.charis.agenda.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record ServiceListDTO(
        Long id,
        Long idEmployee,
        Long idClient,
        LocalDate date,
        LocalTime start,
        LocalTime end
){
    public ServiceListDTO(Service data){
        this(
                data.getId(),
                data.getEmployee().getId(),
                data.getClient().getId(),
                data.getDate(),
                data.getStart(),
                data.getEnding()
        );
    }
}
