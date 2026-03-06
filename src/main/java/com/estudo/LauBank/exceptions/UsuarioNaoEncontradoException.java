package com.estudo.LauBank.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
