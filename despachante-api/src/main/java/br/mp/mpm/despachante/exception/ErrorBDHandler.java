package br.mp.mpm.despachante.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorBDHandler {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataAccessException.class)
	public ErrorListDto handle(DataAccessException exception) {

		List<ErrorDto> dto = new ArrayList<>();
		// String mensagem = exception.getLocalizedMessage();
		String mensagem = "Ocorreu um erro interno no sistema, contacte o administrador! Falha tratamento de dados.";
		ErrorDto erro = new ErrorDto(null, mensagem);
		dto.add(erro);

		log.error("erro de banco de dados", exception);
		return new ErrorListDto(dto);
	}
}
