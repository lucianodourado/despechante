DROP TABLE [dbo].[SINDICATO_ASSOCIACAO];

CREATE TABLE [dbo].[SINDICATO_ASSOCIACAO](
	[id_sindicato_associacao] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NULL,
	[dataInicioVigencia] [datetime2](7) NOT NULL,
	[cnpj] [varchar](14) NOT NULL,
	[nomeSindicatoAssociacao] [varchar](100) NOT NULL,
	tipoBaseCalculo	numeric(2,0) NOT NULL,
	valorReferencia	numeric(10,2) NOT NULL,
	descricaoDescontosSindicato	varchar(4000) NULL,
	banco numeric(20,0) NOT NULL,
	agencia numeric(20,0) NOT NULL,
	agenciaDv varchar(1) NOT NULL,
	conta  numeric(20,0) NOT NULL,
	contaDv varchar(1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_sindicato_associacao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
	
ALTER TABLE [dbo].[SINDICATO_ASSOCIACAO] WITH CHECK ADD  CONSTRAINT [FK_SINDICATO_ASSOCIACAO_PESSOA_REMOVIDA] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO

