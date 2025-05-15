package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.SindicatoAssociacao;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;
import br.mp.mpm.despachante.util.UtilData;

public class SindicatoAssociacaoDto {

	private String dataInicioVigencia;
	private String cnpj;
	private String nomeSindicatoAssociacao;
	private Integer tipoBaseCalculo;	
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)			
	private BigDecimal valorReferencia;
	private String descricaoDescontosSindicato;
	private BigInteger banco;
	private BigInteger agencia;
	private String agenciaDv;
	private BigInteger conta;
	private String contaDv;

	public SindicatoAssociacaoDto() {
	}
	
	public SindicatoAssociacaoDto(SindicatoAssociacao entity) {
		BeanUtils.copyProperties(entity, this);		
		this.dataInicioVigencia = UtilData.convertDateParaString(entity.getDataInicioVigencia(), "dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static SindicatoAssociacaoDto converter(SindicatoAssociacao entity) {
		return new SindicatoAssociacaoDto(entity);
	}

	public static List<SindicatoAssociacaoDto> converter(Collection<SindicatoAssociacao> lista) {
		return lista.stream().map(SindicatoAssociacaoDto::new).collect(Collectors.toList());
	}

	public String getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeSindicatoAssociacao() {
		return nomeSindicatoAssociacao;
	}

	public Integer getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public BigDecimal getValorReferencia() {
		return valorReferencia;
	}

	public String getDescricaoDescontosSindicato() {
		return descricaoDescontosSindicato;
	}

	public BigInteger getBanco() {
		return banco;
	}

	public BigInteger getAgencia() {
		return agencia;
	}

	public String getAgenciaDv() {
		return agenciaDv;
	}

	public BigInteger getConta() {
		return conta;
	}

	public String getContaDv() {
		return contaDv;
	}

	public void setDataInicioVigencia(String dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNomeSindicatoAssociacao(String nomeSindicatoAssociacao) {
		this.nomeSindicatoAssociacao = nomeSindicatoAssociacao;
	}

	public void setTipoBaseCalculo(Integer tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public void setValorReferencia(BigDecimal valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	public void setDescricaoDescontosSindicato(String descricaoDescontosSindicato) {
		this.descricaoDescontosSindicato = descricaoDescontosSindicato;
	}

	public void setBanco(BigInteger banco) {
		this.banco = banco;
	}

	public void setAgencia(BigInteger agencia) {
		this.agencia = agencia;
	}

	public void setAgenciaDv(String agenciaDv) {
		this.agenciaDv = agenciaDv;
	}

	public void setConta(BigInteger conta) {
		this.conta = conta;
	}

	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

}
