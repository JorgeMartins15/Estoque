package modelo.dao;

import java.util.List;

import modelo.entidades.Maquinas;

public interface MaquinasDao {
	void inserir(Maquinas obj);
	void update(Maquinas obj);
	void deletePorId(Integer id);
	Maquinas buscaPorId(Integer id);
	List<Maquinas> buscaPorNome(String nome);
	List<Maquinas> buscarTodos();
}
