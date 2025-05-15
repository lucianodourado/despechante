package br.mp.mpm.despachante.controller.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import br.mp.mpm.despachante.model.LogErro;
import br.mp.mpm.despachante.util.UtilData;

public class LogErroDto {
	
	private String entidade;
	private String dataHora;
	private String erro;

	public LogErroDto(LogErro entity) {
		this.entidade = entity.getEntidade();
		this.erro = entity.getErro();
		this.dataHora = UtilData.convertDateParaString(entity.getDataHora(), "dd/MM/yyyy");
	}
	
	
	public String getEntidade() {
		return entidade;
	}
	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}	
	
	// conversores de Entity <--> Dto
	public static LogErroDto converter(LogErro entity) {
		return new LogErroDto (entity);
	}

	public static List<LogErroDto> converter(Collection<LogErro> lista) {
		return lista.stream().map(LogErroDto ::new).collect(Collectors.toList());
	}
	
}
