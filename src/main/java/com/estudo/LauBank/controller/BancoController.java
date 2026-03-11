package com.estudo.LauBank.controller;

import com.estudo.LauBank.dto.TransacaoResponseDTO;
import com.estudo.LauBank.dto.TransferirRequestDTO;
import com.estudo.LauBank.dto.UsuarioRequestDTO;
import com.estudo.LauBank.dto.UsuarioResponseDTO;
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

    @GetMapping("/usuarios")
    public List<UsuarioResponseDTO> listar(){
        return bancoService.listar();
    }


    @PostMapping("/usuarios")
    public UsuarioResponseDTO cadastrar(@Valid @RequestBody UsuarioRequestDTO usuario){
        return bancoService.cadastrar(usuario);
    }

    @PostMapping("/transacoes")
    public TransferirRequestDTO tranferir(@RequestBody TransferirRequestDTO transferirRequestDTO){
        return bancoService.transferir(
                transferirRequestDTO.getIdOrigem(),
                transferirRequestDTO.getIdDestino(),
                transferirRequestDTO.getValor()
        );
    }

    @GetMapping("/transacoes")
    public List<TransacaoResponseDTO> listarTransacoes(){
        return transacaoService.buscarTransacoes();
    }

    @GetMapping("/usuarios/{id}/transacoes")
    public List<TransacaoResponseDTO> listarTransacoesId(@PathVariable Long id){
        return transacaoService.buscarTransacoesId(id);
    }
}
