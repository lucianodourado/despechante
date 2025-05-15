package br.mp.mpm.despachante.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_TREINAMENTO")
public class TipoTreinamento {

	@Id
	@Column(name = "id_tipo_treinamento")
	private int id;

	@Basic(optional = false)
	@Column(length = 20, nullable = false)
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
