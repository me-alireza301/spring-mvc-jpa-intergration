package br.com.wryel.spring.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.dao.UsuarioDAO;

@Service
public class UsuarioModel extends BasicModel<Usuario, UsuarioDAO> {
	
	public UsuarioModel() {
		
	}
	
	@Autowired
	public UsuarioModel(UsuarioDAO usuarioDAO) {
		super(usuarioDAO);
	}	
}
