package br.com.wryel.spring.mvc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "colecao")
public class Colecao implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_colecao")
	private Integer id;

	private String nome;
	
	@OneToMany(mappedBy = "colecao")
	private List<Card> cards;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Card> getCards() {
		if (cards == null) {
			cards = new ArrayList<Card>();
		}
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
