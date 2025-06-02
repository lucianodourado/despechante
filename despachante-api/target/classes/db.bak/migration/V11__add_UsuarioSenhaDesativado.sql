ALTER TABLE [dbo].[CONFIGURACAO]
ADD ativo [bit] NOT NULL DEFAULT 1;

ALTER TABLE [dbo].[CONFIGURACAO]
ADD [usuario] [varchar](255);

ALTER TABLE [dbo].[CONFIGURACAO]
ADD [senha] [varchar](255);

