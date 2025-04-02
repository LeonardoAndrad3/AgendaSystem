package ivana.charis.agenda.controller;

import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.client.ClientService;
import ivana.charis.agenda.domain.employee.EmployeeService;
import ivana.charis.agenda.domain.service.*;
import ivana.charis.agenda.domain.user.UserLogin;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceS;

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(sort = {"start"}, direction = Sort.Direction.ASC) Pageable pg){
        return ResponseEntity.ok().body(serviceS.findAll(pg));
    }

    @GetMapping("/byId")
    public ResponseEntity findAll(HttpServletRequest request){
        var services = serviceS.findAllById(request);
        return ResponseEntity.ok().body(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        var service = serviceS.findById(id);
        return ResponseEntity.ok(service);
    }

    @PostMapping("/timesToDate")
    public ResponseEntity findServicesDate(@RequestPart Integer day, @RequestPart Integer month,@RequestPart Long id){
        return ResponseEntity.ok().body(serviceS.findAgenda(day, month, id));
    }

    @PostMapping("/add")
    public ResponseEntity addNewService(@RequestBody ServiceAddDTO data, UriComponentsBuilder builder, HttpServletRequest request){
        var newService = serviceS.addNewService(data, request);
        var uri = builder.path("/services/{id}").buildAndExpand(newService.id()).toUri();

        return ResponseEntity.created(uri).body(newService);
    }
}
