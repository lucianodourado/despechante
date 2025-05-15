CREATE TABLE [dbo].[FERIAS](
	[id_ferias] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	dataAdiantamento	[datetime2](7) NULL,
	valorAdiantamentoSaldo	numeric(10,2) NULL,
	quantidadeAdiantamentoParcela [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_ferias] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
	
ALTER TABLE [dbo].[FERIAS]  WITH CHECK ADD  CONSTRAINT [FK_FERIAS_PESSOA_REMOVIDA] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO
	