CREATE TABLE [dbo].[CONFIGURACAO](
	[id_ramo] [varchar](20) NOT NULL,
	[url_token] [varchar](1024) NOT NULL,
	[url_pessoa] [varchar](1024) NOT NULL,
	[url_erro] [varchar](1024) NOT NULL,	
PRIMARY KEY CLUSTERED 
(
	[id_ramo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

INSERT INTO [dbo].[CONFIGURACAO]
(id_ramo, url_token, url_pessoa, url_erro)
VALUES
('MPF','', '', ''),
('MPT','', '', ''),
('MPDFT','', '', '')

