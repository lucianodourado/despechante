CREATE TABLE [dbo].[TIPO_ISENCAO](
	[id_tipo_isencao] [int]  NOT NULL,	
	[descricao] [varchar](200) NOT NULL,	
PRIMARY KEY CLUSTERED 
(
	[id_tipo_isencao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


	
INSERT INTO dbo.TIPO_ISENCAO
(id_tipo_isencao, descricao)
VALUES
(1,'Isenção sobre abono de permanência'),
(2,'Isenção sobre remuneração'),
(3,'Isenção sobre 1/3 férias'),
(4,'Isenção sobre remuneração de férias'),
(5,'Isenção sobre gratificação natalina')
	