package br.com.wryel.spring.mvc.bean;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String keywords;
	
	private String fileName;
	
	private Integer height;
	
	private Integer width;
	
	@ManyToOne
	@JoinColumn
	private GameCategory category;

	private Integer totalPlayed;
	
	private Integer totalVotes;
	
	private String iconName;
	
	@ManyToOne
	@JoinColumn
	private GameStatus gameStatus;
	
	private Long playedToday;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
