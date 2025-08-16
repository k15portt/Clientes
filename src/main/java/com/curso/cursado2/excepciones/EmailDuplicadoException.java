package com.curso.cursado2.excepciones;

public class EmailDuplicadoException extends RuntimeException{
    public EmailDuplicadoException(String message) {
        super(message);
    }
}