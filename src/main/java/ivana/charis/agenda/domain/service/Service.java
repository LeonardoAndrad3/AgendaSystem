package ivana.charis.agenda.domain.service;

import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;


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
    private LocalDate date;
    private LocalTime start;
    private LocalTime ending;

    public Service(ServiceDTO dto){
        this.employee =  new Employee(dto.employee());
        this.client = new Client(dto.client());
        this.start = dto.start();
        this.ending = dto.end();
    }

    public Service(ServiceNewServiceDTO dto, Client client, Employee employee) {
        this.employee =  employee;
        this.client = client;
        this.start = dto.start();
        this.ending = dto.end();
    }

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
