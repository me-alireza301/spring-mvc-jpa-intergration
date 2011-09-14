package br.com.wryel.spring.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wryel.spring.mvc.bean.Card;
import br.com.wryel.spring.mvc.dao.CardDAO;

@Service
public class CardModel extends BasicModel<Card, CardDAO> {
	
	@Autowired
	public CardModel(CardDAO cardDAO) {
		super(cardDAO);
	}
	
	public CardModel() {
		
	}
}
