package br.mp.mpm.despachante.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonType;

import br.mp.mpm.despachante.controller.dto.PessoaRemovidaDto;


//TODO: usar superclasse Pessoa
@Entity
@Table(name = "PESSOA_REMOVIDA_JSON")
@TypeDef(
	    name = "json",
	    typeClass = JsonType.class
	)
public class PessoaRemovidaJson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(length = 11, nullable = false)	
	private String cpf;
	
	private BigInteger matricula;
	
	@Column(length = 100)
	private String nome;

	@Column(nullable = false)
	private String ramo;
		
	@Type(type = "json")	
	private PessoaRemovidaDto pessoaRemovidaCompleto;

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public BigInteger getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getRamo() {
		return ramo;
	}

	public PessoaRemovidaDto getPessoaRemovidaCompleto() {
		return pessoaRemovidaCompleto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setMatricula(BigInteger matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public void setPessoaRemovidaCompleto(PessoaRemovidaDto pessoaRemovidaCompleto) {
		this.pessoaRemovidaCompleto = pessoaRemovidaCompleto;
	}

}
