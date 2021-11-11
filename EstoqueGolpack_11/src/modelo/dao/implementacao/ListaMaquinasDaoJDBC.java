package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.ListaMaquinasDao;
import modelo.entidades.Componentes;
import modelo.entidades.Departamento;
import modelo.entidades.ListaComponenteMaquina;
import modelo.entidades.Maquinas;

public class ListaMaquinasDaoJDBC implements ListaMaquinasDao {

	private Connection conn;

	public ListaMaquinasDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Maquinas obj, Componentes obj2, ListaComponenteMaquina obj3) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO ListaPorMaquina "
					+ "(maquina_id, produto_id, quantidade_por_maquina) "
					+ "VALUES " + "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getId());
			st.setInt(2, obj2.getId());
			st.setInt(3, obj3.getQuanbtidade_Por_Maquina());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(ListaComponenteMaquina obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePorId(Integer mqId, Integer cmId) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM listapormaquina WHERE maquina_id = ? AND produto_id = ?;");
			
			st.setInt(1, mqId);
			st.setInt(2, cmId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ListaComponenteMaquina buscaPorId(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select m.nome, p.nome, p.codigo, p.quantidadeAtual, lm.quantidade_por_maquina, p.departamento "
					+ "from listapormaquina lm, maquinas m, produtos p " + "where m.id = lm.maquina_id "
					+ "and p.id = lm.produto_id " + "and lm.maquina_id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			while (rs.next()) {

				ListaComponenteMaquina obj = new ListaComponenteMaquina();

				obj.setTipoMaquina(rs.getString("m.nome"));
				obj.setComponente_Id(rs.getString("p.nome"));
				obj.setCodigo(rs.getString("p.codigo"));
				obj.setQuanbtidade_Por_Maquina(rs.getInt("lm.quantidade_por_maquina"));
				obj.setQuanbtidade_Em_Estoque(rs.getInt("p.quantidadeAtual"));

				return obj;
			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ListaComponenteMaquina> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select m.nome, p.nome, p.codigo, p.quantidadeAtual, lm.quantidade_por_maquina, p.departamento "
					+ "from listapormaquina lm, maquinas m, produtos p " + "where m.id = lm.maquina_id "
					+ "and p.id = lm.produto_id ");

			rs = st.executeQuery();

			List<ListaComponenteMaquina> list = new ArrayList<ListaComponenteMaquina>();

			while (rs.next()) {

				ListaComponenteMaquina obj = new ListaComponenteMaquina();

				obj.setTipoMaquina(rs.getString("m.nome"));
				obj.setComponente_Id(rs.getString("p.nome"));
				obj.setCodigo(rs.getString("p.codigo"));
				obj.setQuanbtidade_Por_Maquina(rs.getInt("lm.quantidade_por_maquina"));
				obj.setQuanbtidade_Em_Estoque(rs.getInt("p.quantidadeAtual"));
				obj.setTeste(rs.getString("p.departamento"));

				list.add(obj);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ListaComponenteMaquina> buscarPorMaquina(Maquinas maquinas) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select m.nome, p.nome, p.codigo, p.quantidadeAtual, lm.quantidade_por_maquina, p.departamento "
					+ "from listapormaquina lm, maquinas m, produtos p " + "where m.id = lm.maquina_id "
					+ "and p.id = lm.produto_id " + "and lm.maquina_id = ?");

			st.setInt(1, maquinas.getId());

			rs = st.executeQuery();

			List<ListaComponenteMaquina> list = new ArrayList<ListaComponenteMaquina>();

			while (rs.next()) {

				ListaComponenteMaquina obj = new ListaComponenteMaquina();

				obj.setTipoMaquina(rs.getString("m.nome"));
				obj.setComponente_Id(rs.getString("p.nome"));
				obj.setCodigo(rs.getString("p.codigo"));
				obj.setQuanbtidade_Por_Maquina(rs.getInt("lm.quantidade_por_maquina"));
				obj.setQuanbtidade_Em_Estoque(rs.getInt("p.quantidadeAtual"));
				obj.setTeste(rs.getString("p.departamento"));
				

				list.add(obj);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
