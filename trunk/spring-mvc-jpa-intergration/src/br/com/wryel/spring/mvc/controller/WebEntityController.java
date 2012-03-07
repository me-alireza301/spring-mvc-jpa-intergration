package br.com.wryel.spring.mvc.controller;

import br.com.wryel.spring.mvc.dao.BasicDAO;
import br.com.wryel.spring.mvc.model.BasicModel;

/**
 * 
 * @author wryel covo
 * 
 */
public abstract class WebEntityController<BEAN, MODEL extends BasicModel<BEAN, ? extends BasicDAO<BEAN>>> extends WebController {
	
	private static final long serialVersionUID = 1L;
	
	protected MODEL model;
	
	public WebEntityController() {
		
	}
	
	public WebEntityController(MODEL model) { 
		this.model = model;
	}
	
	public MODEL getModel() {
		return model;
	}

	public void setModel(MODEL model) {
		this.model = model;
	}
}