package ivana.charis.agenda.domain.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ivana.charis.agenda.domain.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientDTO (

        @NotBlank
        Long CPF,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotNull
        String phone,
        String photo,
        @NotNull
        String password,
        @Valid
        @JsonDeserialize
        EnderecoDTO endereco
){
        public ClientDTO(Client data) {
                this(data.getCPF(),data.getName(), data.getEmail(), data.getPhone(), data.getPhoto(), data.getPassword(), new EnderecoDTO(data.getEndereco()));
        }
}
