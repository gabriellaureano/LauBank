package com.estudo.LauBank.repository;

import com.estudo.LauBank.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
    @Query("""
    SELECT t FROM Transacao t
    WHERE t.origem.id = :id OR t.destino.id = :id """)
    List<Transacao> buscarPorUsuario(Long id);
}
