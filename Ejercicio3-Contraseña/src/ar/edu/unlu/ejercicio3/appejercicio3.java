package ar.edu.unlu.ejercicio3;

import java.util.ArrayList;

import java.util.Scanner;


public class appejercicio3 {

	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int longitud, cantidad;
		int opcion = 1;
		String s;

		Scanner sc = new Scanner(System.in);
		
		//Creacion del arreglod de contrase�as
		ArrayList<Contrase�a> Contrase�asGuardadas = new ArrayList<Contrase�a>();
		
		do {
		//Tomo la longitud y la cantidad de contrase�as a crear
		System.out.println("Creador de contrase�as");
		System.out.println("Determinar longitud:");
		longitud = sc.nextInt();
		System.out.println("Cantidad de contrase�a a crear:");
		cantidad = sc.nextInt();
		
		//Voy metiendo en el array a medida que creo
		for (int i = 0; i < cantidad; i++) {
			Contrase�a password = new Contrase�a(longitud);
			Contrase�asGuardadas.add(password);
		}
		
		System.out.println("Contrase�as generadas");
		
		System.out.println("Mostrando contrase�as:");
		
		//Muestra la contrase�a y el tipo que es
		for (int i = 0; i < Contrase�asGuardadas.size(); i++) {
			//Mando el mensaje consultando el tipo de contrase�a
			//que es
			if (Contrase�asGuardadas.get(i).tipoContrase�a()) {
				s = "Contrase�a " + Contrase�asGuardadas.get(i).getContrase�a() + " - Fuerte";
			}
			else {
				s = "Contrase�a " + Contrase�asGuardadas.get(i).getContrase�a() + " - Debil";
			}
			System.out.println(s);
			System.out.println("");
		}
		
		//Consultar si queire seguir creando contrase�as
		System.out.println("Quiere seguir creando contrase�as? ");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		opcion = sc.nextInt();
		} while (opcion != 2);
	
		System.out.println("Adios!");
		sc.close();
	}

}
