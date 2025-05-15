package br.mp.mpm.despachante.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONSIGNADO")
public class Consignado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consignado")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@Column(length = 14, nullable = false)
	private String cnpj;

	@Column(length = 100, nullable = false)
	private String nomeInstituicao;

	@Column(nullable = false)
	private BigInteger numeroParcelasContratadas; //TODO: numeric(10,0)

	@Column(nullable = false)
	private BigInteger numeroParcelasPagar; //TODO: numeric(10,0) 

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorParcela;	
	
	@Column(nullable = false)	
	private BigInteger banco;

	@Column(nullable = false)	
	private BigInteger agencia;

	@Column(length = 1, nullable = false)
	private String agenciaDv;

	@Column(nullable = false)	
	private BigInteger conta;

	@Column(length = 1, nullable = false)
	private String contaDv;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public BigInteger getNumeroParcelasContratadas() {
		return numeroParcelasContratadas;
	}

	public void setNumeroParcelasContratadas(BigInteger numeroParcelasContratadas) {
		this.numeroParcelasContratadas = numeroParcelasContratadas;
	}

	public BigInteger getNumeroParcelasPagar() {
		return numeroParcelasPagar;
	}

	public void setNumeroParcelasPagar(BigInteger numeroParcelasPagar) {
		this.numeroParcelasPagar = numeroParcelasPagar;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public BigInteger getBanco() {
		return banco;
	}

	public void setBanco(BigInteger banco) {
		this.banco = banco;
	}

	public BigInteger getAgencia() {
		return agencia;
	}

	public void setAgencia(BigInteger agencia) {
		this.agencia = agencia;
	}

	public String getAgenciaDv() {
		return agenciaDv;
	}

	public void setAgenciaDv(String agenciaDv) {
		this.agenciaDv = agenciaDv;
	}

	public BigInteger getConta() {
		return conta;
	}

	public void setConta(BigInteger conta) {
		this.conta = conta;
	}

	public String getContaDv() {
		return contaDv;
	}

	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

}
