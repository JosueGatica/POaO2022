package ar.edu.unlu.ejercicio6;

import java.util.ArrayList;

public class Jugador {
	
	private ArrayList<Palabra> Palabras = new ArrayList<Palabra>();
	
	private String nombre;
	
	public Jugador(String nombreJugador) {
		nombre = nombreJugador;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarPalabra(String palabraAgregar) {
		Palabra nuevaPalabra = new Palabra(palabraAgregar);
		Palabras.add(nuevaPalabra);
	}
	
	public String mostrarPalabras() {
		String s = "";
		for (int i = 0; i < Palabras.size(); i++) {
			s = s + "Palabra: " + Palabras.get(i).getPalabra() +
					" Puntaje: " + Palabras.get(i).puntaje() + "\n";
		}
		s = s + "Total: " + puntajeTotal();
		return s;
	}

	public int puntajeTotal() {
		int total = 0;
		for (int i = 0; i < Palabras.size(); i++) {
			total = total + Palabras.get(i).puntaje();
		}
		return total;
	}
}
