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
import gui.utils.Alerts;
import javafx.scene.control.Alert.AlertType;
import modelo.dao.MaquinasDao;
import modelo.entidades.Maquinas;

public class MaquinasDaoJDBC implements MaquinasDao {

	private Connection conn;

	public MaquinasDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Maquinas obj) {

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO maquinas " + "(Nome) " + "VALUES " + "(?)",
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
	public void update(Maquinas obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE maquinas " + "SET Nome = ? " + "WHERE Id = ?");

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
			st = conn.prepareStatement("DELETE FROM maquinas WHERE id = ?");
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
	public Maquinas buscaPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM maquinas WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Maquinas obj = new Maquinas();
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
	public List<Maquinas> buscarTodos() {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM maquinas ORDER BY ID");

			rs = st.executeQuery();

			List<Maquinas> mq4 = new ArrayList<Maquinas>();

			while (rs.next()) {
				Maquinas obj = new Maquinas();
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
	public List<Maquinas> buscaPorNome(String nome) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM maquinas WHERE nome LIKE ?;");
			st.setString(1, nome);
			rs = st.executeQuery();
			List<Maquinas> mq4 = new ArrayList<Maquinas>();

			while (rs.next()) {
				Maquinas obj = new Maquinas();
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
