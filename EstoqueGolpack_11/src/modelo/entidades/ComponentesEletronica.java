package modelo.entidades;

import java.io.Serializable;

public class ComponentesEletronica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String codigo;
	private String fornecedor1;
	private String fornecedor2;
	private Integer quantidadeAtual;
	private Integer pontoDePedido;
	
	private Maquinas maquinas;
	
	public ComponentesEletronica() {
		
	}

	public ComponentesEletronica(Integer id, String nome, String codigo, String fornecedor1, String fornecedor2,
			Integer quantidadeAtual, Integer pontoDePedido, Maquinas maquinas) {
		
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.fornecedor1 = fornecedor1;
		this.fornecedor2 = fornecedor2;
		this.quantidadeAtual = quantidadeAtual;
		this.pontoDePedido = pontoDePedido;
		this.maquinas = maquinas;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFornecedor1() {
		return fornecedor1;
	}

	public void setFornecedor1(String fornecedor1) {
		this.fornecedor1 = fornecedor1;
	}

	public String getFornecedor2() {
		return fornecedor2;
	}

	public void setFornecedor2(String fornecedor2) {
		this.fornecedor2 = fornecedor2;
	}

	public Integer getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(Integer quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public Integer getPontoDePedido() {
		return pontoDePedido;
	}

	public void setPontoDePedido(Integer pontoDePedido) {
		this.pontoDePedido = pontoDePedido;
	}

	public Maquinas getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(Maquinas maquinas) {
		this.maquinas = maquinas;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fornecedor1 == null) ? 0 : fornecedor1.hashCode());
		result = prime * result + ((fornecedor2 == null) ? 0 : fornecedor2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maquinas == null) ? 0 : maquinas.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pontoDePedido == null) ? 0 : pontoDePedido.hashCode());
		result = prime * result + ((quantidadeAtual == null) ? 0 : quantidadeAtual.hashCode());
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
		ComponentesEletronica other = (ComponentesEletronica) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fornecedor1 == null) {
			if (other.fornecedor1 != null)
				return false;
		} else if (!fornecedor1.equals(other.fornecedor1))
			return false;
		if (fornecedor2 == null) {
			if (other.fornecedor2 != null)
				return false;
		} else if (!fornecedor2.equals(other.fornecedor2))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maquinas == null) {
			if (other.maquinas != null)
				return false;
		} else if (!maquinas.equals(other.maquinas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pontoDePedido == null) {
			if (other.pontoDePedido != null)
				return false;
		} else if (!pontoDePedido.equals(other.pontoDePedido))
			return false;
		if (quantidadeAtual == null) {
			if (other.quantidadeAtual != null)
				return false;
		} else if (!quantidadeAtual.equals(other.quantidadeAtual))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + " : " + nome + " - Cód. : " + codigo;
	}
	
}
