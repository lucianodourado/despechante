package br.mp.mpm.despachante.controller.dto;

import java.util.List;

public class PessoaRemovidaResponseDto {
	Boolean success;
    String message;
    List<PessoaRemovidaDto> data;

    public PessoaRemovidaResponseDto(Boolean success, String message, List<PessoaRemovidaDto> data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

    public PessoaRemovidaResponseDto() {
	}
    
    
	public Boolean getSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	public List<PessoaRemovidaDto> getData() {
		return data;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(List<PessoaRemovidaDto> data) {
		this.data = data;
	}	

}
