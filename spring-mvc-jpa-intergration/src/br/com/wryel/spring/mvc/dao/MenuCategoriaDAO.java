package br.com.wryel.spring.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.wryel.spring.mvc.bean.MenuCategoria;
import br.com.wryel.spring.mvc.bean.Usuario;

@Repository
public class MenuCategoriaDAO extends BasicDAO<MenuCategoria> {
	
	public List<MenuCategoria> mountMenuByUser(Usuario usuario) throws DAOException {
		List<MenuCategoria> menuCategorias = executeNamedQuery("mountMenuByUser");
		return menuCategorias;
	}
}
