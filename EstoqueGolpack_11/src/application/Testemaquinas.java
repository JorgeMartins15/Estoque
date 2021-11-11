package application;

import java.util.List;

import modelo.dao.FabricaDeDao;
import modelo.dao.MaquinasDao;
import modelo.entidades.Maquinas;

public class Testemaquinas {

	public static void main(String[] args) {

		MaquinasDao maquinasDao = FabricaDeDao.createMaquinasDao();
		
//		System.out.println("\n=== TESTE INSERIR MAQUINA=====");
//		Maquinas newMaquinas = new Maquinas(null, "EP3512");
//		maquinasDao.inserir(newMaquinas);
//		System.out.println("Inserido : " + newMaquinas.getId());
		
//		System.out.println("\n=== TESTE BUSCA POR ID=====");
//		Maquinas mq1 = maquinasDao.buscaPorId(5);
//		System.out.println(mq1);
//		
//		System.out.println("\n=== TESTE UPDATE MAQUINA=====");
//		Maquinas mq = maquinasDao.buscaPorId(5);
//		mq.setNome("EP12345");
//		maquinasDao.update(mq);
//		System.out.println("Update ok!!!");
		
//		System.out.println("\n=== TESTE DELETE POR ID =====");
//		Maquinas mq3 = maquinasDao.buscaPorId(1);
//		maquinasDao.deletePorId(mq3.getId());
//		System.out.println(mq3.getNome());
	
//		System.out.println("\n=== TESTE BUSCA TODOS =====");
//		List<Maquinas> mq4 = maquinasDao.buscarTodos();
//		
//		for( Maquinas m : mq4) {
//		System.out.println(m);
//		}

	}

}
