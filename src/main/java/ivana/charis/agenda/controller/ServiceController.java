package ivana.charis.agenda.controller;

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
    public ResponseEntity<List<LocalDateTime>> findServicesDate(@RequestPart Integer date){
        return ResponseEntity.ok().body(service.findAgenda(date));
    }


}