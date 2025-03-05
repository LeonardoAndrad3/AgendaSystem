package ivana.charis.agenda.domain.client;

import ivana.charis.agenda.domain.user.UserApplication;
import ivana.charis.agenda.domain.user.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail (String email);
}
