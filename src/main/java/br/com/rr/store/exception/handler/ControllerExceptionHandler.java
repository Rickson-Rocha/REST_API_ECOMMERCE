package br.com.rr.store.exception.handler;


import br.com.rr.store.exception.dto.CustomError;
import br.com.rr.store.exception.exceptions.BaseApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseApplicationException.class)
    public ResponseEntity<CustomError> handleBaseApplicationExceptions(BaseApplicationException ex, HttpServletRequest request) {
        HttpStatus status = ex.getStatus();



        CustomError err = new CustomError(
                Instant.now(),
                status.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }

}
