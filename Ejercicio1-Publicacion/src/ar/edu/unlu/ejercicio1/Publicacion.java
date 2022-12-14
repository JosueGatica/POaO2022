package ar.edu.unlu.ejercicio1;

public abstract class Publicacion {
	String nombre;
	
	String editor;
	
	String numeroTelefono;
	
	Integer aņoPublicacion;
	
	//Constructor
	public Publicacion(String nombre, String editor, String numeroTelefono, Integer aņoPublicacion) {
		super();
		this.nombre = nombre;
		this.editor = editor;
		this.numeroTelefono = numeroTelefono;
		this.aņoPublicacion = aņoPublicacion;
	}
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEditor() {
		return editor;
	}



	public void setEditor(String editor) {
		this.editor = editor;
	}



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public Integer getAņoPublicacion() {
		return aņoPublicacion;
	}


	public void setAņoPublicacion(Integer aņoPublicacion) {
		this.aņoPublicacion = aņoPublicacion;
	}

	//Clase abstracta que me muestra la publicacion
	abstract public String mostrar();

	
	
}
