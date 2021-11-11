package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import modelo.entidades.enums.StatusRequisicao;

public class Requisicao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer item;
	private Integer numero;
	private String nome;
	private String codigo;
	private Integer quantidade;
	private String destino;
	private StatusRequisicao status_;
	private String dataEmissao;
	private String dataEntrega;

	Componentes componentes;

	public Requisicao() {

	}

	public Requisicao(Integer id, Integer item, Integer numero, String nome, String codigo, Integer quantidade,
			String destino, StatusRequisicao status_, String dataEmissao, String dataEntrega) {
		
		this.id = id;
		this.item = item;
		this.numero = numero;
		this.nome = nome;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.destino = destino;
		this.status_ = status_;
		this.dataEmissao = dataEmissao;
		this.dataEntrega = dataEntrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public StatusRequisicao getStatus_() {
		return status_;
	}

	public void setStatus_(StatusRequisicao status_) {
		this.status_ = status_;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Componentes getComponentes() {
		return componentes;
	}

	public void setComponentes(Componentes componentes) {
		this.componentes = componentes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((componentes == null) ? 0 : componentes.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((status_ == null) ? 0 : status_.hashCode());
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
		Requisicao other = (Requisicao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (componentes == null) {
			if (other.componentes != null)
				return false;
		} else if (!componentes.equals(other.componentes))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (status_ != other.status_)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Requisicao [id=" + id + ", item=" + item + ", numero=" + numero + ", nome=" + nome + ", codigo="
				+ codigo + ", quantidade=" + quantidade + ", destino=" + destino + ", status_=" + status_
				+ ", dataEmissao=" + dataEmissao + ", dataEntrega=" + dataEntrega;
	}

	
	

}
