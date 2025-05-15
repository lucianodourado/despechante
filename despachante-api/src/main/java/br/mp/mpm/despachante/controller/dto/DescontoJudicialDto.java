package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.DescontoJudicial;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;

public class DescontoJudicialDto {

	private Integer tipoBaseCalculo;
	private Integer tipoValor;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)				
	private BigDecimal valorTotalDesconto;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)				
	private BigDecimal valorPagar;

	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)				
	private BigDecimal valorDesconto;
	
	private String descricaoDescontoJudicial;
	private String cpfCnpjBeneficiario;
	private String nomeBeneficiario;
	private BigInteger banco;
	private BigInteger agencia;
	private String agenciaDv;
	private BigInteger conta;
	private String contaDv;
	private Integer contaJudicial;	

	public DescontoJudicialDto() {
	}
	
	public DescontoJudicialDto(DescontoJudicial entity) {
		BeanUtils.copyProperties(entity, this);
		
		this.tipoBaseCalculo = entity.getTipoBaseCalculo() != null ? entity.getTipoBaseCalculo().getId() : null;
		this.tipoValor = entity.getTipoValor() != null ? entity.getTipoValor().getId() : null;
	}


	// conversores de Entity <--> Dto
	public static DescontoJudicialDto converter(DescontoJudicial entity) {
		return new DescontoJudicialDto(entity);
	}

	public static List<DescontoJudicialDto> converter(Collection<DescontoJudicial> lista) {
		return lista.stream().map(DescontoJudicialDto::new).collect(Collectors.toList());
	}


	public Integer getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}


	public Integer getTipoValor() {
		return tipoValor;
	}


	public BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}


	public BigDecimal getValorPagar() {
		return valorPagar;
	}


	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}


	public String getDescricaoDescontoJudicial() {
		return descricaoDescontoJudicial;
	}


	public String getCpfCnpjBeneficiario() {
		return cpfCnpjBeneficiario;
	}


	public String getNomeBeneficiario() {
		return nomeBeneficiario;
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


	public Integer getContaJudicial() {
		return contaJudicial;
	}


	public void setTipoBaseCalculo(Integer tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}


	public void setTipoValor(Integer tipoValor) {
		this.tipoValor = tipoValor;
	}


	public void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}


	public void setValorPagar(BigDecimal valorPagar) {
		this.valorPagar = valorPagar;
	}


	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}


	public void setDescricaoDescontoJudicial(String descricaoDescontoJudicial) {
		this.descricaoDescontoJudicial = descricaoDescontoJudicial;
	}


	public void setCpfCnpjBeneficiario(String cpfCnpjBeneficiario) {
		this.cpfCnpjBeneficiario = cpfCnpjBeneficiario;
	}


	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
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


	public void setContaJudicial(Integer contaJudicial) {
		this.contaJudicial = contaJudicial;
	}

}
