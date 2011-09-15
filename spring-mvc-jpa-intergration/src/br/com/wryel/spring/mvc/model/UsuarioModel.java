package br.com.wryel.spring.mvc.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.dao.UsuarioDAO;
import br.com.wryel.spring.mvc.util.JPAUtils;

@Service
public class UsuarioModel extends BasicModel<Usuario, UsuarioDAO> {
	
	public UsuarioModel() {
		
	}
	
	@Autowired
	public UsuarioModel(UsuarioDAO usuarioDAO) {
		super(usuarioDAO);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Usuario usuario) throws ApplicationException {
		if (JPAUtils.getKey(usuario) == null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("login", usuario.getLogin());
			long quantidade = count(params);
			if (quantidade > 0) {
				throw new ModelException("Já existe um usuário com este login");
			}
		}
		super.save(usuario);
	}
}
