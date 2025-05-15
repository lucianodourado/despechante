CONSIGNADO

apagar e recriar

	[id_consignado] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	cnpj	varchar(14)	not null
	nomeInstituicao	varchar(100) not null
	numeroParcelasContratadas numeric(10,2) not null
	numeroParcelasPagar	numeric(10,2) not null
	valorParcela	numeric(10,2) not null
	banco	int not null
	agencia int not null
	agenciaDv varchar(1) not null
	conta	int not null
	contaDv varchar(1) not null

