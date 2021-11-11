package modelo.dao;

import java.util.List;

import modelo.entidades.Componentes;
import modelo.entidades.ComponentesEletronica;
import modelo.entidades.Maquinas;

	public interface ComponentesEletronicaDao {
		void inserir(ComponentesEletronica obj);
		void update(ComponentesEletronica obj);
		void deletePorId(Integer id);
		ComponentesEletronica buscaPorId(Integer id);
		List<ComponentesEletronica> buscaPorNome(String nome);
		List<ComponentesEletronica> buscarTodos();
		List<ComponentesEletronica> buscarPorMaquina(Maquinas maquinas);
	}

