package com.jm3.operacao.model;

public enum TipoMercadoria {
	
	ITEN("Iten"),
	SERVICO("Serviço"),
	RECURSO("Recurso");
	
	private String descricao;		

	private TipoMercadoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
