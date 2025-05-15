package br.mp.mpm.despachante.controller.dto;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.mp.mpm.despachante.model.PessoaInterno;
import br.mp.mpm.despachante.model.PessoaRemovidaJson;
import br.mp.mpm.despachante.util.UtilData;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PessoaDto {

	private BigInteger matricula;
	private String nome;
	private String ramo;	
	private String dataNascimento;
	private String cargo;
	private String cpf;

	public PessoaDto(PessoaInterno entity) {
		this.matricula = entity.getMatricula();
		this.nome = entity.getNomeCivil();
		this.dataNascimento = UtilData.convertDateParaString(entity.getDataNascimento(), "dd/MM/yyyy");
		this.cargo = entity.getCargo().getId();
		this.cpf = entity.getCpf();
	}

	public PessoaDto(PessoaRemovidaJson entity) {
		this.matricula = entity.getMatricula();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.ramo = entity.getRamo();
	}
	
	public BigInteger getMatricula() {
		return matricula;
	}
	
	public void setMatricula(BigInteger matricula) {
		this.matricula = matricula;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static PessoaDto converter(PessoaInterno entity) {
		return new PessoaDto(entity);
	}

	public static PessoaDto converter(PessoaRemovidaJson entity) {
		return new PessoaDto(entity);
	}
	
	public static List<PessoaDto> converterOut(Collection<PessoaInterno> lista) {
		return lista.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

	public static Page<PessoaDto> converterOut(Page<PessoaInterno> lista) {
		return lista.map(PessoaDto::new);
	}

	public static List<PessoaDto> converterIn(Collection<PessoaRemovidaJson> lista) {
		return lista.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

	public static Page<PessoaDto> converterIn(Page<PessoaRemovidaJson> lista) {
		return lista.map(PessoaDto::new);
	}
	
	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

}
