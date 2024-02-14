package ivana.charis.agenda.domain.employee;

import ivana.charis.agenda.domain.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EmployeeDTO(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^(\\(11\\) 9[0-9]{4}-[0-9]{4})|(\\(1[2-9]\\) [5-9][0-9]{3}-[0-9]{4})|(\\([2-9][1-9]\\) [5-9][0-9]{3}-[0-9]{4})$")
        String phone,

        String photo,

        String description,

        @NotNull
        Work work,

        @Valid
        EnderecoDTO endereco
) {

        public EmployeeDTO(Employee data){
                this(data.getName(), data.getEmail(), data.getPhone(), data.getPhoto(), data.getDescription(), data.getWork(), new EnderecoDTO(data.getEndereco()));
        }
}
