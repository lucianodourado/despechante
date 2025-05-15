package br.mp.mpm.despachante.exception;

public class ErrorDto {

	private String campo;
	private String erro;

	private Boolean success = false;

	public ErrorDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

	public Boolean getSuccess() {
		return success;
	}

}
