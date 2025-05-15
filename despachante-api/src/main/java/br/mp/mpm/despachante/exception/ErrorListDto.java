package br.mp.mpm.despachante.exception;

import java.util.List;

public class ErrorListDto {

	private Boolean success = false;
	private List<ErrorDto> erros = null;

	public ErrorListDto(List<ErrorDto> erros) {
		this.erros = erros;
	}

	public List<ErrorDto> getErros() {
		return erros;
	}

	public Boolean getSuccess() {
		return success;
	}

}
