package br.mp.mpm.despachante.controller.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpm.despachante.controller.dto.PessoaDto;
import br.mp.mpm.despachante.model.PessoaInterno;
import br.mp.mpm.despachante.model.PessoaRemovidaJson;
import br.mp.mpm.despachante.repository.PessoaInternoRepository;
import br.mp.mpm.despachante.repository.PessoaRemovidaJsonRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/internal/v1/pessoa")
@Api(value = "pessoaController")
@CrossOrigin
public class PessoaController {

	@Autowired
	PessoaInternoRepository pessoaSaindoRepository;

	@Autowired
	PessoaRemovidaJsonRepository pessoaChegandoRepository;
	
	@GetMapping("/saindo")
	public Page<PessoaDto> getAllOut(@RequestParam(required = false) String filtro,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 25) Pageable paginacao) {

		Page<PessoaInterno> pessoas = null;
		
		if (filtro != null && !filtro.equals("")) {
			pessoas = pessoaSaindoRepository.findByFiltro(filtro, paginacao);
			return PessoaDto.converterOut(pessoas);
		}

		pessoas = pessoaSaindoRepository.findAll(paginacao);
		return PessoaDto.converterOut(pessoas);
	}

	@GetMapping("/chegando")
	public Page<PessoaDto> getAllIn(@RequestParam(required = false) String filtro,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 25) Pageable paginacao) {

		Page<PessoaRemovidaJson> pessoas = null;
		
		if (filtro != null && !filtro.equals("")) {
			pessoas = pessoaChegandoRepository.findByFiltro(filtro, paginacao);
			return PessoaDto.converterIn(pessoas);
		}

		pessoas = pessoaChegandoRepository.findAll(paginacao);
		return PessoaDto.converterIn(pessoas);
	}
	
}
