package modelo.dao;

import java.util.List;

import modelo.entidades.Componentes;
import modelo.entidades.ListaComponenteMaquina;
import modelo.entidades.Maquinas;

public interface ListaMaquinasDao {

	void inserir(Maquinas obj, Componentes obj2, ListaComponenteMaquina obj3);
	void update(ListaComponenteMaquina obj);
	void deletePorId(Integer mqId, Integer cmId);
	ListaComponenteMaquina buscaPorId(Integer id);
	List<ListaComponenteMaquina> buscarTodos();
	List<ListaComponenteMaquina> buscarPorMaquina(Maquinas maquinas);
}
