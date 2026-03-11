package com.estudo.LauBank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErro400(MethodArgumentNotValidException erro) {

        var errodecampo = erro.getBindingResult().getFieldError();

        var campoDeErro = errodecampo.getField();
        var mensagemDeErro = errodecampo.getDefaultMessage();

        Map<String,String> resposta = new LinkedHashMap<>();

        resposta.put("Status","400");
        resposta.put("Campo",campoDeErro);
        resposta.put("Erro",mensagemDeErro);

        if (campoDeErro.equals("nome")){
            resposta.put("Ajuda","Verifique se o nome está vazio.");
        } else if (campoDeErro.equals("email")) {
            resposta.put("Ajuda","Verifique se o email contem '@' e um dominio valido (ex: .com)");
        }else {
            resposta.put("ajuda", "Verifique o preenchimento deste campo e tente novamente.");
        }

        return ResponseEntity.badRequest().body(resposta);
    }

}
