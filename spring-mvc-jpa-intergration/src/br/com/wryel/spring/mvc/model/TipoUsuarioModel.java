package br.com.wryel.spring.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wryel.spring.mvc.bean.TipoUsuario;
import br.com.wryel.spring.mvc.dao.TipoUsuarioDAO;

@Service
public class TipoUsuarioModel extends BasicModel<TipoUsuario, TipoUsuarioDAO> {
	
	public TipoUsuarioModel() {
		
	}
	
	@Autowired
	public TipoUsuarioModel(TipoUsuarioDAO tipoUsuarioDAO) {
		super(tipoUsuarioDAO);
	}
}
