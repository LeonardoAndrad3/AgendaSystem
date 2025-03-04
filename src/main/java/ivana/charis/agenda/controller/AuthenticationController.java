package ivana.charis.agenda.controller;

import ivana.charis.agenda.auth.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

        @Autowired
        private AuthenticationManager manager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity login(@RequestBody @Valid DataAuthentication data){
            var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            System.out.println("auth:" +authenticationToken);
            var authentication = manager.authenticate(authenticationToken);
            System.out.println("test:" + authentication);
            var token = tokenService.generatedToken((GeneratedUser) authentication.getPrincipal());
            System.out.println(token);

            return ResponseEntity.ok(new TokeJWTDTO(token));
        }
    }