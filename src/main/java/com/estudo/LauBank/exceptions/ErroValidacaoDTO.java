package com.estudo.LauBank.exceptions;

public class ErroValidacaoDTO {
    private String erro;

    public ErroValidacaoDTO(String erro) {
        this.erro = erro;
    }

    public ErroValidacaoDTO() {
    }

    public String getMensagem() {
        return erro;
    }
}
