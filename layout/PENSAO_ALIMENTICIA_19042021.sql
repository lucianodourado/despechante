PENSAO_ALIMENTICIA

apagar e criar novamente

	[id_pensao_alimenticia] [bigint] IDENTITY(1,1) NOT NULL,
	[id_dependente] [bigint] NOT NULL,
	[tipoBaseCalculo] [int] not NULL,
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
	nomePensionista varchar(100) not null
	dataNascimentoPensionista	[datetime2](7) not null
	grauParentescoPensionista varchar(100) not null
	sexoPensionista	bit  null
	nomeMaePensionista	varchar(100) null
	cpfPensionista	varchar(10) not null
	rgPensionista	varchar(15) null
	rgOrgaoEmissorPensionista	varchar(100) null
	rgUfEmissaoPensionista	varchar(2) null
	rgDataEmissaoPensionista	[datetime2](7) null
	
