package ivana.charis.agenda.client;

import ivana.charis.agenda.service.ServiceDTO;

import java.util.List;

public record ClientDTO (
        String name,
        String email,
        Float phone,
        String photo,
        Float cep
){
}
