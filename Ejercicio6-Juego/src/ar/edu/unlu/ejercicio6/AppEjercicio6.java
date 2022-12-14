package ar.edu.unlu.ejercicio6;

import java.util.Scanner;

public class AppEjercicio6 {

	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion, posicion;
		String nombre, palabra;
		Scanner sc = new Scanner(System.in);
		Juego miJuego = new Juego();
		
		//Menu
		do {
			System.out.println("Ejercicio 6 - Juego de Palabras");
			System.out.println("1 - Mostrar jugadores");
			System.out.println("2 - Agregar jugador");
			System.out.println("3 - Agregar palabra a un jugador");
			System.out.println("4 - Mostrar puntos de un jugador");
			System.out.println("5 - Mostrar ganador del juego");
			System.out.println("0 - Salir");
			System.out.println("Opcion: ");
			opcion = sc.nextInt();
			
			switch (opcion){
				case 1: System.out.println(miJuego.getJugadores());
					break;
				case 2: 
					sc.nextLine(); //Limpio buffer
					System.out.println("Ingrese el nombre del nuevo jugador:");
					nombre = sc.nextLine();
					miJuego.agregarJugador(nombre);
					System.out.println("Nuevo jugador agregado!");
					break;
				case 3:
					System.out.println("Ingrese la posicion del jugador:");
					posicion = sc.nextInt();
					posicion = posicion - 1;
					System.out.println("Ingrese la palabra a agregar:");
					sc.nextLine(); //Limpio buffer
					palabra = sc.nextLine();
					miJuego.obtenerJugador(posicion).agregarPalabra(palabra);
					System.out.println("Palabra agregada!");
					break;
				case 4:
					System.out.println("Ingrese la posicion del jugador:");
					posicion = sc.nextInt();
					posicion = posicion - 1;
					System.out.println(miJuego.obtenerJugador(posicion).mostrarPalabras());
					break;
				case 5:
					System.out.println("El ganador es " + miJuego.darGanador() + "!!!");
					break;
			}
			
			sc.nextLine();
		} while (opcion != 0);
		
		sc.close();
	}

}
