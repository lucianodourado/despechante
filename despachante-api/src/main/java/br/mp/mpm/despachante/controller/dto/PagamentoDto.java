package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.mp.mpm.despachante.model.Pagamento;
import br.mp.mpm.despachante.util.BigDecimalToStringConverter;
import br.mp.mpm.despachante.util.StringToBigDecimalConverter;
import br.mp.mpm.despachante.util.UtilData;

public class PagamentoDto {

	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)	
	private BigDecimal valorAdicionalQualificacao;
	
	private String dataExpiracaoAdicional1;
	private String dataExpiracaoAdicional2;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)		
	private BigDecimal valorQuintosDecimos;
	private BigInteger quantidadeAnuenios;
	private String dataInicioAbonoPermanencia;
	private BigDecimal valorVpni;
	private BigDecimal valorAuxilioAlimentacao;
	private Integer feriasAnoExercicio;
	private Integer quantidadeDiasferiasSaldo;
	private Integer feriasUmTerco;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)		
	private BigDecimal valorFeriasUmTerco;
	
	private int feriasAdiantamentoIr;
	
	@JsonSerialize(converter = BigDecimalToStringConverter.class)
	@JsonDeserialize(converter = StringToBigDecimalConverter.class)			
	private BigDecimal valorGratificacaoNatalinaAdiantamento;
	private Integer tipoIsencaoIr;	
	private String dataIsencaoIr;
	private String descricaoCalculoIsencaoIr;
	private Integer tipoIsencaoPSS;	
	private String dataIsencaoPSS;	
	private String descricaoCalculoIsencaoPSS;
	
	public PagamentoDto() {
	}
	
	public PagamentoDto(Pagamento entity) {
		BeanUtils.copyProperties(entity, this);		
		this.dataExpiracaoAdicional1 = UtilData.convertDateParaString(entity.getDataExpiracaoAdicional1(),
				"dd/MM/yyyy");
		this.dataExpiracaoAdicional2 = UtilData.convertDateParaString(entity.getDataExpiracaoAdicional2(),
				"dd/MM/yyyy");
		this.dataInicioAbonoPermanencia = UtilData.convertDateParaString(entity.getDataInicioAbonoPermanencia(),
				"dd/MM/yyyy");
		this.dataInicioAbonoPermanencia = UtilData.convertDateParaString(entity.getDataInicioAbonoPermanencia(),"dd/MM/yyyy");
		this.tipoIsencaoIr = entity.getTipoIsencaoIr().getId();
		this.dataIsencaoIr = UtilData.convertDateParaString(entity.getDataIsencaoIr(), "dd/MM/yyyy");
		this.tipoIsencaoPSS = entity.getTipoIsencaoPSS().getId();
		this.dataIsencaoPSS = UtilData.convertDateParaString(entity.getDataIsencaoPSS(),"dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static PagamentoDto converter(Pagamento entity) {
		return new PagamentoDto(entity);
	}

	public static List<PagamentoDto> converter(Collection<Pagamento> lista) {
		return lista.stream().map(PagamentoDto::new).collect(Collectors.toList());
	}

	public BigDecimal getValorAdicionalQualificacao() {
		return valorAdicionalQualificacao;
	}

	public String getDataExpiracaoAdicional1() {
		return dataExpiracaoAdicional1;
	}

	public String getDataExpiracaoAdicional2() {
		return dataExpiracaoAdicional2;
	}

	public BigDecimal getValorQuintosDecimos() {
		return valorQuintosDecimos;
	}

	public BigInteger getQuantidadeAnuenios() {
		return quantidadeAnuenios;
	}

	public String getDataInicioAbonoPermanencia() {
		return dataInicioAbonoPermanencia;
	}

	public BigDecimal getValorVpni() {
		return valorVpni;
	}

	public BigDecimal getValorAuxilioAlimentacao() {
		return valorAuxilioAlimentacao;
	}

	public Integer getFeriasAnoExercicio() {
		return feriasAnoExercicio;
	}

	public Integer getQuantidadeDiasferiasSaldo() {
		return quantidadeDiasferiasSaldo;
	}

	public Integer getFeriasUmTerco() {
		return feriasUmTerco;
	}

	public BigDecimal getValorFeriasUmTerco() {
		return valorFeriasUmTerco;
	}

	public int getFeriasAdiantamentoIr() {
		return feriasAdiantamentoIr;
	}

	public BigDecimal getValorGratificacaoNatalinaAdiantamento() {
		return valorGratificacaoNatalinaAdiantamento;
	}

	public Integer getTipoIsencaoIr() {
		return tipoIsencaoIr;
	}

	public String getDataIsencaoIr() {
		return dataIsencaoIr;
	}

	public String getDescricaoCalculoIsencaoIr() {
		return descricaoCalculoIsencaoIr;
	}

	public Integer getTipoIsencaoPSS() {
		return tipoIsencaoPSS;
	}

	public String getDataIsencaoPSS() {
		return dataIsencaoPSS;
	}

	public String getDescricaoCalculoIsencaoPSS() {
		return descricaoCalculoIsencaoPSS;
	}

	public void setValorAdicionalQualificacao(BigDecimal valorAdicionalQualificacao) {
		this.valorAdicionalQualificacao = valorAdicionalQualificacao;
	}

	public void setDataExpiracaoAdicional1(String dataExpiracaoAdicional1) {
		this.dataExpiracaoAdicional1 = dataExpiracaoAdicional1;
	}

	public void setDataExpiracaoAdicional2(String dataExpiracaoAdicional2) {
		this.dataExpiracaoAdicional2 = dataExpiracaoAdicional2;
	}

	public void setValorQuintosDecimos(BigDecimal valorQuintosDecimos) {
		this.valorQuintosDecimos = valorQuintosDecimos;
	}

	public void setQuantidadeAnuenios(BigInteger quantidadeAnuenios) {
		this.quantidadeAnuenios = quantidadeAnuenios;
	}

	public void setDataInicioAbonoPermanencia(String dataInicioAbonoPermanencia) {
		this.dataInicioAbonoPermanencia = dataInicioAbonoPermanencia;
	}

	public void setValorVpni(BigDecimal valorVpni) {
		this.valorVpni = valorVpni;
	}

	public void setValorAuxilioAlimentacao(BigDecimal valorAuxilioAlimentacao) {
		this.valorAuxilioAlimentacao = valorAuxilioAlimentacao;
	}

	public void setFeriasAnoExercicio(Integer feriasAnoExercicio) {
		this.feriasAnoExercicio = feriasAnoExercicio;
	}

	public void setQuantidadeDiasferiasSaldo(Integer quantidadeDiasferiasSaldo) {
		this.quantidadeDiasferiasSaldo = quantidadeDiasferiasSaldo;
	}

	public void setFeriasUmTerco(Integer feriasUmTerco) {
		this.feriasUmTerco = feriasUmTerco;
	}

	public void setValorFeriasUmTerco(BigDecimal valorFeriasUmTerco) {
		this.valorFeriasUmTerco = valorFeriasUmTerco;
	}

	public void setFeriasAdiantamentoIr(int feriasAdiantamentoIr) {
		this.feriasAdiantamentoIr = feriasAdiantamentoIr;
	}

	public void setValorGratificacaoNatalinaAdiantamento(BigDecimal valorGratificacaoNatalinaAdiantamento) {
		this.valorGratificacaoNatalinaAdiantamento = valorGratificacaoNatalinaAdiantamento;
	}

	public void setTipoIsencaoIr(Integer tipoIsencaoIr) {
		this.tipoIsencaoIr = tipoIsencaoIr;
	}

	public void setDataIsencaoIr(String dataIsencaoIr) {
		this.dataIsencaoIr = dataIsencaoIr;
	}

	public void setDescricaoCalculoIsencaoIr(String descricaoCalculoIsencaoIr) {
		this.descricaoCalculoIsencaoIr = descricaoCalculoIsencaoIr;
	}

	public void setTipoIsencaoPSS(Integer tipoIsencaoPSS) {
		this.tipoIsencaoPSS = tipoIsencaoPSS;
	}

	public void setDataIsencaoPSS(String dataIsencaoPSS) {
		this.dataIsencaoPSS = dataIsencaoPSS;
	}

	public void setDescricaoCalculoIsencaoPSS(String descricaoCalculoIsencaoPSS) {
		this.descricaoCalculoIsencaoPSS = descricaoCalculoIsencaoPSS;
	}
	
}
