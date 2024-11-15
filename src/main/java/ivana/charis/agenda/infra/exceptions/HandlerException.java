package ivana.charis.agenda.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity notFound(Exception ex, WebRequest request){
        return new ResponseEntity("Entity not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
