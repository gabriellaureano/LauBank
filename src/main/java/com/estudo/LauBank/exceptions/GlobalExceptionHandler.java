package com.estudo.LauBank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErrorMessage> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException erro){
        ErrorMessage errorMessage = new ErrorMessage(
                404,
                erro.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<ErrorMessage> handleSaldoInsuficiente(SaldoInsuficienteException erro){
        ErrorMessage errorMessage = new ErrorMessage(
                400,
                erro.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(errorMessage);
    }
}
