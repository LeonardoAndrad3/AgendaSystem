package ivana.charis.agenda.controller;

import ivana.charis.agenda.domain.service.ServiceDTO;
import ivana.charis.agenda.domain.service.ServiceNewServiceDTO;
import ivana.charis.agenda.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceS;

    @GetMapping
    public ResponseEntity findAll(){
        var services = serviceS.findAll();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        var service = serviceS.findById(id);
        return ResponseEntity.ok(service);
    }

    @PostMapping("/date")
    public ResponseEntity<List<LocalDateTime>> findServicesDate(@RequestPart Integer day){
        return ResponseEntity.ok().body(serviceS.findAgenda(day));
    }

    @PostMapping()
    public ResponseEntity addNewService(@RequestParam Integer day, @RequestBody ServiceNewServiceDTO data, UriComponentsBuilder builder){

        var newService = serviceS.addNewService(day, data);
        var uri = builder.path("/services/{id}").buildAndExpand(newService.getId()).toUri();

        return ResponseEntity.created(uri).body(new ServiceNewServiceDTO(newService));
    }


}
