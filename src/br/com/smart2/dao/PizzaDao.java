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
import br.com.smart2.model.Pizza;

public class PizzaDao {
	
	 public void inserir(Pizza p) throws ClassNotFoundException, SQLException{
		    Connection con = Conexao.getConnection();
		    
		    PreparedStatement stmt = null;
		    
		     try {
		         stmt = con.prepareStatement("INSERT INTO pizza (sabor_pizza, valor_pizza, tamanho_pizza, descricao_piza, bebida_idbebida)VALUES(?,?,?,?,?)");
		         stmt.setString(1, p.getSabor());
		         stmt.setDouble(2, p.getValor());
		         stmt.setString(3, p.getTamanho());
		         stmt.setString(4, p.getDescricao());
		         stmt.setInt(5, p.getBebida().getId());
		         stmt.executeUpdate();
		         	         
		     } catch (SQLException ex) {
		         
		         JOptionPane.showMessageDialog(null, "Não foi possivel inserir o usuario");
		         throw ex;
		     }finally{
		         Conexao.closeConnetion(con, stmt);
		     }
		 }   


		//LISTAR USUARIOS VINDOS DO BANCO DE DADOS

		public List<Pizza> listar() throws ClassNotFoundException, SQLException{
		   Connection con = Conexao.getConnection();
		   PreparedStatement stmt = null;
		   ResultSet rs =null;
		   List<Pizza> pizza = new ArrayList<>();
		     try {
		         stmt=con.prepareStatement("SELECT * FROM pizza");
		         rs=stmt.executeQuery();
		         
		         while(rs.next()){
		        	 
		             Pizza p = new Pizza();
		            
		             p.setId(rs.getInt("idpizza"));
		             p.setSabor(rs.getString("sabor_pizza"));
		             p.setDescricao(rs.getString("descricao_piza"));
		             p.setTamanho(rs.getString("tamanho_pizza"));
		             p.setValor(rs.getDouble("valor_pizza"));
		            
		              
		             pizza.add(p);
		         }
		         
		     } catch (SQLException ex) {
		        JOptionPane.showMessageDialog(null, "ERRO :(");
		        throw ex;
		     }finally{
		         Conexao.closeConnetion(con, stmt, rs);
		     }
		      return pizza;
		}

		//DELETAR USUARIOS VINDO DO BANCO DE DADOS
		public void delete(Integer id) throws ClassNotFoundException, SQLException{
		  Connection con =  Conexao.getConnection();
		  PreparedStatement stmt = null;
		  
		     try {
		         stmt = con.prepareStatement("DELETE FROM pizza WHERE idpizza=?");
		         stmt.setInt(1, id);
		         
		         stmt.executeUpdate();
		     } catch (SQLException ex) {
		       JOptionPane.showMessageDialog(null, "Não foi possivel excluir esse usuario");
		       throw ex;
		     }finally{
		        Conexao.closeConnetion(con, stmt);
		     }
		  
		}
		//FAZER MUDANÇAS NO REGISTRO
		public void update(Pizza p) throws ClassNotFoundException, SQLException{
		     Connection con =  Conexao.getConnection();
		    
		    PreparedStatement stmt = null;
		    
		     try {
		         stmt = con.prepareStatement("UPDATE pizza SET sabor_pizza=?, valor_pizza=?, tamanho_pizza=?, descricao_piza=? WHERE idpizza =?");
		         stmt.setInt(5, p.getId());
		         stmt.setString(1, p.getSabor());
		         stmt.setDouble(2, p.getValor());
		         stmt.setString(3, p.getTamanho());
		         stmt.setString(4, p.getDescricao());
		    
		      
		         stmt.execute();
		         
		        
		     } catch (SQLException ex) {
		         
		         JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
		         throw ex;
		     }finally{
		         Conexao.closeConnetion(con, stmt);
		     }
		}

	


		public List<Pizza> buscar(String desc) throws ClassNotFoundException, SQLException{
		   
		    Connection con = (Connection) Conexao.getConnection();
		   PreparedStatement stmt = null;
		   ResultSet rs =null;
		   List<Pizza> pizza = new ArrayList<>();
		     try {
		         stmt=con.prepareStatement("SELECT * FROM pizza LIKE ?");
		         stmt.setString(1, "%"+desc+"%");
		         rs=stmt.executeQuery();
		         
		         while(rs.next()){
		             Pizza p = new Pizza();
		             p.setSabor(rs.getString("sabor_pizza"));
		             p.setTamanho(rs.getString("tamanho_pizza"));
		             p.setValor(rs.getDouble("valor_pizza"));
		             p.setDescricao(rs.getString("descricao_pizza"));
		             
		             pizza.add(p);
		         }
		         
		     } catch (SQLException ex) {
		        JOptionPane.showMessageDialog(null, "ERRO :(");
		     }finally{
		         Conexao.closeConnetion(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
		     }
		   

		      return pizza;
		}
		
		
		
		public Pizza buscaID(Integer id) throws ClassNotFoundException, SQLException {
			Connection con = Conexao.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;

			Pizza p = new Pizza();

			try {
				stmt = con.prepareStatement("SELECT * FROM pizza where idpizza=?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery();

				if (rs.next()) {

					p.setId(rs.getInt("idpizza"));
					p.setDescricao(rs.getString("descricao_piza"));
					p.setSabor(rs.getString("sabor_pizza"));
					p.setValor(rs.getDouble("valor_pizza"));
					p.setTamanho(rs.getString("tamanho_pizza"));
				

				}

			} catch (SQLException ex) {
				throw ex;
			} finally {
				Conexao.closeConnetion(con, stmt, rs);
			}

			return p;

		}


}
