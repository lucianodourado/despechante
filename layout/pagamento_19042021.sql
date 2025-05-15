pagamento

CRIAR TABELA DO ZERO

	[id_pagamento] [bigint] IDENTITY(1,1) NOT NULL,
	[id_pessoaremovida] [bigint] NOT NULL,
valorAdicionalQualificacao, [numeric](2, 2), not null
dataExpiracaoAdicional1, [datetime2](7), null
dataExpiracaoAdicional2, [datetime2](7), null
valorQuintosDecimos, [numeric](10, 2), null
quantidadeAnuenios, [numeric](10, 2), null
dataInicioAbonoPermanencia, [datetime2](7), null
valorVpni, [numeric](10, 2), null
valorAuxilioAlimentacao, [numeric](10, 2), null
feriasAnoExercicio, [int]  , not null
quantidadeDiasferiasSaldo, [int]  , not null
feriasUmTerco, [int] , not null
ValorFeriasUmTerco, [numeric](10, 2), not null
feriasAdiantamentoIr, [int] null
ValorGratificacaoNatalinaAdiantamento,, [numeric](10, 2) not null
tipoIsencaoIr, [int] null
dataIsencaoIr, [datetime2](7), null
descricaoCalculoIsencaoIr, varchar(4000), null
tipoIsencaoPSS, int null
dataIsencaoPSS, [datetime2](7), null
descricaoCalculoIsencaoPSS, varchar(4000) null
	
