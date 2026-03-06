package com.estudo.LauBank.dto;

public class UsuarioCreateDTO {
    private Long id;
    private String nome;
    private String email;

    public UsuarioCreateDTO(String nome,String email) {
        this.nome = nome;
        this.email = email;
    }

    public UsuarioCreateDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
