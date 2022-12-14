package ar.edu.unlu.ejercicio10;

import java.time.LocalDate;

public class Compra {
	private int monto;

	private LocalDate fecha;
	
	private String concepto;
	
	private boolean paga;
	
	public Compra(int montoCompra, String conceptoCompra, LocalDate fechaCompra) {
		monto = montoCompra + (montoCompra*(5/100)); //Recargo 5%
		concepto = conceptoCompra;
		fecha = fechaCompra;
		paga = false;
	}
	public boolean estaPaga(){
		return paga;
	};
	
	public int getMonto() {
		return this.monto;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public String getConcepto() {
		return this.concepto;
	}
	
	public void calcularInteres() {
		
	};
	
	public void pagar(int montoapagar){
		if (montoapagar >= monto) {
			paga = true;
		}
		else monto = monto - montoapagar;
	}
}
