package com.estudo.LauBank.dto;

public record TransferirRequestDTO(Long idOrigem, Long idDestino,double valor) {
}
