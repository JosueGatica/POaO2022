package ar.edu.unlu.ejercicio6;

import java.util.ArrayList;

public class Juego {

	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	public void agregarJugador(String nombre) {
		Jugador nuevoJugador = new Jugador(nombre);
		jugadores.add(nuevoJugador);
	}
	
	public String getJugadores() {
		String s = "";
		for (int i = 0; i < jugadores.size(); i++) {
			s = s + "" + (i + 1) + " - " + jugadores.get(i).getNombre() + "\n";
		}
		return s;
	}
	
	public Jugador obtenerJugador(int posicion) {
		return jugadores.get(posicion);
	}
	
	public String darGanador() { //Doy el ganador del juego
		String ganador = "";
		int puntajeGanador = 0;
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).puntajeTotal() > puntajeGanador) {
				puntajeGanador = jugadores.get(i).puntajeTotal();
				ganador = jugadores.get(i).getNombre();
			}
		}
		return ganador;
	}
}
