package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import clases.TablaBarrios;


public class BarriosService {

		private estatico BarriosService instance;
		private Lectura_barrios datos_barrios = Lectura_barrios();
		
		public List<TablaBarrios> fetchAll() {

	        return datos_barrios.getBarrios();

		}
		
		public static BarriosService getInstance() {
			if (instance == null) {
				instance = new BarriosService();
				instance.fetchAll();
			}
			return instance;
		}


}
