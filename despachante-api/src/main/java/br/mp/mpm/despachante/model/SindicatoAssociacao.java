package br.mp.mpm.despachante.model;

import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SINDICATO_ASSOCIACAO")
public class SindicatoAssociacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sindicato_associacao")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@Column(nullable = false)
	private Date dataInicioVigencia;

	@Column(length = 14, nullable = false)
	private String cnpj;

	@Column(length = 100, nullable = false)
	private String nomeSindicatoAssociacao;

	@JoinColumn(name = "tipoBaseCalculo", referencedColumnName = "id_tipo_base_calculo")
	@ManyToOne
	private TipoBaseCalculo tipoBaseCalculo;
		
	@Column(nullable = false)	
	private BigDecimal valorReferencia;
	
	@Column(length = 4000)	
	private String descricaoDescontosSindicato;
	
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

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeSindicatoAssociacao() {
		return nomeSindicatoAssociacao;
	}

	public void setNomeSindicatoAssociacao(String nomeSindicatoAssociacao) {
		this.nomeSindicatoAssociacao = nomeSindicatoAssociacao;
	}

	public TipoBaseCalculo getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public void setTipoBaseCalculo(TipoBaseCalculo tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public BigDecimal getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(BigDecimal valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	public String getDescricaoDescontosSindicato() {
		return descricaoDescontosSindicato;
	}

	public void setDescricaoDescontosSindicato(String descricaoDescontosSindicato) {
		this.descricaoDescontosSindicato = descricaoDescontosSindicato;
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
