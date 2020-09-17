package lib;

public class Validacion {
	
	static String txt,n;
	
	//validad dni posee solo numeros
	public static void numeroCorrecto(String numero) throws NumerosException{
		if(!(numero.matches("[0-9]+"))){
			 throw new NumerosException("datos incorrectos(solo numeros)\n"); 
		}
	}	
}
