package com.jm3.operacao.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Operacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoId;

	@NotEmpty(message = "O codigo é obrigatório!")
	@Size(max = 15, message = "O codigo da mercadoria não pode conter mais do que 15 caracteres")
	private String codigoMercadoria;

	@Enumerated(EnumType.STRING)
	private TipoMercadoria tipoMercadoria;

	@NotEmpty(message = "O Nome da Mercadoria é obrigatória!")
	@Size(max = 60, message = "O Nome da Mercadoria não pode conter mais do que 60 caracteres")
	private String nomeMercadoria;

	@NotNull(message = "A quantidade não pode ser nula!")
	@DecimalMin(value = "0.01", message = "A quantidade não pode ser menor do que 0.01")
	@DecimalMax(value = "9999999.99", message = "A Quantidade não pode ser maior do que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal quantidade;

	@NotNull(message = "O preço é obrigatório!")
	@DecimalMin(value = "0.01", message = "Preço não pode ser menor do que 0.01")
	@DecimalMax(value = "9999999.99", message = "Preço não pode ser maior do que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco;

	@NotNull(message = "A data de negociação não pode ser nula")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNegociacao;

	@Enumerated(EnumType.STRING)
	private TipoNegocio tipoNegocio;

	public Long getCodigoId() {
		return codigoId;
	}

	public void setCodigoId(Long codigoId) {
		this.codigoId = codigoId;
	}

	public String getCodigoMercadoria() {
		return codigoMercadoria;
	}

	public void setCodigoMercadoria(String codigoMercadoria) {
		this.codigoMercadoria = codigoMercadoria;
	}

	public TipoMercadoria getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(TipoMercadoria tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public String getNomeMercadoria() {
		return nomeMercadoria;
	}

	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getDataNegociacao() {
		return dataNegociacao;
	}

	public void setDataNegociacao(Date dataNegociacao) {
		this.dataNegociacao = dataNegociacao;
	}

	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public boolean isNegociacaoTipo() {
		return TipoNegocio.VENDA.equals(this.tipoNegocio);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoId == null) ? 0 : codigoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacao other = (Operacao) obj;
		if (codigoId == null) {
			if (other.codigoId != null)
				return false;
		} else if (!codigoId.equals(other.codigoId))
			return false;
		return true;
	}
	
	

}
