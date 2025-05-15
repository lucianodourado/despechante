package br.mp.mpm.despachante.model;

import java.math.BigDecimal;
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
@Table(name = "FERIAS")
public class Ferias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ferias")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;
	
	private Date dataAdiantamento;
	
	@Column(precision = 10, scale = 2)	
	private BigDecimal valorAdiantamentoSaldo;
	
	private Integer quantidadeAdiantamentoParcela;	


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

	public Date getDataAdiantamento() {
		return dataAdiantamento;
	}

	public void setDataAdiantamento(Date dataAdiantamento) {
		this.dataAdiantamento = dataAdiantamento;
	}

	public BigDecimal getValorAdiantamentoSaldo() {
		return valorAdiantamentoSaldo;
	}

	public void setValorAdiantamentoSaldo(BigDecimal valorAdiantamentoSaldo) {
		this.valorAdiantamentoSaldo = valorAdiantamentoSaldo;
	}

	public Integer getQuantidadeAdiantamentoParcela() {
		return quantidadeAdiantamentoParcela;
	}

	public void setQuantidadeAdiantamentoParcela(Integer quantidadeAdiantamentoParcela) {
		this.quantidadeAdiantamentoParcela = quantidadeAdiantamentoParcela;
	}

}
