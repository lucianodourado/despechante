USE [DESPACHANTE_DEV]
GO
/****** Object:  StoredProcedure [dbo].[SP_IMPORTA_DADOS_DO_MENTOR_PARA_DESPACHANTE]    Script Date: 26/10/2020 14:51:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE  [dbo].[SP_IMPORTA_DADOS_DO_MENTOR_PARA_DESPACHANTE] as
BEGIN TRAN
	DECLARE 
		@errorMessage nvarchar(4000)
       ,@errorSeverity int
       ,@errorState int;            

	BEGIN TRY

		DELETE FROM CONSIGNADO
		DELETE FROM PENSAO_ALIMENTICIA
		DELETE FROM SINDICATO_ASSOCIACAO
		DELETE FROM FUNPRESP_AGRUPAMENTO
		DELETE FROM FUNPRESP
		DELETE FROM DESCONTO_JUDICIAL
		DELETE FROM TREINAMENTO_AGRUPAMENTO
		DELETE FROM TREINAMENTO 
		DELETE FROM PAGAMENTO
		DELETE FROM DEPENDENTE
		DELETE FROM PESSOA_REMOVIDA

		DBCC CHECKIDENT ('CONSIGNADO', RESEED, 0);
		DBCC CHECKIDENT ('PENSAO_ALIMENTICIA', RESEED, 0);
		DBCC CHECKIDENT ('SINDICATO_ASSOCIACAO', RESEED, 0);
		DBCC CHECKIDENT ('FUNPRESP_AGRUPAMENTO', RESEED, 0);
		DBCC CHECKIDENT ('FUNPRESP', RESEED, 0);
		DBCC CHECKIDENT ('DESCONTO_JUDICIAL', RESEED, 0);
		DBCC CHECKIDENT ('TREINAMENTO_AGRUPAMENTO', RESEED, 0);
		DBCC CHECKIDENT ('TREINAMENTO', RESEED, 0);
		DBCC CHECKIDENT ('PAGAMENTO', RESEED, 0);
		DBCC CHECKIDENT ('DEPENDENTE', RESEED, 0);
		DBCC CHECKIDENT ('PESSOA_REMOVIDA', RESEED, 0);

		INSERT INTO PESSOA_REMOVIDA
		(id_pessoaremovida_mentor, matricula, nomeSocial, nomeCivil, dataNascimento, sexo, identidadeGenero, enderecoCep, enderecoResidencial, enderecoNumero, enderecoComplemento, enderecoBairro, enderecoUf, enderecoMunicipio, enderecoPais, enderecoCodigoIbge, emailParticular, estadoCivil, uniaoEstavel, nomeConjuge, dataCasamento, raca, doadorSangue, tipoSanguineo, fatorRh, pne, naturalidade, naturalidadeUf, nacionalidade, paisNascimento, grauInstrucao, formacaoProfissional, cargo, cargoNivel, cargoClasse, cargoPadrao, dataUltimaProgressao, dataNomeacao, dataExercicio, dataPosse, dataExercicioIninterruptoMpu, unidadeLotacaoRemovido, regimePrevidenciario, cpf, rgNumero, rgOrgao, rgDataEmissao, rgUfEmissao, tituloNumero, tituloZona, tituloSecao, tituloUf, tituloDataEmissao, certificadoMilitar, certificadoMilitarDataEmissao, cnh, cnhCategoria, cnhDataEmissao, cnhDataValidade, cnhUfEmissao, registroProfissional, registroProfissionalTipo, registroProfissionalDataEmissao, registroProfissionalUfEmissao, pisPasep, primeiroEmprego, recebeAposentadoria, banco, agencia, agenciaDv, conta, contaDv, statusImportacaoRamo)
			SELECT
				RHCADPESSOA.ID as id_pessoaremovida_mentor,
				RHCADSERVIDOR.matricula as matricula,
				RHCADPESSOA.Nome as nomeSocial,
				RHCADPESSOA.Nome as nomeCivil,
				convert(datetime, RHCADPESSOA.DataNascimentoFormatada, 103 )as dataNascimento,
				case RHCADPESSOA.Sexo 
					when 1 then 2 
					when 2 then 1
				end as sexo,
				NULL AS identidadeGenero,
				RHCADPESSOA.Endereco_CEP as enderecoCep,
				RHCADPESSOA.Endereco_Endereco AS enderecoResidencial,
				RHCADPESSOA.Endereco_Numero as enderecoNumero,
				RHCADPESSOA.Endereco_Complemento as enderecoComplemento,
				RHCADPESSOA.Endereco_Bairro as enderecoBairro, 
				UFEndereco.Codigo as enderecoUf,
 				MunicEndereco.Descricao as 	enderecoMunicipio,
				PaisEndereco.Descricao as enderecoPais,
				case 
					when RHTabESCodMunicipioIBGE.Codigo is null then 0
					else RHTabESCodMunicipioIBGE.Codigo
				end as enderecoCodigoIbge,
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
				case 
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
				case 
					when RHCADPESSOA.TipoSanguineoFormatado is null then 'X' 
					else substring(RHCADPESSOA.TipoSanguineoFormatado,1,PATINDEX('%[+-]%', RHCADPESSOA.TipoSanguineoFormatado)-1) 
				end as tipoSanguineo, 	
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
					when PaisNascimento.Descricao is null then 'Brasil' 
					else PaisNascimento.Descricao
				end as paisNascimento,
				RHTabEscolaridade.Codigo AS grauInstrucao,
				RHTabFormacaoProfissional.Descricao AS formacaoProfissional,
				--RHTABCARGOEFETIVO.Codigo AS cargo,
				case RHTABCARGOEFETIVO.Codigo
					when 'TC20403' then 'TC020102'
					else RHTABCARGOEFETIVO.Codigo
				end as cargo,
				case LEFT(RHTABCARGOEFETIVO.Descricao, CHARINDEX (' ',RHTABCARGOEFETIVO.Descricao)-1) COLLATE Latin1_general_CI_AI
					when 'ANALISTA' then 'AN'
					when 'TECNICO' then 'TC'
					else ''
				end as cargoNivel,
				rhcadservidorFUNCIONAL.Classe as cargoClasse, 
				SUBSTRING(RHTabPadrao.Codigo,PATINDEX('%-%',RHTabPadrao.Codigo)+2,2) as cargoPadrao,
				convert(datetime, RHCADCLASSEPADRAO.DataProvimentoFormatada, 103) as dataUltimaProgressao,	
				case 
					when RHCADCARGOEFETIVO.ProvDtNomeacaoFormatado is null then CURRENT_TIMESTAMP
					else convert(datetime, RHCADCARGOEFETIVO.ProvDtNomeacaoFormatado, 103)
				end as dataNomeacao,
				case 
					when RHCADCARGOEFETIVO.ProvDtExercicioFormatado is null then CURRENT_TIMESTAMP
					else convert(datetime, RHCADCARGOEFETIVO.ProvDtExercicioFormatado, 103)
				end as dataNomeacao,
				case 
					when RHCADCARGOEFETIVO.ProvDtPosseFormatado is null then CURRENT_TIMESTAMP
					else convert(datetime, RHCADCARGOEFETIVO.ProvDtPosseFormatado, 103)
				end as dataPosse,
				case 
					when rhcadhistregjuridico.DataInicialFormatada is null then CURRENT_TIMESTAMP
					else convert(datetime, rhcadhistregjuridico.DataInicialFormatada, 103)
				end as dataExercicioIninterruptoMpu,
				NULL as unidadeLotacaoRemovido, 
				case 
					when RhTabRegimePrev.Codigo = 1 then 1
					when RhTabRegimePrev.Codigo = 8 then 2
				end as regimePrevidenciario,
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
				case 
					when RHCADPESSOADOC.TitEleitorDataExpFormatada is null then CURRENT_TIMESTAMP 
					else convert(datetime, RHCADPESSOADOC.TitEleitorDataExpFormatada, 103)
				end as tituloDataEmissao,
				dbo.udf_GetNumeric(RHCADPESSOADOC.CertMilitarNumero) as certificadoMilitar, 
				convert(datetime, RHCADPESSOADOC.CertMilitarDataExpFormatada, 103) as certificadoMilitarDataEmissao,
				RHCADPESSOADOC.CNTRegistro as cnh,
				RHCADPESSOADOC.CNTCategoria as cnhCategoria,
				convert(datetime, RHCADPESSOADOC.CNTDataExpFormatada, 103) as cnhDataEmissao,
				convert(datetime, RHCADPESSOADOC.CNTDataValFormatada, 103) as cnhDataValidade,
				UFCNH.Codigo as cnhUfEmissao,
				RHCADPESSOADOC.RegProfRegistro as registroProfissional,
				RHCADPESSOADOC.RegProfRegistro as registroProfissionalTipo,
				convert(datetime, RHCADPESSOADOC.RegProfDataExpFormatada, 103) as registroProfissionalDataEmissao,
				UFProf.Codigo as registroProfissionalUfEmissao, 
				RHCadPessoaBancario.NumeroPIS as pisPasep,
				RHCADPESSOA.PrimeiroEmprego as primeiroEmprego,
				case 
					when RHCADSERVIDORFINANCEIRO.AposentData IS NULL then 0
					else 1
				end as recebeAposentadoria,
				RHTABAGENCIA.BANCO as banco,
				RHTABAGENCIA.Codigo as agencia,	
				RHTABAGENCIA.DV as agenciaDv,					
				RHCadServidorBancario.CONTAPGTO_CONTA as conta,
				RHCadServidorBancario.CONTAPGTO_DV as contaDv,
				0 as statusImportacaoRamo
			FROM 
				MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR
				INNER JOIN MENTOR_SQL.dbo.RHCADPESSOA as RHCADPESSOA on RHCADSERVIDOR.pessoa = RHCADPESSOA.id
				INNER JOIN MENTOR_SQL.dbo.rhcadservidorFUNCIONAL as rhcadservidorFUNCIONAL on rhcadservidor.id = rhcadservidorFUNCIONAL.servidor
				INNER JOIN MENTOR_SQL.dbo.RHCadServidorBancario as RHCadServidorBancario on rhcadservidor.ID = RHCadServidorBancario.SERVIDOR
				INNER JOIN MENTOR_SQL.dbo.RHTABAGENCIA as RHTABAGENCIA ON RHTABAGENCIA.ID = RHCadServidorBancario.CONTAPGTO_AGENCIA
				INNER JOIN MENTOR_SQL.dbo.RHCadPessoaDoc as RHCadPessoaDoc on RHCadPessoaDoc.pessoa = rhcadpessoa.id
				INNER JOIN MENTOR_SQL.dbo.RHCadPessoaBancario as RHCadPessoaBancario on RHCadPessoaBancario.Pessoa = rhcadpessoa.ID
				INNER JOIN MENTOR_SQL.dbo.RhCadServidorFinanceiro as RhCadServidorFinanceiro on rhcadservidor.id = RhCadServidorFinanceiro.servidor	
				INNER JOIN MENTOR..SQLUser.RhTabRegimePrev as RhTabRegimePrev on RhTabRegimePrev.Id = RhCadServidorFinanceiro.Regimeprev
				LEFT JOIN MENTOR..SQLUser.RHTabFormacaoProfissional as RHTabFormacaoProfissional on RHTabFormacaoProfissional.id = RHCADPESSOA.FormacaoProfissional
				LEFT JOIN MENTOR..SQLUser.rhcadhistregjuridico as rhcadhistregjuridico on rhcadhistregjuridico.servidor = rhcadservidor.id and rhcadhistregjuridico.DataFinal is NULL
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFEndereco on UFEndereco.ID = RHCADPESSOA.Endereco_UF
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFTitulo on UFTitulo.ID = RHCadPessoaDoc.TitEleitorUF
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFCNH on UFCNH.ID = RHCadPessoaDoc.CNTUF
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFProf on UFProf.ID = RHCadPessoaDoc.RegProfUF
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFId on UFId.ID = RHCadPessoaDoc.IdUF
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFNaturalidade on UFNaturalidade.ID = RHCADPESSOA.NaturalidadeUF	
				LEFT JOIN MENTOR_SQL.dbo.RHTabMunicipio as MunicEndereco on MunicEndereco.ID = RHCADPESSOA.Endereco_Municipio
				LEFT JOIN MENTOR..SQLUser.RHTabESCodMunicipioIBGE as RHTabESCodMunicipioIBGE on RHTabESCodMunicipioIBGE.id = MunicEndereco.MunicipioIBGE
				LEFT JOIN MENTOR..SQLUser.RHTabEscolaridade as RHTabEscolaridade on RHTabEscolaridade.Id = RHCadPessoa.Escolaridade
				LEFT JOIN MENTOR_SQL.dbo.RHTABCARGOEFETIVO as RHTABCARGOEFETIVO on RHTABCARGOEFETIVO.ID = rhcadservidorFUNCIONAL.cargoefetivo
				LEFT JOIN MENTOR..SQLUser.RHCADCLASSEPADRAO as RHCADCLASSEPADRAO on RHCADCLASSEPADRAO.Servidor = rhcadservidor.id 
					and RHCADCLASSEPADRAO.DataVacancia IS NULL 
					and (RHCADCLASSEPADRAO.Cancelado = 0 or RHCADCLASSEPADRAO.Cancelado IS NULL)
				LEFT JOIN MENTOR..SQLUser.RHCADCARGOEFETIVO as RHCADCARGOEFETIVO on RHCADCARGOEFETIVO.Servidor = rhcadservidor.id and RHCADCARGOEFETIVO.VacanciaData is NULL
				INNER JOIN MENTOR_SQL.dbo.RHTabPais as PaisEndereco on PaisEndereco.ID = RHCADPESSOA.Endereco_Pais
				LEFT JOIN MENTOR_SQL.dbo.RHTabPadrao as RHTabPadrao on RHTabPadrao.ID = rhcadservidorFUNCIONAL.Padrao
				LEFT JOIN MENTOR_SQL.dbo.RHTabNacionalidade as RHTabNacionalidade on RHTabNacionalidade.ID = RHCADPESSOA.nacionalidade  
				LEFT JOIN MENTOR_SQL.dbo.RHTabPais as PaisNascimento on PaisNascimento.PaisESocial = RHCADPESSOA.paisNascimento
			WHERE	
				RhCadServidorFinanceiro.datadesligamento is null
				and (rhcadservidorFUNCIONAL.tiposervidor = 2)

		
		INSERT INTO DEPENDENTE
		(id_pessoaremovida, nome, dataNascimento, grauParentesco, sexo, nomeMae, cpf, rg, rgDataEmissao, rgOrgaoEmissor, rgUfEmissao, dataVigenciaAuxilioPreEscolar)
			SELECT 
				PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				RHCadDependente.Nome as nome,
				convert(datetime, RHCadDependente.DataNascFormatada, 103) as dataNascimento,
				RHTabDependenteParentesco.Descricao as grauParentesco,
				case RHCadDependente.Sexo
					when 1 then 2 
					when 2 then 1
				end as sexo,
				RHCadDependente.NomeMae as nomeMae,
				case 
					when RHCadDependente.CPF is null then '1' --TODO
					else dbo.udf_GetNumeric(RHCadDependente.CPF)
				end as cpf,
				RHCadDependente.IdNumero as rg,
				convert(datetime, RHCadDependente.IdDataExpFormatada, 103) as rgDataEmissao,
				RHCadDependente.IdOrgao as rgOrgaoEmissor,
				UFId.CODIGO as rgUfEmissao,
				convert(datetime, RHCadDependenteBeneficio.DtInicialBenefFormatada, 103) as dataVigenciaAuxilioPreEscolar
			FROM
				MENTOR_SQL.DBO.RHCadDependente as RHCadDependente
				INNER JOIN MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHCadDependente.Servidor  	
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula  	
				INNER JOIN MENTOR..SQLUser.RHTabDependenteParentesco as RHTabDependenteParentesco on RHTabDependenteParentesco.Codigo = RHCadDependente.Parentesco
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFId on UFId.ID = RHCadDependente.IdUF
				LEFT JOIN MENTOR_SQL.dbo.RHCadDependenteBeneficio as RHCadDependenteBeneficio on 
					RHCadDependenteBeneficio.Dependente = RHCadDependente.Id
					and RHCadDependenteBeneficio.TipoBenef = 3
			WHERE
				(convert(datetime, RHCadDependente.DataExclusaoFormatada , 103) > CURRENT_TIMESTAMP or RHCadDependente.DataExclusaoFormatada IS NULL)

		-- TREINAMENTO 
		INSERT INTO TREINAMENTO
		(id_pessoaremovida, nome, nomeInstituicao, tipo, dataInicio, dataFim, cargaHoraria, id_treinamento_mentor)

			SELECT
				PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				cast(RHCadTreFormComplementarExterna.Titulo as varchar(200)) as nome,
				RHTabTreEntidadeEnsino.Descricao as nomeInstituicao,
				2 as tipo,
				convert(datetime, RHCadTreFormComplementarExterna.DataInicialFormatada, 103) as dataInicio,
				convert(datetime, RHCadTreFormComplementarExterna.DataFinalFormatada, 103) as dataFim,
				case 
					when RHCadTreFormComplementarExterna.CargaHorRealizada is null then 0 --TODO
					else dbo.udf_GetNumeric(RHCadTreFormComplementarExterna.CargaHorRealizada)
				end as cargaHoraria,
				RHCadTreFormComplementarExterna.id as id_treinamento_mentor
			FROM
				MENTOR..SQLUser.RHCadTreFormComplementarExterna as RHCadTreFormComplementarExterna
				INNER JOIN MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHCadTreFormComplementarExterna.Servidor  	
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula  	
				inner join MENTOR..SQLUser.RHTabTreEntidadeEnsino as RHTabTreEntidadeEnsino on RHTabTreEntidadeEnsino.id = RHCadTreFormComplementarExterna.EntidadeInstrutor
			WHERE 
				RHCadTreFormComplementarExterna.DataInicialFormatada is not null and 
				RHCadTreFormComplementarExterna.DataFinalFormatada is not null

			UNION

			SELECT 
				PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				cast(RHTabTreEvento.TituloFormatado as varchar(200)) as nome,
				case 
					when RHTabTreEvento.EmitenteNome is null then '' --TODO
					else RHTabTreEvento.EmitenteNome
				end as nomeInstituicao,
				1 as tipo,
				convert(datetime, RHCadTreFormComplementarInterna.DataInicialFormatada, 103) as dataInicio,
				convert(datetime, RHCadTreFormComplementarInterna.DataFinalFormatada, 103) as dataFim,
				case 
					when RHCadTreFormComplementarInterna.CargaHorIndFormatada is null then 0 --TODO
					else dbo.udf_GetNumeric(RHCadTreFormComplementarInterna.CargaHorIndFormatada)
				end as cargaHoraria,
				RHCadTreFormComplementarInterna.id as id_treinamento_mentor
			FROM
				MENTOR_SQL.dbo.RHCadTreFormComplementarInterna as RHCadTreFormComplementarInterna
				INNER JOIN MENTOR..SQLUser.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHCadTreFormComplementarInterna.Servidor  	
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula  	
				INNER JOIN MENTOR..SQLUser.RHTabTreEvento as RHTabTreEvento on RHTabTreEvento.Codigo = RHCadTreFormComplementarInterna.Evento
			WHERE 
				RHCadTreFormComplementarInterna.DataFinalFormatada is not null and 
				RHCadTreFormComplementarInterna.DataFinalFormatada is not null

		-- TREINAMENTO AGRUPAMENTO
		INSERT INTO DESPACHANTE_DEV.dbo.TREINAMENTO_AGRUPAMENTO
		(id_treinamento, cargaHorariaUtilizada, sequencialAgrupamento, dataInicio, dataFim)
			SELECT
				TREINAMENTO.id_treinamento as id_treinamento,
				dbo.udf_GetNumeric(RHCadTreFormComplementarExterna.CargaHorUtilizadaAQ) as cargaHorariaUtilizada,
				RHCadAdicQualificacao.Id as sequencialAgrupamento,
				convert(datetime, RHCadAdicQualificacao.DataInicialFormatada , 103) as dataInicio, 
				convert(datetime, RHCadAdicQualificacao.DataFinalFormatada  , 103) as dataFim
			from 
				MENTOR..SQLUser.RHCadTreFormComplementarExterna as RHCadTreFormComplementarExterna
				INNER JOIN MENTOR..SQLUSer.RHCadAdicQualificacao as RHCadAdicQualificacao on RHCadAdicQualificacao.Id = RHCadTreFormComplementarExterna.AdicQualificacao
				INNER JOIN TREINAMENTO as TREINAMENTO on TREINAMENTO.id_treinamento_mentor = RHCadTreFormComplementarExterna.id and TREINAMENTO.tipo = 2
			where 
				RHCadTreFormComplementarExterna.CargaHorUtilizadaAQ is not null

			UNION 

			SELECT
				TREINAMENTO.id_treinamento as id_treinamento,
				dbo.udf_GetNumeric(RHCadTreFormComplementarInterna.CargaHorUtilizadaAQ) as cargaHorariaUtilizada,
				RHCadAdicQualificacao.Id as sequencialAgrupamento,
				convert(datetime, RHCadAdicQualificacao.DataInicialFormatada , 103) as dataInicio, 
				convert(datetime, RHCadAdicQualificacao.DataFinalFormatada  , 103) as dataFim
			from 
				MENTOR..SQLUser.RHCadTreFormComplementarInterna as RHCadTreFormComplementarInterna
				INNER JOIN MENTOR..SQLUSer.RHCadAdicQualificacao as RHCadAdicQualificacao on RHCadAdicQualificacao.Id = RHCadTreFormComplementarInterna.AdicQualificacao
				INNER JOIN TREINAMENTO as TREINAMENTO on TREINAMENTO.id_treinamento_mentor = RHCadTreFormComplementarInterna.id and TREINAMENTO.tipo = 1
			where 
				RHCadTreFormComplementarInterna.CargaHorUtilizadaAQ is not null


		-- CONSIGNADO
		INSERT INTO DESPACHANTE_DEV.dbo.CONSIGNADO
		(id_pessoaremovida, cnpj, nomeInstituicao, percentualMargem, numeroParcelasContratadas, numeroParcelasPagar, valorParcela)
			SELECT
				PESSOA_REMOVIDA.id_pessoaremovida,
				RHTabConsignataria.CGC AS cnpj,
				RHTabConsignataria.Descricao AS nomeInstituicao,
				0 as percentualMargem,
				RHFolCredorConsignataria.QtdParcela as numeroParcelasContratadas,
				0 as numeroParcelasPagar,
				dbo.udf_GetNumeric(RHFolCredorConsignataria.Valor) as valorParcela
			FROM 
				MENTOR..SQLUser.RHTabConsignataria as RHTabConsignataria
				INNER JOIN MENTOR..SQLUser.RHTabRubrica as RHTabRubrica ON RHTabRubrica.Consignataria = RHTabConsignataria.ID 
				INNER JOIN MENTOR..SQLUser.RHFolCredorConsignataria as RHFolCredorConsignataria ON RHFolCredorConsignataria.Rubrica = RHTabRubrica.ID 
				INNER JOIN MENTOR..SQLUser.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHFolCredorConsignataria.Servidor
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula
			WHERE 
				RHFolCredorConsignataria.TipoDesconto = 1 and 
				CAST(RHFolCredorConsignataria.DataFim AS DATE) >= CAST(CURRENT_TIMESTAMP AS DATE)

		-- DESCONTO JUDICIAL
		-- FUNPRESP
		INSERT INTO FUNPRESP
		(id_pessoaremovida, tipoContribuicao, tipoTributacao, percentualDesconto, quantidadeUrp, valorBaseCalculo, dataAdesao)
			SELECT
				PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				case RHFunprespTab03.TipoPlano 
					when 1 then 1 
					when 2 then 3
					when 3 then 2 
					when 4 then 3
				end as tipoContribuicao,
				1 as tipoTributacao, --TODO
				cast(replace(RHFunprespCadastro.PercParticipanteFormatado, ',','.') as numeric(10,2)) as percentualDesconto,
				0 as quantidadeUrp, --TODO
				RHFunprespFinanceiro.ValorBase as valorBaseCalculo,
				convert(datetime, RHFunprespCadastro.DataInicioFormatada, 103) as dataAdesao
			FROM 
				MENTOR..SQLUser.RHFunprespCadastro as RHFunprespCadastro
				INNER JOIN MENTOR..SQLUser.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHFunprespCadastro.Servidor
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula
				INNER JOIN MENTOR..SQLUser.RHFunprespTab03 as RHFunprespTab03 on RHFunprespTab03.Codigo = RHFunprespCadastro.RubricaPagamento
				LEFT JOIN (
					select RHFunprespFinanceiro.Servidor, RHFunprespFinanceiro.TipoPlano, RHFunprespFinanceiro.ValorBase
					from MENTOR..SQLUser.RHFunprespFinanceiro as RHFunprespFinanceiro
					INNER JOIN (
						SELECT Servidor, MAX(Folha) as F
						FROM MENTOR..SQLUser.RHFunprespFinanceiro 
						GROUP BY Servidor
					) as RHFunprespFinanceiroJ ON RHFunprespFinanceiroJ.Servidor = RHFunprespFinanceiro.Servidor AND RHFunprespFinanceiroJ.F = RHFunprespFinanceiro.Folha
				) as RHFunprespFinanceiro on RHFunprespFinanceiro.Servidor = RHCADSERVIDOR.ID and RHFunprespFinanceiro.TipoPlano = RHFunprespTab03.TipoPlano


		-- FUNPRESP AGRUPAMENTO
		-- SINDICADO ASSOCIACAO
		INSERT INTO SINDICATO_ASSOCIACAO
		(id_pessoaremovida, dataInicioVigencia, cnpj, nomeSindicatoAssociacao)
			SELECT 
				PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				convert(datetime, RHFolCredorConsignataria.DataInicioFormatada, 103) as dataInicioVigencia,
				RHTabConsignataria.CGC AS cnpj,
				RHTabConsignataria.Descricao AS nomeSindicatoAssociacao
			FROM 
				MENTOR..SQLUser.RHTabConsignataria as RHTabConsignataria
				INNER JOIN MENTOR..SQLUser.RHTabRubrica as RHTabRubrica ON RHTabRubrica.Consignataria = RHTabConsignataria.ID 
				INNER JOIN MENTOR..SQLUser.RHFolCredorConsignataria as RHFolCredorConsignataria ON RHFolCredorConsignataria.Rubrica = RHTabRubrica.ID 
				INNER JOIN MENTOR..SQLUser.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHFolCredorConsignataria.Servidor
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula
			WHERE 
				RHFolCredorConsignataria.DataFim IS NULL AND 
				(RHTabConsignataria.Descricao LIKE '%SIND%' OR RHTabConsignataria.Descricao LIKE '%ASS%')

		-- PENSAO ALIMENTICIA
		INSERT INTO DESPACHANTE_DEV.dbo.PENSAO_ALIMENTICIA
		(id_dependente, tipoBaseCalculo, dataInicioPagamento, valorReferencia, valorAdiantamentoGratificaoNatalina, descricaoDescontoJudicial, cpfRepresentanteLegal, nomeRepresentanteLegal, banco, agencia, agenciaDv, conta, contaDv)
			SELECT
				DEPENDENTE.id_dependente,
				1 as tipoBaseCalculo,
				RHCADPENSAOALIMENTICIA.DataInicialFormatada as dataInicioPagamento,
				RHCADPENSAOALIMENTICIA.Percentual as valorReferencia,
				1 as valorAdiantamentoGratificaoNatalina,
				NULL as descricaoDescontoJudicial,
				RHCADPENSAOALIMENTICIA.CPF as cpfRepresentanteLegal,
				RHCADPENSAOALIMENTICIA.Nome as nomeRepresentanteLegal,
				RHCADPENSAOALIMENTICIA.Banco as banco,
				RHTABAGENCIA.Codigo as agencia,
				RHTABAGENCIA.Dv as agenciaDv,
				RHCADPENSAOALIMENTICIA.Conta as conta,
				RHCADPENSAOALIMENTICIA.Dv as contaDv
			from 
				MENTOR..SQLUser.RHCadPensaoAlimenticia as RHCadPensaoAlimenticia
				INNER JOIN MENTOR..SQLUser.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHCadPensaoAlimenticia.Servidor
				INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula
				INNER JOIN DEPENDENTE on DEPENDENTE.id_pessoaremovida = PESSOA_REMOVIDA.id_pessoaremovida and DEPENDENTE.cpf = RHCadPensaoAlimenticia.cpf
				LEFT  JOIN MENTOR..SQLUser.RHTABAGENCIA as RHTABAGENCIA on RHTABAGENCIA.ID = RHCADPENSAOALIMENTICIA.Agencia
			where RHCadPensaoAlimenticia.DataFinal is null

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

