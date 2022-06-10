package model.entities;

import java.io.Serializable;
import java.util.Objects;

// Construtor padrão:
public class Department implements Serializable {
	
	//Criar Serializable (transforma os objetos em sequencias de bytes)
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	public Department() {
		
	}

	//Construtor com argumentos:
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	//Getters e Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Criar hashCode e equals - para os objetos serem comparados pelo conteúdo

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}

	//Criar toString (facilitar a impressão dos objetos nos testes)

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}	
}
