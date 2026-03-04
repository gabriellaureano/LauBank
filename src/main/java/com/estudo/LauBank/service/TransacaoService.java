package com.estudo.LauBank.service;

import com.estudo.LauBank.dto.TransacaoResponseDTO;
import com.estudo.LauBank.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public List<TransacaoResponseDTO> buscarTransacoes(){
        return transacaoRepository.findAll().stream()
                .map(transacao -> new TransacaoResponseDTO(
                        transacao.getOrigem().getNome(),
                        transacao.getDestino().getNome(),
                        transacao.getValor(),
                        transacao.getData()
                ))
                .toList();
    }

    public List<TransacaoResponseDTO> buscarTransacoesId(Long id) {

        return transacaoRepository.buscarPorUsuario(id)
                .stream()
                .map(transacao -> new TransacaoResponseDTO(
                        transacao.getOrigem().getNome(),
                        transacao.getDestino().getNome(),
                        transacao.getValor(),
                        transacao.getData()
                ))
                .toList();
    }




}