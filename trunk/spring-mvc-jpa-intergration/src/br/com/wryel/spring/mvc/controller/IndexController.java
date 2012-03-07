package br.com.wryel.spring.mvc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Scope(WebApplicationContext.SCOPE_APPLICATION)
@Controller
public class IndexController extends WebController {

	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "teste", method = RequestMethod.GET)
	public ModelAndView teste() {
		return new ModelAndView("teste");
	}
}