package ivana.charis.agenda.domain.client;

import ivana.charis.agenda.domain.employee.Employee;

public record ClientProfileDTO(
        String name,
        String profile
){

    public ClientProfileDTO(Client data){
        this(data.getName(), "Cliente");
    }
}
