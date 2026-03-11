package com.estudo.LauBank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank(message = "Nome inválido.")
        String nome,

        @NotBlank(message = "Email inválido")
        @Email(message = "Email inválido")
        String email) {
}
