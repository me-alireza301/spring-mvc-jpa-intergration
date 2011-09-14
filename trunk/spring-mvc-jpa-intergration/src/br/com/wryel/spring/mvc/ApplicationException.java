package br.com.wryel.spring.mvc;

/**
 * 
 * @author wryel covo
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		
	}
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(Throwable throwable) {
		super(throwable);
	}
	
	public ApplicationException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
