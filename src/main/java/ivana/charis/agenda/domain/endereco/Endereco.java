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
    private String localidade;
    private String estado;
    private String uf;

    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.localidade = dados.localidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.estado = dados.estado();
    }

    public void atualizarInformacoes(EnderecoDTO data) {
        if(validar(data.logradouro())) this.logradouro = data.logradouro();
        if(validar(data.logradouro())) this.logradouro = data.logradouro();
        if(validar(data.bairro())) this.bairro = data.bairro();
        if(validar(data.cep())) this.cep = data.cep();
        if(validar(data.numero())) this.numero = data.numero();
        if(validar(data.complemento())) this.complemento = data.complemento();
        if(validar(data.localidade())) this.localidade = data.localidade();
        if(validar(data.uf())) this.uf = data.uf();
    }

    public <T> boolean validar(T data){
        return Validation.notNull(data);
    }
}
