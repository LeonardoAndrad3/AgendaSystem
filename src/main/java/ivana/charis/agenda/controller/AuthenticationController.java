package ivana.charis.agenda.controller;

import ivana.charis.agenda.auth.AuthenticationService;
import ivana.charis.agenda.auth.DataAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

        @Autowired
        private AuthenticationService service;

        @GetMapping
        public ResponseEntity validSession(HttpServletRequest request){
            System.out.println("eu");
            return ResponseEntity.ok().body(service.validSession(request));
        }

        @PostMapping("/login")
        public ResponseEntity login(@RequestBody @Valid DataAuthentication data, HttpServletRequest request){

            if(!data.email().isBlank() && !data.password().isBlank()){
                var sessionId = service.startSession(request, data);
                return ResponseEntity.ok().body(sessionId);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not valid credentials");
        }

        @PostMapping("/logout")
        public ResponseEntity logout(HttpServletRequest request){
            try{
                HttpSession session = request.getSession(false);
                if (session != null){
                    session.invalidate();
                }
            } catch(RuntimeException ex){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.noContent().build();
        }
    }