package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.mp.mpm.despachante.model.TreinamentoAgrupamento;
import br.mp.mpm.despachante.util.UtilData;

public class TreinamentoAgrupamentoDto {

	private BigDecimal cargaHorariaUtilizada;
	private Integer sequencialAgrupamento;
	private Integer ordemTreinamentoNoAgrupamento;
	private String dataInicio;
	private String dataFim;

	public TreinamentoAgrupamentoDto() {
		
	}
	
	public TreinamentoAgrupamentoDto(TreinamentoAgrupamento entity) {
		BeanUtils.copyProperties(entity, this);		
		this.dataInicio = UtilData.convertDateParaString(entity.getDataInicio(), "dd/MM/yyyy");
		this.dataFim = UtilData.convertDateParaString(entity.getDataFim(), "dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static TreinamentoAgrupamentoDto converter(TreinamentoAgrupamento entity) {
		return new TreinamentoAgrupamentoDto(entity);
	}

	public static List<TreinamentoAgrupamentoDto> converter(Collection<TreinamentoAgrupamento> lista) {
		return lista.stream().map(TreinamentoAgrupamentoDto::new).collect(Collectors.toList());
	}

	public BigDecimal getCargaHorariaUtilizada() {
		return cargaHorariaUtilizada;
	}

	public Integer getSequencialAgrupamento() {
		return sequencialAgrupamento;
	}

	public Integer getOrdemTreinamentoNoAgrupamento() {
		return ordemTreinamentoNoAgrupamento;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setCargaHorariaUtilizada(BigDecimal cargaHorariaUtilizada) {
		this.cargaHorariaUtilizada = cargaHorariaUtilizada;
	}

	public void setSequencialAgrupamento(Integer sequencialAgrupamento) {
		this.sequencialAgrupamento = sequencialAgrupamento;
	}

	public void setOrdemTreinamentoNoAgrupamento(Integer ordemTreinamentoNoAgrupamento) {
		this.ordemTreinamentoNoAgrupamento = ordemTreinamentoNoAgrupamento;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}
