package ivana.charis.agenda.domain.user;

import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ivana.charis.agenda.auth.User;

import java.util.Collections;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLoginService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("opa");
        if(username.contains("charis.emp")) {
            System.out.println("employee");
            var employee = employeeRepository.findByEmail(username);
            return new UserLogin(employee.getId(),employee.getName(),employee.getEmail(),employee.getPassword(),null,"CLIENT");
        } else {
            System.out.println("client");
            var client = clientRepository.findByEmail(username);
            return new UserLogin(client.getId(),client.getName(),client.getEmail(),client.getPassword(),null,"CLIENT");
        }
    }
}
