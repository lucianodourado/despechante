---- PENSAO ALIMENTICIA 

-- tipoBaseCalculo,NUMÉRICO,2,SIM,Identificador do tipo de base de cálculo. Ver tabela de domínio TIPO_BASE_CALCULO
-- dataInicioPagamento,STRING,10,SIM,Data início do pagamento. Formato DD/MM/YYYY
-- valorReferencia,NUMÉRICO,"10,2",SIM,"Valor de referência. Pode ser um percentual, uma quantidade ou um valor decimal. Separador decimal deve ser o caracter ponto (.), se for o caso."
-- valorAdiantamentoGratificaoNatalina,NUMÉRICO,"10,2",SIM,"Valor de adiantamento referente à gratificação natalina. Separador decimal deve ser o caracter ponto (.), se for o caso."
-- descricaoDescontoJudicial,STRING,4000,NÃO,Descrição do desconto judicial. Texto descritivo de como deve ser feito o cálculo para o desconto.
-- cpfRepresentanteLegal,NUMÉRICO,11,NÃO,"CPF do representante legal, quando o benefício não puder ser pago diretamente ao titular. Somente números. Valor fixo com 11 dígitos."
-- nomeRepresentanteLegal,STRING,100,NÃO,Nome do representante legal
-- banco,NUMÉRICO,20,SIM,Número do banco
-- agencia,NUMÉRICO,20,SIM,Número da agência
-- agenciaDv,STRING,1,SIM,Dígito verificador da agência
-- conta,NUMÉRICO,20,SIM,Número da conta bancária incluindo a operação no caso de CAIXA e SANTANDER
-- contaDv,STRING,1,SIM,Dígito verificador da conta

select
	-- tipoBaseCalculo
	-- dataInicioPagamento
	-- valorReferencia
	-- valorAdiantamentoGratificaoNatalina
	-- descricaoDescontoJudicial
	-- cpfRepresentanteLegal
	-- nomeRepresentanteLegal
	RHCADPENSAOALIMENTICIA.Banco as banco,	
	RHCADPENSAOALIMENTICIA.Agencia as agencia,
	-- agenciaDv
	RHCADPENSAOALIMENTICIA.Conta as conta
	-- contaDv
from 
	MENTOR_SQL.DBO.RHCADPENSAOALIMENTICIA as RHCADPENSAOALIMENTICIA

select * from MENTOR_SQL.DBO.[RHCADSERVIDORPENSAO]
select * from MENTOR..SQLUser.[RHCADSERVIDORPENSAO]
select * from MENTOR_SQL.DBO.[RHCADPENSAOALIMENTICIA]
select * from MENTOR..SQLUser.[RHCADPENSAOALIMENTICIA]
