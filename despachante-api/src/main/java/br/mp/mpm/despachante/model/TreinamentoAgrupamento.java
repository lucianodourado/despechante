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
@Table(name = "TREINAMENTO_AGRUPAMENTO")
public class TreinamentoAgrupamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_treinamento_agrupamento")
	private Long id;

	@JoinColumn(name = "id_treinamento", referencedColumnName = "id_treinamento")
	@ManyToOne
	private Treinamento treinamento;

	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal cargaHorariaUtilizada;

	@Column(nullable = false)
	private int sequencialAgrupamento;

	@Column(nullable = false)	
	private int ordemTreinamentoNoAgrupamento;
	
	@Column(nullable = false)
	private Date dataInicio;

	@Column(nullable = false)
	private Date dataFim;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}

	public BigDecimal getCargaHorariaUtilizada() {
		return cargaHorariaUtilizada;
	}

	public void setCargaHorariaUtilizada(BigDecimal cargaHorariaUtilizada) {
		this.cargaHorariaUtilizada = cargaHorariaUtilizada;
	}

	public int getSequencialAgrupamento() {
		return sequencialAgrupamento;
	}

	public void setSequencialAgrupamento(int sequencialAgrupamento) {
		this.sequencialAgrupamento = sequencialAgrupamento;
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

	public int getOrdemTreinamentoNoAgrupamento() {
		return ordemTreinamentoNoAgrupamento;
	}

	public void setOrdemTreinamentoNoAgrupamento(int ordemTreinamentoNoAgrupamento) {
		this.ordemTreinamentoNoAgrupamento = ordemTreinamentoNoAgrupamento;
	}

}
