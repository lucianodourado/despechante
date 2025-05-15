package br.mp.mpm.despachante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURACAO")
public class Configuracao {

	@Id
	@Column(name = "id_ramo")
	private String ramo;
	
	@Column(length = 1024, nullable = false, name = "url_token")
	String urlToken;

	@Column(length = 1024, nullable = false, name = "url_pessoa")
	String urlPessoa;

	@Column(length = 1024, nullable = false, name = "url_erro")
	String urlErro;

	@Column(nullable = false)
	Boolean ativo;

	@Column(nullable = false)
	String usuario;

	@Column(nullable = false)
	String senha;
	
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
