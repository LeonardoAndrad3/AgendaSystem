package ivana.charis.agenda.domain.usuario;


import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
public class User {

    private String login;
    private String senha;


}
