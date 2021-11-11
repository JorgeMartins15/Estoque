package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public interface DepartamentoDao {
	void inserir(Departamento obj);
	void update(Departamento obj);
	void deletePorId(Integer id);
	Departamento buscaPorId(Integer id);
	List<Departamento> buscaPorNome(String nome);
	List<Departamento> buscarTodos();
}
