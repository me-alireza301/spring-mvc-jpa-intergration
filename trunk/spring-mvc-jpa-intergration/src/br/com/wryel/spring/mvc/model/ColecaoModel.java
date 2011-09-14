package br.com.wryel.spring.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wryel.spring.mvc.bean.Colecao;
import br.com.wryel.spring.mvc.dao.ColecaoDAO;

@Service
public class ColecaoModel extends BasicModel<Colecao, ColecaoDAO> {
	
	public ColecaoModel() {
		
	}
	
	@Autowired
	public ColecaoModel(ColecaoDAO colecaoDAO) {
		super(colecaoDAO);
	}	
}
