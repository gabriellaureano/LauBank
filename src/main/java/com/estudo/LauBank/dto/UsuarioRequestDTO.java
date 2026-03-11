package com.estudo.LauBank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {
    private Long id;

    @NotBlank(message = "Nome inválido")
    private String nome;

    @NotBlank(message = "Email inválido")
    @Email(message = "Email inválido")
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
