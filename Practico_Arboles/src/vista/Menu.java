package vista;

import java.util.Scanner;
import lib.*;
import modelo.Consultor;
import estructuras.ListaDoble;


public class Menu {

	private static Scanner scanner = new Scanner(System.in); 
	private static int select = -1; 
	static ListaDoble listaRequerimientos=new ListaDoble();
	static ListaDoble Productos=new ListaDoble();
	static ListaDoble Clientes=new ListaDoble();
	static ListaDoble Consultores=new ListaDoble();
	static Consultor cons1=new Consultor("Juan", "Perez");
	static Consultor cons2=new Consultor("Tom", "Ate");
	static Consultor cons3=new Consultor("Armando", "Paredes");
	
	
	public static void mostrarMenu() {
	
		Consultores.Insertar(cons1);
		Consultores.Insertar(cons2);
		Consultores.Insertar(cons3);
		try {
		
		while(select != 0){
			System.out.println("Elija opción:\n1.- Registrar Producto\n" +
					"2.- Alta Cliente\n" +
					"3.- Alta Requerimientos\n" +
					"4.- Cambiar Estado (Requerimientos)\n" +
					"5.- Listar Pedientes\n" +
					"6.- Listar En Proceso" +
					"0.- Salir");
			
			String sel=scanner.nextLine();
				lib.Validacion.numeroCorrecto(sel);
			select = Integer.parseInt(sel); 
			
			switch(select){
			case 1: 
				Operaciones.registrarProducto(Productos);
				break;
			case 2: 
				Operaciones.registrarCliente(Clientes,Productos);
				break;
			case 3: 
				Operaciones.registrarRequerimiento(listaRequerimientos, Clientes, Consultores);
				break;
			case 4: 
				Operaciones.cambiarEstados(listaRequerimientos);
				break;
			case 5:
				Operaciones.listarPendientes(listaRequerimientos);
				break;
			case 6:
				Operaciones.listarEnProceso(listaRequerimientos);
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
