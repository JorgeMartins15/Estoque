package application;

import modelo.dao.ComponentesDao;
import modelo.dao.FabricaDeDao;
import modelo.entidades.Requisicao;
import modelo.entidades.enums.StatusRequisicao;



public class TesteComponentes {

	public static void main(String[] args) {
		
		ComponentesDao componentesDao = FabricaDeDao.createComponentesDao();
//		
//		Maquinas maquinas = new Maquinas(2,null);
//		
//		System.out.println("\n=== TESTE INSERIR COMPONENTES=====");
//		Componentes newComponentes = new Componentes(null, "CONTATOR 3A", "011.055.225", "WEG", null, 38, 46, maquinas);
//		componentesDao.inserir(newComponentes);
//		System.out.println("Inserido : " + newComponentes.getId());
		
		
//		System.out.println("===== TESTE BUSCA POR ID =====");
//		Componentes cmp = componentesDao.buscaPorId(7);
//		System.out.println(cmp);
		
//		System.out.println("===== TESTE DELETE POR ID =====");
//		Componentes cmp = componentesDao.buscaPorId(2);
//		componentesDao.deletePorId(cmp.getId());
//		System.out.println("DELETADO COM SUCESSO ID = " + cmp.getId());
		
//		System.out.println("===== TESTE UPDATE POR ID =====");
//		Maquinas mq = new Maquinas();
//		mq.setId(2);
//		Componentes cmp = componentesDao.buscaPorId(8);
//		cmp.setNome("ASDA-A4");
//		cmp.setCodigo("012.000.6789");
//		cmp.setFornecedor1("DELTINHA");
//		cmp.setFornecedor2("NADINHA");
//		cmp.setQuantidadeAtual(24);
//		cmp.setPontoDePedido(25);
//		cmp.setMaquinas(mq);
//		componentesDao.update(cmp);
//		System.out.println("UPDATE REALIZADO COM SUCESSO ID = " + cmp.getId());
		
//		System.out.println("\n=== TESTE BUSCA TODOS =====");
//		List<Componentes> cmp = componentesDao.buscarTodos();
//		for( Componentes m : cmp) {
//		System.out.println(m);
//		}
		
//		System.out.println("\n=== TESTE BUSCA POR MAQUINA =====");
//		Departamento mq = new Departamento();
//		mq.setId(2);
//		List<Componentes> cmp = componentesDao.buscarPorDepartamento(mq);
//		for( Componentes m : cmp) {
//		System.out.println(m);
//		}

	}
}
	

