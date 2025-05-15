package br.mp.mpm.despachante.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorListDto handle(MethodArgumentNotValidException exception) {

		List<ErrorDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorDto erro = new ErrorDto(e.getField(), mensagem);
			dto.add(erro);
		});
		return new ErrorListDto(dto);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public ErrorListDto handle(ValidationException exception) {

		List<ErrorDto> dto = new ArrayList<>();
		String mensagem = exception.getLocalizedMessage();
		ErrorDto erro = new ErrorDto(null, mensagem);
		dto.add(erro);
		return new ErrorListDto(dto);
	}

}
