package br.mp.mpm.despachante.controller.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import br.mp.mpm.despachante.model.Dependente;
import br.mp.mpm.despachante.util.UtilData;

public class DependenteDto {

	private String nome;
	private String dataNascimento;
	private String grauParentesco;
	private Integer sexo;
	private String nomeMae;
	private String cpf;
	private String rg;
	private String rgOrgaoEmissor;
	private String rgUfEmissao;
	private String rgDataEmissao;
	private String dataVigenciaAuxilioPreEscolar;

	public DependenteDto() {		
	}
	
	public DependenteDto(Dependente entity) {
		BeanUtils.copyProperties(entity, this);		
		this.dataNascimento = UtilData.convertDateParaString(entity.getDataNascimento(), "dd/MM/yyyy");
		this.sexo = entity.getSexo() != null ? entity.getSexo().getId() : null;
		this.rgDataEmissao = UtilData.convertDateParaString(entity.getRgDataEmissao(), "dd/MM/yyyy");
		this.dataVigenciaAuxilioPreEscolar = UtilData.convertDateParaString(entity.getDataVigenciaAuxilioPreEscolar(),
				"dd/MM/yyyy");
	}

	// conversores de Entity <--> Dto
	public static DependenteDto converter(Dependente entity) {
		return new DependenteDto(entity);
	}

	public static List<DependenteDto> converter(Collection<Dependente> lista) {
		return lista.stream().map(DependenteDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public Integer getSexo() {
		return sexo;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}

	public String getRgUfEmissao() {
		return rgUfEmissao;
	}

	public String getRgDataEmissao() {
		return rgDataEmissao;
	}

	public String getDataVigenciaAuxilioPreEscolar() {
		return dataVigenciaAuxilioPreEscolar;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public void setRgUfEmissao(String rgUfEmissao) {
		this.rgUfEmissao = rgUfEmissao;
	}

	public void setRgDataEmissao(String rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}

	public void setDataVigenciaAuxilioPreEscolar(String dataVigenciaAuxilioPreEscolar) {
		this.dataVigenciaAuxilioPreEscolar = dataVigenciaAuxilioPreEscolar;
	}

}
