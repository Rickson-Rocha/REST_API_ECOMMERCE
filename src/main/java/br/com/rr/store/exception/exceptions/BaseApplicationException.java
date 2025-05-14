package br.com.rr.store.exception.exceptions;
import org.springframework.http.HttpStatus;

public  abstract class BaseApplicationException extends RuntimeException {
    protected BaseApplicationException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatus();
}