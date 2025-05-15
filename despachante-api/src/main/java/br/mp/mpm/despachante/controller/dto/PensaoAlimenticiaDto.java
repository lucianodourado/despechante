package br.mp.mpm.despachante.controller.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.mp.mpm.despachante.model.PensaoAlimenticia;
import br.mp.mpm.despachante.util.UtilData;

public class PensaoAlimenticiaDto {

	private Integer tipoBaseCalculo;
	private String dataInicioPagamento;
	private BigDecimal valorReferencia;
	private BigDecimal valorAdiantamentoGratificaoNatalina;
	private String descricaoDescontoJudicial;
	private BigInteger cpfRepresentanteLegal;
	private String nomeRepresentanteLegal;
	private BigInteger banco;
	private BigInteger agencia;
	private String agenciaDv;
	private BigInteger conta;
	private String contaDv;	
	private String nomePensionista;
	private String dataNascimentoPensionista;
	private String grauParentescoPensionista;	
	private Character sexoPensionista;
	private String nomeMaePensionista;
	private String cpfPensionista;		
	private String rgPensionista;
	private String rgOrgaoEmissorPensionista;	
	private String rgUfEmissaoPensionista;	
	private String rgDataEmissaoPensionista;
	

	public PensaoAlimenticiaDto() {		
	}
	
	public PensaoAlimenticiaDto(PensaoAlimenticia entity) {
		BeanUtils.copyProperties(entity, this);		
		this.tipoBaseCalculo = entity.getTipoBaseCalculo() != null ? entity.getTipoBaseCalculo().getId() : null;
		this.dataInicioPagamento = UtilData.convertDateParaString(entity.getDataInicioPagamento(), "dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static PensaoAlimenticiaDto converter(PensaoAlimenticia entity) {
		return new PensaoAlimenticiaDto(entity);
	}

	public static List<PensaoAlimenticiaDto> converter(Collection<PensaoAlimenticia> lista) {
		return lista.stream().map(PensaoAlimenticiaDto::new).collect(Collectors.toList());
	}

	public Integer getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public String getDataInicioPagamento() {
		return dataInicioPagamento;
	}

	public BigDecimal getValorReferencia() {
		return valorReferencia;
	}

	public BigDecimal getValorAdiantamentoGratificaoNatalina() {
		return valorAdiantamentoGratificaoNatalina;
	}

	public String getDescricaoDescontoJudicial() {
		return descricaoDescontoJudicial;
	}

	public BigInteger getCpfRepresentanteLegal() {
		return cpfRepresentanteLegal;
	}

	public String getNomeRepresentanteLegal() {
		return nomeRepresentanteLegal;
	}

	public BigInteger getBanco() {
		return banco;
	}

	public BigInteger getAgencia() {
		return agencia;
	}

	public String getAgenciaDv() {
		return agenciaDv;
	}

	public BigInteger getConta() {
		return conta;
	}

	public String getContaDv() {
		return contaDv;
	}

	public String getNomePensionista() {
		return nomePensionista;
	}

	public String getDataNascimentoPensionista() {
		return dataNascimentoPensionista;
	}

	public String getGrauParentescoPensionista() {
		return grauParentescoPensionista;
	}

	public Character getSexoPensionista() {
		return sexoPensionista;
	}

	public String getNomeMaePensionista() {
		return nomeMaePensionista;
	}

	public String getCpfPensionista() {
		return cpfPensionista;
	}

	public String getRgPensionista() {
		return rgPensionista;
	}

	public String getRgOrgaoEmissorPensionista() {
		return rgOrgaoEmissorPensionista;
	}

	public String getRgUfEmissaoPensionista() {
		return rgUfEmissaoPensionista;
	}

	public String getRgDataEmissaoPensionista() {
		return rgDataEmissaoPensionista;
	}

	public void setTipoBaseCalculo(Integer tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public void setDataInicioPagamento(String dataInicioPagamento) {
		this.dataInicioPagamento = dataInicioPagamento;
	}

	public void setValorReferencia(BigDecimal valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	public void setValorAdiantamentoGratificaoNatalina(BigDecimal valorAdiantamentoGratificaoNatalina) {
		this.valorAdiantamentoGratificaoNatalina = valorAdiantamentoGratificaoNatalina;
	}

	public void setDescricaoDescontoJudicial(String descricaoDescontoJudicial) {
		this.descricaoDescontoJudicial = descricaoDescontoJudicial;
	}

	public void setCpfRepresentanteLegal(BigInteger cpfRepresentanteLegal) {
		this.cpfRepresentanteLegal = cpfRepresentanteLegal;
	}

	public void setNomeRepresentanteLegal(String nomeRepresentanteLegal) {
		this.nomeRepresentanteLegal = nomeRepresentanteLegal;
	}

	public void setBanco(BigInteger banco) {
		this.banco = banco;
	}

	public void setAgencia(BigInteger agencia) {
		this.agencia = agencia;
	}

	public void setAgenciaDv(String agenciaDv) {
		this.agenciaDv = agenciaDv;
	}

	public void setConta(BigInteger conta) {
		this.conta = conta;
	}

	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

	public void setNomePensionista(String nomePensionista) {
		this.nomePensionista = nomePensionista;
	}

	public void setDataNascimentoPensionista(String dataNascimentoPensionista) {
		this.dataNascimentoPensionista = dataNascimentoPensionista;
	}

	public void setGrauParentescoPensionista(String grauParentescoPensionista) {
		this.grauParentescoPensionista = grauParentescoPensionista;
	}

	public void setSexoPensionista(Character sexoPensionista) {
		this.sexoPensionista = sexoPensionista;
	}

	public void setNomeMaePensionista(String nomeMaePensionista) {
		this.nomeMaePensionista = nomeMaePensionista;
	}

	public void setCpfPensionista(String cpfPensionista) {
		this.cpfPensionista = cpfPensionista;
	}

	public void setRgPensionista(String rgPensionista) {
		this.rgPensionista = rgPensionista;
	}

	public void setRgOrgaoEmissorPensionista(String rgOrgaoEmissorPensionista) {
		this.rgOrgaoEmissorPensionista = rgOrgaoEmissorPensionista;
	}

	public void setRgUfEmissaoPensionista(String rgUfEmissaoPensionista) {
		this.rgUfEmissaoPensionista = rgUfEmissaoPensionista;
	}

	public void setRgDataEmissaoPensionista(String rgDataEmissaoPensionista) {
		this.rgDataEmissaoPensionista = rgDataEmissaoPensionista;
	}
	
}
