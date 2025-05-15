package br.mp.mpm.despachante.controller.external;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpm.despachante.controller.dto.PessoaRemovidaDto;
import br.mp.mpm.despachante.model.PessoaRemovida;
import br.mp.mpm.despachante.repository.PessoaRemovidaRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pessoaRemovida")
@Api(value = "pessoaRemovidaController")
@CrossOrigin
public class PessoaRemovidaController {

	@Autowired
	PessoaRemovidaRepository pessoaRemovidaRepository;

	@GetMapping("/{id}")
	public ResponseEntity<PessoaRemovidaDto> buscar(@PathVariable(required = true) BigInteger id) {

		PessoaRemovida entity = pessoaRemovidaRepository.findByMatricula(id);
		if (entity != null) {
			return ResponseEntity.ok(PessoaRemovidaDto.converter(entity));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/")
	public ResponseEntity<List<PessoaRemovidaDto>> listar() {
		return Optional.ofNullable(pessoaRemovidaRepository.findAll())
				.map(PessoaRemovidaDto::converter)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaRemovidaDto> marcaStatusImportacaoRamo(@PathVariable(required = true) BigInteger id) {
		// Estes são as mensagens do MPF
		
		PessoaRemovida entity = pessoaRemovidaRepository.findByMatricula(id);
		if (entity == null) {
			return ResponseEntity.notFound().build();
		}
		
		if (entity.getStatusImportacaoRamo()) {
			return ResponseEntity.badRequest().build();
		} else {
			entity.setStatusImportacaoRamo(true);
			pessoaRemovidaRepository.save(entity);
		}

		return ResponseEntity.ok(PessoaRemovidaDto.converter(entity));
		
		// return "A matrícula informada [26695] já consta como incluída pelo ramo."; HTTP 405
		// return "A matrícula informada [2669] não pertence ao ramo."; // HTTP 405
		// return "Matrícula não informada."; // HTTP 400
		// return "Operação executada com sucesso."; // HTTP 200
	}

}
