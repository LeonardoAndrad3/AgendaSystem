package ivana.charis.agenda.employee;

import ivana.charis.agenda.util.ConverterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository rep;


    public List<EmployeeDTO> findAll() {
        return rep.findAll().stream().map(ConverterClass::toEmployee).collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) {
        return rep.findById(id).map(ConverterClass::toEmployee).orElse(null);
    }

    public Employee save(EmployeeDTO dto){
        Employee employee = ConverterClass.toEmployee(dto);
        return rep.save(employee);
    }
}
