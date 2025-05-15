package br.mp.mpm.despachante.controller.external;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpm.despachante.model.LogErro;
import br.mp.mpm.despachante.repository.LogErroRepository;
import br.mp.mpm.despachante.util.UtilData;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/logErro")
@Api(value = "logErroController")
@CrossOrigin
public class LogErroController {

	@Autowired
	LogErroRepository logErroRepository;
	
	@Transactional	
	@PostMapping()
	public ResponseEntity<LogErro>  informaErro(@RequestParam(required = true) String entidade, 
			@RequestParam(required = true) String dataHora, 
			@RequestParam(required = true) String erro) {
		
		LogErro logErro = new LogErro();
		logErro.setDataHora(UtilData.convertStringParaDateTime(dataHora, "dd/MM/yyyy HH:mm:ss"));
		logErro.setEntidade(entidade);
		logErro.setErro(erro);
		
		logErro = logErroRepository.save(logErro);

		return new ResponseEntity<LogErro>(logErro, HttpStatus.OK);
	}

}
