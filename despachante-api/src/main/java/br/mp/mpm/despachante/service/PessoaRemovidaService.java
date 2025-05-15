package br.mp.mpm.despachante.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpm.despachante.controller.dto.PessoaRemovidaDto;
import br.mp.mpm.despachante.controller.dto.PessoaRemovidaResponseDto;
import br.mp.mpm.despachante.model.Configuracao;
import br.mp.mpm.despachante.repository.ConfiguracaoRepository;
import br.mp.mpm.despachante.repository.PessoaRemovidaRepository;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestParsingException;

@Service
public class PessoaRemovidaService {

	@Autowired
	PessoaRemovidaRepository pessoaRemovidaRepository;
	
	@Autowired
	ConfiguracaoRepository configuracaoRepository;
	
	private static final Logger log = LoggerFactory.getLogger(PessoaRemovidaService.class);

	public PessoaRemovidaDto recuperarPessoasPorRamoMatricula(String ramo, BigInteger matricula, String token) {

		Configuracao config = configuracaoRepository.findByRamo(ramo);
		PessoaRemovidaResponseDto response = Unirest.get(config.getUrlPessoa() + "/" + matricula.toString())
				.header("Authorization", String.format("Bearer %s",token))
				.asObject(PessoaRemovidaResponseDto.class)
	            .ifFailure(e -> {
	                    UnirestParsingException ex = e.getParsingError().get();
	                    ex.printStackTrace();
	                    throw new RuntimeException(ex.getMessage());
	            	})
	            .getBody();

			return response.getData().get(0);
	}

	public List<PessoaRemovidaDto> recuperarPessoasPorRamo(String ramo, String token) {
		
		Configuracao config = configuracaoRepository.findByRamo(ramo);
		PessoaRemovidaResponseDto response = Unirest.get(config.getUrlPessoa())
				.header("Authorization", String.format("Bearer %s",token))
				.asObject(PessoaRemovidaResponseDto.class)
	            .ifFailure(e -> {
	                    UnirestParsingException ex = e.getParsingError().get();
	                    ex.printStackTrace();
	                    throw new RuntimeException(ex.getMessage());
	            	})
	            .getBody();

			return response.getData().stream().collect(Collectors.toList());		
	}

	public Boolean marcaPessoaImportadaPorRamo(String ramo, BigInteger matricula, String token) {
		Configuracao config = configuracaoRepository.findByRamo(ramo);
		
		HttpResponse<JsonNode> response = Unirest.put(config.getUrlPessoa() + "/" + matricula.toString())
			.header("Authorization", String.format("Bearer %s",token))
			.asJson()			
			.ifFailure(r -> {
				log.error("Erro ao executar marcação de importação " + r.getStatus());
	            r.getParsingError().ifPresent(e -> {
	                log.error("Parsing Exception: ", e);
	                log.error("Original body: " + e.getOriginalBody());
            });
		});
		
		return response.getBody().getObject().getBoolean("success");
	}
	
	public String obterTokenRamo(String ramo) {
		Configuracao config = configuracaoRepository.findByRamo(ramo);
		
		HttpResponse<JsonNode> token = Unirest.post(config.getUrlToken())
		.header("Content-Type", "application/json")
		.field("usuario", config.getUsuario(), "application/json")
		.field("senha", config.getSenha(), "application/json")
		.asJson()
		.ifFailure(response -> {
			log.error("Erro ao executar recuperação de token" + response.getStatus());
            response.getParsingError().ifPresent(e -> {
                log.error("Parsing Exception: ", e);
                log.error("Original body: " + e.getOriginalBody());
            });
		});
		
		return token.getBody().getObject().get("token").toString();
	}

	public Boolean comunicarErroImportacao(String ramo, BigInteger matricula, String token) {
		Configuracao config = configuracaoRepository.findByRamo(ramo);
		
		HttpResponse<JsonNode> response = Unirest.put(config.getUrlErro() + "/" + matricula.toString())
				.header("Authorization", String.format("Bearer %s", token))
				.field("entidade", "", "application/json")
				.field("dataHora", "", "application/json")
				.field("erro", "", "application/json")				
				.asJson()			
				.ifFailure(r -> {
					log.error("Erro ao executar marcação de importação " + r.getStatus());
		            r.getParsingError().ifPresent(e -> {
		                log.error("Parsing Exception: ", e);
		                log.error("Original body: " + e.getOriginalBody());
	            });
			});
		return response.getBody().getObject().getBoolean("success");		
	}
	
}
