package clases;

public class Comentarios {

	private int id;
	private String nombre;
	private String comentario;
	private String barrioC
	
	public Comentarios() {
		
	}
		
	public Comentarios(String nombre, String comentario, String barrioC) {

		this.nombre = nombre;
		this.comentario = comentario;
		this.barrioC = barrioC;
	}
	public Comentarios(int id, Str
ing nombre, String comentario, String barrioC) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.comentario = comentario;
		this.barrioC = barrioC;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getBarrioC() {
		return barrioC;
	}

	public void setBarrioC(String barrioC) {
		this.barrioC = barrioC;
	}	

	public void printComentario() {
		System.out.prinln(Comentario)
	}
}
