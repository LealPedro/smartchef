package br.com.smart2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.smart2.conexao.Conexao;
import br.com.smart2.model.Bebida;

public class BebidaDao {

	public void inserir(Bebida b) throws ClassNotFoundException, SQLException {
		Connection con = (Connection) Conexao.getConnection();

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO bebida (nome_bebida, tamanho_bebida, valor_bebida)VALUES(?,?,?)");
			stmt.setString(1, b.getNome());
			stmt.setString(2, b.getTamanho());
			stmt.setDouble(3, b.getValor());
			stmt.executeUpdate();

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Não foi possivel inserir o usuario");
		} finally {
			Conexao.closeConnetion(con, stmt);
		}
	}

	// LISTAR USUARIOS VINDOS DO BANCO DE DADOS

	public List<Bebida> listar() throws ClassNotFoundException, SQLException {
		Connection con =  Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Bebida> bebida = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM bebida");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Bebida b = new Bebida();
				b.setId(rs.getInt("idbebida"));
				b.setNome(rs.getString("nome_bebida"));
				b.setTamanho(rs.getString("tamanho_bebida"));
				b.setValor(rs.getDouble("valor_bebida"));
				
				bebida.add(b);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERRO :(");
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}

		return bebida;
	}

	// DELETAR USUARIOS VINDO DO BANCO DE DADOS
	public void delete(Integer b) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;

		stmt = con.prepareStatement("DELETE FROM bebida WHERE idbebida=?");
		stmt.setInt(1, b);

		stmt.executeUpdate();

		Conexao.closeConnetion(con, stmt);

	}

	// FAZER MUDANÇAS NO REGISTRO
	public void update(Bebida b) throws ClassNotFoundException, SQLException {
		Connection con = (Connection) Conexao.getConnection();

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE bebida SET nome_bebida=?, tamanho_bebida=?, valor_bebida=? WHERE idbebida =?");
		
			stmt.setInt(4, b.getId());
			
			stmt.setString(1, b.getNome());
			
			stmt.setString(2, b.getTamanho());
			
			stmt.setDouble(3, b.getValor());
			
			

			stmt.execute();

			
		} catch (SQLException ex) {

			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt);
		}
	}
	
	

	public List<Bebida> buscar(String desc) throws ClassNotFoundException, SQLException {

		Connection con = (Connection) Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Bebida> bebida = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM bebida where nome_bebida LIKE ?");
			stmt.setString(1, "%" + desc + "%");
			rs = stmt.executeQuery();

			Bebida b = new Bebida();
			while (rs.next()) {

				b.setId(rs.getInt("idbebida"));
				b.setNome(rs.getString("nome_bebida"));
				b.setTamanho(rs.getString("tamanho_bebida"));
				b.setValor(rs.getDouble("valor_bebida"));

				bebida.add(b);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERRO :(");
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}

		return bebida;
	}

	// Buscar pelo ID
	@SuppressWarnings("resource")
	public Bebida buscaID(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Bebida b = new Bebida();

		try {
			stmt = con.prepareStatement("SELECT * FROM bebida where idbebida=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {

				b.setId(rs.getInt("idbebida"));
				b.setNome(rs.getString("nome_bebida"));
				b.setTamanho(rs.getString("tamanho_bebida"));
				b.setValor(rs.getDouble("valor_bebida"));

			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}

		return b;

	}

}
