package com.jm3.operacao.model;

public enum TipoNegocio {

	VENDA("Venda"), 
	COMPRA("Compra");

	private String descricao;

	private TipoNegocio(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
