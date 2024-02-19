package ivana.charis.agenda.domain.usuario;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class User{

    private String login;

    private String senha;
}
