package br.mp.mpm.despachante.controller.internal;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpm.despachante.controller.form.ConfiguracaoForm;
import br.mp.mpm.despachante.exception.DespachanteException;
import br.mp.mpm.despachante.model.Configuracao;
import br.mp.mpm.despachante.repository.ConfiguracaoRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/internal/v1/configuracoes")
@Api(value = "configuracaoController")
@CrossOrigin

public class ConfiguracaoController {

	@Autowired
	ConfiguracaoRepository configuracaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Configuracao>> getAll() {
		return Optional.ofNullable(configuracaoRepository.findAll())
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping("/{ramo}")
	public ResponseEntity<Configuracao> getOne(@PathVariable String ramo) {
		return configuracaoRepository.findById(ramo)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	@PutMapping("/{ramo}")
	public ResponseEntity<Configuracao> setItem(@PathVariable String ramo, @RequestBody @Valid ConfiguracaoForm form) {
		Configuracao entity = configuracaoRepository.findById(ramo)
				.orElseThrow(() -> new DespachanteException(String.format("Configuracao de %s não encontrado", ramo)));

		form.preencher(entity, "ramo");
		configuracaoRepository.save(entity);

		return Optional.ofNullable(entity)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.badRequest().build());
	}
}
