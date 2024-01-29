package ivana.charis.agenda.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import ivana.charis.agenda.client.Client;
import ivana.charis.agenda.client.ClientRepository;
import ivana.charis.agenda.employee.Employee;
import ivana.charis.agenda.employee.EmployeeRepository;
import ivana.charis.agenda.employee.Work;
import ivana.charis.agenda.service.Service;
import ivana.charis.agenda.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class Initializer implements CommandLineRunner {

    @Autowired
    private ClientRepository cRep;

    @Autowired
    private EmployeeRepository eRep;

    @Autowired
    private ServiceRepository sRep;

    @Override
    public void run(String... args) throws Exception {

//        cRep.deleteAll();
//        eRep.deleteAll();
//        sRep.deleteAll();

        var e = new Employee(null, "Mariana", "maria@gmail.com", 11960122205f, "Sou zika", Work.MANICURE, new ArrayList<>());
        var c = new Client(null, "Marcia", "marcia@gmail.com", 11982322502f, "/photos/storage/i.png", 08012321f, new ArrayList<>());

        c = cRep.save(c);
        e = eRep.save(e);

        sRep.saveAll(Arrays.asList(
                new Service(null, e, c, LocalDateTime.parse("2024-01-27T11:10:21.559547400"),LocalDateTime.parse("2024-01-27T12:10:21.559547400")),
                new Service(null, e, c, LocalDateTime.parse("2024-01-27T13:10:21.559547400"),LocalDateTime.parse("2024-01-27T14:10:21.559547400"))
        ));

        System.out.println(LocalDateTime.now().minusHours(0));


    }
}
