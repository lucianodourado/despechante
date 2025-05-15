package br.mp.mpm.despachante.controller.dto;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import br.mp.mpm.despachante.model.PessoaRemovida;
import br.mp.mpm.despachante.util.UtilData;

public class PessoaRemovidaDto {

	private BigInteger matricula;
	private String nomeSocial;
	private String nomeCivil;
	private String dataNascimento;
	private Integer sexo;
	private Integer identidadeGenero;
	private long enderecoCep;
	private String enderecoResidencial;
	private String enderecoNumero;
	private String enderecoComplemento;
	private String enderecoBairro;
	private String enderecoUf;
	private String enderecoMunicipio;
	private String enderecoPais;
	private BigInteger enderecoCodigoIbge;
	private String emailParticular;
	private Integer estadoCivil;
	private Integer uniaoEstavel;
	private String nomeConjuge;
	private String dataCasamento;
	private Integer raca;
	private Integer doadorSangue;
	private String tipoSanguineo;
	private String fatorRh;
	private Integer pne;
	private String naturalidade;
	private String naturalidadeUf;
	private String nacionalidade;
	private String paisNascimento;
	private Integer grauInstrucao;
	private String formacaoProfissional;
	private String cargo;
	private String cargoNivel;
	private String cargoClasse;
	private String cargoPadrao;
	private String dataUltimaProgressao;
	private String dataNomeacao;
	private String dataExercicio;
	private String dataPosse;
	private String dataExercicioIninterruptoMpu;
	private String unidadeLotacaoRemovido;
	private Integer regimePrevidenciario;
	private String cpf;
	private String rgNumero;
	private String rgOrgao;
	private String rgDataEmissao;
	private String rgUfEmissao;
	private BigInteger tituloNumero;
	private String tituloZona;
	private String tituloSecao;
	private String tituloUf;
	private String tituloDataEmissao;
	private String certificadoMilitar; //TODO: tá vindo como string. ex: 257198-Q":
	private String certificadoMilitarDataEmissao;
	private BigInteger cnh;
	private String cnhCategoria;
	private String cnhDataEmissao;
	private String cnhDataValidade;
	private String cnhUfEmissao;
	private String registroProfissional;
	private String registroProfissionalTipo;
	private String registroProfissionalDataEmissao;
	private String registroProfissionalUfEmissao;
	private BigInteger pisPasep;
	private Integer primeiroEmprego;
	private Integer recebeAposentadoria;
	private BigInteger banco;
	private BigInteger agencia;
	private String agenciaDv;
	private BigInteger conta;
	private String contaDv;
	private String portariaRemocao;	

	private Collection<DependenteDto> dependente;
	private Collection<TreinamentoDto> treinamento;
	private Collection<PagamentoDto> pagamento;
	private Collection<ConsignadoDto> consignado;
	private Collection<SindicatoAssociacaoDto> sindicatoAssociacao;
	private Collection<DescontoJudicialDto> descontoJudicial;
	private Collection<FunprespDto> funpresp;
	private Collection<PrevidenciaAgrupamentoDto> previdenciaAgrupamento;
	private Collection<PensaoAlimenticiaDto> pensaoAlimenticia;
	private Collection<FeriasDto> ferias;

	public PessoaRemovidaDto() {
		super();
	}
	
	public PessoaRemovidaDto(PessoaRemovida entity) {
		BeanUtils.copyProperties(entity, this);		
		this.dataNascimento = UtilData.convertDateParaString(entity.getDataNascimento(), "dd/MM/yyyy");
		this.sexo = entity.getSexo() != null ? entity.getSexo().getId() : null;
		this.identidadeGenero = entity.getIdentidadeGenero() != null ? entity.getIdentidadeGenero().getId() : null;
		this.estadoCivil = entity.getEstadoCivil() != null ? entity.getEstadoCivil().getId() : null;
		this.dataCasamento = UtilData.convertDateParaString(entity.getDataCasamento(), "dd/MM/yyyy");
		this.raca = entity.getRaca() != null ? entity.getRaca().getId() : null;
		this.tipoSanguineo = entity.getTipoSanguineo() != null ? entity.getTipoSanguineo().name() : null;
		this.fatorRh = entity.getFatorRh() != null ? entity.getFatorRh().name() : null;
		this.grauInstrucao = entity.getGrauInstrucao() != null ? entity.getGrauInstrucao().getId() : null;
		this.cargo = entity.getCargo().getId();
		this.cargoClasse = entity.getCargoClasse() != null ? entity.getCargoClasse().name() : null;
		this.dataUltimaProgressao = UtilData.convertDateParaString(entity.getDataUltimaProgressao(), "dd/MM/yyyy");
		this.dataNomeacao = UtilData.convertDateParaString(entity.getDataNomeacao(), "dd/MM/yyyy");
		this.dataExercicio = UtilData.convertDateParaString(entity.getDataExercicio(), "dd/MM/yyyy");
		this.dataPosse = UtilData.convertDateParaString(entity.getDataPosse(), "dd/MM/yyyy");
		this.dataExercicioIninterruptoMpu = UtilData.convertDateParaString(entity.getDataExercicioIninterruptoMpu(), "dd/MM/yyyy");
		this.regimePrevidenciario = entity.getRegimePrevidenciario() != null ? entity.getRegimePrevidenciario().getId() : null;
		this.rgDataEmissao = UtilData.convertDateParaString(entity.getRgDataEmissao(), "dd/MM/yyyy");
		this.tituloDataEmissao = UtilData.convertDateParaString(entity.getTituloDataEmissao(), "dd/MM/yyyy");
		this.certificadoMilitarDataEmissao = UtilData.convertDateParaString(entity.getCertificadoMilitarDataEmissao(), "dd/MM/yyyy");
		this.cnhCategoria = entity.getCnhCategoria() != null ? entity.getCnhCategoria().name() : null;
		this.cnhDataEmissao = UtilData.convertDateParaString(entity.getCnhDataEmissao(), "dd/MM/yyyy");
		this.cnhDataValidade = UtilData.convertDateParaString(entity.getCnhDataValidade(), "dd/MM/yyyy");
		this.registroProfissionalDataEmissao = UtilData.convertDateParaString(entity.getRegistroProfissionalDataEmissao(), "dd/MM/yyyy");
		this.portariaRemocao = entity.getPortariaRemocao() != null ? entity.getPortariaRemocao() : null;

		this.treinamento = TreinamentoDto.converter(entity.getTreinamento());
		this.dependente = DependenteDto.converter(entity.getDependente());
		this.pagamento = PagamentoDto.converter(entity.getPagamento());
		this.consignado = ConsignadoDto.converter(entity.getConsignado());
		this.sindicatoAssociacao = SindicatoAssociacaoDto.converter(entity.getSindicatoAssociacao());
		this.descontoJudicial = DescontoJudicialDto.converter(entity.getDescontoJudicial());
		this.funpresp = FunprespDto.converter(entity.getFunpresp());
		this.previdenciaAgrupamento = PrevidenciaAgrupamentoDto.converter(entity.getPrevidenciaAgrupamento());
		this.pensaoAlimenticia = PensaoAlimenticiaDto.converter(entity.getPensaoAlimenticia());
		this.ferias = FeriasDto.converter(entity.getFerias());
	}
	
	// conversores de Entity <--> Dto
	public static PessoaRemovidaDto converter(PessoaRemovida entity) {
		return new PessoaRemovidaDto(entity);
	}

	public static List<PessoaRemovidaDto> converter(Collection<PessoaRemovida> lista) {
		return lista.stream().map(PessoaRemovidaDto::new).collect(Collectors.toList());
	}

	public static Page<PessoaRemovidaDto> converter(Page<PessoaRemovida> lista) {
		return lista.map(PessoaRemovidaDto::new);
	}


	public BigInteger getMatricula() {
		return matricula;
	}


	public String getNomeSocial() {
		return nomeSocial;
	}


	public String getNomeCivil() {
		return nomeCivil;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public Integer getSexo() {
		return sexo;
	}


	public Integer getIdentidadeGenero() {
		return identidadeGenero;
	}


	public long getEnderecoCep() {
		return enderecoCep;
	}


	public String getEnderecoResidencial() {
		return enderecoResidencial;
	}


	public String getEnderecoNumero() {
		return enderecoNumero;
	}


	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}


	public String getEnderecoBairro() {
		return enderecoBairro;
	}


	public String getEnderecoUf() {
		return enderecoUf;
	}


	public String getEnderecoMunicipio() {
		return enderecoMunicipio;
	}


	public String getEnderecoPais() {
		return enderecoPais;
	}


	public BigInteger getEnderecoCodigoIbge() {
		return enderecoCodigoIbge;
	}


	public String getEmailParticular() {
		return emailParticular;
	}


	public Integer getEstadoCivil() {
		return estadoCivil;
	}


	public Integer getUniaoEstavel() {
		return uniaoEstavel;
	}


	public String getNomeConjuge() {
		return nomeConjuge;
	}


	public String getDataCasamento() {
		return dataCasamento;
	}


	public Integer getRaca() {
		return raca;
	}


	public Integer getDoadorSangue() {
		return doadorSangue;
	}


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public String getFatorRh() {
		return fatorRh;
	}


	public Integer getPne() {
		return pne;
	}


	public String getNaturalidade() {
		return naturalidade;
	}


	public String getNaturalidadeUf() {
		return naturalidadeUf;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public String getPaisNascimento() {
		return paisNascimento;
	}


	public Integer getGrauInstrucao() {
		return grauInstrucao;
	}


	public String getFormacaoProfissional() {
		return formacaoProfissional;
	}


	public String getCargo() {
		return cargo;
	}


	public String getCargoNivel() {
		return cargoNivel;
	}


	public String getCargoClasse() {
		return cargoClasse;
	}


	public String getCargoPadrao() {
		return cargoPadrao;
	}


	public String getDataUltimaProgressao() {
		return dataUltimaProgressao;
	}


	public String getDataNomeacao() {
		return dataNomeacao;
	}


	public String getDataExercicio() {
		return dataExercicio;
	}


	public String getDataPosse() {
		return dataPosse;
	}


	public String getDataExercicioIninterruptoMpu() {
		return dataExercicioIninterruptoMpu;
	}


	public String getUnidadeLotacaoRemovido() {
		return unidadeLotacaoRemovido;
	}


	public Integer getRegimePrevidenciario() {
		return regimePrevidenciario;
	}


	public String getCpf() {
		return cpf;
	}


	public String getRgNumero() {
		return rgNumero;
	}


	public String getRgOrgao() {
		return rgOrgao;
	}


	public String getRgDataEmissao() {
		return rgDataEmissao;
	}


	public String getRgUfEmissao() {
		return rgUfEmissao;
	}


	public BigInteger getTituloNumero() {
		return tituloNumero;
	}


	public String getTituloZona() {
		return tituloZona;
	}


	public String getTituloSecao() {
		return tituloSecao;
	}


	public String getTituloUf() {
		return tituloUf;
	}


	public String getTituloDataEmissao() {
		return tituloDataEmissao;
	}


	public String getCertificadoMilitar() {
		return certificadoMilitar;
	}


	public String getCertificadoMilitarDataEmissao() {
		return certificadoMilitarDataEmissao;
	}


	public BigInteger getCnh() {
		return cnh;
	}


	public String getCnhCategoria() {
		return cnhCategoria;
	}


	public String getCnhDataEmissao() {
		return cnhDataEmissao;
	}


	public String getCnhDataValidade() {
		return cnhDataValidade;
	}


	public String getCnhUfEmissao() {
		return cnhUfEmissao;
	}


	public String getRegistroProfissional() {
		return registroProfissional;
	}


	public String getRegistroProfissionalTipo() {
		return registroProfissionalTipo;
	}


	public String getRegistroProfissionalDataEmissao() {
		return registroProfissionalDataEmissao;
	}


	public String getRegistroProfissionalUfEmissao() {
		return registroProfissionalUfEmissao;
	}


	public BigInteger getPisPasep() {
		return pisPasep;
	}


	public Integer getPrimeiroEmprego() {
		return primeiroEmprego;
	}


	public Integer getRecebeAposentadoria() {
		return recebeAposentadoria;
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


	public String getPortariaRemocao() {
		return portariaRemocao;
	}


	public Collection<DependenteDto> getDependente() {
		return dependente;
	}


	public Collection<TreinamentoDto> getTreinamento() {
		return treinamento;
	}


	public Collection<PagamentoDto> getPagamento() {
		return pagamento;
	}


	public Collection<ConsignadoDto> getConsignado() {
		return consignado;
	}


	public Collection<SindicatoAssociacaoDto> getSindicatoAssociacao() {
		return sindicatoAssociacao;
	}


	public Collection<DescontoJudicialDto> getDescontoJudicial() {
		return descontoJudicial;
	}


	public Collection<FunprespDto> getFunpresp() {
		return funpresp;
	}


	public Collection<PrevidenciaAgrupamentoDto> getPrevidenciaAgrupamento() {
		return previdenciaAgrupamento;
	}


	public Collection<PensaoAlimenticiaDto> getPensaoAlimenticia() {
		return pensaoAlimenticia;
	}


	public Collection<FeriasDto> getFerias() {
		return ferias;
	}


	public void setMatricula(BigInteger matricula) {
		this.matricula = matricula;
	}


	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}


	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}


	public void setIdentidadeGenero(Integer identidadeGenero) {
		this.identidadeGenero = identidadeGenero;
	}


	public void setEnderecoCep(long enderecoCep) {
		this.enderecoCep = enderecoCep;
	}


	public void setEnderecoResidencial(String enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}


	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}


	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}


	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}


	public void setEnderecoUf(String enderecoUf) {
		this.enderecoUf = enderecoUf;
	}


	public void setEnderecoMunicipio(String enderecoMunicipio) {
		this.enderecoMunicipio = enderecoMunicipio;
	}


	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
	}


	public void setEnderecoCodigoIbge(BigInteger enderecoCodigoIbge) {
		this.enderecoCodigoIbge = enderecoCodigoIbge;
	}


	public void setEmailParticular(String emailParticular) {
		this.emailParticular = emailParticular;
	}


	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public void setUniaoEstavel(Integer uniaoEstavel) {
		this.uniaoEstavel = uniaoEstavel;
	}


	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}


	public void setDataCasamento(String dataCasamento) {
		this.dataCasamento = dataCasamento;
	}


	public void setRaca(Integer raca) {
		this.raca = raca;
	}


	public void setDoadorSangue(Integer doadorSangue) {
		this.doadorSangue = doadorSangue;
	}


	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}


	public void setFatorRh(String fatorRh) {
		this.fatorRh = fatorRh;
	}


	public void setPne(Integer pne) {
		this.pne = pne;
	}


	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}


	public void setNaturalidadeUf(String naturalidadeUf) {
		this.naturalidadeUf = naturalidadeUf;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}


	public void setGrauInstrucao(Integer grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}


	public void setFormacaoProfissional(String formacaoProfissional) {
		this.formacaoProfissional = formacaoProfissional;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public void setCargoNivel(String cargoNivel) {
		this.cargoNivel = cargoNivel;
	}


	public void setCargoClasse(String cargoClasse) {
		this.cargoClasse = cargoClasse;
	}


	public void setCargoPadrao(String cargoPadrao) {
		this.cargoPadrao = cargoPadrao;
	}


	public void setDataUltimaProgressao(String dataUltimaProgressao) {
		this.dataUltimaProgressao = dataUltimaProgressao;
	}


	public void setDataNomeacao(String dataNomeacao) {
		this.dataNomeacao = dataNomeacao;
	}


	public void setDataExercicio(String dataExercicio) {
		this.dataExercicio = dataExercicio;
	}


	public void setDataPosse(String dataPosse) {
		this.dataPosse = dataPosse;
	}


	public void setDataExercicioIninterruptoMpu(String dataExercicioIninterruptoMpu) {
		this.dataExercicioIninterruptoMpu = dataExercicioIninterruptoMpu;
	}


	public void setUnidadeLotacaoRemovido(String unidadeLotacaoRemovido) {
		this.unidadeLotacaoRemovido = unidadeLotacaoRemovido;
	}


	public void setRegimePrevidenciario(Integer regimePrevidenciario) {
		this.regimePrevidenciario = regimePrevidenciario;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}


	public void setRgOrgao(String rgOrgao) {
		this.rgOrgao = rgOrgao;
	}


	public void setRgDataEmissao(String rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}


	public void setRgUfEmissao(String rgUfEmissao) {
		this.rgUfEmissao = rgUfEmissao;
	}


	public void setTituloNumero(BigInteger tituloNumero) {
		this.tituloNumero = tituloNumero;
	}


	public void setTituloZona(String tituloZona) {
		this.tituloZona = tituloZona;
	}


	public void setTituloSecao(String tituloSecao) {
		this.tituloSecao = tituloSecao;
	}


	public void setTituloUf(String tituloUf) {
		this.tituloUf = tituloUf;
	}


	public void setTituloDataEmissao(String tituloDataEmissao) {
		this.tituloDataEmissao = tituloDataEmissao;
	}


	public void setCertificadoMilitar(String certificadoMilitar) {
		this.certificadoMilitar = certificadoMilitar;
	}


	public void setCertificadoMilitarDataEmissao(String certificadoMilitarDataEmissao) {
		this.certificadoMilitarDataEmissao = certificadoMilitarDataEmissao;
	}


	public void setCnh(BigInteger cnh) {
		this.cnh = cnh;
	}


	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}


	public void setCnhDataEmissao(String cnhDataEmissao) {
		this.cnhDataEmissao = cnhDataEmissao;
	}


	public void setCnhDataValidade(String cnhDataValidade) {
		this.cnhDataValidade = cnhDataValidade;
	}


	public void setCnhUfEmissao(String cnhUfEmissao) {
		this.cnhUfEmissao = cnhUfEmissao;
	}


	public void setRegistroProfissional(String registroProfissional) {
		this.registroProfissional = registroProfissional;
	}


	public void setRegistroProfissionalTipo(String registroProfissionalTipo) {
		this.registroProfissionalTipo = registroProfissionalTipo;
	}


	public void setRegistroProfissionalDataEmissao(String registroProfissionalDataEmissao) {
		this.registroProfissionalDataEmissao = registroProfissionalDataEmissao;
	}


	public void setRegistroProfissionalUfEmissao(String registroProfissionalUfEmissao) {
		this.registroProfissionalUfEmissao = registroProfissionalUfEmissao;
	}


	public void setPisPasep(BigInteger pisPasep) {
		this.pisPasep = pisPasep;
	}


	public void setPrimeiroEmprego(Integer primeiroEmprego) {
		this.primeiroEmprego = primeiroEmprego;
	}


	public void setRecebeAposentadoria(Integer recebeAposentadoria) {
		this.recebeAposentadoria = recebeAposentadoria;
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


	public void setPortariaRemocao(String portariaRemocao) {
		this.portariaRemocao = portariaRemocao;
	}


	public void setDependente(Collection<DependenteDto> dependente) {
		this.dependente = dependente;
	}


	public void setTreinamento(Collection<TreinamentoDto> treinamento) {
		this.treinamento = treinamento;
	}


	public void setPagamento(Collection<PagamentoDto> pagamento) {
		this.pagamento = pagamento;
	}


	public void setConsignado(Collection<ConsignadoDto> consignado) {
		this.consignado = consignado;
	}


	public void setSindicatoAssociacao(Collection<SindicatoAssociacaoDto> sindicatoAssociacao) {
		this.sindicatoAssociacao = sindicatoAssociacao;
	}


	public void setDescontoJudicial(Collection<DescontoJudicialDto> descontoJudicial) {
		this.descontoJudicial = descontoJudicial;
	}


	public void setFunpresp(Collection<FunprespDto> funpresp) {
		this.funpresp = funpresp;
	}


	public void setPrevidenciaAgrupamento(Collection<PrevidenciaAgrupamentoDto> previdenciaAgrupamento) {
		this.previdenciaAgrupamento = previdenciaAgrupamento;
	}


	public void setPensaoAlimenticia(Collection<PensaoAlimenticiaDto> pensaoAlimenticia) {
		this.pensaoAlimenticia = pensaoAlimenticia;
	}


	public void setFerias(Collection<FeriasDto> ferias) {
		this.ferias = ferias;
	}

}
