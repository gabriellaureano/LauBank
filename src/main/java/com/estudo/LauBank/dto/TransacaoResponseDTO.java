package com.estudo.LauBank.dto;

public class TransacaoResponseDTO {
    private String nomeOrigem;
    private String nomeDestino;
    private double valor;
    private String dateTime;

    public TransacaoResponseDTO(String nomeOrigem, String nomeDestino, double valor, String dateTime) {
        this.nomeOrigem = nomeOrigem;
        this.nomeDestino = nomeDestino;
        this.valor = valor;
        this.dateTime = dateTime;
    }

    public TransacaoResponseDTO() {
    }

    public String getNomeOrigem() {
        return nomeOrigem;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public double getValor() {
        return valor;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setNomeOrigem(String nomeOrigem) {
        this.nomeOrigem = nomeOrigem;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
