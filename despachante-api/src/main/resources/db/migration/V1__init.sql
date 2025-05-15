SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AUDIT_REVINFO](
	[REV] [int] NOT NULL,
	[REVTSTMP] [bigint] NULL,
	[data] [datetime2](7) NOT NULL,
	[origem] [varchar](255) NOT NULL,
	[usuario] [varchar](255) NOT NULL,
	[usuario_db] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[REV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CONSIGNADO](
	[id_consignado] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,	
	[cnpj] [varchar](14) NOT NULL,
	[nomeInstituicao] [varchar](100) NOT NULL,
	[percentualMargem] [numeric](10, 2) NOT NULL,	
	[numeroParcelasContratadas] [numeric](10,0) NOT NULL,
	[numeroParcelasPagar] [numeric](10,0) NOT NULL,
	[valorParcela] [numeric](10, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_consignado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DEPENDENTE](
	[id_dependente] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,	
	[nome] [varchar](100) NOT NULL,
	[dataNascimento] [datetime2](7) NULL,
	[grauParentesco] [varchar](100) NOT NULL,
	[sexo] [int] NULL,
	[nomeMae] [varchar](100) NULL,	
	[cpf] [varchar](11) NOT NULL,
	[rg] [varchar](100) NULL,
	[rgDataEmissao] [datetime2](7) NULL,
	[rgOrgaoEmissor] [varchar](100) NULL,
	[rgUfEmissao] [varchar](2) NULL,	
	[dataVigenciaAuxilioPreEscolar] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_dependente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DESCONTO_JUDICIAL](
	[id_desconto_judicial] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	[tipoBaseCalculo] [int] NULL,
	[tipoValor] [int] NULL,
	[valorTotalDesconto] [numeric](10, 2) NOT NULL,
	[valorPagar] [numeric](10, 2) NOT NULL,	
	[valorDesconto] [numeric](10, 2) NOT NULL,
	[descricaoDescontoJudicial] [varchar](4000) NULL,
	[cpfCnpjBeneficiario] [varchar](14) NOT NULL,
	[nomeBeneficiario] [varchar](100) NOT NULL,
	[banco] [numeric](20, 0) NOT NULL,	
	[agencia] [numeric](20, 0) NOT NULL,
	[agenciaDv] [varchar](1) NULL,
	[conta] [numeric](20, 0) NOT NULL,
	[contaDv] [varchar](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_desconto_judicial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ESTADO_CIVIL](
	[id_estado_civil] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_estado_civil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FUNPRESP](
	[id_funpresp] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	[tipoContribuicao] [int] NULL,
	[tipoTributacao] [int] NULL,
	[percentualDesconto] [numeric](10, 2) NULL,	
	[quantidadeUrp] [numeric](10, 0) NULL,
	[valorBaseCalculo] [numeric](10, 2) NULL,
	[dataAdesao] [datetime2](7) NOT NULL,	
PRIMARY KEY CLUSTERED 
(
	[id_funpresp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FUNPRESP_AGRUPAMENTO](
	[id_funpresp_agrupamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_funpresp] [bigint] NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	[tipoAgrupamento] [int] NULL,
	[dataInicio] [datetime2](7) NOT NULL,
	
PRIMARY KEY CLUSTERED 
(
	[id_funpresp_agrupamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GRAU_INSTRUCAO](
	[id_grau_instrucao] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_grau_instrucao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IDENTIDADE_GENERO](
	[id_identidade_genero] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_identidade_genero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PAGAMENTO](
	[id_pagamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	[valorAdicionalQualificacao] [numeric](10, 2) NOT NULL,
	[dataExpiracaoAdicional1] [datetime2](7) NULL,
	[dataExpiracaoAdicional2] [datetime2](7) NULL,
	[quintosDecimos] [numeric](10, 2) NULL,	
	[anuenios] [numeric](10, 0) NULL,
	[dataInicioAbonoPermanecia] [datetime2](7) NULL,
	[vpni] [numeric](10, 2) NULL,	
	[auxilioAlimentacao] [numeric](10, 2) NULL,
	[feriasAnoExercicio] [int] NOT NULL,
	[feriasSaldo] [int] NOT NULL,
	[feriasUmTerco] [int] NOT NULL,
	[feriasDataAdiantamento] [datetime2](7) NOT NULL,
	[feriasAdiantamentoSaldo] [numeric](10, 2) NULL,
	[feriasAdiantamentoParcela] [int] NOT NULL,
	[feriasAdiantamentoIr] [int] NOT NULL,
	[gratificacaoNatalinaAdiantamento] [numeric](10, 2) NULL,	
	[dataIsencaoIr] [datetime2](7) NULL,
	[tipoIsencaoIr] [numeric](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_pagamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PENSAO_ALIMENTICIA](
	[id_pensao_alimenticia] [bigint] IDENTITY(1,1) NOT NULL,
	[id_dependente] [bigint] NOT NULL,
	[tipoBaseCalculo] [int] NULL,
	[dataInicioPagamento] [datetime2](7) NOT NULL,
	[valorReferencia] [numeric](10, 2) NOT NULL,
	[valorAdiantamentoGratificaoNatalina] [numeric](10, 2) NOT NULL,
	[descricaoDescontoJudicial] [varchar](4000) NULL,
	[cpfRepresentanteLegal] [varchar](11) NULL,
	[nomeRepresentanteLegal] [varchar](100) NULL,
	[banco] [numeric](20, 0) NOT NULL,	
	[agencia] [numeric](20, 0) NOT NULL,
	[agenciaDv] [varchar](1) NULL,
	[conta] [numeric](20, 0) NOT NULL,
	[contaDv] [varchar](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_pensao_alimenticia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PESSOA_REMOVIDA](
	[id_pessoaremovida] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida_mentor] [bigint] NOT NULL,	
	[matricula] [numeric](25, 2) NULL,
	[nomeSocial] [varchar](100) NOT NULL,
	[nomeCivil] [varchar](100) NULL,
	[dataNascimento] [datetime2](7) NOT NULL,
	[sexo] [int] NULL,
	[identidadeGenero] [int] NULL,
	[enderecoCep] [bigint] NOT NULL,
	[enderecoResidencial] [varchar](100) NOT NULL,
	[enderecoNumero] [varchar](100) NULL,
	[enderecoComplemento] [varchar](100) NULL,
	[enderecoBairro] [varchar](100) NOT NULL,
	[enderecoUf] [varchar](2) NOT NULL,
	[enderecoMunicipio] [varchar](100) NULL,
	[enderecoPais] [varchar](100) NOT NULL,
	[enderecoCodigoIbge] [numeric](10, 0) NOT NULL,
	[emailParticular] [varchar](100) NULL,
	[estadoCivil] [int] NULL,
	[uniaoEstavel] [int] NOT NULL,
	[nomeConjuge] [varchar](100) NULL,
	[dataCasamento] [datetime2](7) NULL,
	[raca] [int] NULL,
	[doadorSangue] [int] NOT NULL,
	[tipoSanguineo] [varchar](2) NOT NULL,
	[fatorRh] [varchar](1) NOT NULL,
	[pne] [int] NOT NULL,
	[naturalidade] [varchar](100) NOT NULL,
	[naturalidadeUf] [varchar](2) NOT NULL,
	[nacionalidade] [varchar](100) NOT NULL,
	[paisNascimento] [varchar](100) NOT NULL,
	[grauInstrucao] [int] NULL,
	[formacaoProfissional] [varchar](200) NULL,
	[cargo] [varchar](20) NOT NULL,
	[cargoNivel] [varchar](2) NOT NULL,	
	[cargoClasse] [varchar](1) NOT NULL,
	[cargoPadrao] [varchar](2) NOT NULL,
	[dataUltimaProgressao] [datetime2](7) NOT NULL,
	[dataNomeacao] [datetime2](7) NOT NULL,
	[dataExercicio] [datetime2](7) NOT NULL,
	[dataPosse] [datetime2](7) NOT NULL,
	[dataExercicioIninterruptoMpu] [datetime2](7) NOT NULL,
	[unidadeLotacaoRemovido] [varchar](200) NULL,
	[regimePrevidenciario] [int] NULL,
	[cpf] [varchar](11) NOT NULL,
	[rgNumero] [varchar](100) NOT NULL,
	[rgOrgao] [varchar](100) NOT NULL,
	[rgDataEmissao] [datetime2](7) NOT NULL,
	[rgUfEmissao] [varchar](2) NOT NULL,
	[tituloNumero] [numeric](20, 2) NOT NULL,
	[tituloZona] [varchar](10) NOT NULL,
	[tituloSecao] [varchar](10) NOT NULL,
	[tituloUf] [varchar](2) NOT NULL,	
	[tituloDataEmissao] [datetime2](7) NOT NULL,
	[certificadoMilitar] [numeric](20, 0) NULL,
	[certificadoMilitarDataEmissao] [datetime2](7) NULL,
	[cnh] [numeric](19, 2) NULL,
	[cnhCategoria] [varchar](2) NULL,
	[cnhDataEmissao] [datetime2](7) NULL,
	[cnhDataValidade] [datetime2](7) NULL,
	[cnhUfEmissao] [varchar](2) NULL,
	[registroProfissional] [varchar](20) NULL,
	[registroProfissionalTipo] [varchar](100) NULL,
	[registroProfissionalDataEmissao] [datetime2](7) NULL,	
	[registroProfissionalUfEmissao] [varchar](2) NULL,
	[pisPasep] [numeric](20, 0) NOT NULL,
	[primeiroEmprego] [int] NOT NULL,
	[recebeAposentadoria] [int] NOT NULL,
	[banco] [numeric](20, 0) NOT NULL,
	[agencia] [numeric](20, 0) NOT NULL,
	[agenciaDv] [varchar](1) NULL,
	[conta] [numeric](20, 0) NOT NULL,
	[contaDv] [varchar](1) NOT NULL,
	[statusImportacaoRamo] [int] NOT NULL,	
PRIMARY KEY CLUSTERED 
(
	[id_pessoaremovida] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RACA](
	[id_raca] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_raca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOG_ERRO](
	[id_logerro] [bigint] IDENTITY(1,1) NOT NULL,	
	[entidade]   [varchar](1000) NOT NULL,
	[dataHora]   [datetime2](7)  NOT NULL,
	[erro]       [varchar](1000) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_logerro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SEXO](
	[id_sexo] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_sexo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SINDICATO_ASSOCIACAO](
	[id_sindicato_associacao] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NULL,	
	[dataInicioVigencia] [datetime2](7) NOT NULL,	
	[cnpj] [varchar](14) NOT NULL,
	[nomeSindicatoAssociacao] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_sindicato_associacao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_AGRUPAMENTO](
	[id_tipo_agrupamento] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_agrupamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_BASE_CALCULO](
	[id_tipo_base_calculo] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_base_calculo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_CONTRIBUICAO](
	[id_tipo_contribuicao] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_contribuicao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_REGIME_PREVIDENCIARIO](
	[id_tipo_regime_previdenciario] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_regime_previdenciario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_TREINAMENTO](
	[id_tipo_treinamento] [int] NOT NULL,
	[descricao] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_treinamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_TRIBUTACAO](
	[id_tipo_tributacao] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_tributacao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_VALOR](
	[id_tipo_valor] [int] NOT NULL,
	[descricao] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_tipo_valor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TREINAMENTO](
	[id_treinamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,	
	[nome] [varchar](200) NOT NULL,
	[nomeInstituicao] [varchar](200) NOT NULL,
	[tipo] [int] NULL,
	[dataInicio] [datetime2](7) NOT NULL,
	[dataFim] [datetime2](7) NOT NULL,	
	[cargaHoraria] [numeric](19, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_treinamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TREINAMENTO_AGRUPAMENTO](
	[id_treinamento_agrupamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_treinamento] [bigint] NOT NULL,	
	[cargaHorariaUtilizada] [numeric](19, 2) NOT NULL,
	[sequencialAgrupamento] [int] NOT NULL,
	[dataInicio] [datetime2](7) NOT NULL,
	[dataFim] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_treinamento_agrupamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CONSIGNADO]  WITH CHECK ADD  CONSTRAINT [FKopusjuk9u8gh5p13vwjj7hgi0] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[CONSIGNADO] CHECK CONSTRAINT [FKopusjuk9u8gh5p13vwjj7hgi0]
GO
ALTER TABLE [dbo].[DEPENDENTE]  WITH CHECK ADD  CONSTRAINT [FK2j9j8kojj7ypr67sux5y7jybr] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[DEPENDENTE] CHECK CONSTRAINT [FK2j9j8kojj7ypr67sux5y7jybr]
GO
ALTER TABLE [dbo].[DEPENDENTE]  WITH CHECK ADD  CONSTRAINT [FKtr7c4fc65wknuayn9lubfm80i] FOREIGN KEY([sexo])
REFERENCES [dbo].[SEXO] ([id_sexo])
GO
ALTER TABLE [dbo].[DEPENDENTE] CHECK CONSTRAINT [FKtr7c4fc65wknuayn9lubfm80i]
GO
ALTER TABLE [dbo].[DESCONTO_JUDICIAL]  WITH CHECK ADD  CONSTRAINT [FK14np88e8q19809sy8v8khgco6] FOREIGN KEY([tipoValor])
REFERENCES [dbo].[TIPO_VALOR] ([id_tipo_valor])
GO
ALTER TABLE [dbo].[DESCONTO_JUDICIAL] CHECK CONSTRAINT [FK14np88e8q19809sy8v8khgco6]
GO
ALTER TABLE [dbo].[DESCONTO_JUDICIAL]  WITH CHECK ADD  CONSTRAINT [FKgmr9ipcbclhguds3lch4vvamp] FOREIGN KEY([tipoBaseCalculo])
REFERENCES [dbo].[TIPO_BASE_CALCULO] ([id_tipo_base_calculo])
GO
ALTER TABLE [dbo].[DESCONTO_JUDICIAL] CHECK CONSTRAINT [FKgmr9ipcbclhguds3lch4vvamp]
GO
ALTER TABLE [dbo].[DESCONTO_JUDICIAL]  WITH CHECK ADD  CONSTRAINT [FKhumx1itl87gqmd1lbfloh13wp] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[DESCONTO_JUDICIAL] CHECK CONSTRAINT [FKhumx1itl87gqmd1lbfloh13wp]
GO
ALTER TABLE [dbo].[FUNPRESP]  WITH CHECK ADD  CONSTRAINT [FKd171oh704gtnigyvrlv91be5h] FOREIGN KEY([tipoTributacao])
REFERENCES [dbo].[TIPO_TRIBUTACAO] ([id_tipo_tributacao])
GO
ALTER TABLE [dbo].[FUNPRESP] CHECK CONSTRAINT [FKd171oh704gtnigyvrlv91be5h]
GO
ALTER TABLE [dbo].[FUNPRESP]  WITH CHECK ADD  CONSTRAINT [FKmqvxe835jt73qduxpge9of2yq] FOREIGN KEY([tipoContribuicao])
REFERENCES [dbo].[TIPO_CONTRIBUICAO] ([id_tipo_contribuicao])
GO
ALTER TABLE [dbo].[FUNPRESP] CHECK CONSTRAINT [FKmqvxe835jt73qduxpge9of2yq]
GO
ALTER TABLE [dbo].[FUNPRESP]  WITH CHECK ADD  CONSTRAINT [FKtnnmpduowvvs6etwswmdp7gtp] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[FUNPRESP] CHECK CONSTRAINT [FKtnnmpduowvvs6etwswmdp7gtp]
GO
ALTER TABLE [dbo].[FUNPRESP_AGRUPAMENTO]  WITH CHECK ADD  CONSTRAINT [FK3nt3jdnj42aqc58d38j41w7j8] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[FUNPRESP_AGRUPAMENTO] CHECK CONSTRAINT [FK3nt3jdnj42aqc58d38j41w7j8]
GO
ALTER TABLE [dbo].[FUNPRESP_AGRUPAMENTO]  WITH CHECK ADD  CONSTRAINT [FKai477fvc3lfwsqnbulv54xbme] FOREIGN KEY([tipoAgrupamento])
REFERENCES [dbo].[TIPO_AGRUPAMENTO] ([id_tipo_agrupamento])
GO
ALTER TABLE [dbo].[FUNPRESP_AGRUPAMENTO] CHECK CONSTRAINT [FKai477fvc3lfwsqnbulv54xbme]
GO
ALTER TABLE [dbo].[FUNPRESP_AGRUPAMENTO]  WITH CHECK ADD  CONSTRAINT [FKi662jobo55cn0e6i6lntr3k3y] FOREIGN KEY([id_funpresp])
REFERENCES [dbo].[FUNPRESP] ([id_funpresp])
GO
ALTER TABLE [dbo].[FUNPRESP_AGRUPAMENTO] CHECK CONSTRAINT [FKi662jobo55cn0e6i6lntr3k3y]
GO
ALTER TABLE [dbo].[PAGAMENTO]  WITH CHECK ADD  CONSTRAINT [FK23g1oqec7d69reouibm3av9w5] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[PAGAMENTO] CHECK CONSTRAINT [FK23g1oqec7d69reouibm3av9w5]
GO
ALTER TABLE [dbo].[PENSAO_ALIMENTICIA]  WITH CHECK ADD  CONSTRAINT [FKivr611xnmq5gcybvx47l1j71n] FOREIGN KEY([tipoBaseCalculo])
REFERENCES [dbo].[TIPO_BASE_CALCULO] ([id_tipo_base_calculo])
GO
ALTER TABLE [dbo].[PENSAO_ALIMENTICIA] CHECK CONSTRAINT [FKivr611xnmq5gcybvx47l1j71n]
GO
ALTER TABLE [dbo].[PENSAO_ALIMENTICIA]  WITH CHECK ADD  CONSTRAINT [FKrkrhrgnlsdrwydtchnl6kub8i] FOREIGN KEY([id_dependente])
REFERENCES [dbo].[DEPENDENTE] ([id_dependente])
GO
ALTER TABLE [dbo].[PENSAO_ALIMENTICIA] CHECK CONSTRAINT [FKrkrhrgnlsdrwydtchnl6kub8i]
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA]  WITH CHECK ADD  CONSTRAINT [FK5qr32b6ix5u3gljrylnvy65d7] FOREIGN KEY([identidadeGenero])
REFERENCES [dbo].[IDENTIDADE_GENERO] ([id_identidade_genero])
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA] CHECK CONSTRAINT [FK5qr32b6ix5u3gljrylnvy65d7]
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA]  WITH CHECK ADD  CONSTRAINT [FKam3fvcejpah7lxfi4v8t0y9o1] FOREIGN KEY([regimePrevidenciario])
REFERENCES [dbo].[TIPO_REGIME_PREVIDENCIARIO] ([id_tipo_regime_previdenciario])
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA] CHECK CONSTRAINT [FKam3fvcejpah7lxfi4v8t0y9o1]
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA]  WITH CHECK ADD  CONSTRAINT [FKgdubv6jg4hja5y3vpopjomvv2] FOREIGN KEY([estadoCivil])
REFERENCES [dbo].[ESTADO_CIVIL] ([id_estado_civil])
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA] CHECK CONSTRAINT [FKgdubv6jg4hja5y3vpopjomvv2]
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA]  WITH CHECK ADD  CONSTRAINT [FKlnn1mthqgns7kjpaf2bd44oh3] FOREIGN KEY([raca])
REFERENCES [dbo].[RACA] ([id_raca])
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA] CHECK CONSTRAINT [FKlnn1mthqgns7kjpaf2bd44oh3]
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA]  WITH CHECK ADD  CONSTRAINT [FKnk4ieolal7971mihp0exn13op] FOREIGN KEY([grauInstrucao])
REFERENCES [dbo].[GRAU_INSTRUCAO] ([id_grau_instrucao])
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA] CHECK CONSTRAINT [FKnk4ieolal7971mihp0exn13op]
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA]  WITH CHECK ADD  CONSTRAINT [FKu3dfv4e2hc2msvkfil4gdxhb] FOREIGN KEY([sexo])
REFERENCES [dbo].[SEXO] ([id_sexo])
GO
ALTER TABLE [dbo].[PESSOA_REMOVIDA] CHECK CONSTRAINT [FKu3dfv4e2hc2msvkfil4gdxhb]
GO
ALTER TABLE [dbo].[SINDICATO_ASSOCIACAO]  WITH CHECK ADD  CONSTRAINT [FKt13534mmlboniby9clgxs83t3] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[SINDICATO_ASSOCIACAO] CHECK CONSTRAINT [FKt13534mmlboniby9clgxs83t3]
GO
ALTER TABLE [dbo].[TREINAMENTO]  WITH CHECK ADD  CONSTRAINT [FK5436uwm3ip8nr0rcilhwbdgaa] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
ALTER TABLE [dbo].[TREINAMENTO] CHECK CONSTRAINT [FK5436uwm3ip8nr0rcilhwbdgaa]
GO
ALTER TABLE [dbo].[TREINAMENTO]  WITH CHECK ADD  CONSTRAINT [FKi72h1vskw64fbg68993cdi2uf] FOREIGN KEY([tipo])
REFERENCES [dbo].[TIPO_TREINAMENTO] ([id_tipo_treinamento])
GO
ALTER TABLE [dbo].[TREINAMENTO] CHECK CONSTRAINT [FKi72h1vskw64fbg68993cdi2uf]
GO
ALTER TABLE [dbo].[TREINAMENTO_AGRUPAMENTO]  WITH CHECK ADD  CONSTRAINT [FK6lmrxosq122p3y5l9vif0aibv] FOREIGN KEY([id_treinamento])
REFERENCES [dbo].[TREINAMENTO] ([id_treinamento])
GO
ALTER TABLE [dbo].[TREINAMENTO_AGRUPAMENTO] CHECK CONSTRAINT [FK6lmrxosq122p3y5l9vif0aibv]
GO
