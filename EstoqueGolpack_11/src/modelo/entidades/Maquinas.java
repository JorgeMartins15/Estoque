package modelo.entidades;

import java.io.Serializable;

public class Maquinas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer qtdeMaquinas;

	public Maquinas() {

	}
	
	
	
	public Maquinas(Integer id, String nome, Integer qtdeMaquinas) {
		this.id = id;
		this.nome = nome;
		this.qtdeMaquinas = qtdeMaquinas;
	}



	public Maquinas(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	

	public Integer getQtdeMaquinas() {
		return qtdeMaquinas;
	}



	public void setQtdeMaquinas(Integer qtdeMaquinas) {
		this.qtdeMaquinas = qtdeMaquinas;
	}



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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((qtdeMaquinas == null) ? 0 : qtdeMaquinas.hashCode());
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
		Maquinas other = (Maquinas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdeMaquinas == null) {
			if (other.qtdeMaquinas != null)
				return false;
		} else if (!qtdeMaquinas.equals(other.qtdeMaquinas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id.toString();
	}

}
