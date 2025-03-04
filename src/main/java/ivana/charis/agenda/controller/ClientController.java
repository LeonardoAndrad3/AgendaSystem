package ivana.charis.agenda.controller;

import ivana.charis.agenda.domain.client.ClientDTO;
import ivana.charis.agenda.domain.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientDTO client, UriComponentsBuilder currentURI){

        System.out.println(client);

        var save = service.save(client);
        var uri = currentURI.path("/id").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDTO(save));
    }
}
