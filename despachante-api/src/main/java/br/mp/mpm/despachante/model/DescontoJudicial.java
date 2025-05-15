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
@Table(name = "DESCONTO_JUDICIAL")
public class DescontoJudicial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_desconto_judicial")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@JoinColumn(name = "tipoBaseCalculo", referencedColumnName = "id_tipo_base_calculo")
	@ManyToOne
	private TipoBaseCalculo tipoBaseCalculo;

	@JoinColumn(name = "tipoValor", referencedColumnName = "id_tipo_valor")
	@ManyToOne
	private TipoValor tipoValor;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotalDesconto;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorPagar;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorDesconto;

	@Column(length = 4000)
	private String descricaoDescontoJudicial;

	@Column(length = 14, nullable = false)
	private String cpfCnpjBeneficiario;

	@Column(length = 100, nullable = false)
	private String nomeBeneficiario;

	private BigInteger banco;

	private BigInteger agencia;

	@Column(length = 1)
	private String agenciaDv;

	private BigInteger conta;

	@Column(length = 1)
	private String contaDv;

	private Integer contaJudicial;
	
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

	public TipoBaseCalculo getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public void setTipoBaseCalculo(TipoBaseCalculo tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public TipoValor getTipoValor() {
		return tipoValor;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public BigDecimal getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(BigDecimal valorPagar) {
		this.valorPagar = valorPagar;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public String getDescricaoDescontoJudicial() {
		return descricaoDescontoJudicial;
	}

	public void setDescricaoDescontoJudicial(String descricaoDescontoJudicial) {
		this.descricaoDescontoJudicial = descricaoDescontoJudicial;
	}

	public String getCpfCnpjBeneficiario() {
		return cpfCnpjBeneficiario;
	}

	public void setCpfCnpjBeneficiario(String cpfCnpjBeneficiario) {
		this.cpfCnpjBeneficiario = cpfCnpjBeneficiario;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
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

	public Integer getContaJudicial() {
		return contaJudicial;
	}

	public void setContaJudicial(Integer contaJudicial) {
		this.contaJudicial = contaJudicial;
	}

}
