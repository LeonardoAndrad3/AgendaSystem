package ivana.charis.agenda.domain.endereco;

import ivana.charis.agenda.util.Validation;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private Short numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public void atualizarInformacoes(EnderecoDTO data) {
        if(Validation.notNull(data.logradouro())) this.logradouro = data.logradouro();
        if(Validation.notNull(data.bairro())) this.bairro = data.bairro();
        if(Validation.notNull(data.cep())) this.cep = data.cep();
        if(Validation.notNull(data.numero())) this.numero = data.numero();
        if(Validation.notNull(data.complemento())) this.complemento = data.complemento();
        if(Validation.notNull(data.cidade())) this.cidade = data.cidade();
        if(Validation.notNull(data.uf())) this.uf = data.uf();
    }
}
