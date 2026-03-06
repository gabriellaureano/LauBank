package com.estudo.LauBank.exceptions;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ErrorMessage {
    private Integer status;
    private String mensagem;
    private LocalDateTime timestamp;

    public ErrorMessage(Integer status, String mensagem, LocalDateTime timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

    public ErrorMessage() {
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
