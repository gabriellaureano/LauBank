package com.estudo.LauBank.service;

import com.estudo.LauBank.dto.TransferirResponseDTO;
import com.estudo.LauBank.dto.UsuarioCreateDTO;
import com.estudo.LauBank.dto.UsuarioResponseDTO;
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

    public List<UsuarioResponseDTO> listar(){
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getSaldo()
                ))
                .toList();
    }

    public UsuarioResponseDTO cadastrar(UsuarioCreateDTO usuario){

        Usuario user = new Usuario(usuario.getNome(), usuario.getEmail());
        usuarioRepository.save(user);

        return new UsuarioResponseDTO(
                user.getId(),
                user.getNome(),
                user.getSaldo()
        );
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
