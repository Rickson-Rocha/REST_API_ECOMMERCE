package br.com.rr.store.exception.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends  BaseApplicationException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
