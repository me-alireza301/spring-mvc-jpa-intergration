package br.com.wryel.spring.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wryel.spring.mvc.bean.Ponto;
import br.com.wryel.spring.mvc.dao.PontoDAO;

@Service
public class PontoModel extends BasicModel<Ponto, PontoDAO> {
	
	/**
	 * Construtor default para o spring poder manipular proxy
	 */
	public PontoModel() {
		
	}
	
	@Autowired
	public PontoModel(PontoDAO pontoDAO) {
		super(pontoDAO);
	}
}
