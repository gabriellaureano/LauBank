package com.estudo.LauBank.service;

import com.estudo.LauBank.dto.TransferirResponseDTO;
import com.estudo.LauBank.exceptions.SaldoInsuficienteException;
import com.estudo.LauBank.exceptions.UsuarioNaoEncontradoException;
import com.estudo.LauBank.model.Transacao;
import com.estudo.LauBank.model.Usuario;
import com.estudo.LauBank.repository.TransacaoRepository;
import com.estudo.LauBank.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BancoService {

    private final TransacaoRepository transacaoRepository;

    private final UsuarioRepository usuarioRepository;

    public BancoService(UsuarioRepository usuarioRepository,TransacaoRepository transacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public TransferirResponseDTO transferir(Long idOrigem, Long idDestino, double valor){

        Usuario origem = usuarioRepository.findById(idOrigem)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));

        Usuario destino = usuarioRepository.findById(idDestino)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));

        if (origem.sacar(valor)){
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = dateTime.format(formatador);

            destino.depositar(valor);
            Transacao transacao = new Transacao(
                    origem,
                    destino,
                    valor,
                    dataFormatada
            );
            transacaoRepository.save(transacao);
            return new TransferirResponseDTO(
                    transacao.getOrigem().getId(),
                    transacao.getDestino().getId(),
                    transacao.getValor()
            );
        }
        else {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }


    }
}
