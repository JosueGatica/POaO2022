package ar.edu.unlu.ejercicio1;

public abstract class Publicacion {
	String nombre;
	
	String editor;
	
	String numeroTelefono;
	
	Integer a�oPublicacion;
	
	//Constructor
	public Publicacion(String nombre, String editor, String numeroTelefono, Integer a�oPublicacion) {
		super();
		this.nombre = nombre;
		this.editor = editor;
		this.numeroTelefono = numeroTelefono;
		this.a�oPublicacion = a�oPublicacion;
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



	public Integer getA�oPublicacion() {
		return a�oPublicacion;
	}


	public void setA�oPublicacion(Integer a�oPublicacion) {
		this.a�oPublicacion = a�oPublicacion;
	}

	//Clase abstracta que me muestra la publicacion
	abstract public String mostrar();

	
	
}
