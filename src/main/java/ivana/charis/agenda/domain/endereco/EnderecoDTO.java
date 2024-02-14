package ivana.charis.agenda.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        Short numero
) {

        public EnderecoDTO(Endereco data) {
                this(data.getLogradouro(), data.getBairro(), data.getCep(), data.getUf(), data.getCidade(), data.getComplemento(), data.getNumero());
        }
}
