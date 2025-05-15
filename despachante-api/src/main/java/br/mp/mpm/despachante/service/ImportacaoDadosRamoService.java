package br.mp.mpm.despachante.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpm.despachante.controller.dto.PessoaRemovidaDto;
import br.mp.mpm.despachante.model.Configuracao;
import br.mp.mpm.despachante.model.PessoaRemovidaJson;
import br.mp.mpm.despachante.repository.ConfiguracaoRepository;
import br.mp.mpm.despachante.repository.PessoaRemovidaJsonRepository;

@Service
public class ImportacaoDadosRamoService {

	private static final Logger log = LoggerFactory.getLogger(ImportacaoDadosRamoService.class);
	
	@Autowired
	ConfiguracaoRepository configuracaoRepository;
	
	@Autowired
	PessoaRemovidaJsonRepository pessoaRepository;
	
	@Autowired	
	PessoaRemovidaService pessoaRemovidaService;
	
	private void  processaImportacaoRamos() {
		List<Configuracao> configs = configuracaoRepository.findAll();
		Map<String, String> tokens = new HashMap<>();
		for (Configuracao config : configs) {
			if (config.getAtivo()) {

				String ramo = config.getRamo();
				
				tokens.put(ramo, pessoaRemovidaService.obterTokenRamo(ramo));

				List<PessoaRemovidaDto> pessoas = pessoaRemovidaService.recuperarPessoasPorRamo(ramo, tokens.get(ramo));
				
				for (PessoaRemovidaDto p : pessoas) {					
					if (pessoaRepository.findByCpf(p.getCpf()) == null) {
						PessoaRemovidaJson json = new PessoaRemovidaJson();
						json.setCpf(p.getCpf());
						json.setMatricula(p.getMatricula());
						json.setNome(p.getNomeCivil());
						json.setRamo(config.getRamo());
						json.setPessoaRemovidaCompleto(p);
						pessoaRepository.save(json);
					}
				}				
				log.info(String.format("Processados %d pessoas do ramo %s para remoção", pessoas.size(), ramo));
			}
		}
	}
	
	public void recuperaServidoresRemocao() {
		processaImportacaoRamos();		
	}
	
}
