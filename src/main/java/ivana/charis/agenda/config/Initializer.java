package ivana.charis.agenda.config;

import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.Employee;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import ivana.charis.agenda.domain.employee.Work;
import ivana.charis.agenda.domain.endereco.Endereco;
import ivana.charis.agenda.domain.service.Service;
import ivana.charis.agenda.domain.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

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

//        Endereco endereco = new Endereco("Rua ABC", "Centro", "12345-678", (short) 223, "Apto 101", "São Paulo", "SP");
//        Endereco endereco2 = new Endereco("Avenida XYZ", "Vila Nova", "54321-987", (short) 456, "Casa 202", "Rio de Janeiro", "RJ");
//
//        var e = new Employee(null, "Mariana", "maria@gmail.com", "(11) 96012-2205", "/photos/storage/maria.png", "Sou zika", Work.MANICURE, new ArrayList<>(), endereco, "$2a$12$9.CR6tp1e8dFaiocvF1dS.zbOysC78qFsgNBViPiCKirV665ut6OW");
//
////
//        var c = new Client(null, "Marcia", "marcia@gmail.com", "(11) 96041-2305", "/photos/storage/marcia.png", new ArrayList<>(), endereco2, "$2a$12$T/W8XG4ueNXZHYZRKkcnNOS1HONVPTftoOfWtGrXkaUexE37iBfHS");
////        user2.setClient(c);
////
//        c = cRep.save(c);
//        e = eRep.save(e);
////
//        sRep.saveAll(Arrays.asList(
//                new Service(null, eRep.getReferenceById(1l), cRep.getReferenceById(1l), LocalDateTime.parse("2024-03-27T15:10:21.559547400"),LocalDateTime.parse("2024-03-27T16:10:21.559547400"))
//        ));
//
//        System.out.println(LocalDateTime.now().minusHours(0));


    }
}
