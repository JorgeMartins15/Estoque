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
import modelo.dao.DepartamentoDao;
import modelo.entidades.Departamento;
import modelo.entidades.Maquinas;

public class DepartamentoDaoJDBC implements DepartamentoDao {

	private Connection conn;

	public DepartamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Departamento obj) {

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO departamento " + "(Nome) " + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());

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
			throw new DbException("NOME DUPLICADO");
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Departamento obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE departamento " + "SET Nome = ? " + "WHERE Id = ?");

			st.setString(1, obj.getNome());
			st.setInt(2, obj.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletePorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("DELETE FROM departamento WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public Departamento buscaPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Departamento WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	

	@Override
	public List<Departamento> buscarTodos() {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Departamento ORDER BY ID");

			rs = st.executeQuery();

			List<Departamento> mq4 = new ArrayList<Departamento>();

			while (rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Nome"));
				mq4.add(obj);
			}
			return mq4;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Departamento> buscaPorNome(String nome) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Departamento WHERE nome LIKE ?;");
			st.setString(1, nome);
			rs = st.executeQuery();
			List<Departamento> mq4 = new ArrayList<Departamento>();

			while (rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Nome"));
				mq4.add(obj);
			}
			return mq4;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


}
