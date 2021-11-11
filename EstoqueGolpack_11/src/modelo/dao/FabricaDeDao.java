package modelo.dao;

import db.DB;
import modelo.dao.implementacao.ComponentesDaoJDBC;
import modelo.dao.implementacao.ComponentesEletronicaDaoJDBC;
import modelo.dao.implementacao.DepartamentoDaoJDBC;
import modelo.dao.implementacao.ListaMaquinasDaoJDBC;
import modelo.dao.implementacao.MaquinasDaoJDBC;
import modelo.dao.implementacao.RequisicaoDaoJDBC;

public class FabricaDeDao {

	public static ComponentesDao createComponentesDao() {
		return new ComponentesDaoJDBC(DB.getConnection());
	}
	
	public static ComponentesEletronicaDao createComponentesEletronicaDao() {
		return new ComponentesEletronicaDaoJDBC(DB.getConnection());
	}
	
	public static MaquinasDao createMaquinasDao() {
		return new MaquinasDaoJDBC(DB.getConnection());
	}
	
	public static ListaMaquinasDao createListaMaquinasDao() {
		return new ListaMaquinasDaoJDBC(DB.getConnection());
	}
	
	public static DepartamentoDao createDepartamentoDao() {
		return new DepartamentoDaoJDBC(DB.getConnection());
	}
	
	public static RequisicaoDao createRequisicaoDao() {
		return new RequisicaoDaoJDBC(DB.getConnection());
	}
}
