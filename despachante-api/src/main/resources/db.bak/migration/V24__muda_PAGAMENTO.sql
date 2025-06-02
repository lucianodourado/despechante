DROP TABLE [dbo].[PAGAMENTO];

CREATE TABLE [dbo].[PAGAMENTO] (

	[id_pagamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	[valorAdicionalQualificacao] numeric(2, 2) NOT NULL,
	[dataExpiracaoAdicional1] datetime2(7) NULL,
	[dataExpiracaoAdicional2] datetime2(7) NULL,
	[valorQuintosDecimos] numeric(10, 2) NULL,
	[quantidadeAnuenios] numeric(10, 2) NULL,
	[dataInicioAbonoPermanencia] datetime2(7) NULL,
	[valorVpni] numeric(10, 2) NULL,
	[valorAuxilioAlimentacao] numeric(10, 2) NULL,
	[feriasAnoExercicio] int  NOT NULL,
	[quantidadeDiasferiasSaldo] int NOT NULL,
	[feriasUmTerco] varchar(1) NOT NULL,
	[ValorFeriasUmTerco] numeric(10, 2) NOT NULL,
	[feriasAdiantamentoIr] varchar(1) NULL,
	[ValorGratificacaoNatalinaAdiantamento] numeric(10, 2) NOT NULL,
	[tipoIsencaoIr] int NULL,
	[dataIsencaoIr] datetime2(7) NULL,
	[descricaoCalculoIsencaoIr] varchar(4000) NULL,
	[tipoIsencaoPSS] int NULL,
	[dataIsencaoPSS] datetime2(7) NULL,
	[descricaoCalculoIsencaoPSS] varchar(4000) NULL,
	
PRIMARY KEY CLUSTERED 
(
	[id_pagamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
	
ALTER TABLE [dbo].PAGAMENTO WITH CHECK ADD CONSTRAINT [FK_PAGAMENTO_PESSOA_REMOVIDA] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO

