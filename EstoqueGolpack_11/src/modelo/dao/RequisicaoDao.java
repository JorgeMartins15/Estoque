package modelo.dao;

import java.util.List;

import modelo.entidades.Requisicao;

public interface RequisicaoDao {

	void inserir(Requisicao obj);
	void update(Requisicao obj);
	Requisicao buscarPorId(Integer id);
	void deletePorId(Integer id);
	List<Requisicao> buscarTodos();
	List<Requisicao> buscaPorNumero(Requisicao requisicao);

}
