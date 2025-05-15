
class Dependente {
	nome: string;
	dataNascimento: string;
	grauParentesco: string;
	sexo: number;
	nomeMae: string;
	cpf: number;
	rg: string;
	rgOrgaoEmissor: string;
	rgUfEmissao: string;
	rgDataEmissao: string;
	dataVigenciaAuxilioPreEscolar: string;
}

class Treinamento {
    nome: string;
	nomeInstituicao: string;
	tipo: number;
	dataInicio: string;
	dataFim: string;
	cargaHoraria: number;
}

export class PessoaRemovida {

	matricula: number;
	nomeSocial: string;
	nomeCivil: string;
	dataNascimento: string;
	sexo: number;
	identidadeGenero: number;
	enderecoCep: number;
	enderecoResidencial: string;
	enderecoNumero: string;
	enderecoComplemento: string;
	enderecoBairro: string;
	enderecoUf: string;
	enderecoMunicipio: string;
	enderecoPais: string;
	enderecoCodigoIbge: number;
	emailParticular: string;
	estadoCivil: number;
	uniaoEstavel: number;
	nomeConjuge: string;
	dataCasamento: string;
	raca: number;
	doadorSangue: number;
	tipoSanguineo: string;
	fatorRh: string;
	pne: number;
	naturalidade: string;
	naturalidadeUf: string;
	nacionalidade: string;
	paisNascimento: string;
	grauInstrucao: number;
	formacaoProfissional: string;
	cargo: string;
	cargoNivel: string;
	cargoClasse: string;
	cargoPadrao: string;
	dataUltimaProgressao: string;
	dataNomeacao: string;
	dataExercicio: string;
	dataPosse: string;
	dataExercicioIninterruptoMpu: string;
	unidadeLotacaoRemovido: string;
	regimePrevidenciario: number;
	cpf: number;
	rgNumero: string;
	rgOrgao: string;
	rgDataEmissao: string;
	rgUfEmissao: string;
	tituloNumero: number;
	tituloZona: string;
	tituloSecao: string;
	tituloUf: string;
	tituloDataEmissao: string;
	certificadoMilitar: number;
	certificadoMilitarDataEmissao: string;
	cnh: number;
	cnhCategoria: string;
	cnhDataEmissao: string;
	cnhDataValidade: string;
	cnhUfEmissao: string;
	registroProfissional: string;
	registroProfissionalTipo: string;
	registroProfissionalDataEmissao: string;
	registroProfissionalUfEmissao: string;
	pisPasep: number;
	primeiroEmprego: number;
	recebeAposentadoria: number;
	banco: number;
	agencia: number;
	agenciaDv: string;
	conta: number;
	contaDv: string;

	treinamento: Treinamento[];
	dependente: Dependente[];
}