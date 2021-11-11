package modelo.entidades;

import java.io.Serializable;

public class ListaComponenteMaquina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tipoMaquina;
	private String componente_Id;
	private String codigo;
	private Integer quanbtidade_Por_Maquina;
	private Integer quanbtidade_Em_Estoque;
	private String teste;
	
	private Integer maqId;
	private Integer cmpId;
	
	Maquinas maquinas;
	Componentes componentes;
	Departamento departamento;
	
	public ListaComponenteMaquina() {

	}
	
	

	public ListaComponenteMaquina(String tipoMaquina, String componente_Id, String codigo,
			Integer quanbtidade_Por_Maquina, Integer quanbtidade_Em_Estoque, String teste) {
		super();
		this.tipoMaquina = tipoMaquina;
		this.componente_Id = componente_Id;
		this.codigo = codigo;
		this.quanbtidade_Por_Maquina = quanbtidade_Por_Maquina;
		this.quanbtidade_Em_Estoque = quanbtidade_Em_Estoque;
		this.teste = teste;
	}



	public ListaComponenteMaquina(String tipoMaquina, String componente_Id, String codigo,
			Integer quanbtidade_Por_Maquina, Integer quanbtidade_Em_Estoque) {
		super();
		this.tipoMaquina = tipoMaquina;
		this.componente_Id = componente_Id;
		this.codigo = codigo;
		this.quanbtidade_Por_Maquina = quanbtidade_Por_Maquina;
		this.quanbtidade_Em_Estoque = quanbtidade_Em_Estoque;
	}

	public ListaComponenteMaquina(Integer quanbtidade_Por_Maquina, Integer maqId, Integer cmpId) {
		super();
		this.quanbtidade_Por_Maquina = quanbtidade_Por_Maquina;
		this.maqId = maqId;
		this.cmpId = cmpId;
	}

	public ListaComponenteMaquina(Integer quanbtidade_Por_Maquina, Maquinas maquinas, Componentes componentes) {
		super();
		this.quanbtidade_Por_Maquina = quanbtidade_Por_Maquina;
		this.maquinas = maquinas;
		this.componentes = componentes;
	}
	
	

	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public Maquinas getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(Maquinas maquinas) {
		this.maquinas = maquinas;
	}

	public Componentes getComponentes() {
		return componentes;
	}

	public void setComponentes(Componentes componentes) {
		this.componentes = componentes;
	}

	public Integer getMaqId() {
		return maqId;
	}

	public void setMaqId(Integer maqId) {
		this.maqId = maqId;
	}

	public Integer getCmpId() {
		return cmpId;
	}

	public void setCmpId(Integer cmpId) {
		this.cmpId = cmpId;
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public String getComponente_Id() {
		return componente_Id;
	}

	public void setComponente_Id(String componente_Id) {
		this.componente_Id = componente_Id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getQuanbtidade_Por_Maquina() {
		return quanbtidade_Por_Maquina ;
	}

	public void setQuanbtidade_Por_Maquina(Integer quanbtidade_Por_Maquina) {
		this.quanbtidade_Por_Maquina = quanbtidade_Por_Maquina;
	}

	public Integer getQuanbtidade_Em_Estoque() {
		return quanbtidade_Em_Estoque;
	}

	public void setQuanbtidade_Em_Estoque(Integer quanbtidade_Em_Estoque) {
		this.quanbtidade_Em_Estoque = quanbtidade_Em_Estoque;
	}
	
	public Integer multiplica(Integer mult) {
		return quanbtidade_Por_Maquina * mult;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmpId == null) ? 0 : cmpId.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((componente_Id == null) ? 0 : componente_Id.hashCode());
		result = prime * result + ((componentes == null) ? 0 : componentes.hashCode());
		result = prime * result + ((maqId == null) ? 0 : maqId.hashCode());
		result = prime * result + ((maquinas == null) ? 0 : maquinas.hashCode());
		result = prime * result + ((quanbtidade_Em_Estoque == null) ? 0 : quanbtidade_Em_Estoque.hashCode());
		result = prime * result + ((quanbtidade_Por_Maquina == null) ? 0 : quanbtidade_Por_Maquina.hashCode());
		result = prime * result + ((teste == null) ? 0 : teste.hashCode());
		result = prime * result + ((tipoMaquina == null) ? 0 : tipoMaquina.hashCode());
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
		ListaComponenteMaquina other = (ListaComponenteMaquina) obj;
		if (cmpId == null) {
			if (other.cmpId != null)
				return false;
		} else if (!cmpId.equals(other.cmpId))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (componente_Id == null) {
			if (other.componente_Id != null)
				return false;
		} else if (!componente_Id.equals(other.componente_Id))
			return false;
		if (componentes == null) {
			if (other.componentes != null)
				return false;
		} else if (!componentes.equals(other.componentes))
			return false;
		if (maqId == null) {
			if (other.maqId != null)
				return false;
		} else if (!maqId.equals(other.maqId))
			return false;
		if (maquinas == null) {
			if (other.maquinas != null)
				return false;
		} else if (!maquinas.equals(other.maquinas))
			return false;
		if (quanbtidade_Em_Estoque == null) {
			if (other.quanbtidade_Em_Estoque != null)
				return false;
		} else if (!quanbtidade_Em_Estoque.equals(other.quanbtidade_Em_Estoque))
			return false;
		if (quanbtidade_Por_Maquina == null) {
			if (other.quanbtidade_Por_Maquina != null)
				return false;
		} else if (!quanbtidade_Por_Maquina.equals(other.quanbtidade_Por_Maquina))
			return false;
		if (teste == null) {
			if (other.teste != null)
				return false;
		} else if (!teste.equals(other.teste))
			return false;
		if (tipoMaquina == null) {
			if (other.tipoMaquina != null)
				return false;
		} else if (!tipoMaquina.equals(other.tipoMaquina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  tipoMaquina + "," + componente_Id + ","
				+ codigo + "," + quanbtidade_Por_Maquina + ","
				+ quanbtidade_Em_Estoque;
	}
	
	

}
