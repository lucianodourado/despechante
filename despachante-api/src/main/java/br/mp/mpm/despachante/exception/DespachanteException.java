package br.mp.mpm.despachante.exception;

import javax.validation.ValidationException;

public class DespachanteException extends ValidationException {

	private static final long serialVersionUID = 1L;

	public DespachanteException(String message) {
		super(message);
	}

}
