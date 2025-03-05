package ivana.charis.agenda.domain.client;


import ivana.charis.agenda.auth.GeneratedUser;
import ivana.charis.agenda.auth.User;
import ivana.charis.agenda.domain.endereco.Endereco;
import ivana.charis.agenda.domain.service.Service;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private Long CPF;

    private String name;

    @NotBlank
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String photo;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Service> works;

    @Embedded
    private Endereco endereco;

    private String password;

    public Client(ClientDTO data){
        this.CPF = data.CPF();
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.photo = data.photo();
        this.password = BCrypt.hashpw(data.password(), BCrypt.gensalt());
        this.endereco = new Endereco(data.endereco());
    }

}
