package ar.edu.unlu.ejercicio10;

import java.util.Scanner;

public class AppEjercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		int codigo, saldoCN, limCN;
		
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine(); //Limpio buffer
		System.out.println("Ingrese su nombre:");
		nombre = sc.nextLine();
		System.out.println("Ingrese el codigo:");
		codigo = sc.nextInt();
		System.out.println("Ingrese el saldo de la cuenta normal:");
		saldoCN = sc.nextInt();
		System.out.println("Ingrese el limite descubierto de la cuenta:");
		limCN = sc.nextInt();
		
		//Creacion del usuario
		Cliente Usuario = new Cliente(nombre,codigo,saldoCN,limCN);
		
		System.out.println(Usuario.getNombre());
		System.out.println(Usuario.getCodigo());
		
		sc.close();
	}

}
