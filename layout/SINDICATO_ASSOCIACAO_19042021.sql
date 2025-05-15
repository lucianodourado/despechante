SINDICATO_ASSOCIACAO

apagar e criar


	[id_sindicato_associacao] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NULL,
	[dataInicioVigencia] [datetime2](7) NOT NULL,
	[cnpj] [varchar](14) NOT NULL,
	[nomeSindicatoAssociacao] [varchar](100) NOT NULL,
	tipoBaseCalculo	int NOT NULL,
	valorReferencia	numeric(10,2) NOT NULL,
	descricaoDescontosSindicato	varchar(4000)	null
	banco	int not null
	agencia int not null
	agenciaDv varchar(1) not null
	conta	int not null
	contaDv varchar(1) not null
