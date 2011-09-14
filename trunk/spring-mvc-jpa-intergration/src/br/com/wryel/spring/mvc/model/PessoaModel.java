package br.com.wryel.spring.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wryel.spring.mvc.bean.Pessoa;
import br.com.wryel.spring.mvc.dao.PessoaDAO;

@Service
public class PessoaModel extends BasicModel<Pessoa, PessoaDAO> {
	
	/**
	 * Construtor default para o spring poder manipular proxy
	 */
	public PessoaModel() {
		
	}
	
	@Autowired
	public PessoaModel(PessoaDAO pessoaDAO) {
		super(pessoaDAO);
	}
}
