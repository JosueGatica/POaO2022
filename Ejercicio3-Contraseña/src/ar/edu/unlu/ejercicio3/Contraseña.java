package ar.edu.unlu.ejercicio3;

//Clase contraseñas
public class Contraseña {
	
	//Atributos
	private String contraseña;
	
	private int longitud; 

	//Constructor
	public Contraseña(int tamano) {
		//Creo el string de los valores posibles
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"; //Todos los posibles caracteres
		//Creo un string builder, donde guardo la contraseña
		StringBuilder sb = new StringBuilder(tamano);
		
		//Recorro el tamaño del string
		for (int i = 0; i < tamano; i++) {
			//Guardo en index el char que obtuve para la contraseña
            int index = (int)(AlphaNumericString.length() * Math.random());
            //Lo pongo en el string
            sb.append(AlphaNumericString.charAt(index));}

		//Guardo el tamaño y la contraseña obtenida
		longitud = tamano;
		contraseña = sb.toString();
	}
	
	//Getters
	public String getContraseña() {
		return contraseña;
	}
	
	//Tipo de contraseña que es, fuerte o debil
	public boolean tipoContraseña() {
		//True = Fuerte
		//False = Debil
		int mayusculas = 0;
		int minusculas = 0;
		int numeros = 0;
		boolean tipo = false;
		
		//Recorro el string y voy consultar entre los char, si
		// es mayuscula, minuscula o un numero
		for (int contador = 0; contador < longitud; contador++) {
			if (contraseña.charAt(contador) >= 'a' &&
				contraseña.charAt(contador) <= 'z'){
				minusculas++;
				}
			if (contraseña.charAt(contador) >= 'A' &&
			contraseña.charAt(contador) <= 'Z'){
				mayusculas++;
				}
			if (contraseña.charAt(contador) >= '0' &&
			contraseña.charAt(contador) <= '9'){
				numeros++;
				}
			
			//Comprobar si es fuerte
			if (mayusculas > 2 && minusculas > 1 && numeros >= 2)
			{
				tipo = true;}
			}
		return tipo;
		
	}
}
