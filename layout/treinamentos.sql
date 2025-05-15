
select 
	RHCadTreFormComplementarExterna.Titulo as nome,
	RHTabTreEntidadeEnsino.Descricao as nomeInstituicao,
	RHCadTreFormComplementarExterna.DataInicialFormatada as dataInicio,
	RHCadTreFormComplementarExterna.DataFinalFormatada as dataFim,
	RHCadTreFormComplementarExterna.CargaHorRealizada as cargaHoraria
from 
	MENTOR..SQLUser.RHCadTreFormComplementarExterna as RHCadTreFormComplementarExterna
	inner join MENTOR..SQLUser.RHTabTreEntidadeEnsino as RHTabTreEntidadeEnsino on RHTabTreEntidadeEnsino.id = RHCadTreFormComplementarExterna.EntidadeInstrutor

