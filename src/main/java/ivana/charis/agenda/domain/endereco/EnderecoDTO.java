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
        String localidade,
        @NotBlank
        String uf,
        String complemento,

        String estado,
        Short numero
) {

        public EnderecoDTO(Endereco data) {
                this(data.getLogradouro(), data.getBairro(), data.getCep(), data.getLocalidade(), data.getUf(), data.getComplemento(), data.getEstado(), data.getNumero());
        }
}
