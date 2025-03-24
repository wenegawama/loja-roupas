package com.loja.roupas.trein.infra.exceptionsService;

public class RecupercaoSenhaException extends RuntimeException{
    public RecupercaoSenhaException(String message) {
        super("Dados enviados para a recuperação da senha são inválidos!!!");
    }
}
