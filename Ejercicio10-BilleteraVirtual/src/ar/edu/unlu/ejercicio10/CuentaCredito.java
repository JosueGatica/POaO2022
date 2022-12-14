package ar.edu.unlu.ejercicio10;

import java.time.LocalDate;
import java.util.ArrayList;

public class CuentaCredito {
	private ArrayList<Compra> compras;
	
	private int limiteDeGastos = 10; //Fijo por el momento
	
	public void limiteGastos() {
		limiteDeGastos = limiteDeGastos - compras.size();
	}
	
	
	public void obtenerDeudaActual() {
		
	}
	
	/*Cada vez que realizo una compra, instancio el objeto compra y lo agrego a 
	mi lista de compras realizadas*/
	public void comprar(int monto, String concepto, LocalDate fecha) {
		Compra miCompra = new Compra(monto, concepto, fecha);
		compras.add(miCompra);
		limiteGastos();
	}
	
	public void abonar(int monto, int posicion) {
		compras.get(posicion).pagar(monto);
	}
	
}
