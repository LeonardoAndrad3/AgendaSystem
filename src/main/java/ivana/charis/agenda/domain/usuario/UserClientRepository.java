package ivana.charis.agenda.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Long> {
    UserDetails findByLogin(String username);
}
