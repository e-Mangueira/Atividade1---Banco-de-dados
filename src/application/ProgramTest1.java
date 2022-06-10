package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import db.DB;
import db.DbIntegrityException;


public class ProgramTest1 {
	public static void main(String[] args) {
		
		// Mostrar apenas que está conectado o BD:
		System.out.println(">> dbmangueira Database connected \n");
				
/*
		// Test1 - CONEXÃO COM O BANCO DE DADOS
		
		System.out.println("==== Test1 - JDBC connection with MySQL ==== \n");
		
		System.out.println(">> dbmangueira Database connected \n");
		
		Connection conn = DB.getConnection();
		DB.closeConnection();

		
		// Test2 - RECUPERAR DADOS - Criar classes Statement e ResultSet
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			System.out.println("==== Test2 - Department Data - Id and name ==== \n");
			
			rs = st.executeQuery("Select * from Department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.getStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

		// Test3 - COMANDO DE INSERIR DADOS
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO professor "
					+ "(Name, Email, BirthDate, CPF, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?)"
					);
				
			st. setString(1, "Carl Purple ") ;
			st. setString(2,"carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setInt (4, 888999) ;
			st.setDouble(5, 3000.0) ;
			st.setInt (6, 4) ;
			
			int rowsAffected = st.executeUpdate() ;
			
			System.out.println( "Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

		// Test4 - Atualizar dados - Update
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
				"UPDATE professor "
				+ "SET BaseSalary = BaseSalary + ? "
				+ "WHERE "
				+ " (DepartmentId = ?) ") ;
			
			st.setDouble(1, 200.0) ;
			st.setInt (2, 2);
			
			int rowsAffected = st. executeUpdate();
			
			System.out.println( "Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e. printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

		// Test5 - DELETAR DADOS - Delete
		
		Connection conn = null;
		PreparedStatement st = null;
		
		 try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
				"DELETE FROM department "
				+ "WHERE "
				+ "Id = ?) ") ;
			
			st.setInt (1, 5);
			
			int rowsAffected = st. executeUpdate();
			
			System.out.println( "Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
			}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	


*/

		// Test5 - DELETAR DADOS - Delete
		
		Connection conn = null;
		PreparedStatement st = null;
		
		 try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
				"DELETE FROM department "
				+ "WHERE "
				+ "Id = ?) ") ;
			
			st.setInt (1, 5);
			
			int rowsAffected = st. executeUpdate();
			
			System.out.println( "Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
			}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
