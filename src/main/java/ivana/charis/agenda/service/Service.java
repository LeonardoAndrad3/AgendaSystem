package ivana.charis.agenda.service;

import ivana.charis.agenda.client.Client;
import ivana.charis.agenda.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


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
    private LocalDateTime finish;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", employee=" + employee.getId() +
                ", client=" + client.getId() +
                ", date=" + start +
                ", end=" + finish +
                '}';
    }
}
