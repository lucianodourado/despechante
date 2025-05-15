package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.Funpresp;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;
import br.mp.mpm.despachante.util.UtilData;

public class FunprespDto {

	private Integer tipoContribuicao;
	private Integer tipoTributacao;

	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)					
	private BigDecimal percentualDesconto;
	
	private BigInteger quantidadeUrp;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)					
	private BigDecimal valorBaseCalculo;
	
	private String dataAdesao;

	public FunprespDto() {
	}
	
	public FunprespDto(Funpresp entity) {
		BeanUtils.copyProperties(entity, this);		
		this.tipoContribuicao = entity.getTipoContribuicao() != null ? entity.getTipoContribuicao().getId() : null;
		this.tipoTributacao = entity.getTipoTributacao() != null ? entity.getTipoTributacao().getId() : null;
		this.dataAdesao = UtilData.convertDateParaString(entity.getDataAdesao(), "dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static FunprespDto converter(Funpresp entity) {
		return new FunprespDto(entity);
	}

	public static List<FunprespDto> converter(Collection<Funpresp> lista) {
		return lista.stream().map(FunprespDto::new).collect(Collectors.toList());
	}

	public Integer getTipoContribuicao() {
		return tipoContribuicao;
	}

	public Integer getTipoTributacao() {
		return tipoTributacao;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public BigInteger getQuantidadeUrp() {
		return quantidadeUrp;
	}

	public BigDecimal getValorBaseCalculo() {
		return valorBaseCalculo;
	}

	public String getDataAdesao() {
		return dataAdesao;
	}

	public void setTipoContribuicao(Integer tipoContribuicao) {
		this.tipoContribuicao = tipoContribuicao;
	}

	public void setTipoTributacao(Integer tipoTributacao) {
		this.tipoTributacao = tipoTributacao;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public void setQuantidadeUrp(BigInteger quantidadeUrp) {
		this.quantidadeUrp = quantidadeUrp;
	}

	public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}

	public void setDataAdesao(String dataAdesao) {
		this.dataAdesao = dataAdesao;
	}
}
