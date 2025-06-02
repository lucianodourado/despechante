INSERT INTO TIPO_VALOR(ID_TIPO_VALOR, descricao) VALUES (1,'Quantidade');
INSERT INTO TIPO_VALOR(ID_TIPO_VALOR, descricao) VALUES (2,'Percentual');
INSERT INTO TIPO_VALOR(ID_TIPO_VALOR, descricao) VALUES (3,'Valor');

INSERT INTO TIPO_TRIBUTACAO(ID_TIPO_TRIBUTACAO, descricao) VALUES(1,'Regressiva');
INSERT INTO TIPO_TRIBUTACAO(ID_TIPO_TRIBUTACAO, descricao) VALUES(2,'Progressiva');

INSERT INTO TIPO_REGIME_PREVIDENCIARIO(ID_TIPO_REGIME_PREVIDENCIARIO, descricao) VALUES(1,'RPPS - Regime Próprio de Previdência Social');
INSERT INTO TIPO_REGIME_PREVIDENCIARIO(ID_TIPO_REGIME_PREVIDENCIARIO, descricao) VALUES(2,'RPPS limitado ao teto do RGPS');

INSERT INTO TIPO_CONTRIBUICAO(ID_TIPO_CONTRIBUICAO, descricao) VALUES(1,'Patrocinada');
INSERT INTO TIPO_CONTRIBUICAO(ID_TIPO_CONTRIBUICAO, descricao) VALUES(2,'Vinculada');
INSERT INTO TIPO_CONTRIBUICAO(ID_TIPO_CONTRIBUICAO, descricao) VALUES(3,'Facultativa');

INSERT INTO TIPO_BASE_CALCULO(ID_TIPO_BASE_CALCULO, descricao) VALUES(1,'Valor Líquido');
INSERT INTO TIPO_BASE_CALCULO(ID_TIPO_BASE_CALCULO, descricao) VALUES(2,'Valor Bruto');
INSERT INTO TIPO_BASE_CALCULO(ID_TIPO_BASE_CALCULO, descricao) VALUES(3,'Salário Líquido');
INSERT INTO TIPO_BASE_CALCULO(ID_TIPO_BASE_CALCULO, descricao) VALUES(4,'Valor Fixo');
INSERT INTO TIPO_BASE_CALCULO(ID_TIPO_BASE_CALCULO, descricao) VALUES(99,'Não Informado');

INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(1,'Função de confiança/cargo em comissão, inclusive em substituição');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(2,'Adicional de qualificação/treinamento');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(3,'Adicional noturno');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(4,'Adicional por serviço extraordinário (hora extra)');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(5,'Gratificação de perícia');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(6,'Gratificação de projeto');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(7,'Gratificação de Segurança');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(8,'Gratificação acumulação de ofício');
INSERT INTO TIPO_AGRUPAMENTO(ID_TIPO_AGRUPAMENTO, descricao) VALUES(9,'Rubricas pagas em decorrência de local de trabalho (Ad. Atividade penosa, Ad. Insalubridade, Ad. Periculosidade etc)');

INSERT INTO RACA(id_raca, descricao) VALUES (1,'Preta');
INSERT INTO RACA(id_raca, descricao) VALUES (2,'Branca');
INSERT INTO RACA(id_raca, descricao) VALUES (3,'Amarela');
INSERT INTO RACA(id_raca, descricao) VALUES (4,'Parda');
INSERT INTO RACA(id_raca, descricao) VALUES (5,'Indígena');
INSERT INTO RACA(id_raca, descricao) VALUES (99,'Não desejo informar');

INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(1,'Solteiro');
INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(2,'Casado');
INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(3,'Viúvo');
INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(4,'Separado');
INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(5,'Divorciado');
INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(6,'União Estável');
INSERT INTO ESTADO_CIVIL(id_estado_civil, descricao) VALUES(99,'Outros');

INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(1,'ANALFABETO');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(2,'ATÉ O 5º ANO INCOMPLETO DO ENSINO FUNDAMENTAL (ANTIGA 4ª SÉRIE');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(3,'5º ANO COMPLETO DO ENSINO FUNDAMENTAL');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(4,'DO 6º AO 9º ANO DO ENSINO FUNDAMENTAL (ANTIGA 5ª À 8ª SÉRIE)');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(5,'ENSINO FUNDAMENTAL COMPLETO');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(6,'ENSINO MÉDIO INCOMPLETO');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(7,'ENSINO MÉDIO COMPLETO');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(8,'EDUCAÇÃO SUPERIOR INCOMPLETA');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(9,'EDUCAÇÃO SUPERIOR COMPLETA');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(10,'ESPECIALIZAÇÃO');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(11,'MESTRADO');
INSERT INTO GRAU_INSTRUCAO(id_grau_instrucao, descricao) VALUES(12,'DOUTORADO');

INSERT INTO IDENTIDADE_GENERO(id_identidade_genero, descricao) VALUES(1,'Homem Transgênero');
INSERT INTO IDENTIDADE_GENERO(id_identidade_genero, descricao) VALUES(2,'Mulher Transgênero');

INSERT INTO TIPO_TREINAMENTO(id_tipo_treinamento, descricao) VALUES(1, 'Institucional');
INSERT INTO TIPO_TREINAMENTO(id_tipo_treinamento, descricao) VALUES(2, 'para Particular');

INSERT INTO SEXO(id_sexo, descricao) VALUES(1, 'Masculino');
INSERT INTO SEXO(id_sexo, descricao) VALUES(2, 'Feminino');




