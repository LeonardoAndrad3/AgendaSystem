package ivana.charis.agenda.controller;

import ivana.charis.agenda.domain.employee.EmployeeDTO;
import ivana.charis.agenda.domain.employee.EmployeeService;
import ivana.charis.agenda.domain.employee.ListEmployeeDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody EmployeeDTO employee, UriComponentsBuilder currentUri){
        var save = service.save(employee);
        var uri = currentUri.path("/id").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeDTO(save));
    }
}