package clases;

import com.vaadin.flow.component.html.Image;

public class TablaBarrios {

	// VARIABLES
	private int id;
	private String barrio;
	private String distrito;
	private String edad_media;
	private String nacionalidad_espanola;
	private String nacionalidad_extranjera;
	private String renta_anual;
	private String bibliotecas;
	private String centros_deportivos;
	private String areas_verdes;
	private String hosteleria;
	private String centros_sanitarios;
	private String aparcamientos;
	private String colegios;
	private String estaciones;
	private String valor_m2;
	private String habitantes;
	private String string_imagen;
	private Image imagen_b;
	private String detalles;

	
	// COMBOBOX EDAD MEDIA
	// Español
	public enum EdadPos {
		Joven, Adulta;
	}
	private EdadPos edadPos;

	// Ingles
	public enum AgePos {
		Young, Adult;
	}
	private AgePos agePos;
	

	// COMBOBOX NACIONALIDAD
	// Español
	public enum NacionalidadPos {
		Alta, Baja;
	}
	private NacionalidadPos nacionalidadPos;

	// Ingles
	public enum NacionalityPos {
		High, Low;
	}
	private NacionalityPos nacionalityPos;

	
	// COMBOBOX RENTA
	// Español
	public enum RentaPos {
		Alta, Media, Baja;
	}
	private RentaPos rentaPos;

	// Ingles
	public enum RentPos {
		High, Average, Low;
	}
	private RentPos rentPos;
	
	// COMBOBOX METRO CUADRADO
		//Español
		public enum MetroPos {
			Alto, Medio, Bajo;
		}
		private MetroPos metroPos;
		
		//Ingles
		public enum MetroIPos {
			High, Average, Low;
		}
		private MetroIPos metroIPos;
	
	private String centrosSanitariosPos;
	
	private String healthCentersPos;
	
	private String hosteleriaPos;
	
	private String restaurantPos;
	
	private String aparcamientoPos;
	
	private String parkingPos;
	
	private String verdesPos;
	
	private String greenPos;
	
	private String colegiosPos;
	
	private String collegePos;
	
	private String estacionesPos;
	
	private String stationsPos;
	
	private String bibliotecasPos;
	
	private String libraryPos;
	
	private String centrosDeportivosPos;
	
	private String scentersPos;
	
	

	// CONSTRUCTOR DATOS
	// CONSTRUCTOR TABLA
	public TablaBarrios(String barrio, String distrito, String detalles) {
		super();
		this.barrio = barrio;
		this.distrito = distrito;
		this.detalles = detalles;
	}

	public TablaBarrios(int id, String barrio, String distrito, String edad_media, String nacionalidad_espanola,
			String nacionalidad_extranjera, String renta_anual, String bibliotecas, String centros_deportivos,
			String areas_verdes, String hosteleria, String centros_sanitarios, String aparcamientos, String colegios,
			String estaciones, String valor_m2) {
		super();
		this.id = id;
		this.barrio = barrio;
		this.distrito = distrito;
		this.edad_media = edad_media;
		this.nacionalidad_espanola = nacionalidad_espanola;
		this.nacionalidad_extranjera = nacionalidad_extranjera;
		this.renta_anual = renta_anual;
		this.bibliotecas = bibliotecas;
		this.centros_deportivos = centros_deportivos;
		this.areas_verdes = areas_verdes;
		this.hosteleria = hosteleria;
		this.centros_sanitarios = centros_sanitarios;
		this.aparcamientos = aparcamientos;
		this.colegios = colegios;
		this.estaciones = estaciones;
		this.valor_m2 = valor_m2;
	}

	public TablaBarrios(int id, String distrito, String habitantes) {
		super();
		this.id = id;
		this.distrito = distrito;
		this.habitantes = habitantes;
	}

	public TablaBarrios() {

	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEdad_media() {
		return edad_media;
	}

	public void setEdad_media(String edad_media) {
		this.edad_media = edad_media;
	}

	public String getNacionalidad_espanola() {
		return nacionalidad_espanola;
	}

	public void setNacionalidad_espanola(String nacionalidad_espanola) {
		this.nacionalidad_espanola = nacionalidad_espanola;
	}

	public String getNacionalidad_extranjera() {
		return nacionalidad_extranjera;
	}

	public void setNacionalidad_extranjera(String nacionalidad_extranjera) {
		this.nacionalidad_extranjera = nacionalidad_extranjera;
	}

	public String getRenta_anual() {
		return renta_anual;
	}

	public void setRenta_anual(String renta_anual) {
		this.renta_anual = renta_anual;
	}

	public String getBibliotecas() {
		return bibliotecas;
	}

	public void setBibliotecas(String bibliotecas) {
		this.bibliotecas = bibliotecas;
	}

	public String getCentros_deportivos() {
		return centros_deportivos;
	}

	public void setCentros_deportivos(String centros_deportivos) {
		this.centros_deportivos = centros_deportivos;
	}

	public String getAreas_verdes() {
		return areas_verdes;
	}

	public void setAreas_verdes(String areas_verdes) {
		this.areas_verdes = areas_verdes;
	}

	public String getColegios() {
		return colegios;
	}

	public void setColegios(String colegios) {
		this.colegios = colegios;
	}

	public String getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(String estaciones) {
		this.estaciones = estaciones;
	}

	public String getValor_m2() {
		return valor_m2;
	}

	public void setValor_m2(String valor_m2) {
		this.valor_m2 = valor_m2;
	}

	public String getHosteleria() {
		return hosteleria;
	}

	public void setHosteleria(String hosteleria) {
		this.hosteleria = hosteleria;
	}

	public String getCentros_sanitarios() {
		return centros_sanitarios;
	}

	public void setCentros_sanitarios(String centros_sanitarios) {
		this.centros_sanitarios = centros_sanitarios;
	}

	public String getAparcamientos() {
		return aparcamientos;
	}

	public void setAparcamientos(String aparcamientos) {
		this.aparcamientos = aparcamientos;
	}

	public String getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(String habitantes) {
		this.habitantes = habitantes;
	}

	public String getDetalles() {
		detalles = "Ver detalles";
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getString_imagen() {
		return string_imagen;
	}

	public void setString_imagen(String string_imagen) {
		obtenerImagen(string_imagen);
		this.string_imagen = string_imagen;
	}

	public Image getImagen() {
		return imagen_b;
	}

	public void setImagen(Image imagen) {
		imagen.setWidth("60px");
		imagen.setHeight("70px");
		this.imagen_b = imagen;
	}

	public void obtenerImagen(String enlace) {
		Image imagen = new Image(enlace, "Imagen");
		setImagen(imagen);
	}

	public EdadPos getEdadPos() {
		return edadPos;
	}

	public void setEdadPos(EdadPos edadpos) {
		this.edadPos = edadpos;
	}

	public NacionalidadPos getNacionalidadPos() {
		return nacionalidadPos;
	}

	public void setNacionalidadPos(NacionalidadPos nacionalidadPos) {
		this.nacionalidadPos = nacionalidadPos;
	}

	public RentaPos getRentaPos() {
		return rentaPos;
	}

	public void setRentaPos(RentaPos rentaPos) {
		this.rentaPos = rentaPos;
	}

	public MetroPos getMetroPos() {
		return metroPos;
	}

	public void setMetroPos(MetroPos metroPos) {
		this.metroPos = metroPos;
	}
	
	public Image getImagen_b() {
		return imagen_b;
	}

	public void setImagen_b(Image imagen_b) {
		this.imagen_b = imagen_b;
	}

	public AgePos getAgePos() {
		return agePos;
	}

	public void setAgePos(AgePos agePos) {
		this.agePos = agePos;
	}

	public NacionalityPos getNacionalityPos() {
		return nacionalityPos;
	}

	public void setNacionalityPos(NacionalityPos nacionalityPos) {
		this.nacionalityPos = nacionalityPos;
	}

	public RentPos getRentPos() {
		return rentPos;
	}

	public void setRentPos(RentPos rentPos) {
		this.rentPos = rentPos;
	}
	
	public MetroIPos getMetroIPos() {
		return metroIPos;
	}

	public void setMetroIPos(MetroIPos metroIPos) {
		this.metroIPos = metroIPos;
	}

	public String getCentrosSanitariosPos() {
		return centrosSanitariosPos;
	}

	public void setCentrosSanitariosPos(String centrosSanitariosPos) {
		this.centrosSanitariosPos = centrosSanitariosPos;
	}

	public String getHealthCentersPos() {
		return healthCentersPos;
	}

	public void setHealthCentersPos(String healthCentersPos) {
		this.healthCentersPos = healthCentersPos;
	}

	public String getHosteleriaPos() {
		return hosteleriaPos;
	}

	public void setHosteleriaPos(String hosteleriaPos) {
		this.hosteleriaPos = hosteleriaPos;
	}

	public String getRestaurantPos() {
		return restaurantPos;
	}

	public void setRestaurantPos(String restaurantPos) {
		this.restaurantPos = restaurantPos;
	}

	public String getAparcamientoPos() {
		return aparcamientoPos;
	}

	public void setAparcamientoPos(String aparcamientoPos) {
		this.aparcamientoPos = aparcamientoPos;
	}

	public String getParkingPos() {
		return parkingPos;
	}

	public void setParkingPos(String parkingPos) {
		this.parkingPos = parkingPos;
	}

	public String getVerdesPos() {
		return verdesPos;
	}

	public void setVerdesPos(String verdesPos) {
		this.verdesPos = verdesPos;
	}

	public String getGreenPos() {
		return greenPos;
	}

	public void setGreenPos(String greenPos) {
		this.greenPos = greenPos;
	}

	public String getColegiosPos() {
		return colegiosPos;
	}

	public void setColegiosPos(String colegiosPos) {
		this.colegiosPos = colegiosPos;
	}

	public String getCollegePos() {
		return collegePos;
	}

	public void setCollegePos(String collegePos) {
		this.collegePos = collegePos;
	}

	public String getEstacionesPos() {
		return estacionesPos;
	}

	public void setEstacionesPos(String estacionesPos) {
		this.estacionesPos = estacionesPos;
	}

	public String getStationsPos() {
		return stationsPos;
	}

	public void setStationsPos(String stationsPos) {
		this.stationsPos = stationsPos;
	}

	public String getBibliotecasPos() {
		return bibliotecasPos;
	}

	public void setBibliotecasPos(String bibliotecasPos) {
		this.bibliotecasPos = bibliotecasPos;
	}

	public String getLibraryPos() {
		return libraryPos;
	}

	public void setLibraryPos(String libraryPos) {
		this.libraryPos = libraryPos;
	}

	public String getCentrosDeportivosPos() {
		return centrosDeportivosPos;
	}

	public void setCentrosDeportivosPos(String centrosDeportivosPos) {
		this.centrosDeportivosPos = centrosDeportivosPos;
	}

	public String getScentersPos() {
		return scentersPos;
	}

	public void setScentersPos(String scentersPos) {
		this.scentersPos = scentersPos;
	}
	
	
}
