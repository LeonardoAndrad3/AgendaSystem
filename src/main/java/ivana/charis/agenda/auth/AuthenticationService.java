package ivana.charis.agenda.auth;

import ivana.charis.agenda.domain.user.UserLogin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    public String startSession(HttpServletRequest request, DataAuthentication data){
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = manager.authenticate(authenticationToken);
        var token = tokenService.generatedToken((GeneratedUser) authentication.getPrincipal());
        var user = (GeneratedUser) authentication.getPrincipal();

        HttpSession session = request.getSession(true);
        String randomId = UUID.randomUUID().toString();
        session.setMaxInactiveInterval(2*60*60);
        session.setAttribute("token", token);
        session.setAttribute("userId", authentication);
        session.setAttribute("userAuth", authentication);
        session.setAttribute("user", user);

        return token;
    }

    public boolean validSession(HttpServletRequest request){
        System.out.println(request.getSession(false).getCreationTime());
        return true;
    }
}
