package ar.edu.unlu.ejercicio10;

import java.time.Duration; //Libreria para el calculo entre fechas
import java.time.LocalDate;

public class PlazoFijo {
	private LocalDate fechaInicio;
	
	private int dias;
	
	private int monto;
	
	private int interes;
	
	private CuentaNormal ctaNormal;
	
	public PlazoFijo(LocalDate fechaInicioPF, int diasPF, int montoPF, int interesPF)
	{
		fechaInicio = fechaInicioPF;
		dias = diasPF;
		monto = montoPF;
		interes = interesPF;
	}
	
	public int calcularIntereses() {
		return interes;
	}
	
	public boolean estaVencido() {
		LocalDate fechaactual = LocalDate.now();
		Duration diff = Duration.between(fechaInicio.atStartOfDay(), fechaactual.atStartOfDay());
		long diffDays = diff.toDays();
		return (dias > diffDays);
	}
}
