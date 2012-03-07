package br.com.wryel.spring.mvc.controller;

public class WebController extends Controller {

	private static final long serialVersionUID = 1L;

	public static final String INPUT = "input";
	
	public static final String LIST = "list";
	
	public static final String VIEW_EXTENSION = ".java";
	
	public static final String ERRORS = "errors";	
	
	/**
	 * prepara String para realizar redirecionamento
	 * @param value
	 * @return
	 */
	protected String redirect(String value) {
		return "redirect:" + value + VIEW_EXTENSION;
	}
}
