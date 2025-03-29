package ivana.charis.agenda.infra.security;


import ivana.charis.agenda.auth.TokenService;
import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Authentication auth = null;

        if (session != null){
            auth = (Authentication) session.getAttribute("user");
            getToken(session);
        if (auth != null) {
//                var role = auth.getAuthorities().stream().findFirst().orElse(null);
//    //            var data = tokenService.getClaims(token);
//    //            if(role.getAuthority().contains("EMPLOYEE")) {
//    //                user = employeeRepository.findByEmail(data.get("sub").asString()).generatedUserLogin();
//    //            } else {
//    //                user = clientRepository.findByEmail(data.get("sub").asString()).generatedUserLogin();
//    //            }
                var authentication = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), auth.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request,response);
    }

    private String getToken(HttpSession session) {
        var token = session.getAttribute("token");

        if(token != null)
            return token.toString();

        return null;
    }
}
