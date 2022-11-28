package ar.edu.unlu.corazones.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.corazones.observer.Observable;
import ar.edu.unlu.corazones.observer.Observador;

public class Corazones implements Observable{
	
	private static final int puntajeMaximo = 50;
	private static final int cantJugadores = 4;
	private static final int cantJugadasPorRonda = 13; //TESTING
	private static final int cantCartasRepartidas = 13; //TESTING
	private static final int maximoPasajeDeCartas = 3;
	

	/**
	 * Atributos
	 */
	
	//Array donde estaran los jugadores
	private Jugador[] jugadores; 
	
	//Mazo del juego
	private Mazo mazo;
	
	//Rondas jugadas
	private int ronda;
	
	//Mesa donde se tiraran las cartas del juego
	private Mesa mesa;
	
	//
	private int posJugadorActual;
	private int posCartaATirar;
	private Jugador jugadorGanadorMano;
	
	private List<Observador> observadores;
	
	/**
	 * Comportamiento
	 */
	
	//Constructor
	public Corazones() {
		//Inicializo las rondas en 0
		ronda = 0;
		//Creo la instancia de los jugadores
		jugadores = new Jugador[cantJugadores];	
		this.observadores = new ArrayList<>();
		/**
		 * Cargo default
		 */
		agregarJugadores("a");
		agregarJugadores("b");
		agregarJugadores("c");
		agregarJugadores("d");
	}
	
	/**
	 * INICIO DE JUEGO:
	 * .Tiene que dar por iniciado el juego y terminar una vez que se supere
	 * la cantidad maxima de puntos
	 * .Tiene que crear las rondas cada vez que termina una
	 * .Tiene que mostrar al jugador ganador
	 */
	public void inicarJuego() {
		//Inicializo la ronda
		ronda = 1;
		boolean seTermino = false;
		while (!seTermino) {
			iniciarRonda();
			if (hayGanador()) {
				seTermino = true;
			} else {
				//Notifico el fin de ronda y muestro los puntajes
				notificar(EventosCorazones.FIN_DE_RONDA);
				ronda ++;
			}
		}
	}
	
	/**
	 * INICIO DE LA RONDA
	 * .Tiene que crear el mazo para comenzar
	 * .Tiene que repartir las 13 cartas a cada jugador
	 * .Tiene que solicitar las cartas la jugador para que las tire en la mesa
	 * .Tiene que determinar que cartas es capaz de tirar
	 * .Tiene que determinar al ganador de cada jugada
	 */
	
	public void iniciarRonda() {
		//Creo el mazo
		mazo = new Mazo();
		//reparto las cartas a los jugadores
		repartirCartas();
		pasajeDeCartas();
		//Jugador jugadorGanadorMano = null;
		//Ciclo por todas las jugadas que hay en la ronda
		for(int jugada = 0; jugada < cantJugadasPorRonda; jugada++) {
			mesa = new Mesa(); //Creo la mesa donde se colocaran las 4 cartas
			if (jugada == 0) { //Primera jugada, se tira el 2 de trebol
				//Obtengo la posicion del jugador que tiene el 2 de trebol
				//y lo cargo en la mesa
				posJugadorActual = jugador2Trebol(); 
				//Obtengo al jugador del 2 de trebol
				jugadorGanadorMano = jugadores[posJugadorActual]; 
				}
			else { //Otra jugada que no sea la primera
				//Obtengo la posicion del jugador que es mano
				posJugadorActual = jugadorGanadorMano.getPosicionFisica();
				//Le pido la carta a jugar
				notificar(EventosCorazones.PEDIR_CARTA);
				jugarCarta(posCartaATirar);
				/**
				 * Pido la carta al jugador que es mano
				 */
			}
			//Itero con los jugadores restantes, para pedir que tiren las cartas
			//Siempre juega el jugador que esta a la izquierda del que tiro
			int i = 0;
			//Pido la posicion del jugador que realiza la primera jugada
			posJugadorActual = jugadorGanadorMano.getPosicionFisica();		
			//itero con los jugadores restantes
			while (i < 3) {
				//Pido el proximo jugador (el de la izquierda)
				Jugador proxJugador = obtenerIzquierda(jugadores[posJugadorActual]);
				/**
				 * Solicito la carta
				 */
				posJugadorActual = proxJugador.getPosicionFisica();
				notificar(EventosCorazones.PEDIR_CARTA);
				jugarCarta(posCartaATirar);
				//Aumento contador
				i++;
			}
			
			//Determino el ganador
			jugadorGanadorMano = jugadores[mesa.determinarGanador()];
			notificar(EventosCorazones.GANADOR_JUGADA);
			//Cargo las cartas al ganador
			jugadorGanadorMano.recibirCartasRecogida(mesa.getCartasJugadasEnMesa());
		}
		//Calculo los puntajes de los jugadores
		calcularPuntajes();
	}
	
	public void setposCartaATirar(int posCartaATirar2) {
		this.posCartaATirar = posCartaATirar2;
	}
	
	//Metodo privada que le pide la carta a los jugadores
	public void jugarCarta(int posCartaATirar2) {
		Carta carta = jugadores[posJugadorActual].obtenerCarta(posCartaATirar2);
		mesa.recibirCartaTirada(posJugadorActual, carta);
		jugadores[posJugadorActual].tirarCarta(carta);
	}
	
	//Metodo que se encarga de decirme quien es el jugador que tiene
	//el 2 de trebol, ademas de agregarlo a la mesa y tirarlo de la mano
	//del jugador
	private int jugador2Trebol() {
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < jugadores.length) {
			if (jugadores[i].tengoEl2DeTrebol()) {
				encontrado = true;
				mesa.recibirCartaTirada(i, new Carta(Palo.TREBOL,2));
				jugadores[i].tirar2Trebol();
			} else {i++;}
		}
		return i;
	}
	
	//Metodo privado que determina si existe o no un jugador
	//en el juego
	private boolean hayGanador() {
		boolean hayGanador = false;
		int pos = 0;
		while (!hayGanador && pos < jugadores.length) {
			if (jugadores[0].getPuntaje() > puntajeMaximo) {
				hayGanador = true;
			}
			else {
				pos ++;
			}
		}
		return hayGanador;
	}

	//Metodo que agrega jugadores al juego,
	//segun lo que devuelva indica si se cargo de forma correcta o no el jugador
	//true = se cargo
	//false = no se cargo porque ya estan todos los jugadores
	public boolean agregarJugadores(String nombre) {
		boolean hayEspacio = false;
		int pos = 0;
		while(!hayEspacio && pos < jugadores.length) {
			if (jugadores[pos] == null) {
				jugadores[pos] = new Jugador(nombre,pos);
				hayEspacio = true;
			}
			else {
				pos++;
			}
		}
		return hayEspacio;
	}
	
	//Metodo que modifica un jugador en el juego
	//Solamente modifica si existe un jugador en la posicion que quiere
	//modificar el usuario, sino no lo hace
	public boolean reemplazarJugadores(String nombre,int posicion) {
		boolean seReemplazo = false;
		//Chequeo si no hay ningun jugador, o el referencial apunta a nulo
		if (!(jugadores[posicion - 1] == null)){
			//Cambia la bandera y modifico al jugador
			seReemplazo = true;
			jugadores[posicion - 1].setNombre(nombre);
		}
		return seReemplazo;
	}
	
	//Metodo que me muestra los jugadores que hay en el juego
	public String mostrarJugadores() {
		String s = "";
		int i = 0;
		boolean vacio = false;
		while (!vacio && i < jugadores.length) {
			if (jugadores[i] != null) {
				s += "Jugador: " + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n";
				i++;
			} else vacio = true;
		}
		return s;	
	}
		
	
	//Metodo que me muestra las mano de los jugadores
	public String mostrarManoJugadores() {
		String s = "";
		for(int i = 0; i < jugadores.length; i++) {
			s += "Jugador: " + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n" +
					jugadores[i].mostrarMano() + "\n";
		}
		return s;
	}


	//Metodo que reparte las cartas a cada jugador, como 
	//se hace de forma habitual
	//1 1 1 1, 2 2 2 2, 3 3 3 3, etc.
	private void repartirCartas() {
		for(int i = 0; i < cantCartasRepartidas; i++) {
			for(Jugador jugador : jugadores) {
				jugador.recibirCarta(mazo.sacarCarta());
			} 
		}
	}
	
	//Metodo para obtener el jugador que esta a la izquierda
	private Jugador obtenerIzquierda(Jugador jugador) {
		return jugadores[jugador.obtenerIzquierda()];
	}
	
	//Metodo quer realiza el pasaje de cartas entre usuarios, segun el
	//numero de ronda
	public void pasajeDeCartas() {
		int pasaje = this.ronda % 4;
		/**
		 * CASOS:
		 * 	1. Pasaje de 0: Se realiza el pasaje a la izquierda
		 *  2. Pasaje de 1: Se realiza el pasaje al frente
		 *  3. Pasaje de 2: Se realiza el pasaje a la derecha
		 *  4. Pasaje de 3: No hay pasaje
		 */
		
		//Primer for por la cantida de jugadores
		for(int jugador = 0; jugador < jugadores.length; jugador++) {
			//Segundo for por la cantidad de cartas que se van a pasar
			for (int cartasPasadas = 0; cartasPasadas < maximoPasajeDeCartas; cartasPasadas++ ) {
				//Recibo la carta
				Carta carta = jugadores[jugador].cartaRandom();
				//Carta carta = jugadores[jugador].tirarCarta(null);
				jugadores[jugador].tirarCarta(carta);
				if (pasaje == 0) { //CASO 1: A LA IZQUIERDA
					jugadores[jugadores[jugador].obtenerIzquierda()].recibirCarta(carta);
				} else if (pasaje == 1) { //CASO 2: AL FRENTE
					jugadores[jugadores[jugadores[jugador]
							.obtenerIzquierda()].obtenerIzquierda()].recibirCarta(carta);
				} else { //CASO 3: A LA DERECHA
						jugadores[jugadores[jugadores[jugadores[jugador]
								.obtenerIzquierda()].obtenerIzquierda()].
						          obtenerIzquierda()].recibirCarta(carta);
				}
			}
		}
	}

	//Metodo que calcula el puntaje de cada jugador
	public void calcularPuntajes() {
		for(int i = 0; i < jugadores.length; i++) {
			jugadores[i].contarPuntos();
		}
	}

	//Metodo que me muestra los puntajes de cada jugador
	public String mostrarPuntajes() {
		String s = "Ronda " + this.ronda + "\n" ;
		for(int i = 0; i < jugadores.length; i++) {
			s += "Jugador:" + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n" +
					jugadores[i].getPuntaje() + "\n";
		}
		return s;
	}
	
	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}

	@Override
	public void agregadorObservador(Observador observador) {
		this.observadores.add(observador);
	}

	public String cartasEnMesa() {
		return mesa.mostrarCartasEnMesa();
	}
	
	public String cartasJugadorActual() {
		return this.jugadores[posJugadorActual].mostrarMano();
	}
	
	public String jugadorActual() {
		return jugadores[posJugadorActual].mostrarNombre();
	}

	public String ganadorJugada() {
		return this.jugadorGanadorMano.mostrarNombre();
	}
}
