package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import clases.Comentarios;
import clases.TablaBarrios;



public class Lectura_comentarios {

	private final List<Comentarios> datos_comentarios = new ArrayList<>();
	
	public List<Comentarios> getComentarios() {
		if (datos_comentarios.isEmpty()) {
			datos_comentarios.get(0);
			Connection conn = null;
			Statement state_comentarios = null;
			ResultSet result_comentarios = null;
	
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://db-tfg-barrios.cbzb1lejscmc.us-east-2.rds.amazonaws.com:3306/dbHoodfinder? CharacterEncoding = latin1","rocioTFG","rootquery");
				state_comentarios = conn.createStatement();
				result_comentarios = state_comentarios.executeQuery("SELECT * FROM dbHoodfinder.comentarios");
				
				
				while (result_comentarios.next()) {
					Comentarios comentarios = new Comentarios();
					comentarios.setNombre(result_comentarios.getString("nombre"));
					comentarios.setBarrioC(result_comentarios.getString("barrioC"));
					comentarios.setComentario(result_comentarios.getString("comentario"));
					datos_comentarios.add(comentarios);
				} 
				return datos_comentarios;
				
			} catch(Exception e) {
				System.out.println(e); 
			} finally {
				
			    try { result_comentarios.close(); System.out.println("Se ha cerrado el resultset");} catch (Exception e) { /* ignored */ }
			    try { state_comentarios.close(); System.out.println("Se ha cerrado el statement");} catch (Exception e) { /* ignored */ }
			    try { conn.close(); System.out.println("Se ha cerrado la conexión");} catch (Exception e) { /* ignored */ }
			}
			return datos_comentarios;
		} else {
			return datos_comentarios;
		}
	}

}
