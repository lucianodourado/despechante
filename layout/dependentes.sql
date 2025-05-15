-- Dependentes

-- nome,STRING,100,SIM,Nome do depenente.
-- dataNascimento,STRING,10,NÃO,Data de nascimento. Formato DD/MM/YYYY
-- grauParentesco,STRING,100,SIM,Grau de parentesco com a pessoa
-- sexo,NUMÉRICO,1,SIM,Sexo. 1 para MASCULINO; 2 para FEMININO
-- nomeMae,STRING,100,NÃO,Nome da mãe do dependente
-- cpf,NUMÉRICO,11,SIM,CPF. Somente números. Valor fixo com 11 dígitos.
-- rg,STRING,100,NÃO,RG
-- rgOrgaoEmissor,STRING,100,NÃO,Órgão de emissão do RG
-- rgUfEmissao,STRING,2,NÃO,UF de emissão do RG
-- rgDataEmissao,STRING,10,NÃO,Data de emissão do RG. Formato DD/MM/YYYY
-- dataVigenciaAuxilioPreEscolar,STRING,10,NÃO,Data de vigência do auxílio pré-escolar. Formato DD/MM/YYYY
-- pensaoAlimenticia,LISTA,,,Ver LEIAUTE PENSAO_ALIMENTICIA


select * from MENTOR..SQLUser.RHCadDependente
select * from MENTOR..SQLUser.RHTabDependenteParentesco

select *	
from MENTOR_SQL.DBO.RHCadDependente

select * from MENTOR_SQL.DBO.RHTabDependenteParentesco
select * from DESPACHANTE_NOVO.dbo.PESSOA_REMOVIDA

select id_pessoaremovida from DESPACHANTE_NOVO.dbo.PESSOA_REMOVIDA where matricula = 1652

			SELECT
				--PESSOA_REMOVIDA.id_pessoaremovida as id_pessoaremovida,
				RHCadDependente.Nome as nome,
				convert(datetime, RHCadDependente.DataNascFormatada, 103) as dataNascimento,
				RHTabDependenteParentesco.Descricao as grauParentesco, 
				RHCadDependente.Sexo as sexo, -- 1 MASC e 2 FEMI
				RHCadDependente.NomeMae as nomeMae,
				case 
					when RHCadDependente.CPF is null then ''
					else RHCadDependente.CPF
				end as cpf,
				RHCadDependente.idNumero as rg,
				convert(datetime, RHCadDependente.IdDataExpFormatada, 103) as rgDataEmissao,
				RHCadDependente.IdOrgao as rgOrgaoEmissor,
				UFId.CODIGO as rgUfEmissao,				
				CURRENT_TIMESTAMP as dataVigenciaAuxilioPreEscolar
			FROM
				MENTOR_SQL.DBO.RHCadDependente as RHCadDependente
				INNER JOIN MENTOR_SQL.DBO.RHTabDependenteParentesco as RHTabDependenteParentesco on RHTabDependenteParentesco.ID = RHCadDependente.Parentesco
				INNER JOIN MENTOR_SQL.dbo.rhcadservidor as RHCADSERVIDOR on RHCADSERVIDOR.ID = RHCadDependente.Servidor  	
				LEFT JOIN MENTOR_SQL.dbo.rhtabuf as UFId on UFId.ID = RHCadDependente.IdUF
				--INNER JOIN PESSOA_REMOVIDA as PESSOA_REMOVIDA on PESSOA_REMOVIDA.matricula = RHCADSERVIDOR.matricula  	
			WHERE
				RHCADSERVIDOR.matricula between  0 and 1760	
