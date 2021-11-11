package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.dao.FabricaDeDao;
import modelo.dao.RequisicaoDao;
import modelo.entidades.Requisicao;
import modelo.entidades.enums.StatusRequisicao;

public class TesteRequisicoes {

	public static void main(String[] args) throws ParseException {

		RequisicaoDao requisicaoDao = FabricaDeDao.createRequisicaoDao();
//
//		System.out.println("Teste Inseriri + Data");
//		Date dt1 = new Date();
//		Date dt2 = new Date();
//		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
//		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
//		dt2 = df2.parse("04/12/2021");
//
//		if (dt1.before(dt2)) {
//			Requisicao req = new Requisicao(null, 1, 5, "IH", "000.000.0009", 1, "CHIANG",
//					StatusRequisicao.EM_ANDAMENTO, df1.format(dt1), df2.format(dt2));
//			System.out.println(req);
//			requisicaoDao.inserir(req);
//		}else {
//			System.out.println("Data Invalida");
//		}
//		
//		System.out.println("Teste Busca por Numero Requisicao");
//		
//		Requisicao req = new Requisicao();
//		req.setNumero(20);
//		
//		List<Requisicao> list = requisicaoDao.buscaPorNumero(req);
//		
//		for(Requisicao r: list) {
//			System.out.println(r);
//		}

		
//		System.out.println("Teste Delete por Id");
//
//		Requisicao req = new Requisicao();
//		req = requisicaoDao.buscarPorId(2);
//		
//		System.out.println(req);
//		
//		requisicaoDao.deletePorId(req.getId());
//		
//		System.out.println("Teste Buscar Todos + Teste Update");
//		
//		List<Requisicao> list =  new ArrayList<Requisicao>();
//		
//		list = requisicaoDao.buscarTodos();
//			
//		Date dt1 = new Date();
//		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
//		Date dt2 = new Date();
//		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
//		
//		StatusRequisicao status = null;
//		
//		for(Requisicao r: list) {
//		
//			if (dt1.after(df2.parse(r.getDataEntrega()))) {
//				r.setStatus_(status.ATRASADO);
//				requisicaoDao.update(r);
//			}
//			
//			System.out.println(r);
//		}
//		
	

	}

}
