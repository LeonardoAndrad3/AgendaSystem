package ivana.charis.agenda.domain.employee;

import ivana.charis.agenda.domain.endereco.Endereco;
import ivana.charis.agenda.domain.service.Service;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

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

    public Employee(EmployeeDTO dto) {
        this.photo = dto.photo();
        this.description = dto.description();
        this.work = dto.work();
        this.endereco = new Endereco(dto.endereco());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
