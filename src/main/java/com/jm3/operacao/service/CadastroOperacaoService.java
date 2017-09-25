package com.jm3.operacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jm3.operacao.model.Operacao;
import com.jm3.operacao.repository.Operacoes;

@Service
public class CadastroOperacaoService {
	
	@Autowired
	private Operacoes operacoes;
	
	public void salvar(Operacao operacao) {
		try {
			operacoes.save(operacao);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido!");
		}
	}
	
	public void exluir(Long codigo) {
		operacoes.delete(codigo);
	}
	
	

}
