package clases;

public class Formulario {

	//VARIABLES
	private String edad_media;
	private String nacionalidad;
	private String renta_neta;
	private int valor_m2;
	private String hosteleria;
	private String areas_verdes;
	private String colegios;
	private String bibliotecas;
	private String aparcamientos;
	private String estaciones;
	private String centros_sanitarios;
	private String centros_deportivos;
	
	
	// CONSTRUCTORES
	
	public Formulario() {
		super();
	}

	public Formulario(String edad_media, String nacionalidad, String renta_neta, int valor_m2, String hosteleria,
			String areas_verdes, String colegios, String bibliotecas, String aparcamientos, String estaciones,
			String centros_sanitarios, String centros_deportivos) {
		super();
		this.edad_media = edad_media;
		this.nacionalidad = nacionalidad;
		this.renta_neta = renta_neta;
		this.valor_m2 = valor_m2;
		this.hosteleria = hosteleria;
		this.areas_verdes = areas_verdes;
		this.colegios = colegios;
		this.bibliotecas = bibliotecas;
		this.aparcamientos = aparcamientos;
		this.estaciones = estaciones;
		this.centros_sanitarios = centros_sanitarios;
		this.centros_deportivos = centros_deportivos;
	}


	// GETTERS Y SETTERS
	public String getEdad_media() {
		return edad_media;
	}
	public void setEdad_media(String edad_media) {
		this.edad_media = edad_media;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getRenta_neta() {
		return renta_neta;
	}
	public void setRenta_neta(String renta_neta) {
		this.renta_neta = renta_neta;
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
	public String getHosteleria() {
		return hosteleria;
	}

	public void setHosteleria(String hosteleria) {
		this.hosteleria = hosteleria;
	}

	public String getAparcamientos() {
		return aparcamientos;
	}

	public void setAparcamientos(String aparcamientos) {
		this.aparcamientos = aparcamientos;
	}

	public String getCentros_sanitarios() {
		return centros_sanitarios;
	}

	public void setCentros_sanitarios(String centros_sanitarios) {
		this.centros_sanitarios = centros_sanitarios;
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
	public int getValor_m2() {
		return valor_m2;
	}
	public void setValor_m2(int valor_m2) {
		this.valor_m2 = valor_m2;
	}
}
