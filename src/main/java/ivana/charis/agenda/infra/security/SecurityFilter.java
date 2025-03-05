package ivana.charis.agenda.infra.security;


import ivana.charis.agenda.auth.TokenService;
import ivana.charis.agenda.auth.User;
import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.client.ClientRepository;
import ivana.charis.agenda.domain.employee.Employee;
import ivana.charis.agenda.domain.employee.EmployeeRepository;
import ivana.charis.agenda.domain.user.UserLogin;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;
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

        var token = getToken(request);

        if(token != null) {
            var data = tokenService.getClaims(token);

            UserDetails user;

            if(data.get("rule").asString().equalsIgnoreCase("role_employee"))
                user = (UserDetails) employeeRepository.findByEmail(data.get("sub").asString());
            else
                user = (UserDetails) clientRepository.findByEmail(data.get("sub").asString());

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request) {
        var auth = request.getHeader("Authorization");

        if(auth != null)
            return auth.replace("Bearer ", "");

        return null;
    }
}
