package ivana.charis.agenda.util;


import ivana.charis.agenda.client.Client;
import ivana.charis.agenda.client.ClientDTO;
import ivana.charis.agenda.client.ClientRepository;
import ivana.charis.agenda.employee.Employee;
import ivana.charis.agenda.employee.EmployeeDTO;
import ivana.charis.agenda.employee.EmployeeService;
import ivana.charis.agenda.service.Service;
import ivana.charis.agenda.service.ServiceDTO;
import ivana.charis.agenda.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ConverterClass {

    @Autowired
    private static EmployeeService eService;

    @Autowired
    private static ClientRepository cService;

    public static Employee toEmployee(EmployeeDTO dto){
        return new Employee(
                null,
                dto.name(),
                dto.email(),
                dto.phone(),
                dto.description(),
                dto.work(),
                new ArrayList<>());
    }

    public static EmployeeDTO toEmployee(Employee employee){
        return new EmployeeDTO(
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDescription(),
                employee.getWork()
        );
    }

    public static Client toClient(ClientDTO dto){
        return new Client(
                null,
                dto.name(),
                dto.email(),
                dto.phone(),
                dto.photo(),
                dto.cep(),
                new ArrayList<>()
        );
    }

    public static ClientDTO toClient(Client client){
        return new ClientDTO(
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getPhoto(),
                client.getCep()
        );
    }

    public static ServiceDTO toService(Service service){
        return new ServiceDTO(
                toClient(service.getClient()),
                toEmployee(service.getEmployee()),
                service.getStart(),
                service.getFinish()
        );
    }

    public static Service toService(ServiceDTO dto){
        return new Service(
                null,
                toEmployee(dto.employee()),
                toClient(dto.client()),
                dto.start(),
                dto.finish()
        );
    }
}
