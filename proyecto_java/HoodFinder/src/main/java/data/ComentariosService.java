package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import clases.Comentarios;
import clases.TablaBarrios;


public class ComentariosService {

		private static ComentariosService instance;
		private Lectura_comentarios datos_comentarios = new Lectura_comentarios();
		
		public List<Comentarios>() fetchAll() {

	        return datos_comentarios.getComentarios();

		}
		
		public static ComentariosService getInstance() {
			if (instance = null) {
				instance = new ComentariosService();
				Instance.fetchAll();
			}
			return instance;
		}


}
