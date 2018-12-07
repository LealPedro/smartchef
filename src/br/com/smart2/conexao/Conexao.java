package br.com.smart2.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcheffinal", "root", "");
		}catch(SQLException ex) {
			throw ex;
		}
		
	}
	
	
	public static void closeConnetion(Connection con){
        
        try {
            if (con != null) {
               con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
  
}

public static void closeConnetion(Connection con, PreparedStatement stmt){
    closeConnetion(con);
    
   
        try {
           if (stmt != null) {
              stmt.close();
           }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}

public static void closeConnetion(Connection con, PreparedStatement stmt, ResultSet rs){
    closeConnetion(con, stmt);
    
  
        try {
          if (rs != null) {
             rs.close();
          }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}


}
