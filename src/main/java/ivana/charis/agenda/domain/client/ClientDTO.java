package ivana.charis.agenda.domain.client;

import ivana.charis.agenda.domain.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientDTO (

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotNull
        String phone,

        String photo,

        @Valid
        EnderecoDTO endereco
){
}
