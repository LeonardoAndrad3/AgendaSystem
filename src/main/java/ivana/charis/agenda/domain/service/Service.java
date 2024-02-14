package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Client client;
    private LocalDateTime start;
    private LocalDateTime ending;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", employee=" + employee.getId() +
                ", client=" + client.getId() +
                ", date=" + start +
                ", end=" + ending +
                '}';
    }
}
