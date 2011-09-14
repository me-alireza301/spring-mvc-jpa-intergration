package br.com.wryel.spring.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.wryel.spring.mvc.bean.TipoUsuario;
import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.model.UsuarioModel;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController extends BasicController<Usuario, UsuarioModel> {
	
	@Autowired
	public UsuarioController(UsuarioModel usuarioModel) {
		super(usuarioModel);
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() {
		
		List<Usuario> usuarios = getModel().list(new HashMap<String, Object>());
		
		ModelAndView modelAndView = new ModelAndView("/usuario/" + LIST, "usuarios", usuarios);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView("/usuario/" + INPUT, "usuario", new Usuario(new TipoUsuario()));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("usuario") Usuario usuario) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("login", usuario.getLogin());
		
		long quantidadeDeUsuarios = getModel().countList(params);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (quantidadeDeUsuarios > 0) {
			modelAndView.setViewName("/usuario/" + INPUT);
			modelAndView.addObject("usuario", usuario);
			return modelAndView;
		}
		
		getModel().save(usuario);
		
		modelAndView.setViewName("/usuario/" + LIST);
		
		return modelAndView;
		
	}
}