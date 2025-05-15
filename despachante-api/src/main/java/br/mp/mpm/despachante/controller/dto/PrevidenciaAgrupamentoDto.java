package br.mp.mpm.despachante.controller.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import br.mp.mpm.despachante.model.PrevidenciaAgrupamento;
import br.mp.mpm.despachante.util.UtilData;

public class PrevidenciaAgrupamentoDto {

	private Integer tipoAgrupamento;
	private String dataInicio;

	public PrevidenciaAgrupamentoDto() {		
	}
	
	public PrevidenciaAgrupamentoDto(PrevidenciaAgrupamento entity) {
		this.tipoAgrupamento = entity.getTipoAgrupamento() != null ? entity.getTipoAgrupamento().getId() : null;
		this.dataInicio = UtilData.convertDateParaString(entity.getDataInicio(), "dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static PrevidenciaAgrupamentoDto converter(PrevidenciaAgrupamento entity) {
		return new PrevidenciaAgrupamentoDto(entity);
	}
	
	public static List<PrevidenciaAgrupamentoDto> converter(Collection<PrevidenciaAgrupamento> lista) {
		return lista.stream().map(PrevidenciaAgrupamentoDto::new).collect(Collectors.toList());
	}
	
	public Integer getTipoAgrupamento() {
		return tipoAgrupamento;
	}

	public void setTipoAgrupamento(Integer tipoAgrupamento) {
		this.tipoAgrupamento = tipoAgrupamento;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

}
