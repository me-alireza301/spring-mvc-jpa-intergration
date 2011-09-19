package br.com.wryel.spring.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.MenuCategoria;
import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.dao.MenuCategoriaDAO;

@Service
public class MenuCategoriaModel extends BasicModel<MenuCategoria, MenuCategoriaDAO> {
	
	public MenuCategoriaModel() {
		
	}
	
	@Autowired
	public MenuCategoriaModel(MenuCategoriaDAO menuCategoriaDAO) {
		super(menuCategoriaDAO);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_UNCOMMITTED)
	public List<MenuCategoria> mountMenuByUser(Usuario usuario) throws ApplicationException {
		List<MenuCategoria> menuCategorias = getDao().mountMenuByUser(usuario);
		return menuCategorias;
	}
}
