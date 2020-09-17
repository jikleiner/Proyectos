package vista;


import java.util.ArrayList;
import java.util.Scanner;

import estructura.ListaSimple;
import modelo.Caja;
import modelo.Cliente;
import modelo.Sala;


public class Menu {
	
	static Scanner scanner = new Scanner(System.in); 
	static int select = -1; 
	static Operaciones ops;
	static ArrayList listaCliente=new ArrayList<Cliente>();
	static ListaSimple listaEntrada=new ListaSimple();
	static ArrayList<Caja> caja = new ArrayList();
	
	
	
	//menu de opciones para carga de datos
	public static void mostrarMenu() {
		
		
		while(select != 0){
			
			try{
				System.out.println("Elige opción:\n1.- Cargar Cliente" +
						"\n2.- Comprar entrada\n" +
						"3.- Comprar snack\n" +
						"4.- Recaudacion total por sala\n" +
						"5.- Ingreso por snacks \n" +
						"6.- Ingreso total \n" +
						"0.- Salir");
				
				select = Integer.parseInt(scanner.nextLine()); 
	
				
				switch(select){
				case 1: 
					ops.CargarCliente(listaCliente);
					break;
				case 2: 
					ops.ComprarEntrada(listaCliente,listaEntrada,caja);
					break;
				case 3: 
					ops.ComprarSnack(caja);
					break;
				case 4: 
					ops.CalcularMontoSala(caja);
					break;
				case 5: 
					ops.CalcularSnack(caja);
					break;
				case 6: 
					ops.CalcularIngresoTotal(caja);			
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n");
				
			}catch(Exception e){
				System.out.println(e.getMessage().toString());
			}
		}

	}
	



}
