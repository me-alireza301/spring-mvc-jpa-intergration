package br.com.wryel.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.Colecao;
import br.com.wryel.spring.mvc.model.ColecaoModel;

@Controller
@RequestMapping(value = "/colecao")
public class ColecaoController extends BasicController<Colecao, ColecaoModel> {
	
	@Autowired
	public ColecaoController(ColecaoModel colecaoModel) {
		super(colecaoModel);
	}
	
	@RequestMapping(value = "add")
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView("/colecao/input");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("colecao") Colecao colecao) throws ApplicationException {
		
		getModel().save(colecao);
		
		return redirect("/colecao/add");
	}
}
