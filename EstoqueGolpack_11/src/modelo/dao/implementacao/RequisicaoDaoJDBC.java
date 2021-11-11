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
import modelo.dao.RequisicaoDao;
import modelo.entidades.Componentes;
import modelo.entidades.Departamento;
import modelo.entidades.Requisicao;
import modelo.entidades.enums.StatusRequisicao;

public class RequisicaoDaoJDBC implements RequisicaoDao {

	private Connection conn;

	public RequisicaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Requisicao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO requisicoes (item, numero, nome, codigo, quantidade, destino, status_, dataEmissao, dataEntrega)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getItem());
			st.setInt(2, obj.getNumero());
			st.setString(3, obj.getNome());
			st.setString(4, obj.getCodigo());
			st.setInt(5, obj.getQuantidade());
			st.setString(6, obj.getDestino());
			st.setString(7, obj.getStatus_().toString());
			st.setString(8, obj.getDataEmissao());
			st.setString(9, obj.getDataEntrega());

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
//			throw new DbException("NOME DUPLICADO");
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Requisicao obj) {
		PreparedStatement st = null;

		
		try {
			st = conn.prepareStatement(
					"UPDATE requisicoes " + "SET quantidade = ? , destino = ?, dataEntrega = ?, status_ = ?" + "WHERE numero = ?;");

			st.setInt(1, obj.getQuantidade());
			st.setString(2, obj.getDestino());
			st.setString(3, obj.getDataEntrega());
			st.setString(4, obj.getStatus_().toString());
			st.setInt(5, obj.getNumero());

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
			st = conn.prepareStatement("DELETE FROM requisicoes WHERE id = ?;");

			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Requisicao> buscaPorNumero(Requisicao requisicao) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM requisicoes WHERE numero = ?;");

			st.setInt(1, requisicao.getNumero());
			rs = st.executeQuery();

			List<Requisicao> req = new ArrayList<Requisicao>();

			while (rs.next()) {

				Requisicao obj = new Requisicao();

				String status = rs.getString("status_");

				StatusRequisicao statusEnum = StatusRequisicao.valueOf(status);

				obj.setId(rs.getInt("id"));
				obj.setItem(rs.getInt("item"));
				obj.setNumero(rs.getInt("numero"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setQuantidade(rs.getInt("quantidade"));
				obj.setDestino(rs.getString("destino"));
				obj.setStatus_(statusEnum);
				obj.setDataEmissao(rs.getString("dataEmissao"));
				obj.setDataEntrega(rs.getString("dataEntrega"));

				req.add(obj);

			}
			return req;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Requisicao buscarPorId(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM requisicoes WHERE Id = ?");
			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {

				Requisicao obj = new Requisicao();

				String status = rs.getString("status_");

				StatusRequisicao statusEnum = StatusRequisicao.valueOf(status);

				obj.setId(rs.getInt("id"));
				obj.setItem(rs.getInt("item"));
				obj.setNumero(rs.getInt("numero"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setQuantidade(rs.getInt("quantidade"));
				obj.setDestino(rs.getString("destino"));
				obj.setStatus_(statusEnum);
				obj.setDataEmissao(rs.getString("dataEmissao"));
				obj.setDataEntrega(rs.getString("dataEntrega"));

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
	public List<Requisicao> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM requisicoes ORDER BY NUMERO");

			rs = st.executeQuery();

			List<Requisicao> list = new ArrayList<Requisicao>();

			while (rs.next()) {

				Requisicao obj = new Requisicao();

				String status = rs.getString("status_");

				StatusRequisicao statusEnum = StatusRequisicao.valueOf(status);

				obj.setId(rs.getInt("id"));
				obj.setItem(rs.getInt("item"));
				obj.setNumero(rs.getInt("numero"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setQuantidade(rs.getInt("quantidade"));
				obj.setDestino(rs.getString("destino"));
				obj.setStatus_(statusEnum);
				obj.setDataEmissao(rs.getString("dataEmissao"));
				obj.setDataEntrega(rs.getString("dataEntrega"));
				
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
