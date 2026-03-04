package com.estudo.LauBank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TransferirResponseDTO {

    private Long idOrigem;

    private Long idDestino;

    private double valor;

    public TransferirResponseDTO(Long idOrigem, Long idDestino, double valor) {
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        this.valor = valor;
    }

    public TransferirResponseDTO() {
    }

    public Long getIdOrigem() {
        return idOrigem;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setIdOrigem(Long idOrigem) {
        this.idOrigem = idOrigem;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
