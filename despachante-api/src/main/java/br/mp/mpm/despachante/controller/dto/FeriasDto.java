package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.Ferias;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;
import br.mp.mpm.despachante.util.UtilData;

public class FeriasDto {

	private String dataAdiantamento;	
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)						
	private BigDecimal valorAdiantamentoSaldo;	
	private Integer quantidadeAdiantamentoParcela;
	
	public FeriasDto() {		
	}
	
	public FeriasDto(Ferias entity) {
		BeanUtils.copyProperties(entity, this);		
		this.dataAdiantamento = UtilData.convertDateParaString(entity.getDataAdiantamento(), "dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static FeriasDto converter(Ferias entity) {
		return new FeriasDto(entity);
	}

	public static List<FeriasDto> converter(Collection<Ferias> lista) {
		return lista.stream().map(FeriasDto::new).collect(Collectors.toList());
	}
	
	public String getDataAdiantamento() {
		return dataAdiantamento;
	}
	public BigDecimal getValorAdiantamentoSaldo() {
		return valorAdiantamentoSaldo;
	}
	public Integer getQuantidadeAdiantamentoParcela() {
		return quantidadeAdiantamentoParcela;
	}
	public void setDataAdiantamento(String dataAdiantamento) {
		this.dataAdiantamento = dataAdiantamento;
	}
	public void setValorAdiantamentoSaldo(BigDecimal valorAdiantamentoSaldo) {
		this.valorAdiantamentoSaldo = valorAdiantamentoSaldo;
	}
	public void setQuantidadeAdiantamentoParcela(Integer quantidadeAdiantamentoParcela) {
		this.quantidadeAdiantamentoParcela = quantidadeAdiantamentoParcela;
	}
	
}
