package vista;

import java.util.ArrayList;
import java.util.Scanner;
import lib.*;
import modelo.Proveedor;
import modelo.Vendedor;
import estructuras.ListaDoble;


public class Menu {

	private static Scanner scanner = new Scanner(System.in); 
	private static int select = -1; 
	static ArrayList<Vendedor> ListaVend;
	static ArrayList<Proveedor> ListaProv;
	
	public static void mostrarMenu() {
	
		try {
		
		while(select != 0){
			System.out.println("Elija opción:\n1.- Cargar Proveedor\n" +
					"2.- Modificar Nombre de vendedor de un proveedor\n" +
					"3.- Eliminar vendedor de un proveedor\n" +
					"4.- Cambiar vendedor de un proveedor\n" +
					"5.- Listar proveedores sin vendedor\n" +
					"6.- Listar vendedores con menos de 3 telefonos\n" +
					"7.- Cargar vendedor\n" +
					"----------------------------------------------------\n"+
					"8.- calculo de numero factoria\n"+
					"9.- calculo de serie de fibonacci\n"+
					"0.- Salir");
			
			String sel=scanner.nextLine();
				lib.Validacion.numeroCorrecto(sel);
			select = Integer.parseInt(sel); 
			
			switch(select){
			case 1: 
				Operaciones.cargarProveedor(ListaProv,ListaVend);
				break;
			case 2: 
				Operaciones.modificarNombreVendedor(ListaProv,ListaVend);
				break;
			case 3: 
				Operaciones.eliminarVendedor(ListaProv);
				break;
			case 4: 
				Operaciones.cambiarVendedor(ListaProv,ListaVend);
				break;
			case 5:
				Operaciones.listarSinVendedor(ListaProv);
				break;
			case 6:
				Operaciones.listarMenosTresTel(ListaVend);
				break;
			case 7:
				Operaciones.cargarVendedor(ListaVend);
				break;
			case 8:
				System.out.println("ingrese numero a calcular:");
				String num=scanner.nextLine();
				int i=Integer.parseInt(num);
				System.out.println(Operaciones.factorial(i));
				break;
			case 9:
				System.out.println("ingrese numero a calcular secuencia:");
				String nu=scanner.nextLine();
				int n=Integer.parseInt(nu);
				System.out.println(Operaciones.fibonacci(n));
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
