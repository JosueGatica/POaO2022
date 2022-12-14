package ar.edu.unlu.ejercicio1;

public class Libro extends Publicacion{

	private Integer ISBN;
	
	private String autor;
	
	private Integer numPaginas;
	
	//Constructor
	public Libro(String nombre, String editor, String numeroTelefono, Integer aņoPublicacion, Integer numEjemplares,
			Integer iSBN, String autor, Integer numPaginas) {
		super(nombre, editor, numeroTelefono, aņoPublicacion, numEjemplares);
		this.ISBN = iSBN;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	//Getters y Setters
	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	//Mostrar
	@Override
	public String mostrar() {
		String s;
		s = "LIBRO" + "\n" + ".nombre: " + getNombre() + "\n" + ".editor: " + this.getEditor() + "\n" + 
				".telefono: " + this.getNumeroTelefono() + "\n" + ".Aņo: " + this.getAņoPublicacion() + "\n" +
				".ISBN: " + this.getISBN() + "\n" + ".autor: " + this.getAutor() + "\n" + ".numPaginas: " + this.getNumPaginas() + "\n" + 
				".ejemplares: " + this.getNumEjemplares() + "\n" + ".ejemplares prestado: " + this.getNumEjemplaresPrestados();
		return s;
	}
	
	
	
	

}
