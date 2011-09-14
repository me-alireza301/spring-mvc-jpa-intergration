package br.com.wryel.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.Pessoa;
import br.com.wryel.spring.mvc.model.PessoaModel;

/**
 * http://localhost:8080/base/pessoa/list
 * @author wryel
 *
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaController extends BasicController<Pessoa, PessoaModel> {
	
	@Autowired
	public PessoaController(PessoaModel pessoaModel) {
		super(pessoaModel);
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) throws ApplicationException {
		
		List<Pessoa> pessoas = getModel().list();
		
		modelMap.addAttribute("pessoas", pessoas);
		
		return "/pessoa/" + LIST;
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap modelMap) throws ApplicationException {
		
		Pessoa pessoaDoBanco = getModel().retrieve(new Pessoa(id));
		
		modelMap.addAttribute("pessoa", pessoaDoBanco);
		
		return "/pessoa/" + INPUT;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(ModelMap modelMap, HttpServletRequest httpServletRequest) throws Exception {
		
		Pessoa pessoa = new Pessoa();	
		
		BeanUtils.populate(pessoa, httpServletRequest.getParameterMap());
		
		getModel().save(pessoa);
		
		return redirect("/pessoa/" + LIST);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		modelMap.addAttribute("pessoa", new Pessoa());
		
		return "/pessoa/" + INPUT;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, ModelMap modelMap) throws ApplicationException {
		
		getModel().delete(new Pessoa(id));
		
		return redirect("/pessoa/" + LIST);
	}
}