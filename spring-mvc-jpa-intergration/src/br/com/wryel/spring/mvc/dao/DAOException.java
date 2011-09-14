package br.com.wryel.spring.mvc.dao;

import br.com.wryel.spring.mvc.ApplicationException;

public class DAOException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Throwable throwable) {
		super(throwable);
	}
	
	public DAOException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
