package lib;

public class Validacion {
	
	static String txt,n;
	
	//validad dni posee solo numeros
	public static void numeroCorrecto(String numero) throws NumerosException{
		if(!(numero.matches("[0-9]+"))){
			 throw new NumerosException("datos incorrectos(solo numeros)\n"); 
		}
	}
	
	//validar ingreso letras
	public static void soloLetras(String letras) throws letraException{
		if(!(letras.matches("[A-Za-z\\s]{2,}"))){
			throw new letraException("datos incorrectos(solo letras)"); 
		}
	}
	//validar cantidad digitos dni
	public static void cantidadDigitosDni(String digitos) throws CantidadDigitosException{
		char[] chars = digitos.toCharArray();

		int i=chars.length;
			if(i!=8){
				throw new CantidadDigitosException("el dni debe tener 8 digitos");
			}
	}
	
	//validar cantidad digitos legajo
	public static void cantidadDigitosLegajo(String digitos) throws CantidadDigitosLegajoException{
		char[] chars = digitos.toCharArray();

		int i=chars.length;
			if(i!=4){
				throw new CantidadDigitosLegajoException("el legajo debe tener 4 digitos");
			}
	}
	
	//validar que la nota este entre 1 y 10
	public static void notaCorrecta(String nota) throws notaException{
		int notaIngresada = Integer.parseInt(nota);
		if(notaIngresada > 10 || notaIngresada < 1){
			throw new notaException("la nota debe estar entre el rango de 1 y 10");
		}
	}
	
	public static void valEntero(String num){
		int n=0;
		txt= num;
		
		if(!txt.matches("[-]*[0-9]{0,}")){
		System.out.println("No ingreso un numero correcto intente de nuevo.");
			
		}
	}
	
	public static void valDouble(String msj){
		double n=0;
		txt=msj;
		
			if(!txt.matches("[0-9]*.[0-9]*")){
			System.out.println("No ingreso un numero correcto intente de nuevo.");
			
			}
		
		
	}
			

		public static void valFloat(String msj){
			float n=0;
			txt=msj;
			
				if(!txt.matches("[0-9]*.[0-9]*")){
				System.out.println("No ingreso un numero correcto intente de nuevo.");
				
				}
		
		}
		
		
}
