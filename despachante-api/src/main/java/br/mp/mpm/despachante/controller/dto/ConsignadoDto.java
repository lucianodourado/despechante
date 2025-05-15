
package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.Consignado;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;

public class ConsignadoDto {

	private String cnpj;
	private String nomeInstituicao;
	private BigInteger numeroParcelasContratadas;
	private BigInteger numeroParcelasPagar;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)	
	private BigDecimal valorParcela;
	private BigInteger banco;
	private BigInteger agencia;
	private String agenciaDv;
	private BigInteger conta;
	private String contaDv;

	public ConsignadoDto() {
	}

	
	public ConsignadoDto(Consignado entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	// conversores de Entity <--> Dto
	public static ConsignadoDto converter(Consignado entity) {
		return new ConsignadoDto(entity);
	}

	public static List<ConsignadoDto> converter(Collection<Consignado> lista) {
		return lista.stream().map(ConsignadoDto::new).collect(Collectors.toList());
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public BigInteger getNumeroParcelasContratadas() {
		return numeroParcelasContratadas;
	}

	public BigInteger getNumeroParcelasPagar() {
		return numeroParcelasPagar;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
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

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public void setNumeroParcelasContratadas(BigInteger numeroParcelasContratadas) {
		this.numeroParcelasContratadas = numeroParcelasContratadas;
	}

	public void setNumeroParcelasPagar(BigInteger numeroParcelasPagar) {
		this.numeroParcelasPagar = numeroParcelasPagar;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
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
