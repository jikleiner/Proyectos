package main;

import java.util.ArrayList;
import java.util.Scanner;

import estructuras.ArbolClientes;
import estructuras.Nodo;
import modelo.Cliente;
import modelo.Domicilio;
import modelo.Vehiculo;


public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int sel=-1;
	public static ArbolClientes arbolCli=new ArbolClientes();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(sel != 0){
			System.out.println("Elija opción:\n1.- cargar por código Árbol Binario de Clientes(pto.2)\n" +
					"2.- agregar por código para el cliente 150 su dirección, y agregar 5 vehículos(pto. 3)\n" +
					"3.- eliminar el cliente 90 del Arbol e imprimir en consola pre-Orden (pto. 4)\n" +
					"4.- imprimir post-Orden nombre y apellido de los Clientes del Arbol Clientes (pto. 5)\n" +
					"5.- imprimir por pantalla un mensaje si el cliente 150 tiene un auto con patente “AA 000 BB”.(pto. 5))\n" +
					"0.- Salir");
			
			String sele=sc.nextLine();
			sel = Integer.parseInt(sele); 
				
			switch(sel){
			case 1:
				Cliente cl1=new Cliente(100, "matias", "bueno", null);
				arbolCli.insertar(cl1);
				Cliente cl2=new Cliente(130, "jose", "kleiner", null);
				arbolCli.insertar(cl2);
				Cliente cl3=new Cliente(90, "gaston", "de la cruz", null);
				arbolCli.insertar(cl3);
				Cliente cl4=new Cliente(80, "facundo", "cacerez", null);
				arbolCli.insertar(cl4);
				Cliente cl5=new Cliente(150, "luciano", "triputti", null);
				arbolCli.insertar(cl5);
				Cliente cl6=new Cliente(95, "alexia", "gallo", null);
				arbolCli.insertar(cl6);
				arbolCli.recorrerPreOrden();
				break;
			case 2:
				Nodo a=arbolCli.buscar(new Cliente(150));
				((Cliente) a.getDato()).setDomicilio(new Domicilio("calle", 123, "barrio"));
				Vehiculo ve1=new Vehiculo("AA000BB", 2000, "ford");
				((Cliente) a.getDato()).getVehiculos().insertar(ve1, "000");
				Vehiculo ve2=new Vehiculo("AB123BE", 2010, "renault");
				((Cliente) a.getDato()).getVehiculos().insertar(ve2, "123");
				Vehiculo ve3=new Vehiculo("AC321BD", 2005, "fiat");
				((Cliente) a.getDato()).getVehiculos().insertar(ve3, "321");
				Vehiculo ve4=new Vehiculo("AD456BC", 2012, "chevrolet");
				((Cliente) a.getDato()).getVehiculos().insertar(ve4, "456");
				Vehiculo ve5=new Vehiculo("AE654BA", 2007, "peugeot");
				((Cliente) a.getDato()).getVehiculos().insertar(ve5, "654");
				break;
			case 3:
				arbolCli.eliminar(new Cliente(90));
				arbolCli.recorrerPreOrden();
				break;
			case 4:
				ArrayList<Cliente> ar=arbolCli.recorrerPostOrdenCliente();
				for(Cliente c:ar){
					System.out.println(c.getNombre()+" "+c.getApellido());
				}
				break;
			case 5:
				if(arbolCli.buscarVehiculo(new Cliente(150), "000")==true){
					System.out.println("el cliente 150 ´´SI´´ tiene vehiculo con con patente AA 000 BB");
				}else{
					System.out.println("el cliente 150 ´´NO´´ posee vehiculo con patente AA 000 BB");
				}
				break;
			case 0: 
				System.exit(0);;
				break;
			default:
				System.out.println("Número invalido");
				break;
			}
				
		}

	}
}

