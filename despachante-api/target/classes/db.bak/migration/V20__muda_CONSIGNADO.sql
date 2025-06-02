DROP TABLE [dbo].[CONSIGNADO];

CREATE TABLE [dbo].[CONSIGNADO](
	id_consignado bigint NOT NULL IDENTITY(1,1),
	id_pessoaremovida bigint NOT NULL,
	cnpj varchar(14) NOT NULL,
	nomeInstituicao	varchar(100) NOT NULL,
	numeroParcelasContratadas numeric(10,2) NOT NULL,
	numeroParcelasPagar	numeric(10,2) NOT NULL,
	valorParcela	numeric(10,2) NOT NULL,
	banco numeric(20,0) NOT NULL,
	agencia numeric(20,0) NOT NULL,
	agenciaDv varchar(1) NOT NULL,
	conta  numeric(20,0) NOT NULL,
	contaDv varchar(1) NOT NULL,	
PRIMARY KEY CLUSTERED 
(
	[id_consignado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
	
ALTER TABLE [dbo].[CONSIGNADO]  WITH CHECK ADD  CONSTRAINT [FK_CONSIGNADO_PESSOA_REMOVIDA] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO