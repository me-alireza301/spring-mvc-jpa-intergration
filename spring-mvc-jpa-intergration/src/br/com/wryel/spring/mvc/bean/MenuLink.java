package br.com.wryel.spring.mvc.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu_link")
public class MenuLink implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_menu_link")
	private Long id;
	
	private String descricao;
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_menu_categoria")
	private MenuCategoria menuCategoria;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MenuCategoria getMenuCategoria() {
		return menuCategoria;
	}

	public void setMenuCategoria(MenuCategoria menuCategoria) {
		this.menuCategoria = menuCategoria;
	}
}
