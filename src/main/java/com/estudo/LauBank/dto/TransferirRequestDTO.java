package com.estudo.LauBank.dto;

public class TransferirRequestDTO {

    private Long idOrigem;

    private Long idDestino;

    private double valor;

    public TransferirRequestDTO(Long idOrigem, Long idDestino, double valor) {
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        this.valor = valor;
    }

    public TransferirRequestDTO() {
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
