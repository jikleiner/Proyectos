package vista;

import java.util.Scanner;
import lib.*;
import estructura.ListaDoble;


public class Menu {

	private static Scanner scanner = new Scanner(System.in); 
	private static int select = -1; 
	static ListaDoble listaInmuebles=new ListaDoble();
	
	
	public static void mostrarMenu() {
		
		try {
		
		while(select != 0){
			System.out.println("Elija opción:\n1.- xxxxxxxx\n" +
					"2.- xxxxxxxx\n" +
					"3.- xxxxxxxx\n" +
					"4.- xxxxxxxx\n" +
					"0.- xxxxxxxx");
			
			String sel=scanner.nextLine();
				lib.Validacion.numeroCorrecto(sel);
			select = Integer.parseInt(sel); 
			
			switch(select){
			case 1: 
				;
				break;
			case 2: 
				;
				break;
			case 3: 
				;
				break;
			case 4: 
				;
				break;
			case 0: 
				System.out.println("Adios!");
				break;
			default:
				System.out.println("Número no reconocido");break;
			}
			
			System.out.println("\n");
			
		}
		
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
