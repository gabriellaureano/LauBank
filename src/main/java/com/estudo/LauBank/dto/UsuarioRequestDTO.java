package com.estudo.LauBank.dto;

public class UsuarioRequestDTO {
    private Long id;
    private String nome;
    private String email;

    public UsuarioRequestDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public UsuarioRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
