package ivana.charis.agenda.controller;

import ivana.charis.agenda.domain.service.ServiceDTO;
import ivana.charis.agenda.domain.service.ServiceNewServiceDTO;
import ivana.charis.agenda.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService service;

    @PostMapping("/times")
    public ResponseEntity<List<LocalDateTime>> findServicesDate(@RequestPart Integer day){
        return ResponseEntity.ok().body(service.findAgenda(day));
    }

    @PostMapping
    public ResponseEntity addNewService(@RequestParam Integer day, @RequestBody ServiceNewServiceDTO data){

        var newService = service.addNewService(day, data);

        return ResponseEntity.ok(newService);
    }
}
