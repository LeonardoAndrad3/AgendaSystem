package ivana.charis.agenda.domain.employee;

import ivana.charis.agenda.domain.endereco.Endereco;
import ivana.charis.agenda.domain.service.Service;
import ivana.charis.agenda.domain.usuario.UserClient;
import ivana.charis.agenda.domain.usuario.UserEmployee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee{

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
}
