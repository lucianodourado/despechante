package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.Treinamento;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;
import br.mp.mpm.despachante.util.UtilData;

public class TreinamentoDto {

	private String nome;
	private String nomeInstituicao;
	private Integer tipo;
	private String dataInicio;
	private String dataFim;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)							
	private BigDecimal cargaHoraria;
	
	private Collection<TreinamentoAgrupamentoDto> agrupamento;

	public TreinamentoDto() {
	}
	
	public TreinamentoDto(Treinamento entity) {
		BeanUtils.copyProperties(entity, this);		
		this.tipo = entity.getTipoTreinamento() != null ? entity.getTipoTreinamento().getId() : null;
		this.dataInicio = UtilData.convertDateParaString(entity.getDataInicio(), "dd/MM/yyyy");
		this.dataFim = UtilData.convertDateParaString(entity.getDataFim(), "dd/MM/yyyy");
		this.agrupamento = TreinamentoAgrupamentoDto.converter(entity.getTreinamentoAgrupamento());
	}

	// conversores de Entity <--> Dto
	public static TreinamentoDto converter(Treinamento entity) {
		return new TreinamentoDto(entity);
	}

	public static List<TreinamentoDto> converter(Collection<Treinamento> lista) {
		return lista.stream().map(TreinamentoDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public BigDecimal getCargaHoraria() {
		return cargaHoraria;
	}

	public Collection<TreinamentoAgrupamentoDto> getAgrupamento() {
		return agrupamento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public void setCargaHoraria(BigDecimal cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setAgrupamento(Collection<TreinamentoAgrupamentoDto> agrupamento) {
		this.agrupamento = agrupamento;
	}
}
