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
import modelo.dao.ComponentesEletronicaDao;
import modelo.entidades.Componentes;
import modelo.entidades.ComponentesEletronica;
import modelo.entidades.Maquinas;

public class ComponentesEletronicaDaoJDBC implements ComponentesEletronicaDao {

	private Connection conn;

	public ComponentesEletronicaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(ComponentesEletronica obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO componentesEletronica "
					+ "(Nome, codigo, fornecedor1, fornecedor2, quantidadeAtual, pontoDePedido, maquina_id) "
					+ "VALUES " + "(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());
			st.setString(2, obj.getCodigo());
			st.setString(3, obj.getFornecedor1());
			st.setString(4, obj.getFornecedor2());
			st.setInt(5, obj.getQuantidadeAtual());
			st.setInt(6, obj.getPontoDePedido());
			st.setInt(7, obj.getMaquinas().getId());

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
	public void update(ComponentesEletronica obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE componenteseletronica "
					+ "SET nome = ? , codigo = ?, fornecedor1 = ?, fornecedor2 = ?, quantidadeAtual = ?, pontoDePedido = ?, maquina_id = ? "
					+ "WHERE Id = ?;");

			st.setString(1, obj.getNome());
			st.setString(2, obj.getCodigo());
			st.setString(3, obj.getFornecedor1());
			st.setString(4, obj.getFornecedor2());
			st.setInt(5, obj.getQuantidadeAtual());
			st.setInt(6, obj.getPontoDePedido());
			st.setInt(7, obj.getMaquinas().getId());
			st.setInt(8, obj.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deletePorId(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM componenteseletronica WHERE id = ?;");

			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ComponentesEletronica buscaPorId(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT componenteseletronica.*,maquinas.Id as MaqId, maquinas.Nome as MaqNome "
					+ "FROM componenteseletronica INNER JOIN maquinas " + "ON componenteseletronica.maquina_Id = maquinas.Id "
					+ "WHERE componenteseletronica.Id = ?");
			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {

				ComponentesEletronica obj = new ComponentesEletronica();
				Maquinas mq = new Maquinas();

				mq.setId(rs.getInt("MaqId"));
				mq.setNome(rs.getString("MaqNome"));

				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				obj.setMaquinas(mq);
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
	public List<ComponentesEletronica> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT componenteseletronica.*,maquinas.Id as MaqId, maquinas.Nome as MaqNome "
					+ "FROM componenteseletronica INNER JOIN maquinas " + "ON componenteseletronica.maquina_Id = maquinas.Id ");

			rs = st.executeQuery();

			List<ComponentesEletronica> list = new ArrayList<ComponentesEletronica>();

			while (rs.next()) {

				ComponentesEletronica obj = new ComponentesEletronica();
				Maquinas mq = new Maquinas();

				mq.setId(rs.getInt("MaqId"));
				mq.setNome(rs.getString("MaqNome"));

				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				obj.setMaquinas(mq);

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
	public List<ComponentesEletronica> buscarPorMaquina(Maquinas maquinas) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT componenteseletronica.*,maquinas.Id as MaqId, maquinas.Nome as MaqNome "
					+ "FROM componenteseletronica INNER JOIN maquinas " + "ON produtos.maquina_Id = maquinas.Id "
					+ "WHERE maquinas.Id  = ?;");

			st.setInt(1, maquinas.getId());

			rs = st.executeQuery();

			List<ComponentesEletronica> list = new ArrayList<ComponentesEletronica>();

			while (rs.next()) {

				ComponentesEletronica obj = new ComponentesEletronica();
				Maquinas mq = new Maquinas();

				mq.setId(rs.getInt("MaqId"));
				mq.setNome(rs.getString("MaqNome"));

				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				obj.setMaquinas(mq);

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
	public List<ComponentesEletronica> buscaPorNome(String nome) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM componenteseletronica WHERE nome LIKE ?;");
			st.setString(1, nome);
			rs = st.executeQuery();
			List<ComponentesEletronica> cp4 = new ArrayList<ComponentesEletronica>();

			while (rs.next()) {
				ComponentesEletronica obj = new ComponentesEletronica();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				cp4.add(obj);
			}
			return cp4;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
