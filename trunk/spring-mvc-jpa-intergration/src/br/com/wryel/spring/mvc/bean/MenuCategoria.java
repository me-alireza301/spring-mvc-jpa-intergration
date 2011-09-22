package br.com.wryel.spring.mvc.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu_categoria")
public class MenuCategoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_menu_categoria")
	private Long id;
	
	private String descricao;
	
	@OneToMany(mappedBy = "menuCategoria")
	private List<MenuLink> menuLinks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<MenuLink> getMenuLinks() {
		return menuLinks;
	}

	public void setMenuLinks(List<MenuLink> menuLinks) {
		this.menuLinks = menuLinks;
	}
}
