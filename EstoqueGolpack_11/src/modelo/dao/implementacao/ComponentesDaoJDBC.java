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
import modelo.dao.ComponentesDao;
import modelo.entidades.Componentes;
import modelo.entidades.Departamento;
import modelo.entidades.Maquinas;

public class ComponentesDaoJDBC implements ComponentesDao{
	
	private Connection conn;
	
	public ComponentesDaoJDBC(Connection conn) {
		this.conn = conn;
	}


	@Override
	public void inserir(Componentes obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO produtos " +
				"(Nome, codigo, fornecedor1, fornecedor2, quantidadeAtual, pontoDePedido, departamento) " +
				"VALUES " +
				"(?, ?, ?, ?, ?, ?, ?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());
			st.setString(2, obj.getCodigo());
			st.setString(3, obj.getFornecedor1());
			st.setString(4, obj.getFornecedor2());
			st.setInt(5, obj.getQuantidadeAtual());
			st.setInt(6, obj.getPontoDePedido());
			st.setInt(7, obj.getDepartamento().getId());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
		
	}


	@Override
	public void update(Componentes obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE produtos "
					+ "SET nome = ? , codigo = ?, fornecedor1 = ?, fornecedor2 = ?, quantidadeAtual = ?, pontoDePedido = ?, departamento = ? "
					+ "WHERE Id = ?;");
			
			st.setString(1, obj.getNome());		
			st.setString(2, obj.getCodigo());
			st.setString(3, obj.getFornecedor1());
			st.setString(4, obj.getFornecedor2());
			st.setInt(5, obj.getQuantidadeAtual());
			st.setInt(6, obj.getPontoDePedido());
			st.setInt(7, obj.getDepartamento().getId());
			st.setInt(8, obj.getId());	
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deletePorId(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM produtos WHERE id = ?;");
			
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public Componentes buscaPorId(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT produtos.*,departamento.Id as DepId, departamento.Nome as DepNome " 
					+ "FROM produtos INNER JOIN departamento "
					+ "ON produtos.departamento = departamento.Id " 
					+ "WHERE produtos.Id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();

			if (rs.next()) {
	
				Componentes obj = new Componentes();
				Departamento mq = new Departamento();
				
				mq.setId(rs.getInt("DepId"));
				mq.setNome(rs.getString("DepNome"));
				
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				obj.setDepartamento(mq);
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
	public List<Componentes> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT produtos.*,departamento.Id as DepId, departamento.Nome as DepNome " 
					+ "FROM produtos INNER JOIN departamento "
					+ "ON produtos.departamento = departamento.Id ");			
			
			rs = st.executeQuery();
			
			List<Componentes> list = new ArrayList<Componentes>();

			while (rs.next()) {
	
				Componentes obj = new Componentes();
				Departamento mq = new Departamento();
				
				mq.setId(rs.getInt("DepId"));
				mq.setNome(rs.getString("DepNome"));
				
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				obj.setDepartamento(mq);
				
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
	public List<Componentes> buscarPorDepartamento(Departamento departamento) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT produtos.*,departamento.Id as DepId, departamento.Nome as DepNome " 
					+ "FROM produtos INNER JOIN departamento "
					+ "ON produtos.departamento = departamento.Id "
					+ "WHERE departamento.Id  = ?;");
			
			st.setInt(1, departamento.getId());
			
			rs = st.executeQuery();
			
			List<Componentes> list = new ArrayList<Componentes>();

			while (rs.next()) {
	
				Componentes obj = new Componentes();
				Departamento mq = new Departamento();
				
				mq.setId(rs.getInt("DepId"));
				mq.setNome(rs.getString("DepNome"));
				
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCodigo(rs.getString("codigo"));
				obj.setFornecedor1(rs.getString("fornecedor1"));
				obj.setFornecedor2(rs.getString("fornecedor2"));
				obj.setQuantidadeAtual(rs.getInt("quantidadeAtual"));
				obj.setPontoDePedido(rs.getInt("pontoDePedido"));
				obj.setDepartamento(mq);
				
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
	public List<Componentes> buscaPorNome(String nome) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?;");
			st.setString(1, nome);
			rs = st.executeQuery();
			List<Componentes> cp4 = new ArrayList<Componentes>();

			while (rs.next()) {
				Componentes obj = new Componentes();
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
