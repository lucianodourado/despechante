package br.mp.mpm.despachante.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoaremovida")
	private Long id;

	private BigInteger matricula;

	@Column(length = 100)
	private String nomeCivil;

	@Column(nullable = false)
	private Date dataNascimento;

	@JoinColumn(name = "cargo", referencedColumnName = "id_cargo_efetivo")
	@ManyToOne	
	private TipoCargoEfetivo cargo;

	@NotBlank
	@Column(length = 11, nullable = false)
	private String cpf;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getMatricula() {
		return matricula;
	}

	public void setMatricula(BigInteger matricula) {
		this.matricula = matricula;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoCargoEfetivo getCargo() {
		return cargo;
	}

	public void setCargo(TipoCargoEfetivo cargo) {
		this.cargo = cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
