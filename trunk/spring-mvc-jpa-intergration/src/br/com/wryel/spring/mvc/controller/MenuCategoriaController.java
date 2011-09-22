package br.com.wryel.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.MenuCategoria;
import br.com.wryel.spring.mvc.model.MenuCategoriaModel;

@Controller
@RequestMapping("/menuCategoria")
public class MenuCategoriaController extends BasicController<MenuCategoria, MenuCategoriaModel> {
	
	public MenuCategoriaController() {
		
	}
	
	@Autowired
	public MenuCategoriaController(MenuCategoriaModel menuCategoriaModel) {
		super(menuCategoriaModel);
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() throws ApplicationException {
		
		ModelAndView modelAndView = new ModelAndView("/menuCategoria/" + LIST);
		
		List<MenuCategoria> menuCategorias = getModel().list();
		
		modelAndView.addObject("menuCategorias", menuCategorias);
		
		return modelAndView;
		
	}
}
