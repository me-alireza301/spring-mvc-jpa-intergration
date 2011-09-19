package br.com.wryel.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.TipoUsuario;
import br.com.wryel.spring.mvc.bean.Usuario;
import br.com.wryel.spring.mvc.model.ModelException;
import br.com.wryel.spring.mvc.model.ModelFactory;
import br.com.wryel.spring.mvc.model.UsuarioModel;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController extends BasicController<Usuario, UsuarioModel> {
	
	@Autowired
	public UsuarioController(UsuarioModel usuarioModel) {
		super(usuarioModel);
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() throws ApplicationException {
		
		List<Usuario> usuarios = getModel().list(new HashMap<String, Object>());
		
		ModelAndView modelAndView = new ModelAndView("/usuario/" + LIST, "usuarios", usuarios);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws ApplicationException {
		
		ModelAndView modelAndView = new ModelAndView("/usuario/" + INPUT, "usuario", new Usuario(new TipoUsuario()));
		
		List<TipoUsuario> tiposUsuario = ModelFactory.getModel(TipoUsuario.class).list();
		
		modelAndView.addObject("tiposUsuario", tiposUsuario);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) throws ApplicationException {

		ModelAndView modelAndView = new ModelAndView();
		
		try {
			
			getModel().save(usuario);			
			modelAndView.setViewName(redirect("/usuario/" + LIST));
		
		} catch (ModelException modelException) {
		
			List<TipoUsuario> tiposUsuario = ModelFactory.getModel(TipoUsuario.class).list();
			modelAndView.addObject("tiposUsuario", tiposUsuario);
			
			List<String> errors = new ArrayList<String>();
			errors.add(modelException.getMessage());
			modelAndView.addObject(ERRORS, errors);
			
			modelAndView.setViewName("/usuario/" + INPUT);
			modelAndView.addObject("usuario", usuario);
			
		}
		
		return modelAndView;
	}
}