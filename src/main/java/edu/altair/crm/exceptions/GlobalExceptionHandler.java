package edu.altair.crm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Intercepta la excepción FaltaNotFoundException y la transforma
     * en una respuesta estructurada según la especificación RFC 7807 (ProblemDetail).
     */
    @ExceptionHandler(FaltaNotFoundException.class)
    public ProblemDetail handleFaltaNotFoundException(FaltaNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, 
                ex.getMessage()
        );
        
        problemDetail.setTitle("Recurso no encontrado");
        problemDetail.setType(URI.create("https://edu.altair.crm/errors/not-found"));
        problemDetail.setProperty("timestamp", Instant.now());
        
        return problemDetail;
    }
}