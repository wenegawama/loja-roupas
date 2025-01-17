package com.loja.roupas.trein.infra.exceptionsService;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
