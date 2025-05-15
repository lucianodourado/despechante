package br.mp.mpm.despachante.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.mp.mpm.despachante.model.enums.CargoClasse;
import br.mp.mpm.despachante.model.enums.CnhCategoria;
import br.mp.mpm.despachante.model.enums.FatorRh;
import br.mp.mpm.despachante.model.enums.TipoSanguineo;

@Entity
@Table(name = "PESSOA_REMOVIDA")
public class PessoaRemovida extends Pessoa {

	@Column(name = "id_pessoaremovida_mentor", nullable = false)
	private Long idMentor;

	@Column(length = 100, nullable = false)
	private String nomeCivil;
	
	@Column(length = 100)
	private String nomeSocial;
	
	@Column(nullable = false)
	private Date dataNascimento;

	@JoinColumn(name = "sexo", referencedColumnName = "id_sexo")
	@ManyToOne
	private Sexo sexo;

	@JoinColumn(name = "identidadeGenero", referencedColumnName = "id_identidade_genero")
	@ManyToOne
	private IdentidadeGenero identidadeGenero;

	@Column(nullable = false)	
	private long enderecoCep;

	@Column(length = 100, nullable = false)
	private String enderecoResidencial;

	@Column(length = 100, nullable = false)
	private String enderecoNumero;

	@Column(length = 100)
	private String enderecoComplemento;

	@Column(length = 100)
	private String enderecoBairro;

	@Column(length = 2, nullable = false)
	private String enderecoUf;

	@Column(length = 100, nullable = false)
	private String enderecoMunicipio;

	@Column(length = 100, nullable = false)
	private String enderecoPais;

	@Column(nullable = false)
	private BigInteger enderecoCodigoIbge;

	@Column(length = 100)
	private String emailParticular;

	@JoinColumn(name = "estadoCivil", referencedColumnName = "id_estado_civil")
	@ManyToOne
	private EstadoCivil estadoCivil;

	private int uniaoEstavel; // União estável. 1 para SIM; 0 para NÃO

	@Column(length = 100)
	private String nomeConjuge;

	private Date dataCasamento;

	@JoinColumn(name = "raca", referencedColumnName = "id_raca")
	@ManyToOne
	private Raca raca;

	private int doadorSangue; // Doador de sangue. 0 para NÃO; 1 para SIM;

	@Column(length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo; // Tipo sanguíneo. O, A, AB

	@Column(length = 1)
	@Enumerated(EnumType.STRING)
	private FatorRh fatorRh; // Fator RH. P ou N

	private int pne; // Portador de necessidades especiais. 0 NÃO; 1 SIM;

	@Column(length = 100)
	private String naturalidade;

	@Column(length = 2)
	private String naturalidadeUf;

	@Column(length = 100, nullable = false)
	private String nacionalidade;

	@Column(length = 100, nullable = false)
	private String paisNascimento;

	@JoinColumn(name = "grauInstrucao", referencedColumnName = "id_grau_instrucao")
	@ManyToOne
	private GrauInstrucao grauInstrucao;

	@Column(length = 200)
	private String formacaoProfissional;

	@NotBlank	
	@Column(length = 2, nullable = false)
	private String cargoNivel; // AN para ANALISTA; TC para TÉCNICO
	
	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private CargoClasse cargoClasse; // Classe do cargo. A, B, C

	@NotBlank
	@Column(length = 2, nullable = false)
	private String cargoPadrao; // Padrão do cargo. Valores de 1 a 13

	@Column(nullable = false)
	private Date dataUltimaProgressao;

	@Column(nullable = false)
	private Date dataNomeacao;

	@Column(nullable = false)
	private Date dataExercicio;

	@Column(nullable = false)
	private Date dataPosse;

	@Column(nullable = false)
	private Date dataExercicioIninterruptoMpu;

	@Column(length = 200)
	private String unidadeLotacaoRemovido;

	@JoinColumn(name = "regimePrevidenciario", referencedColumnName = "id_tipo_regime_previdenciario")
	@ManyToOne
	private TipoRegimePrevidenciario regimePrevidenciario;

	@Column(length = 11, nullable = false)
	private String cpf;
	
	@Column(length = 15, nullable = false)
	private String rgNumero;

	@Column(length = 100, nullable = false)
	private String rgOrgao;

	private Date rgDataEmissao;

	@Column(length = 2, nullable = false)
	private String rgUfEmissao;

	private BigInteger tituloNumero;

	@Column(length = 10)
	private String tituloZona;

	@Column(length = 10)
	private String tituloSecao;

	@Column(length = 2)
	private String tituloUf;

	private Date tituloDataEmissao;

	private BigInteger certificadoMilitar;

	private Date certificadoMilitarDataEmissao;

	private BigInteger cnh;

	@Column(length = 2)
	@Enumerated(EnumType.STRING)
	private CnhCategoria cnhCategoria; // Categoria do CNH. Exemplos A, B, C, D, E

	private Date cnhDataEmissao;

	private Date cnhDataValidade;

	@Column(length = 2)
	private String cnhUfEmissao;

	@Column(length = 20)
	private String registroProfissional;

	@Column(length = 100)
	private String registroProfissionalTipo;

	private Date registroProfissionalDataEmissao;

	@Column(length = 2)
	private String registroProfissionalUfEmissao;

	@Column(nullable = false)
	private BigInteger pisPasep;

	private Integer primeiroEmprego; // Primeiro emprego? 0 para NÃO; 1 para SIM;

	private Integer recebeAposentadoria; // Recebe aposentadoria? 0 para NÃO; 1 para SIM;

	@Column(nullable = false)
	private BigInteger banco;

	@Column(nullable = false)
	private BigInteger agencia;

	@Column(length = 1)
	private String agenciaDv;

	@Column(nullable = false)
	private BigInteger conta;

	@Column(length = 1, nullable = false)
	private String contaDv;

	@Column(length = 400)	
	private String portariaRemocao;
	
	@Column(nullable = false)
	private Boolean statusImportacaoRamo; // Marcado como importado por algum ramo.

	@Column(nullable = false)
	private Boolean statusDisponivelRamo; // Marcado para disponibilidade de remoção por ramo
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<Treinamento> treinamento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<Dependente> dependente;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<Pagamento> pagamento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<Consignado> consignado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<SindicatoAssociacao> sindicatoAssociacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<DescontoJudicial> descontoJudicial;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<Funpresp> funpresp;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<PrevidenciaAgrupamento> previdenciaAgrupamento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<Ferias> ferias;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaRemovida")
	private Collection<PensaoAlimenticia> pensaoAlimenticia;
	
	public Long getIdMentor() {
		return idMentor;
	}

	public void setIdMentor(Long idMentor) {
		this.idMentor = idMentor;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public IdentidadeGenero getIdentidadeGenero() {
		return identidadeGenero;
	}

	public void setIdentidadeGenero(IdentidadeGenero identidadeGenero) {
		this.identidadeGenero = identidadeGenero;
	}

	public long getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(long enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoResidencial() {
		return enderecoResidencial;
	}

	public void setEnderecoResidencial(String enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoUf() {
		return enderecoUf;
	}

	public void setEnderecoUf(String enderecoUf) {
		this.enderecoUf = enderecoUf;
	}

	public String getEnderecoMunicipio() {
		return enderecoMunicipio;
	}

	public void setEnderecoMunicipio(String enderecoMunicipio) {
		this.enderecoMunicipio = enderecoMunicipio;
	}

	public String getEnderecoPais() {
		return enderecoPais;
	}

	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
	}

	public BigInteger getEnderecoCodigoIbge() {
		return enderecoCodigoIbge;
	}

	public void setEnderecoCodigoIbge(BigInteger enderecoCodigoIbge) {
		this.enderecoCodigoIbge = enderecoCodigoIbge;
	}

	public String getEmailParticular() {
		return emailParticular;
	}

	public void setEmailParticular(String emailParticular) {
		this.emailParticular = emailParticular;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getUniaoEstavel() {
		return uniaoEstavel;
	}

	public void setUniaoEstavel(int uniaoEstavel) {
		this.uniaoEstavel = uniaoEstavel;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public Date getDataCasamento() {
		return dataCasamento;
	}

	public void setDataCasamento(Date dataCasamento) {
		this.dataCasamento = dataCasamento;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public int getDoadorSangue() {
		return doadorSangue;
	}

	public void setDoadorSangue(int doadorSangue) {
		this.doadorSangue = doadorSangue;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public FatorRh getFatorRh() {
		return fatorRh;
	}

	public void setFatorRh(FatorRh fatorRh) {
		this.fatorRh = fatorRh;
	}

	public int getPne() {
		return pne;
	}

	public void setPne(int pne) {
		this.pne = pne;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNaturalidadeUf() {
		return naturalidadeUf;
	}

	public void setNaturalidadeUf(String naturalidadeUf) {
		this.naturalidadeUf = naturalidadeUf;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getPaisNascimento() {
		return paisNascimento;
	}

	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public GrauInstrucao getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public String getFormacaoProfissional() {
		return formacaoProfissional;
	}

	public void setFormacaoProfissional(String formacaoProfissional) {
		this.formacaoProfissional = formacaoProfissional;
	}

	public String getCargoNivel() {
		return cargoNivel;
	}

	public void setCargoNivel(String cargoNivel) {
		this.cargoNivel = cargoNivel;
	}

	public CargoClasse getCargoClasse() {
		return cargoClasse;
	}

	public void setCargoClasse(CargoClasse cargoClasse) {
		this.cargoClasse = cargoClasse;
	}

	public String getCargoPadrao() {
		return cargoPadrao;
	}

	public void setCargoPadrao(String cargoPadrao) {
		this.cargoPadrao = cargoPadrao;
	}

	public Date getDataUltimaProgressao() {
		return dataUltimaProgressao;
	}

	public void setDataUltimaProgressao(Date dataUltimaProgressao) {
		this.dataUltimaProgressao = dataUltimaProgressao;
	}

	public Date getDataNomeacao() {
		return dataNomeacao;
	}

	public void setDataNomeacao(Date dataNomeacao) {
		this.dataNomeacao = dataNomeacao;
	}

	public Date getDataExercicio() {
		return dataExercicio;
	}

	public void setDataExercicio(Date dataExercicio) {
		this.dataExercicio = dataExercicio;
	}

	public Date getDataPosse() {
		return dataPosse;
	}

	public void setDataPosse(Date dataPosse) {
		this.dataPosse = dataPosse;
	}

	public Date getDataExercicioIninterruptoMpu() {
		return dataExercicioIninterruptoMpu;
	}

	public void setDataExercicioIninterruptoMpu(Date dataExercicioIninterruptoMpu) {
		this.dataExercicioIninterruptoMpu = dataExercicioIninterruptoMpu;
	}

	public String getUnidadeLotacaoRemovido() {
		return unidadeLotacaoRemovido;
	}

	public void setUnidadeLotacaoRemovido(String unidadeLotacaoRemovido) {
		this.unidadeLotacaoRemovido = unidadeLotacaoRemovido;
	}

	public TipoRegimePrevidenciario getRegimePrevidenciario() {
		return regimePrevidenciario;
	}

	public void setRegimePrevidenciario(TipoRegimePrevidenciario regimePrevidenciario) {
		this.regimePrevidenciario = regimePrevidenciario;
	}


	public String getRgNumero() {
		return rgNumero;
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}

	public String getRgOrgao() {
		return rgOrgao;
	}

	public void setRgOrgao(String rgOrgao) {
		this.rgOrgao = rgOrgao;
	}

	public Date getRgDataEmissao() {
		return rgDataEmissao;
	}

	public void setRgDataEmissao(Date rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}

	public String getRgUfEmissao() {
		return rgUfEmissao;
	}

	public void setRgUfEmissao(String rgUfEmissao) {
		this.rgUfEmissao = rgUfEmissao;
	}

	public BigInteger getTituloNumero() {
		return tituloNumero;
	}

	public void setTituloNumero(BigInteger tituloNumero) {
		this.tituloNumero = tituloNumero;
	}

	public String getTituloZona() {
		return tituloZona;
	}

	public void setTituloZona(String tituloZona) {
		this.tituloZona = tituloZona;
	}

	public String getTituloSecao() {
		return tituloSecao;
	}

	public void setTituloSecao(String tituloSecao) {
		this.tituloSecao = tituloSecao;
	}

	public String getTituloUf() {
		return tituloUf;
	}

	public void setTituloUf(String tituloUf) {
		this.tituloUf = tituloUf;
	}

	public Date getTituloDataEmissao() {
		return tituloDataEmissao;
	}

	public void setTituloDataEmissao(Date tituloDataEmissao) {
		this.tituloDataEmissao = tituloDataEmissao;
	}

	public BigInteger getCertificadoMilitar() {
		return certificadoMilitar;
	}

	public void setCertificadoMilitar(BigInteger certificadoMilitar) {
		this.certificadoMilitar = certificadoMilitar;
	}

	public Date getCertificadoMilitarDataEmissao() {
		return certificadoMilitarDataEmissao;
	}

	public void setCertificadoMilitarDataEmissao(Date certificadoMilitarDataEmissao) {
		this.certificadoMilitarDataEmissao = certificadoMilitarDataEmissao;
	}

	public BigInteger getCnh() {
		return cnh;
	}

	public void setCnh(BigInteger cnh) {
		this.cnh = cnh;
	}

	public CnhCategoria getCnhCategoria() {
		return cnhCategoria;
	}

	public void setCnhCategoria(CnhCategoria cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}

	public Date getCnhDataEmissao() {
		return cnhDataEmissao;
	}

	public void setCnhDataEmissao(Date cnhDataEmissao) {
		this.cnhDataEmissao = cnhDataEmissao;
	}

	public Date getCnhDataValidade() {
		return cnhDataValidade;
	}

	public void setCnhDataValidade(Date cnhDataValidade) {
		this.cnhDataValidade = cnhDataValidade;
	}

	public String getCnhUfEmissao() {
		return cnhUfEmissao;
	}

	public void setCnhUfEmissao(String cnhUfEmissao) {
		this.cnhUfEmissao = cnhUfEmissao;
	}

	public String getRegistroProfissional() {
		return registroProfissional;
	}

	public void setRegistroProfissional(String registroProfissional) {
		this.registroProfissional = registroProfissional;
	}

	public String getRegistroProfissionalTipo() {
		return registroProfissionalTipo;
	}

	public void setRegistroProfissionalTipo(String registroProfissionalTipo) {
		this.registroProfissionalTipo = registroProfissionalTipo;
	}

	public Date getRegistroProfissionalDataEmissao() {
		return registroProfissionalDataEmissao;
	}

	public void setRegistroProfissionalDataEmissao(Date registroProfissionalDataEmissao) {
		this.registroProfissionalDataEmissao = registroProfissionalDataEmissao;
	}

	public String getRegistroProfissionalUfEmissao() {
		return registroProfissionalUfEmissao;
	}

	public void setRegistroProfissionalUfEmissao(String registroProfissionalUfEmissao) {
		this.registroProfissionalUfEmissao = registroProfissionalUfEmissao;
	}

	public BigInteger getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(BigInteger pisPasep) {
		this.pisPasep = pisPasep;
	}

	public Integer getPrimeiroEmprego() {
		return primeiroEmprego;
	}

	public void setPrimeiroEmprego(Integer primeiroEmprego) {
		this.primeiroEmprego = primeiroEmprego;
	}

	public Integer getRecebeAposentadoria() {
		return recebeAposentadoria;
	}

	public void setRecebeAposentadoria(Integer recebeAposentadoria) {
		this.recebeAposentadoria = recebeAposentadoria;
	}

	public BigInteger getBanco() {
		return banco;
	}

	public void setBanco(BigInteger banco) {
		this.banco = banco;
	}

	public BigInteger getAgencia() {
		return agencia;
	}

	public void setAgencia(BigInteger agencia) {
		this.agencia = agencia;
	}

	public String getAgenciaDv() {
		return agenciaDv;
	}

	public void setAgenciaDv(String agenciaDv) {
		this.agenciaDv = agenciaDv;
	}

	public BigInteger getConta() {
		return conta;
	}

	public void setConta(BigInteger conta) {
		this.conta = conta;
	}

	public String getContaDv() {
		return contaDv;
	}

	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

	public Collection<Treinamento> getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Collection<Treinamento> treinamento) {
		this.treinamento = treinamento;
	}

	public Collection<Dependente> getDependente() {
		return dependente;
	}

	public void setDependente(Collection<Dependente> dependente) {
		this.dependente = dependente;
	}

	public Collection<Pagamento> getPagamento() {
		return pagamento;
	}

	public void setPagamento(Collection<Pagamento> pagamento) {
		this.pagamento = pagamento;
	}

	public Collection<Consignado> getConsignado() {
		return consignado;
	}

	public void setConsignado(Collection<Consignado> consignado) {
		this.consignado = consignado;
	}

	public Collection<SindicatoAssociacao> getSindicatoAssociacao() {
		return sindicatoAssociacao;
	}

	public void setSindicatoAssociacao(Collection<SindicatoAssociacao> sindicatoAssociacao) {
		this.sindicatoAssociacao = sindicatoAssociacao;
	}

	public Collection<DescontoJudicial> getDescontoJudicial() {
		return descontoJudicial;
	}

	public void setDescontoJudicial(Collection<DescontoJudicial> descontoJudicial) {
		this.descontoJudicial = descontoJudicial;
	}

	public Collection<Funpresp> getFunpresp() {
		return funpresp;
	}

	public void setFunpresp(Collection<Funpresp> funpresp) {
		this.funpresp = funpresp;
	}

	public Boolean getStatusImportacaoRamo() {
		return statusImportacaoRamo;
	}

	public void setStatusImportacaoRamo(Boolean statusImportacaoRamo) {
		this.statusImportacaoRamo = statusImportacaoRamo;
	}

	public Boolean getStatusDisponivelRamo() {
		return statusDisponivelRamo;
	}

	public void setStatusDisponivelRamo(Boolean statusDisponivelRamo) {
		this.statusDisponivelRamo = statusDisponivelRamo;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getPortariaRemocao() {
		return portariaRemocao;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setPortariaRemocao(String portariaRemocao) {
		this.portariaRemocao = portariaRemocao;
	}

	public Collection<PrevidenciaAgrupamento> getPrevidenciaAgrupamento() {
		return previdenciaAgrupamento;
	}

	public Collection<Ferias> getFerias() {
		return ferias;
	}

	public void setPrevidenciaAgrupamento(Collection<PrevidenciaAgrupamento> previdenciaAgrupamento) {
		this.previdenciaAgrupamento = previdenciaAgrupamento;
	}

	public void setFerias(Collection<Ferias> ferias) {
		this.ferias = ferias;
	}

	public Collection<PensaoAlimenticia> getPensaoAlimenticia() {
		return pensaoAlimenticia;
	}

	public void setPensaoAlimenticia(Collection<PensaoAlimenticia> pensaoAlimenticia) {
		this.pensaoAlimenticia = pensaoAlimenticia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
