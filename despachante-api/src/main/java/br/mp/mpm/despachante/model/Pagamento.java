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
@Table(name = "PAGAMENTO")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@Column(nullable = false, precision = 2, scale = 2)
	private BigDecimal valorAdicionalQualificacao;

	private Date dataExpiracaoAdicional1;

	private Date dataExpiracaoAdicional2;

	private BigDecimal valorQuintosDecimos;

	private BigInteger quantidadeAnuenios;

	private Date dataInicioAbonoPermanencia;

	private BigDecimal valorVpni;

	private BigDecimal valorAuxilioAlimentacao;

	@Column(nullable = false)
	private int feriasAnoExercicio;
	
	@Column(nullable = false)	
	private int quantidadeDiasferiasSaldo;	

	@Column(nullable = false)
	private int feriasUmTerco; // foi recebido 1/3 de férias no ramo de origem. 1 para SIM e 0 para NÂO

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorFeriasUmTerco;
	
	private int feriasAdiantamentoIr;
	
	@Column(nullable = false, precision = 10, scale = 2)	
	private BigDecimal valorGratificacaoNatalinaAdiantamento;

	@JoinColumn(name = "tipoIsencaoIr", referencedColumnName = "id_tipo_isencao")
	@ManyToOne		
	private TipoIsencao tipoIsencaoIr;
	
	private Date dataIsencaoIr;

	@Column(length = 4000)	
	private String descricaoCalculoIsencaoIr;

	@JoinColumn(name = "tipoIsencaoPSS", referencedColumnName = "id_tipo_isencao")
	@ManyToOne	
	private TipoIsencao tipoIsencaoPSS;
	
	private Date dataIsencaoPSS;
	
	@Column(length = 4000)
	private String descricaoCalculoIsencaoPSS;

	
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

	public BigDecimal getValorAdicionalQualificacao() {
		return valorAdicionalQualificacao;
	}

	public void setValorAdicionalQualificacao(BigDecimal valorAdicionalQualificacao) {
		this.valorAdicionalQualificacao = valorAdicionalQualificacao;
	}

	public Date getDataExpiracaoAdicional1() {
		return dataExpiracaoAdicional1;
	}

	public void setDataExpiracaoAdicional1(Date dataExpiracaoAdicional1) {
		this.dataExpiracaoAdicional1 = dataExpiracaoAdicional1;
	}

	public Date getDataExpiracaoAdicional2() {
		return dataExpiracaoAdicional2;
	}

	public void setDataExpiracaoAdicional2(Date dataExpiracaoAdicional2) {
		this.dataExpiracaoAdicional2 = dataExpiracaoAdicional2;
	}

	public int getFeriasAnoExercicio() {
		return feriasAnoExercicio;
	}

	public void setFeriasAnoExercicio(int feriasAnoExercicio) {
		this.feriasAnoExercicio = feriasAnoExercicio;
	}

	public int getFeriasUmTerco() {
		return feriasUmTerco;
	}

	public void setFeriasUmTerco(int feriasUmTerco) {
		this.feriasUmTerco = feriasUmTerco;
	}

	public int getFeriasAdiantamentoIr() {
		return feriasAdiantamentoIr;
	}

	public void setFeriasAdiantamentoIr(int feriasAdiantamentoIr) {
		this.feriasAdiantamentoIr = feriasAdiantamentoIr;
	}

	public Date getDataIsencaoIr() {
		return dataIsencaoIr;
	}

	public void setDataIsencaoIr(Date dataIsencaoIr) {
		this.dataIsencaoIr = dataIsencaoIr;
	}

	public BigDecimal getValorQuintosDecimos() {
		return valorQuintosDecimos;
	}

	public BigInteger getQuantidadeAnuenios() {
		return quantidadeAnuenios;
	}

	public BigDecimal getValorVpni() {
		return valorVpni;
	}

	public BigDecimal getValorAuxilioAlimentacao() {
		return valorAuxilioAlimentacao;
	}

	public int getQuantidadeDiasferiasSaldo() {
		return quantidadeDiasferiasSaldo;
	}

	public BigDecimal getValorFeriasUmTerco() {
		return valorFeriasUmTerco;
	}

	public BigDecimal getValorGratificacaoNatalinaAdiantamento() {
		return valorGratificacaoNatalinaAdiantamento;
	}

	public TipoIsencao getTipoIsencaoIr() {
		return tipoIsencaoIr;
	}

	public String getDescricaoCalculoIsencaoIr() {
		return descricaoCalculoIsencaoIr;
	}

	public TipoIsencao getTipoIsencaoPSS() {
		return tipoIsencaoPSS;
	}

	public Date getDataIsencaoPSS() {
		return dataIsencaoPSS;
	}

	public String getDescricaoCalculoIsencaoPSS() {
		return descricaoCalculoIsencaoPSS;
	}

	public void setValorQuintosDecimos(BigDecimal valorQuintosDecimos) {
		this.valorQuintosDecimos = valorQuintosDecimos;
	}

	public void setQuantidadeAnuenios(BigInteger quantidadeAnuenios) {
		this.quantidadeAnuenios = quantidadeAnuenios;
	}

	public void setValorVpni(BigDecimal valorVpni) {
		this.valorVpni = valorVpni;
	}

	public void setValorAuxilioAlimentacao(BigDecimal valorAuxilioAlimentacao) {
		this.valorAuxilioAlimentacao = valorAuxilioAlimentacao;
	}

	public void setQuantidadeDiasferiasSaldo(int quantidadeDiasferiasSaldo) {
		this.quantidadeDiasferiasSaldo = quantidadeDiasferiasSaldo;
	}

	public void setValorFeriasUmTerco(BigDecimal valorFeriasUmTerco) {
		this.valorFeriasUmTerco = valorFeriasUmTerco;
	}

	public void setValorGratificacaoNatalinaAdiantamento(BigDecimal valorGratificacaoNatalinaAdiantamento) {
		this.valorGratificacaoNatalinaAdiantamento = valorGratificacaoNatalinaAdiantamento;
	}

	public void setTipoIsencaoIr(TipoIsencao tipoIsencaoIr) {
		this.tipoIsencaoIr = tipoIsencaoIr;
	}

	public void setDescricaoCalculoIsencaoIr(String descricaoCalculoIsencaoIr) {
		this.descricaoCalculoIsencaoIr = descricaoCalculoIsencaoIr;
	}

	public void setTipoIsencaoPSS(TipoIsencao tipoIsencaoPSS) {
		this.tipoIsencaoPSS = tipoIsencaoPSS;
	}

	public void setDataIsencaoPSS(Date dataIsencaoPSS) {
		this.dataIsencaoPSS = dataIsencaoPSS;
	}

	public void setDescricaoCalculoIsencaoPSS(String descricaoCalculoIsencaoPSS) {
		this.descricaoCalculoIsencaoPSS = descricaoCalculoIsencaoPSS;
	}

	public Date getDataInicioAbonoPermanencia() {
		return dataInicioAbonoPermanencia;
	}

	public void setDataInicioAbonoPermanencia(Date dataInicioAbonoPermanencia) {
		this.dataInicioAbonoPermanencia = dataInicioAbonoPermanencia;
	}

}
