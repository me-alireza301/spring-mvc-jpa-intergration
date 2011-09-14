package br.com.wryel.spring.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.wryel.spring.mvc.bean.Pessoa;

@Repository
public class PessoaDAO extends BasicDAO<Pessoa> {

	@Override
	public List<Pessoa> list(Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}	
}
