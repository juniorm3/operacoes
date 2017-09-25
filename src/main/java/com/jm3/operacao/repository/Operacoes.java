package com.jm3.operacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jm3.operacao.model.Operacao;

public interface Operacoes extends JpaRepository<Operacao, Long>{

}
