package ivana.charis.agenda.domain.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    @Autowired
    private ClientRepository rep;

    public List<ClientListDTO> findAll() { return rep.findAll().stream().map(ClientListDTO::new).collect(Collectors.toList());}

    public ClientDTO findById(Long id){ return rep.findById(id).map(ClientDTO::new).orElse(null);}

    public Client save(ClientDTO client){
        return rep.save(new Client(client));
    }

}
