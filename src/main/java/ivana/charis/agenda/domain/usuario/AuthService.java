package ivana.charis.agenda.domain.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private UserRepository user;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return user.findByLogin(login);
    }
}
