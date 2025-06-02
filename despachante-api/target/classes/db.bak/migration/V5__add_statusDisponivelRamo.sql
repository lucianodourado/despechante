ALTER TABLE [dbo].[PESSOA_REMOVIDA]
ALTER COLUMN statusImportacaoRamo BIT;

ALTER TABLE [dbo].[PESSOA_REMOVIDA]
ADD CONSTRAINT con_statusImportacaoRamo
DEFAULT 0 FOR statusImportacaoRamo;  

ALTER TABLE [dbo].[PESSOA_REMOVIDA]
ADD statusDisponivelRamo BIT DEFAULT 0; 