package br.com.wryel.spring.mvc.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_card")
	private Integer id;
	
	private String nome;
	
	@JoinColumn(name = "id_colecao")
	@ManyToOne
	private Colecao colecao;

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

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
}
