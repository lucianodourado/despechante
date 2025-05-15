DELETE FROM PENSAO_ALIMENTICIA;
DELETE FROM DEPENDENTE;	
DELETE FROM CONSIGNADO;
DELETE FROM DESCONTO_JUDICIAL;
DELETE FROM PREVIDENCIA_AGRUPAMENTO;
DELETE FROM FUNPRESP;
DELETE FROM SINDICATO_ASSOCIACAO;
DELETE FROM TREINAMENTO_AGRUPAMENTO;
DELETE FROM TREINAMENTO;
DELETE FROM PAGAMENTO;
DELETE FROM FERIAS;
DELETE FROM PESSOA_REMOVIDA;

DBCC CHECKIDENT ('PESSOA_REMOVIDA', RESEED, 0);

-- PESSOA_REMOVIDA
INSERT INTO PESSOA_REMOVIDA
(id_pessoaremovida_mentor, matricula, nomeSocial, nomeCivil, dataNascimento, sexo, identidadeGenero, enderecoCep, enderecoResidencial, enderecoNumero, enderecoComplemento, enderecoBairro, enderecoUf, enderecoMunicipio, enderecoPais, enderecoCodigoIbge, emailParticular, estadoCivil, uniaoEstavel, nomeConjuge, dataCasamento, raca, doadorSangue, tipoSanguineo, fatorRh, pne, naturalidade, naturalidadeUf, nacionalidade, paisNascimento, grauInstrucao, formacaoProfissional, cargo, cargoNivel, cargoClasse, cargoPadrao, dataUltimaProgressao, dataNomeacao, dataExercicio, dataPosse, dataExercicioIninterruptoMpu, unidadeLotacaoRemovido, regimePrevidenciario, cpf, rgNumero, rgOrgao, rgDataEmissao, rgUfEmissao, tituloNumero, tituloZona, tituloSecao, tituloUf, tituloDataEmissao, certificadoMilitar, certificadoMilitarDataEmissao, cnh, cnhCategoria, cnhDataEmissao, cnhDataValidade, cnhUfEmissao, registroProfissional, registroProfissionalTipo, registroProfissionalDataEmissao, registroProfissionalUfEmissao, pisPasep, primeiroEmprego, recebeAposentadoria, banco, agencia, agenciaDv, conta, contaDv, portariaRemocao)
VALUES
(1, 125, 'PEDRO PEREIRA', 'PEDRO', '12/01/2000', 1, NULL, 71930000, 'LOTE', '35', 'AO LONGO DA RUA', 'TABATI', 'RR', 'MACAPA', 'BRASIL', 1501402, 'maca@gmail.com', 1, 0, 'PEDRITA', '12/12/1988', 1, 1, 'B', 'P', 0, 'BRASILIA', 'DF', 'BRASILEIRO', 'BRASIL', 1, 'SUPER MEGA', 'AN030135', 'TC', 'A', '13', '04/12/2014', '04/12/2014', '04/12/2014', '04/12/2014', '04/12/2014', 'PGJM', 2, '63885517000', '3298534', 'SSP', '04/12/2014', 'PA', 31308520108, '29', '555', 'PA', '04/12/2014', NULL, NULL, NULL, NULL ,NULL, NULL, NULL, NULL, NULL, NULL, NULL,  81647475096, NULL, NULL, 1, 1022, '1', 9555, '8', 0),
(2, 222, 'SATURNINO COSTA', 'SATU', '01/12/1981', 1, NULL, 72125690, 'AVENIDA', '55', NULL, 'OLAVO FREIRE', 'AC', 'RIO BRANCO', 'BRASIL', 1501402, 'rio@gmail.com', 1, 0, 'BOB DA DORES', '11/01/1911', 1, 1, 'A', 'P', 0, 'PARA', 'PA', 'BRASILEIRO', 'BRASIL', 1, 'SUPER MEGA', 'AN030114', 'TC', 'A', '13', '04/12/2014', '04/12/2014', '04/12/2014', '04/12/2014', '04/12/2014', 'PGJM', 2, '63885517000', '3298534', 'SSP', '04/12/2014', 'AC', 31308520108, '30', '99', 'DF', '04/12/2014', NULL, NULL, NULL, NULL ,NULL, NULL, NULL, NULL, NULL, NULL, NULL,  81647475096, NULL, NULL, 1, 1022, '1', 9555, '8', 0),
(3, 1250, 'JOAO BASTOS DA SILVA DE MATOS DENTRO', 'JONAS', '02/07/1981', 1, NULL, 72125690, 'QND', '19', 'PERTO DO NADA', 'ALEMAO', 'RJ', 'RIO DE JANEIRO', 'BRASIL', 1501402, 'german@uol.com.br', 1, 0, 'NOEMIA PETRA', '08/08/1945', 2, 0, 'A', 'N', 0, 'RIO', 'RJ', 'BRASILEIRO', 'BRASIL', 1, 'SUPER MEGA', 'AN030112', 'TC', 'A', '13', '04/12/2014', '04/12/2014', '04/12/2014', '04/12/2014', '04/12/2014', 'PGJM', 2, '63885517000', '3298534', 'SSP', '04/12/2014', 'DF', 31308520108, '255', '222', 'SP', '04/12/2014', NULL, NULL, NULL, NULL ,NULL, NULL, NULL, NULL, NULL, NULL, NULL,  81647475096, NULL, NULL, 1, 1022, '1', 9555, '8', 0);

DBCC CHECKIDENT ('DEPENDENTE', RESEED, 0);

-- DEPENDENTE
INSERT INTO DEPENDENTE
(id_pessoaremovida, nome, dataNascimento, grauParentesco, sexo, nomeMae, cpf, rg, rgDataEmissao, rgOrgaoEmissor, rgUfEmissao, dataVigenciaAuxilioPreEscolar)
VALUES
(1, 'MARIA FARIA', '11/11/2000', 'FILHO', 2, '', '95503877047', '1978281', '11/01/2000', 'SSP', 'DF', '01/01/2000'),
(1, 'BERNADO FARIA', '11/11/2001', 'FILHO', 1, '', '95503877047', '', '', '', '', '01/01/2000'),
(2, 'CARLOS COSTA', '11/11/1999', 'ESPOSA', 1, '', '95503877047', '', '', '', '', '01/01/2000'),
(2, 'MARIA DOS DANTOS COSTA', '11/11/2001', 'FILHO', 2, '', '16428181002',  '', '', '', '', '01/01/2000'),
(3, 'JAIR DE MATOS DENTRO', '11/11/2019', 'PAI', 1, '', '16428181002', '', '', '', '', '01/01/1981'),
(3, 'FLAVIO DOS MATOS FORA', '11/11/1917', 'FILHO', 1, '', '16428181002', '', '', '', '', '01/01/1999');	

DBCC CHECKIDENT ('CONSIGNADO', RESEED, 0);

-- CONSIGNADO
INSERT INTO CONSIGNADO
(id_pessoaremovida, cnpj, nomeInstituicao, numeroParcelasContratadas, numeroParcelasPagar, valorParcela, banco, agencia, agenciaDv, conta, contaDv)
VALUES
(1,'17550586000160','XPTO 1', 20, 2, 2500, 1, 1032, '1', 9554, '8'),
(2,'84664666000134','XPTO 2', 10, 1, 1500, 1, 1027, '3', 9112, '1'),
(2,'21579882000161','XPTO 3', 48, 9, 850.55, 1, 1322, 'X', 9555, 'X'),		
(3,'21579882000161','XPTO 3', 49, 9, 850.55, 1, 3022, '0', 8666, '5');

DBCC CHECKIDENT ('DESCONTO_JUDICIAL', RESEED, 0);	

-- DESCONTO JUDICIAL
INSERT INTO DESCONTO_JUDICIAL
(id_pessoaremovida, tipoBaseCalculo, tipoValor, valorTotalDesconto, valorPagar, valorDesconto, descricaoDescontoJudicial, cpfCnpjBeneficiario, nomeBeneficiario, banco, agencia, agenciaDv, conta, contaDv, contaJudicial)
VALUES
(1, 1, 1, 1000, 9000, 900, 'DECISÃO DO JUIZ', '71687505187', 'COPEL', 1, 1022, '1', 954944, '1', '1'),
(2, 1, 2, 220, 555, 550, 'DECISÃO DO JUIZ', '71687505187', 'BRB', 2, 4594, '1', 8437999, '9', '0');		

DBCC CHECKIDENT ('FUNPRESP', RESEED, 0);

-- FUNPRESP
INSERT INTO FUNPRESP
(id_pessoaremovida, tipoContribuicao, tipoTributacao, percentualDesconto, quantidadeUrp, valorBaseCalculo, dataAdesao)
VALUES
(1, 3, 1, 10.5,	1, 9500, '11/11/2001'),
(2, 2, 1, 10.9,	2, 9500, '10/11/2013');		
		
DBCC CHECKIDENT ('PREVIDENCIA_AGRUPAMENTO', RESEED, 0);
	
-- PREVIDENCIA_AGRUPAMENTO
INSERT INTO PREVIDENCIA_AGRUPAMENTO
(id_pessoaremovida, tipoAgrupamento, dataInicio)
VALUES
(1, 3, '01/12/2018'),
(1, 2, '01/12/2017'),
(1, 1, '01/12/2016');

DBCC CHECKIDENT ('SINDICATO_ASSOCIACAO', RESEED, 0);
	
-- SINDICADO ASSOCIACAO
INSERT INTO SINDICATO_ASSOCIACAO
(id_pessoaremovida, dataInicioVigencia, cnpj, nomeSindicatoAssociacao, tipoBaseCalculo, valorReferencia, descricaoDescontosSindicato, banco, agencia, agenciaDv, conta, contaDv)
VALUES
(1, '01/01/2000', '09358842000194', 'SINDIMPU', 1, 12, '', 1, 1022, '1', 954944, '1'),
(2, '01/01/2001', '09358842000194', 'SINDIJUS', 2, 333, '', 2, 4594, '1', 8437999, '9'),
(3, '01/01/2002', '09358842000194', 'SINDIMPU', 3, 88.3, '', 2, 4594, '1', 8437999, '9');	

DBCC CHECKIDENT ('PENSAO_ALIMENTICIA', RESEED, 0);

-- PENSAO ALIMENTICIA
INSERT INTO PENSAO_ALIMENTICIA
(id_pessoaremovida, tipoBaseCalculo, dataInicioPagamento, valorReferencia, valorAdiantamentoGratificaoNatalina, descricaoDescontoJudicial, cpfRepresentanteLegal, nomeRepresentanteLegal, banco, agencia, agenciaDv, conta, contaDv, nomePensionista, dataNascimentoPensionista, grauParentescoPensionista, cpfPensionista)
VALUES
(1, 2, '10/10/2000', 9500, 500, 'MANDOU PAGAR', '71687505187', 'MARIA', 1, 4594, '4', 95554, '1', 'Maria', '10/10/2001', 'Filha', '71687505187'),
(2, 1, '11/11/2000', 20000, 900, 'PAGAR AGORA', NULL, NULL, 1, 1022, '7', 3566, '1', 'Pedro', '10/12/2000', 'Pai', '71687505188');	
	
DBCC CHECKIDENT ('TREINAMENTO', RESEED, 0);	
	
-- TREINAMENTO 
INSERT INTO TREINAMENTO
(id_pessoaremovida, nome, nomeInstituicao, tipo, dataInicio, dataFim, cargaHoraria, id_treinamento_mentor)
VALUES
(1, 'JAVA', 'CAELUM', 1, '01/01/2000', '01/02/2000', 20, 3),
(1, 'C++', 'CAELUM', 1, '01/01/2000', '01/02/2000', 90, 2),
(1, 'DIREITO 1', 'IDP', 1, '01/01/2000', '01/02/2000', 10, 1),
(2, 'DIREITO 2', 'IDP', 2, '01/01/2000', '01/02/2000', 120, 2),
(3, 'ADM. PUBLICA', 'FGV', 2, '01/01/2000', '01/02/2000', 90, 4);	
	
DBCC CHECKIDENT ('TREINAMENTO_AGRUPAMENTO', RESEED, 0);
	
-- TREINAMENTO AGRUPAMENTO
INSERT INTO TREINAMENTO_AGRUPAMENTO
(id_treinamento, cargaHorariaUtilizada, sequencialAgrupamento, dataInicio, dataFim, ordemTreinamentoNoAgrupamento)
VALUES
(1, 20, 1, '01/02/2000', '01/02/2022', 1),
(2, 50, 2, '01/02/2000', '01/02/2010', 2),
(3, 10, 3, '01/02/2000', '01/02/2010', 2);	
	

DBCC CHECKIDENT ('FERIAS', RESEED, 0);
-- FERIAS
INSERT INTO FERIAS
(id_pessoaremovida, dataAdiantamento, valorAdiantamentoSaldo, quantidadeAdiantamentoParcela)
VALUES
(1, '10/10/2000', 1111, 22);

DBCC CHECKIDENT ('PAGAMENTO', RESEED, 0);	
-- PAGAMENTO
INSERT INTO PAGAMENTO
(id_pessoaremovida, valorAdicionalQualificacao, dataExpiracaoAdicional1, dataExpiracaoAdicional2, valorQuintosDecimos, quantidadeAnuenios, dataInicioAbonoPermanencia, valorVpni, valorAuxilioAlimentacao, feriasAnoExercicio, quantidadeDiasferiasSaldo, feriasUmTerco, ValorFeriasUmTerco, feriasAdiantamentoIr, ValorGratificacaoNatalinaAdiantamento, tipoIsencaoIr, dataIsencaoIr, descricaoCalculoIsencaoIr, tipoIsencaoPSS, dataIsencaoPSS, descricaoCalculoIsencaoPSS)
VALUES
(1, 0.5, '10/10/2000', '10/10/2020', 1, 1, '10/10/2020', 2, 913, 2019, 2, '1', 1, '0',1, 1, '10/10/2020', 'ir', 1, '10/10/2020', 'pss'),
(2, 0.2, '10/10/2000', '10/10/2020', 2, 1, '10/10/2020', 3, 912, 2012, 3, '1', 1, '0',1, 1, '10/10/2020', 'ir', 1, '10/10/2020', 'pss'),
(3, 0.3, '10/10/2001', '10/10/2009', 3, 2, '10/10/2020', 4, 911, 2011, 4, '1', 1, '0',1, 1, '10/10/2020', 'ir', 1, '10/10/2020', 'pss');
