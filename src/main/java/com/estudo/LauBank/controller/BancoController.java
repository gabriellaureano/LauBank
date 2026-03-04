package com.estudo.LauBank.controller;

import com.estudo.LauBank.dto.TransacaoResponseDTO;
import com.estudo.LauBank.dto.TransferirResponseDTO;
import com.estudo.LauBank.model.Usuario;
import com.estudo.LauBank.service.BancoService;
import com.estudo.LauBank.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laubank")
public class BancoController {

    private final TransacaoService transacaoService;

    private final BancoService bancoService;

    public BancoController(BancoService bancoService,TransacaoService transacaoService) {
        this.bancoService = bancoService;
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public List<Usuario> listar(){
        return bancoService.listar();
    }

    @PostMapping("/users")
    public Usuario cadastrar(@Valid @RequestBody Usuario usuario){
        return bancoService.cadastrar(usuario);
    }

    @PostMapping
    public TransferirResponseDTO tranferir(@RequestBody TransferirResponseDTO transferirDTO){
        return bancoService.transferir(
                transferirDTO.getIdOrigem(),
                transferirDTO.getIdDestino(),
                transferirDTO.getValor()
        );
    }

    @GetMapping("/transacoes")
    public List<TransacaoResponseDTO> listarTransacoes(){
        return transacaoService.buscarTransacoes();
    }

    @GetMapping("/transacoes/{id}")
    public List<TransacaoResponseDTO> listarTransacoesId(@PathVariable Long id){
        return transacaoService.buscarTransacoesId(id);
    }
}
