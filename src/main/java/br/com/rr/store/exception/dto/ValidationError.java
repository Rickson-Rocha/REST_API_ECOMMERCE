package br.com.rr.store.exception.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError  extends  CustomError{


    private final List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, int status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public void addErro(String campo, String mensagem) {
        erros.add(new FieldMessage(campo, mensagem));
    }

    public List<FieldMessage> getErros() {
        return erros;
    }
}
