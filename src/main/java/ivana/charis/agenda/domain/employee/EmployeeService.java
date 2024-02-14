package ivana.charis.agenda.domain.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository rep;

    public List<ListEmployeeDTO> findAll() {
        return rep.findAll().stream().map(ListEmployeeDTO::new).collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) {
        return rep.findById(id).map(EmployeeDTO::new).orElse(null);
    }

    public Employee save(EmployeeDTO dto){
        Employee employee = new Employee(dto);
        return rep.save(employee);
    }
}
