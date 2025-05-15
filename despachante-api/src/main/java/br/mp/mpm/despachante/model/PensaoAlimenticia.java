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
@Table(name = "PENSAO_ALIMENTICIA")
public class PensaoAlimenticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pensao_alimenticia")
	private Long id;

	@JoinColumn(name = "id_pessoaremovida", referencedColumnName = "id_pessoaremovida")
	@ManyToOne
	private PessoaRemovida pessoaRemovida;

	@JoinColumn(name = "tipoBaseCalculo", referencedColumnName = "id_tipo_base_calculo")
	@ManyToOne
	private TipoBaseCalculo tipoBaseCalculo;

	@Column(nullable = false)
	private Date dataInicioPagamento;

	@Column(nullable = false)
	private BigDecimal valorReferencia;

	@Column(nullable = false)
	private BigDecimal valorAdiantamentoGratificaoNatalina;

	@Column(length = 4000)
	private String descricaoDescontoJudicial;

	@Column(length = 11)
	private String cpfRepresentanteLegal;

	@Column(length = 100)
	private String nomeRepresentanteLegal;

	@Column(nullable = false)
	private BigInteger banco;

	@Column(nullable = false)
	private BigInteger agencia;

	@Column(length = 1, nullable = false)	
	private String agenciaDv;

	@Column(nullable = false)
	private BigInteger conta;

	@Column(length = 1, nullable = false)
	private String contaDv;

	@Column(length = 100, nullable = false)	
	private String nomePensionista;
	
	@Column(nullable = false)	
	private Date dataNascimentoPensionista;
	
	@Column(length = 100, nullable = false)
	private String grauParentescoPensionista;
	
	private Character sexoPensionista;
	
	@Column(length = 100)	
	private String nomeMaePensionista;
	
	@Column(length = 11, nullable = false)	
	private String cpfPensionista;
		
	private String rgPensionista;
	
	@Column(length = 100)	
	private String rgOrgaoEmissorPensionista;
	
	private String rgUfEmissaoPensionista;
	
	private Date rgDataEmissaoPensionista;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoBaseCalculo getTipoBaseCalculo() {
		return tipoBaseCalculo;
	}

	public void setTipoBaseCalculo(TipoBaseCalculo tipoBaseCalculo) {
		this.tipoBaseCalculo = tipoBaseCalculo;
	}

	public Date getDataInicioPagamento() {
		return dataInicioPagamento;
	}

	public void setDataInicioPagamento(Date dataInicioPagamento) {
		this.dataInicioPagamento = dataInicioPagamento;
	}

	public BigDecimal getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(BigDecimal valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	public BigDecimal getValorAdiantamentoGratificaoNatalina() {
		return valorAdiantamentoGratificaoNatalina;
	}

	public void setValorAdiantamentoGratificaoNatalina(BigDecimal valorAdiantamentoGratificaoNatalina) {
		this.valorAdiantamentoGratificaoNatalina = valorAdiantamentoGratificaoNatalina;
	}

	public String getDescricaoDescontoJudicial() {
		return descricaoDescontoJudicial;
	}

	public void setDescricaoDescontoJudicial(String descricaoDescontoJudicial) {
		this.descricaoDescontoJudicial = descricaoDescontoJudicial;
	}

	public String getCpfRepresentanteLegal() {
		return cpfRepresentanteLegal;
	}

	public void setCpfRepresentanteLegal(String cpfRepresentanteLegal) {
		this.cpfRepresentanteLegal = cpfRepresentanteLegal;
	}

	public String getNomeRepresentanteLegal() {
		return nomeRepresentanteLegal;
	}

	public void setNomeRepresentanteLegal(String nomeRepresentanteLegal) {
		this.nomeRepresentanteLegal = nomeRepresentanteLegal;
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

	public PessoaRemovida getPessoaRemovida() {
		return pessoaRemovida;
	}

	public void setPessoaRemovida(PessoaRemovida pessoaRemovida) {
		this.pessoaRemovida = pessoaRemovida;
	}

	public String getNomePensionista() {
		return nomePensionista;
	}

	public void setNomePensionista(String nomePensionista) {
		this.nomePensionista = nomePensionista;
	}

	public Date getDataNascimentoPensionista() {
		return dataNascimentoPensionista;
	}

	public void setDataNascimentoPensionista(Date dataNascimentoPensionista) {
		this.dataNascimentoPensionista = dataNascimentoPensionista;
	}

	public String getGrauParentescoPensionista() {
		return grauParentescoPensionista;
	}

	public void setGrauParentescoPensionista(String grauParentescoPensionista) {
		this.grauParentescoPensionista = grauParentescoPensionista;
	}

	public Character getSexoPensionista() {
		return sexoPensionista;
	}

	public void setSexoPensionista(Character sexoPensionista) {
		this.sexoPensionista = sexoPensionista;
	}

	public String getNomeMaePensionista() {
		return nomeMaePensionista;
	}

	public void setNomeMaePensionista(String nomeMaePensionista) {
		this.nomeMaePensionista = nomeMaePensionista;
	}

	public String getCpfPensionista() {
		return cpfPensionista;
	}

	public void setCpfPensionista(String cpfPensionista) {
		this.cpfPensionista = cpfPensionista;
	}

	public String getRgPensionista() {
		return rgPensionista;
	}

	public void setRgPensionista(String rgPensionista) {
		this.rgPensionista = rgPensionista;
	}

	public String getRgOrgaoEmissorPensionista() {
		return rgOrgaoEmissorPensionista;
	}

	public void setRgOrgaoEmissorPensionista(String rgOrgaoEmissorPensionista) {
		this.rgOrgaoEmissorPensionista = rgOrgaoEmissorPensionista;
	}

	public String getRgUfEmissaoPensionista() {
		return rgUfEmissaoPensionista;
	}

	public void setRgUfEmissaoPensionista(String rgUfEmissaoPensionista) {
		this.rgUfEmissaoPensionista = rgUfEmissaoPensionista;
	}

	public Date getRgDataEmissaoPensionista() {
		return rgDataEmissaoPensionista;
	}

	public void setRgDataEmissaoPensionista(Date rgDataEmissaoPensionista) {
		this.rgDataEmissaoPensionista = rgDataEmissaoPensionista;
	}

}
