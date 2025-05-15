package br.mp.mpm.despachante.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TREINAMENTO")
public class Treinamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_treinamento")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@Column(length = 200, nullable = false)
	private String nome;

	@Column(length = 200, nullable = false)
	private String nomeInstituicao;

	@JoinColumn(name = "tipo", referencedColumnName = "id_tipo_treinamento")
	@ManyToOne
	private TipoTreinamento tipoTreinamento;

	@Column(nullable = false)
	private Date dataInicio;

	@Column(nullable = false)
	private Date dataFim;

	@Column(nullable = false)
	private BigDecimal cargaHoraria;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "treinamento")
	private Collection<TreinamentoAgrupamento> agrupamento;

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

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public TipoTreinamento getTipoTreinamento() {
		return tipoTreinamento;
	}

	public void setTipoTreinamento(TipoTreinamento tipoTreinamento) {
		this.tipoTreinamento = tipoTreinamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public BigDecimal getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(BigDecimal cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Collection<TreinamentoAgrupamento> getTreinamentoAgrupamento() {
		return agrupamento;
	}

	public void setTreinamentoAgrupamento(Collection<TreinamentoAgrupamento> treinamentoAgrupamento) {
		this.agrupamento = treinamentoAgrupamento;
	}

}
