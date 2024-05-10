package data;

import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class InsertComentarios{
	
	public void InsertarComentarios(String nombre, String barrioC, String comentario) {
		PreparedStatement preparedStmt = null;
			//ResultSet result_coment = null;
			Connection conex = null;
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver.noexiste");
			conex = DriverManager.getConnection("jdbc:mysql://db-tfg-barrios.cbzb1lejscmc.us-east-2.rds.amazonaws.com:3306/dbHoodfinder? CharacterEncoding = latin1","rocioTFG","rootquery");

			String query = "insert into comentarios (nombre, barrioC, comentario) values (?, ?, ?)";
			
			preparedStmt = conex.prepareStatement(query);
			preparedStmt.setString (1, nombre);
			preparedStmt.setString (2, barrioC);
			preparedStmt.setString(3,  comentario);
	
		    // execute the preparedstatement
		    preparedStmt.execute();
		    
		    
			
		}catch(Exception e) {
			System.out.println(e); 
		} finally {
			//try { result_coment.close(); System.out.println("Se ha cerrado el resultset");} catch (Exception e) { /* ignored */ }
		    try { preparedStmt.close(); System.out.println("Se ha cerrado el statement");} catch (Exception e) { /* ignored */ }
		    try { conex.close(); System.out.println("Se ha cerrado la conexión");} catch (Exception e) { /* ignored */ }
		}
	}

}

