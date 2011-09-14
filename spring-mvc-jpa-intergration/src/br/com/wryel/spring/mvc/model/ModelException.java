package br.com.wryel.spring.mvc.model;

import br.com.wryel.spring.mvc.ApplicationException;

public class ModelException extends ApplicationException {
	
	private static final long serialVersionUID = 1L;

	public ModelException() {
		
	}
	
	public ModelException(String message) {
		super(message);
	}
	
	public ModelException(Throwable throwable) {
		super(throwable);
	}
	
	public ModelException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
