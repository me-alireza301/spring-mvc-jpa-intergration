package br.com.wryel.spring.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.wryel.spring.mvc.ApplicationException;
import br.com.wryel.spring.mvc.bean.Card;
import br.com.wryel.spring.mvc.model.CardModel;

@Controller
@RequestMapping("/card")
public class CardController extends BasicController<Card, CardModel> {
	
	@Autowired
	public CardController(CardModel cardModel) {
		super(cardModel);
	}
	
	@RequestMapping(value = "busca", method = RequestMethod.GET)
	public ModelAndView busca(HttpServletRequest request) throws ApplicationException {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if (!StringUtils.isEmpty(request.getParameter("q"))) {
			parametros.put("nomeLike", "%" + request.getParameter("q") + "%");
		}
		
		List<Card> cards = getModel().list(parametros);
		
		long resultados = getModel().count(parametros);
		
		ModelAndView modelAndView = new ModelAndView("card.list");
		
		modelAndView.addObject("cards", cards);
		
		modelAndView.addObject("resultados", resultados);
		
		return modelAndView;
	}
}
