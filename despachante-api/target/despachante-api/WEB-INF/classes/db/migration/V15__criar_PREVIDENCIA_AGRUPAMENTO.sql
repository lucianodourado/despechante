CREATE TABLE [dbo].[PREVIDENCIA_AGRUPAMENTO](
	[id_previdencia_agrupamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
	[tipoAgrupamento] [int] NOT NULL,
	[dataInicio]	[datetime2](7) NOT NULL, 	
PRIMARY KEY CLUSTERED 
(
	[id_previdencia_agrupamento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
	
ALTER TABLE [dbo].[PREVIDENCIA_AGRUPAMENTO]  WITH CHECK ADD  CONSTRAINT [FK_PREAGRUPPESSOA_REMOVIDA] FOREIGN KEY([id_pessoaremovida])
REFERENCES [dbo].[PESSOA_REMOVIDA] ([id_pessoaremovida])
GO