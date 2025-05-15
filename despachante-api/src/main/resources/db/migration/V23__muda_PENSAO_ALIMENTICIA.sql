DROP TABLE [dbo].[PENSAO_ALIMENTICIA];
	
CREATE TABLE [dbo].[PENSAO_ALIMENTICIA](	
	[id_pensao_alimenticia] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NULL,
	[tipoBaseCalculo] [numeric](2, 0) NOT NULL,
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
	[nomePensionista] varchar(100) NOT NULL,
	[dataNascimentoPensionista]	[datetime2](7) NOT NULL,
	[grauParentescoPensionista] varchar(100) NOT NULL,
	[sexoPensionista]	varchar(1)  NULL,
	[nomeMaePensionista] varchar(100) NULL,
	[cpfPensionista] varchar(11) NOT NULL,
	[rgPensionista]	varchar(15) NULL,
	[rgOrgaoEmissorPensionista]	varchar(100) NULL,
	[rgUfEmissaoPensionista]	varchar(2) NULL,
	[rgDataEmissaoPensionista]	[datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_pensao_alimenticia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
	
ALTER TABLE [dbo].[PENSAO_ALIMENTICIA] WITH CHECK ADD  CONSTRAINT [FK_PENSAO_ALIMENTICIA_PESSOA_REMOVIDA] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO

	