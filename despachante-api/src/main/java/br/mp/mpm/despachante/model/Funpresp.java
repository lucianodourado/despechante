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
@Table(name = "FUNPRESP")
public class Funpresp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funpresp")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@JoinColumn(name = "tipoContribuicao", referencedColumnName = "id_tipo_contribuicao")
	@ManyToOne
	private TipoContribuicao tipoContribuicao;

	@JoinColumn(name = "tipoTributacao", referencedColumnName = "id_tipo_tributacao")
	@ManyToOne
	private TipoTributacao tipoTributacao;

	@Column(precision = 3, scale = 2)
	private BigDecimal percentualDesconto;

	private BigInteger quantidadeUrp;

	private BigDecimal valorBaseCalculo;

	@Column(nullable = false)
	private Date dataAdesao;

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

	public TipoContribuicao getTipoContribuicao() {
		return tipoContribuicao;
	}

	public void setTipoContribuicao(TipoContribuicao tipoContribuicao) {
		this.tipoContribuicao = tipoContribuicao;
	}

	public TipoTributacao getTipoTributacao() {
		return tipoTributacao;
	}

	public void setTipoTributacao(TipoTributacao tipoTributacao) {
		this.tipoTributacao = tipoTributacao;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigInteger getQuantidadeUrp() {
		return quantidadeUrp;
	}

	public void setQuantidadeUrp(BigInteger quantidadeUrp) {
		this.quantidadeUrp = quantidadeUrp;
	}

	public BigDecimal getValorBaseCalculo() {
		return valorBaseCalculo;
	}

	public void setValorBaseCalculo(BigDecimal valorBaseCalculo) {
		this.valorBaseCalculo = valorBaseCalculo;
	}

	public Date getDataAdesao() {
		return dataAdesao;
	}

	public void setDataAdesao(Date dataAdesao) {
		this.dataAdesao = dataAdesao;
	}

}
