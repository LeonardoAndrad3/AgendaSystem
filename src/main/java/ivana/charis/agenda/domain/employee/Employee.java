package ivana.charis.agenda.domain.employee;

import ivana.charis.agenda.auth.GeneratedUser;
import ivana.charis.agenda.auth.User;
import ivana.charis.agenda.domain.endereco.Endereco;
import ivana.charis.agenda.domain.service.Service;
import ivana.charis.agenda.domain.user.UserLogin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements GeneratedUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(unique = true)
    @NotBlank
    private String email;

    @Column(unique = true)
    private String phone;

    private String photo;

    private String description;

    @Enumerated(EnumType.STRING)
    private Work work;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Service> services = new ArrayList<>();

    @Embedded
    private Endereco endereco;

    private String password;

    public Employee(EmployeeDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.photo = data.photo();
        this.description = data.description();
        this.work = data.work();
        this.endereco = new Endereco(data.endereco());
        this.password =  BCrypt.hashpw(data.password(), BCrypt.gensalt());
    }

    @Override
    public User generatedUser() {
        return new User(this.getId(),this.getName(),this.getEmail(),this.getWork(),"EMPLOYEE");
    }

    @Override
    public UserLogin generatedUserLogin() {
        return new UserLogin(this.getId(),this.getName(),this.getEmail(), this.getPassword(), this.getWork(), "CLIENT");
    }
}
