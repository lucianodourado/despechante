package br.mp.mpm.despachante.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.mp.mpm.despachante.service.ImportacaoDadosRamoService;

@Service
public class RecuperaTodasRemocoesBatch {

	@Autowired
	ImportacaoDadosRamoService ramoService;
	
	@Scheduled(fixedDelay = 1000*60*360)
	public void executarImportacaoRamos() {
		ramoService.recuperaServidoresRemocao();
	}
}
