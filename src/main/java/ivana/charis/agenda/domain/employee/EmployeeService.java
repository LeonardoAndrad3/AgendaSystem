package ivana.charis.agenda.domain.employee;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRepository rep;

    public List<EmployeeListDTO> findAll() {
        return rep.findAll().stream().map(EmployeeListDTO::new).toList();
    }

    public EmployeeDTO findById(Long id) {
        return rep.findById(id).map(EmployeeDTO::new).orElse(null);
    }

    public EmployeeProfileDTO findByEmail(String email) {
            System.out.println(email);
            var emp = rep.findByEmail(email);
            System.out.println(emp);
            return new EmployeeProfileDTO(emp);
    }

    public Employee save(EmployeeDTO dto){
        Employee employee = new Employee(dto);
        return rep.save(employee);
    }
}
