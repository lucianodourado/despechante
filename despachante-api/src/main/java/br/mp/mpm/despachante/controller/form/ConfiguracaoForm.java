package br.mp.mpm.despachante.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import br.mp.mpm.despachante.model.Configuracao;

public class ConfiguracaoForm {

	@NotNull
	@NotEmpty	
	private String ramo;

	@NotNull
	@NotEmpty	
	private String urlToken;
	
	@NotNull
	@NotEmpty	
	private String urlPessoa;

	@NotNull
	@NotEmpty	
	private String urlErro;

	@NotNull	
	private Boolean ativo;
	
	@NotNull
	@NotEmpty	
	private String usuario;

	@NotNull
	@NotEmpty	
	private String senha;
	
	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getUrlToken() {
		return urlToken;
	}

	public void setUrlToken(String urlToken) {
		this.urlToken = urlToken;
	}

	public String getUrlPessoa() {
		return urlPessoa;
	}

	public void setUrlPessoa(String urlPessoa) {
		this.urlPessoa = urlPessoa;
	}

	public String getUrlErro() {
		return urlErro;
	}

	public void setUrlErro(String urlErro) {
		this.urlErro = urlErro;
	}
	
	public Configuracao preencher(Configuracao configuracao, String... ignoreProperties) {
		BeanUtils.copyProperties(this, configuracao, ignoreProperties);
		return configuracao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
