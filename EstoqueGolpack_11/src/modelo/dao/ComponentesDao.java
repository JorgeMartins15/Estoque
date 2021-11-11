package modelo.dao;

import java.util.List;

import modelo.entidades.Componentes;
import modelo.entidades.Departamento;

	public interface ComponentesDao {
		void inserir(Componentes obj);
		void update(Componentes obj);
		void deletePorId(Integer id);
		Componentes buscaPorId(Integer id);
		List<Componentes> buscaPorNome(String nome);
		List<Componentes> buscarTodos();
		List<Componentes> buscarPorDepartamento(Departamento departamento);
	}

