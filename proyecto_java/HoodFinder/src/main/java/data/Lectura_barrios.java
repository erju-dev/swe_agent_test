package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import clases.TablaBarrios;



public class Lectura_barrios {

	private final List<TablaBarrios> datos_barrios = new ArrayList<>();
	
	public List<TablaBarrios> getBarrios() {
		if (datos_barrios.isEmpty()) {
			Connection conn = null;
			Statement state_barrios = null;
			ResultSet result_barrios = null;
	
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://db-tfg-barrios.cbzb1lejscmc.us-east-2.rds.amazonaws.com:3306/dbHoodfinder? CharacterEncoding = latin1","rocioTFG","rootquery");
				state_barrios = conn.createStatement();
				result_barrios = state_barrios.executeQuery("SELECT * FROM dbHoodfinder.barrios");
				
				
				while (result_barrios.next()) {
					TablaBarrios barrios = new TablaBarrios();
					barrios.setBarrio(result_barrios.getString("barrio"));
					barrios.setDistrito(result_barrios.getString("distrito"));
					barrios.setEdad_media(result_barrios.getString("edad_media"));
					barrios.setNacionalidad_espanola(result_barrios.getString("nacionalidad_espanola"));
					barrios.setNacionalidad_extranjera(result_barrios.getString("nacionalidad_extranjera"));
					barrios.setRenta_anual(result_barrios.getString("renta_anual"));
					barrios.setBibliotecas(result_barrios.getString("bibliotecas"));
					barrios.setCentros_deportivos(result_barrios.getString("centros_deportivos"));
					barrios.setAreas_verdes(result_barrios.getString("areas_verdes"));
					barrios.setHosteleria(result_barrios.getString("hosteleria"));
					barrios.setCentros_sanitarios(result_barrios.getString("centros_sanitarios"));
					barrios.setAparcamientos(result_barrios.getString("aparcamientos"));
					barrios.setColegios(result_barrios.getString("colegios"));
					barrios.setEstaciones(result_barrios.getString("estaciones"));
					barrios.setValor_m2(result_barrios.getString("valor_m2"));
					barrios.setString_imagen(result_barrios.getString("string_imagen"));
					datos_barrios.add(barrios);
				} 
				return datos_barrios;
				
			} catch(Exception e) {
				System.out.println(e); 
			} finally {
				
			    try { result_barrios.close(); System.out.println("Se ha cerrado el resultset");} catch (Exception e) { /* ignored */ }
			    try { state_barrios.close(); System.out.println("Se ha cerrado el statement");} catch (Exception e) { /* ignored */ }
			    try { conn.close(); System.out.println("Se ha cerrado la conexión");} catch (Exception e) { /* ignored */ }
			}
			return datos_barrios;
		} else {
			return datos_barrios;
		}
	}

}
