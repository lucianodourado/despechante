
CREATE PROCEDURE  [dbo].[SP_IMPORTA_DADOS_DO_MENTOR_PARA_DESPACHANTE] as
BEGIN TRAN
	DECLARE 
		@errorMessage nvarchar(4000)
       ,@errorSeverity int
       ,@errorState int;            

	BEGIN TRY

		INSERT INTO PESSOA_REMOVIDA
		(id_pessoaremovida_mentor, matricula, nomeSocial, nomeCivil, dataNascimento, sexo, identidadeGenero, enderecoCep, enderecoResidencial, enderecoNumero, enderecoComplemento, enderecoBairro, enderecoUf, enderecoMunicipio, enderecoPais, enderecoCodigoIbge, emailParticular, estadoCivil, uniaoEstavel, nomeConjuge, dataCasamento, raca, doadorSangue, tipoSanguineo, fatorRh, pne, naturalidade, naturalidadeUf, nacionalidade, paisNascimento, grauInstrucao, formacaoProfissional, cargo, cargoNivel, cargoClasse, cargoPadrao, dataUltimaProgressao, dataNomeacao, dataExercicio, dataPosse, dataExercicioIninterruptoMpu, unidadeLotacaoRemovido, regimePrevidenciario, cpf, rgNumero, rgOrgao, rgDataEmissao, rgUfEmissao, tituloNumero, tituloZona, tituloSecao, tituloUf, tituloDataEmissao, certificadoMilitar, certificadoMilitarDataEmissao, cnh, cnhCategoria, cnhDataEmissao, cnhDataValidade, cnhUfEmissao, registroProfissional, registroProfissionalTipo, registroProfissionalDataEmissao, registroProfissionalUfEmissao, pisPasep, primeiroEmprego, recebeAposentadoria, banco, agencia, agenciaDv, conta, contaDv)
			SELECT
				RHCADPESSOA.ID as id_pessoaremovida_mentor,
				RHCADSERVIDOR.matricula as matricula,
				RHCADPESSOA.Nome as nomeSocial,
				RHCADPESSOA.Nome as nomeCivil,
				convert(datetime, RHCADPESSOA.DataNascimentoFormatada, 103 )as dataNascimento,
				RHCADPESSOA.Sexo as sexo,
				NULL AS identidadeGenero,	
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
				case 
					when RHCADPESSOA.EstadoCivil = 1 then 1
					when RHCADPESSOA.EstadoCivil = 2 then 2
					when RHCADPESSOA.EstadoCivil = 3 then 4
					when RHCADPESSOA.EstadoCivil = 4 then 5
					when RHCADPESSOA.EstadoCivil = 5 then 3
					when RHCADPESSOA.EstadoCivil = 7 then 99
					when RHCADPESSOA.EstadoCivil = 8 then 6
				end as estadoCivil,
				case  --TODO
					when RHCADPESSOA.EstadoCivil = 8 then 1
					else 0 
				end as uniaoEstavel,
				RHCADPESSOA.NomeConjuge as nomeConjuge,
				convert(datetime, RHCADPESSOA.DataCasamentoFormatada, 103) as dataCasamento,
				RHCADPESSOA.Raca as raca,
				case 
					when RHCADPESSOA.DoadorSangueFormatado = 'Sim' then 1
					else 0 
				end as doadorSangue,
				-- TODO
				case 
					when RHCADPESSOA.TipoSanguineoFormatado is null then 'X' 
					else substring(RHCADPESSOA.TipoSanguineoFormatado,1,PATINDEX('%[+-]%', RHCADPESSOA.TipoSanguineoFormatado)-1) 
				end as tipoSanguineo, 	
				-- TODO
				case 
					when RIGHT(RHCADPESSOA.TipoSanguineoFormatado, 1) = '+' then 'P'
					when RIGHT(RHCADPESSOA.TipoSanguineoFormatado, 1) = '-' then 'N' 
					else 'X'		
				end as fatorRh,
				CASE
					WHEN RHCADPESSOA.NecessidadeEspecialFormatado = 'Não' then 0
					ELSE 1
				end as pne,
				RHCADPESSOA.Naturalidade as naturalidade,
				UFNaturalidade.Codigo as naturalidadeUf,
				RHTabNacionalidade.Descricao as nacionalidade,
				case 
					when PaisNascimento.Descricao is null then '' 
					else PaisNascimento.Descricao
				end as paisNascimento,
				1 AS grauInstrucao, 
				--grauInstrucao,NUMÉRICO,2,SIM,Grau de instrução. Ver tabela de domínio GRAU_INSTRUCAO
				'' AS formacaoProfissional,
				--formacaoProfissional,STRING,200,NÃO,Formação profissional. Descrição da formação profissional da pessoa
				'' AS cargo,
				--cargo,STRING,20,SIM,Código do cargo. Ver tabela de domínio CARGO 
				case LEFT(RHTABCARGOEFETIVO.Descricao, CHARINDEX (' ',RHTABCARGOEFETIVO.Descricao)-1) COLLATE Latin1_general_CI_AI
					when 'ANALISTA' then 'AN'
					when 'TECNICO' then 'TC'
					else ''
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
				'' as unidadeLotacaoRemovido, 
				--unidadeLotacaoRemovido,STRING,200,NÃO,Descrição da unidade de lotação para qual o servidor foi removido.
				1 as regimePrevidenciario,
				--regimePrevidenciario,NUMÉRICO,2,SIM,Tipo de regime previdenciário. Ver tabela de domínio TP_REGIME_PREVIDENCIARIO
				RHCADPESSOA.cpf as cpf,	
				dbo.udf_GetNumeric(RHCADPESSOADOC.idNumero) as rgNumero, 
				RHCADPESSOADOC.idOrgao as rgOrgao,	
				case 
					when RHCADPESSOADOC.idDataExpFormatada is null then CURRENT_TIMESTAMP 
					else convert(datetime, RHCADPESSOADOC.idDataExpFormatada, 103)
				end as rgDataEmissao,
				UFId.Codigo as rgUfEmissao,	
				dbo.udf_GetNumeric(RHCADPESSOADOC.TitEleitorNumero) as tituloNumero,
				RHCADPESSOADOC.TitEleitorZona as tituloZona,
				RHCADPESSOADOC.TitEleitorSecao as tituloSecao,
				UFTitulo.Codigo as tituloUf,	
				convert(datetime, RHCADPESSOADOC.TitEleitorDataExpFormatada, 103) as tituloDataEmissao,
				dbo.udf_GetNumeric(RHCADPESSOADOC.CertMilitarNumero) as certificadoMilitar, 
				convert(datetime, RHCADPESSOADOC.CertMilitarDataExpFormatada, 103) as certificadoMilitarDataEmissao,
				RHCADPESSOADOC.CNTRegistro as cnh,
				RHCADPESSOADOC.CNTCategoria as cnhCategoria,
				convert(datetime, RHCADPESSOADOC.CNTDataExpFormatada, 103) as cnhDataEmissao,
				convert(datetime, RHCADPESSOADOC.CNTDataValFormatada, 103) as cnhDataValidade,
				UFCNH.Codigo as cnhUfEmissao,
				RHCADPESSOADOC.RegProfRegistro as registroProfissional,
				'' as registroProfissionalTipo,
				--registroProfissionalTipo,STRING,100,NÃO,Tipo de registro profissional	
				convert(datetime, RHCADPESSOADOC.RegProfDataExpFormatada, 103) as registroProfissionalDataEmissao,
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
				LEFT JOIN MENTOR_SQL.dbo.RHTabPais as PaisNascimento on PaisNascimento.PaisESocial = RHCADPESSOA.paisNascimento
			WHERE	
				RhCadServidorFinanceiro.datadesligamento is null
				and (rhcadservidorFUNCIONAL.tiposervidor = 2)
				and RHCADSERVIDOR.matricula between  0 and 1760

		
		INSERT INTO DEPENDENTE
		(id_pessoaremovida, nome, dataNascimento, grauParentesco, sexo, nomeMae, cpf, rg, rgDataEmissao, rgOrgaoEmissor, rgUfEmissao, dataVigenciaAuxilioPreEscolar)
			SELECT
				PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				RHCadDependente.Nome as nome,
				convert(datetime, RHCadDependente.DataNascFormatada, 103) as dataNascimento,
				RHTabDependenteParentesco.Descricao as grauParentesco,
				RHCadDependente.Sexo as sexo, -- 1 MASC e 2 FEMI
				RHCadDependente.NomeMae as nomeMae,
				-- todo
				case 
					when RHCadDependente.CPF is null then '1'
					else dbo.udf_GetNumeric(RHCadDependente.CPF)
				end as cpf,
				RHCadDependente.idNumero as rg,
				convert(datetime, RHCadDependente.IdDataExpFormatada, 103) as rgDataEmissao,
				RHCadDependente.IdOrgao as rgOrgaoEmissor,
				UFId.CODIGO as rgUfEmissao,				
				CURRENT_TIMESTAMP as dataVigenciaAuxilioPreEscolar
			FROM
				MENTOR_SQL.DBO.RHCadDependente as RHCadDependente
				INNER JOIN MENTOR_SQL.DBO.RHTabDependenteParentesco as RHTabDependenteParentesco on RHTabDependenteParentesco.ID = RHCadDependente.Parentesco
				INNER JOIN MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHCadDependente.Servidor  	
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFId on UFId.ID = RHCadDependente.IdUF
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula  	
			WHERE
				RHCADSERVIDOR.matricula between  0 and 1760			

		-- CONSIGNADO
		-- DESCONTO JUDICIAL
		-- FUNPRESP
		-- FUNPRESP AGRUPAMENTO
		-- SINDICADO ASSOCIACAO
		-- PENSAO ALIMENTICIA
		-- TREINAMENTO 
		-- TREINAMENTO AGRUPAMENTO
		-- PAGAMENTO

		COMMIT TRAN
	END TRY

	BEGIN CATCH	
	    SELECT	@errorMessage = 'Erro na carga de tabelas do DESPACHANTE: ' + ERROR_MESSAGE(), 
				@errorSeverity = ERROR_SEVERITY(), 
				@errorState = ERROR_STATE();
        RAISERROR (@errorMessage, @errorSeverity, @errorState);
		ROLLBACK TRAN
	END CATCH
GO



