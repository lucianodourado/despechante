SELECT
	RHCADSERVIDOR.matricula as matricula,
	RHCADPESSOA.Nome as nomeSocial,
	RHCADPESSOA.Nome as nomeCivil,
	RHCADPESSOA.DataNascimentoFormatada as dataNascimento,
	RHCADPESSOA.Sexo as sexo,
	1 AS identidadeGenero,	
	--identidadeGenero,NUMÉRICO,3,NÃO,Identidade de gênero. Ver tabela de domínio IDENTIDADE_GENERO
	RHCADPESSOA.Endereco_CEP as enderecoCep,
	'' AS enderecoResidencial,
	--enderecoResidencial,STRING ,100,SIM,Endereço Residencial
	RHCADPESSOA.Endereco_Numero as enderecoNumero,
	RHCADPESSOA.Endereco_Complemento as enderecoComplemento,
	RHCADPESSOA.Endereco_Bairro as enderecoBairro, 
	UFEndereco.Codigo as enderecoUf,
 	MunicEndereco.Descricao as 	enderecoMunicipio,
	PaisEndereco.Descricao as enderecoPais,
	111 AS enderecoCodigoIbge,
	--enderecoCodigoIbge,NUMÉRICO,10,SIM,Código do IBGE do endereço da pessoa
	RHCADPESSOA.EMail as emailParticular,
	RHCADPESSOA.EstadoCivil as estadoCivil,
	0 AS uniaoEstavel,
	--uniaoEstavel,NUMÉRICO,1,SIM,União estável. 1 para SIM; 0 para NÃO	
	RHCADPESSOA.NomeConjuge as nomeConjuge,
	RHCADPESSOA.DataCasamentoFormatada as dataCasamento,
	RHCADPESSOA.Raca as raca,
	RHCADPESSOA.DoadorSangue as doadorSangue, 
	substring(RHCADPESSOA.TipoSanguineoFormatado,1,PATINDEX('%[+-]%', RHCADPESSOA.TipoSanguineoFormatado)-1) as tipoSanguineo, 	
	case 
		when RIGHT(RHCADPESSOA.TipoSanguineoFormatado, 1) = '+' then 'P'
		when RIGHT(RHCADPESSOA.TipoSanguineoFormatado, 1) = '-' then 'N' 
		else ''		
	end as fatorRh,
	CASE
		WHEN RHCADPESSOA.NecessidadeEspecialFormatado = 'Não' then 0
		ELSE 1
	end as pne,
	RHCADPESSOA.Naturalidade as naturalidade,
	UFNaturalidade.Codigo as naturalidadeUf,
	RHTabNacionalidade.Descricao as nacionalidade,
	RHCADPESSOA.paisNascimento as paisNascimento,
	1 AS grauInstrucao, 
	--grauInstrucao,NUMÉRICO,2,SIM,Grau de instrução. Ver tabela de domínio GRAU_INSTRUCAO
	'' AS formacaoProfissional,
	--formacaoProfissional,STRING,200,NÃO,Formação profissional. Descrição da formação profissional da pessoa
	'TEC' AS cargo, 	
	--cargo,STRING,20,SIM,Código do cargo. Ver tabela de domínio CARGO 
	case LEFT(RHTABCARGOEFETIVO.Descricao, CHARINDEX (' ',RHTABCARGOEFETIVO.Descricao)-1) COLLATE Latin1_general_CI_AI
		when 'ANALISTA' then 'AN'
		when 'TECNICO' then 'TC'
	end as cargoNivel,
	rhcadservidorFUNCIONAL.Classe as cargoClasse, 
	SUBSTRING(RHTabPadrao.Codigo,PATINDEX('%-%',RHTabPadrao.Codigo)+2,2) as cargoPadrao,
	CURRENT_TIMESTAMP as dataUltimaProgressao,	
	--dataUltimaProgressao,STRING,10,SIM,Data da última vigência de promoção/progressão. Formato DD/MM/YYYY
	CURRENT_TIMESTAMP as dataNomeacao,	
	--dataNomeacao,STRING,10,SIM,Data de nomeação. Formato DD/MM/YYYY
	CURRENT_TIMESTAMP as dataExercicio,
	--dataExercicio,STRING,10,SIM,Data de exercício. Formato DD/MM/YYYY
	CURRENT_TIMESTAMP as dataPosse,	
	--dataPosse,STRING,10,SIM,Data de posse. Formato DD/MM/YYYY
	CURRENT_TIMESTAMP as dataExercicioIninterruptoMpu,	
	--dataExercicioIninterruptoMpu,STRING,10,SIM,"Data de exercício ininterrupto no MPU. Formato DD/MM/YYYY. A data mais remota dentre os cargos já ocupados pelo servidor, desde que não tenha havido interrupção entre um cargo e outro"
	'MPU' as unidadeLotacaoRemovido, 
	--unidadeLotacaoRemovido,STRING,200,NÃO,Descrição da unidade de lotação para qual o servidor foi removido.
	1 as regimePrevidenciario,
	--regimePrevidenciario,NUMÉRICO,2,SIM,Tipo de regime previdenciário. Ver tabela de domínio TP_REGIME_PREVIDENCIARIO
	RHCADPESSOA.cpf as cpf,	
	RHCADPESSOADOC.idNumero as rgNumero, 
	RHCADPESSOADOC.idOrgao as rgOrgao,	
	RHCADPESSOADOC.idDataExpFormatada as rgDataEmissao,	
	UFId.Codigo as rgUfEmissao,	
	RHCADPESSOADOC.TitEleitorNumero as tituloNumero,
	RHCADPESSOADOC.TitEleitorZona as tituloZona,
	RHCADPESSOADOC.TitEleitorSecao as tituloSecao,
	UFTitulo.Codigo as tituloUf,	
	RHCADPESSOADOC.TitEleitorDataExpFormatada as tituloDataEmissao,
	RHCADPESSOADOC.CertMilitarNumero as certificadoMilitar, 
	RHCADPESSOADOC.CertMilitarDataExpFormatada as certificadoMilitarDataEmissao,
	RHCADPESSOADOC.CNTRegistro as cnh,
	RHCADPESSOADOC.CNTCategoria as cnhCategoria,
	RHCADPESSOADOC.CNTDataExpFormatada as cnhDataEmissao,
	RHCADPESSOADOC.CNTDataValFormatada as cnhDataValidade,
	UFCNH.Codigo as cnhUfEmissao,
	RHCADPESSOADOC.RegProfRegistro as registroProfissional,
	'MPU' as registroProfissionalTipo,
	--registroProfissionalTipo,STRING,100,NÃO,Tipo de registro profissional	
	RHCADPESSOADOC.RegProfDataExpFormatada as registroProfissionalDataEmissao,
	UFProf.Codigo as registroProfissionalUfEmissao, 
	RHCadPessoaBancario.NumeroPIS as pisPasep,
	0 as primeiroEmprego,
	--primeiroEmprego,NUMÉRICO,1,SIM,Primeiro emprego? 0 para NÃO; 1 para SIM;
	0 as recebeAposentadoria,
	--recebeAposentadoria,NUMÉRICO,1,SIM,Recebe aposentadoria? 0 para NÃO; 1 para SIM;
	RHTABAGENCIA.BANCO as banco,
	RHTABAGENCIA.Codigo as agencia,	
	RHTABAGENCIA.DV as agenciaDv,					
	RHCadServidorBancario.CONTAPGTO_CONTA as conta,
	RHCadServidorBancario.CONTAPGTO_DV as contaDv	
FROM 
	MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR
	INNER JOIN MENTOR_SQL.dbo.RHCADPESSOA as RHCADPESSOA on RHCADSERVIDOR.pessoa = RHCADPESSOA.id
	INNER JOIN MENTOR_SQL.dbo.rhcadservidorFUNCIONAL as rhcadservidorFUNCIONAL on rhcadservidor.id = rhcadservidorFUNCIONAL.servidor
	INNER JOIN MENTOR_SQL.dbo.RHCadServidorBancario as RHCadServidorBancario on rhcadservidor.ID = RHCadServidorBancario.SERVIDOR
	INNER JOIN MENTOR_SQL.dbo.RHTABAGENCIA as RHTABAGENCIA ON RHTABAGENCIA.ID = RHCadServidorBancario.CONTAPGTO_AGENCIA
	INNER JOIN MENTOR_SQL.dbo.RHCadPessoaDoc as RHCadPessoaDoc on RHCadPessoaDoc.pessoa = rhcadpessoa.id
	INNER JOIN MENTOR_SQL.dbo.RHCadPessoaBancario as RHCadPessoaBancario on RHCadPessoaBancario.Pessoa = rhcadpessoa.ID
	INNER JOIN MENTOR_SQL.dbo.RhCadServidorFinanceiro as RhCadServidorFinanceiro on rhcadservidor.id = RhCadServidorFinanceiro.servidor	
	LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFEndereco on UFEndereco.ID = RHCADPESSOA.Endereco_UF
	LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFTitulo on UFTitulo.ID = RHCadPessoaDoc.TitEleitorUF
	LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFCNH on UFCNH.ID = RHCadPessoaDoc.CNTUF
	LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFProf on UFProf.ID = RHCadPessoaDoc.RegProfUF
	LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFId on UFId.ID = RHCadPessoaDoc.IdUF
	LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFNaturalidade on UFNaturalidade.ID = RHCADPESSOA.NaturalidadeUF	
	LEFT JOIN MENTOR_SQL.dbo.RHTabMunicipio as MunicEndereco on MunicEndereco.ID = RHCADPESSOA.Endereco_Municipio 	
	LEFT JOIN MENTOR_SQL.dbo.RHTABCARGOEFETIVO as RHTABCARGOEFETIVO on RHTABCARGOEFETIVO.ID = rhcadservidorFUNCIONAL.cargoefetivo
	INNER JOIN MENTOR_SQL.dbo.RHTabPais as PaisEndereco on PaisEndereco.ID = RHCADPESSOA.Endereco_Pais
	LEFT JOIN MENTOR_SQL.dbo.RHTabPadrao as RHTabPadrao on RHTabPadrao.ID = rhcadservidorFUNCIONAL.Padrao
	LEFT JOIN MENTOR_SQL.dbo.RHTabNacionalidade as RHTabNacionalidade on RHTabNacionalidade.ID = RHCADPESSOA.nacionalidade  
WHERE	
	RhCadServidorFinanceiro.datadesligamento is null
	and (rhcadservidorFUNCIONAL.tiposervidor = 2)
	and RHCADSERVIDOR.matricula = 1652
	
	
	

 select sexo from MENTOR_SQL.dbo.rhcadpessoa
 select PaisEndereco.Descricao from MENTOR_SQL.dbo.rhcadpessoa  LEFT JOIN MENTOR_SQL.dbo.RHTabPais as PaisEndereco on PaisEndereco.PaisESocial = RHCADPESSOA.paisNascimento
 
 
 select paisNascimento,Endereco_Pais from MENTOR_SQL.dbo.rhcadpessoa where paisNascimento is not NULL 
 select * from MENTOR_SQL.dbo.rhcadservidorFUNCIONAL where EMailInstitucional = 'fausto.silva@mpm.mp.br'
 select * from  MENTOR_SQL.dbo.RHTABCARGOEFETIVO
 select * from MENTOR_SQL.dbo.rhcadservidor
 select * from MENTOR_SQL.dbo.RHCadPessoaDoc
 select * from MENTOR_SQL.dbo.RHTabMunicipio
 select * from rhcadservidorFUNCIONAL
select * from MENTOR_SQL.dbo.RHTabPais
select * from MENTOR_SQL.dbo.RHTabPadrao
select * from MENTOR_SQL.dbo.RHTabNacionalidade


select RHCADPESSOADOC.idDataExpFormatada, RHCADPESSOADOC.idDataExp 
from 
	MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR
	INNER JOIN MENTOR_SQL.dbo.RHCADPESSOA as RHCADPESSOA on RHCADSERVIDOR.pessoa = RHCADPESSOA.id
	INNER JOIN MENTOR_SQL.dbo.RHCadPessoaDoc as RHCadPessoaDoc on RHCadPessoaDoc.pessoa = rhcadpessoa.id
where  RHCADSERVIDOR.matricula = 640	


select * from MENTOR_SQL.dbo.RHTABESTADOCIVIL
select RHCADPESSOA.DoadorSangueFormatado from MENTOR_SQL.dbo.rhcadpessoa


CREATE FUNCTION dbo.udf_GetNumeric
(
  @strAlphaNumeric VARCHAR(256)
)
RETURNS VARCHAR(256)
AS
BEGIN
  DECLARE @intAlpha INT
  SET @intAlpha = PATINDEX('%[^0-9]%', @strAlphaNumeric)
  BEGIN
    WHILE @intAlpha > 0
    BEGIN
      SET @strAlphaNumeric = STUFF(@strAlphaNumeric, @intAlpha, 1, '' )
      SET @intAlpha = PATINDEX('%[^0-9]%', @strAlphaNumeric )
    END
  END
  RETURN ISNULL(@strAlphaNumeric,0)
END

SELECT dbo.udf_GetNumeric('076.520.3004   77') 
select left('076.520.3004 77', patindex('%[^0-9]%', '076.520.3004-77'+'.') - 1)

SELECT SYSDATETIME()  
    ,SYSDATETIMEOFFSET()  
    ,SYSUTCDATETIME()  
    ,CURRENT_TIMESTAMP  
    ,GETDATE()  
    ,GETUTCDATE(); 

SELECT Convert('22/01/2000' AS Tran_Date)
select Convert(varchar(10), '22/01/2000',103)
 
 