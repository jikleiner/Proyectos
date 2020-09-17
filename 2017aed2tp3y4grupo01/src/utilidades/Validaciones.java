package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Validaciones {	
	public static Scanner entrada = new Scanner(System.in);	
	
	public static int validarIntEntrada(){
		while (!entrada.hasNextInt()){ 
			entrada.next(); 
			System.out.println("Por favor, inserte solo números.");
		}
		return entrada.nextInt();		
	}		
	
	public static int validarIntEntradaConRango(int tope){
		    for (;;) {
		        if (! entrada.hasNextInt()) {
		            System.out.println("Por favor, inserte solo números");
		        } else {
		            int numero = entrada.nextInt();
		            if (numero >= 0 && numero <= tope)
		                return numero;
		            System.out.println("Debes ingresar un número dentro del rango");
		        }
		        entrada.nextLine(); 
		    }
	}	
	
	public static String validarStringEntradaconRango(int tope){	
		while (!entrada.next().matches("^[A-Fa-f ]+$")){ 			
				entrada.next(); 
				System.out.println("Por favor, inserte solo letras en el rango A-F.");							
			}	
		return entrada.next();
	}	
	
	
	public static int esEntero(String mensaje) {
		try {
			entrada = new Scanner(System.in);

			System.out.println(mensaje);
			int numero = entrada.nextInt();
			return numero;
			
			} catch (InputMismatchException | IllegalStateException e ) //IllegalStateException | NoSuchElementException
				{
				System.err.println("Por favor, ingrese solo numeros:");
				return esEntero(mensaje);
			}
		}
	
	
	public static String esString(String mensaje){
		try {
			entrada = new Scanner(System.in);
			
			System.out.println(mensaje);
			String string = entrada.nextLine();
			
			if(string == null || string.trim().equals("") || !string.matches("^[A-Za-z ]+$")){
				throw new Exception();
			}
			return string;
		} catch (Exception e) {
			System.err.println("Por favor, ingrese solo letras. No se admiten numeros ni símbolos.");
			return esString(mensaje);
		}
	}
	
	public static String stringSinEspacios(String mensaje){
		try {
			entrada = new Scanner(System.in);
			
			System.out.println(mensaje);
			String string = entrada.nextLine();
			
			if(string == null || string.trim().equals("")){
				throw new Exception();
			}
			return string;
		} catch (Exception e) {
			System.err.println("Por favor, ingrese texto.");
			return esString(mensaje);
		}
	}
	
}
