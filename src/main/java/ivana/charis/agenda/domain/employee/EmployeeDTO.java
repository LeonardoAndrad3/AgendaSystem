package ivana.charis.agenda.domain.employee;

import ivana.charis.agenda.domain.endereco.EnderecoDTO;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EmployeeDTO(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,

        String phone,

        String photo,

        String description,

        @NotNull
        Work work,

        @Valid
        EnderecoDTO endereco,
        String password
) {

        public EmployeeDTO(Employee data){
                this(data.getName(), data.getEmail(), data.getPhone(),data.getPhoto() ,data.getDescription(), data.getWork(), new EnderecoDTO(data.getEndereco()), data.getPassword());
        }
}
