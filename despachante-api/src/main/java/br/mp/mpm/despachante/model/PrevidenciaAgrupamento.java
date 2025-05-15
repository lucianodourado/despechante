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
@Table(name = "PREVIDENCIA_AGRUPAMENTO")
public class PrevidenciaAgrupamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_previdencia_agrupamento")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@JoinColumn(name = "tipoAgrupamento", referencedColumnName = "id_tipo_agrupamento")
	@ManyToOne
	private TipoAgrupamento tipoAgrupamento;

	@Column(nullable = false)
	private Date dataInicio;

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

	public TipoAgrupamento getTipoAgrupamento() {
		return tipoAgrupamento;
	}

	public void setTipoAgrupamento(TipoAgrupamento tipoAgrupamento) {
		this.tipoAgrupamento = tipoAgrupamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

}
