package ivana.charis.agenda.domain.usuario;


import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;

    @OneToOne
    private Client client;
}
