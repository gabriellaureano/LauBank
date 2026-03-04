package com.estudo.LauBank.model;

import jakarta.persistence.*;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origem_id")
    private Usuario origem;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Usuario destino;

    private double valor;
    private String data;

    public Transacao(Usuario origem, Usuario destino, double valor, String data) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.data = data;
    }

    public Transacao() {
    }

    public Usuario getOrigem() {
        return origem;
    }

    public Usuario getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }
}
