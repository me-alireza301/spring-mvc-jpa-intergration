package br.com.wryel.spring.mvc.controller;

import org.springframework.context.annotation.Scope;

import br.com.wryel.spring.mvc.dao.BasicDAO;
import br.com.wryel.spring.mvc.model.BasicModel;

/**
 * 
 * @author wryel covo
 *
 */
@Scope("request")
public abstract class BasicController<BEAN, MODEL extends BasicModel<BEAN, ? extends BasicDAO<BEAN>>> {
	
	public static final String INPUT = "input";
	
	public static final String LIST = "list";
	
	protected MODEL model;
	
	public BasicController() {
		
	}
	
	public BasicController(MODEL model) { 
		this.model = model;
	}
	
	public MODEL getModel() {
		return model;
	}

	public void setModel(MODEL model) {
		this.model = model;
	}

	/**
	 * prepara String para realizar redirecionamento
	 * @param value
	 * @return
	 */
	protected String redirect(String value) {
		return "redirect:" + value;
	}	
}