ALTER TABLE [dbo].[PAGAMENTO] WITH CHECK ADD CONSTRAINT [FK_IR_TIPO_ISENCAO] FOREIGN KEY([tipoIsencaoIr]) REFERENCES [dbo].[TIPO_ISENCAO] ([id_tipo_isencao]);
ALTER TABLE [dbo].[PAGAMENTO] WITH CHECK ADD CONSTRAINT [FK_PSS_TIPO_ISENCAO] FOREIGN KEY([tipoIsencaoPSS]) REFERENCES [dbo].[TIPO_ISENCAO] ([id_tipo_isencao]);
ALTER TABLE [dbo].PREVIDENCIA_AGRUPAMENTO WITH CHECK ADD CONSTRAINT [FK_PREVIDENCIA_TIPO_AGRUPAMENTO] FOREIGN KEY([tipoAgrupamento]) REFERENCES [dbo].[TIPO_AGRUPAMENTO] ([id_tipo_agrupamento]);
