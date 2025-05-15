package br.mp.mpm.despachante.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEPENDENTE")
public class Dependente {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dependente")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@Column(length = 100, nullable = false)
	private String nome;

	private Date dataNascimento;

	@Column(length = 100, nullable = false)
	private String grauParentesco;

	@JoinColumn(name = "sexo", referencedColumnName = "id_sexo")
	@ManyToOne
	private Sexo sexo;

	@Column(length = 100)
	private String nomeMae;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(length = 100)
	private String rg;

	@Column(length = 100)
	private String rgOrgaoEmissor;

	@Column(length = 2)
	private String rgUfEmissao;

	private Date rgDataEmissao;

	@Column(nullable = false)	
	private Date dataVigenciaAuxilioPreEscolar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaRemovida getPessoaRemovida() {
		return pessoaRemovida;
	}

	public void setPessoaRemovida(PessoaRemovida pessoaRemovida) {
		this.pessoaRemovida = pessoaRemovida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public String getRgUfEmissao() {
		return rgUfEmissao;
	}

	public void setRgUfEmissao(String rgUfEmissao) {
		this.rgUfEmissao = rgUfEmissao;
	}

	public Date getRgDataEmissao() {
		return rgDataEmissao;
	}

	public void setRgDataEmissao(Date rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}

	public Date getDataVigenciaAuxilioPreEscolar() {
		return dataVigenciaAuxilioPreEscolar;
	}

	public void setDataVigenciaAuxilioPreEscolar(Date dataVigenciaAuxilioPreEscolar) {
		this.dataVigenciaAuxilioPreEscolar = dataVigenciaAuxilioPreEscolar;
	}

}
