Mapeamento de Entidade Básica

```
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id_pessoa")
	private Long id;

	public void setId(Long id) {
		this.id = id
	}

	public Long getId() {
		return this.id;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
```