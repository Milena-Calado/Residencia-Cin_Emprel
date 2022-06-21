package com.example.selecaoemprel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamcacaoRepository extends JpaRepository<ReclamacaoModel, Long> {
    Optional<ReclamacaoModel> findByReclam(String reclam);
    Optional<ReclamacaoModel> findByProtocolo(String protocolo);
}
