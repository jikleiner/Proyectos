package main;

import java.util.ArrayList;
import java.util.Scanner;

import estructuras.ArbolVehiculos;
import estructuras.Nodo;
import modelo.Conductor;
import modelo.EmpresaTransporte;
import modelo.Vehiculo;


public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int sel=-1;
	public static EmpresaTransporte e;
	public static ArbolVehiculos arbolV= new ArbolVehiculos();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(sel != 0){
			System.out.println("Elija opción:\n1.- cargar por código la Empresa “La Veloz”.(pto.2)\n" +
					"2.- agregar por código 3 conductores para el Vehículo ID 40.(pto. 3)\n" +
					"3.- eliminar el Vehículo 10 del Árbol Binario de Vehículos.(pto. 4)\n" +
					"4.- imprimir pre-Orden sólo la Patente y Modelo de los Vehículos.(pto. 5)\n" +
					"5.- imprimir por pantalla cuántos conductores tiene en total toda la Empresa.(pto. 6))\n" +
					"0.- Salir");
			
			String sele=sc.nextLine();
			sel = Integer.parseInt(sele); 
				
			switch(sel){
			case 1:
				e = new EmpresaTransporte("La Veloz", "30-12345678-9");
				Vehiculo v1 = new Vehiculo(20, "transit", "ford", "AA123B");
				e.getVehiculos().insertar(v1);
				Vehiculo v2 = new Vehiculo(10, "kangoo", "renault", "AB321A");
				e.getVehiculos().insertar(v2);
				Vehiculo v3 = new Vehiculo(30, "berlingo", "citroen", "AC334A");
				e.getVehiculos().insertar(v3);
				Vehiculo v4 = new Vehiculo(5, "qubo", "fiat", "AA723A");
				e.getVehiculos().insertar(v4);
				Vehiculo v5 = new Vehiculo(15, "partner", "peugeot", "AC111B");
				e.getVehiculos().insertar(v5);
				Vehiculo v6 = new Vehiculo(40, "fiorino", "fiat", "AC665C");
				e.getVehiculos().insertar(v6);
				e.getVehiculos().recorrerPreOrden();
				break;
			case 2:
				Conductor c1 = new Conductor(34768495, "jose", "kleiner");
				Conductor c2 = new Conductor(31838080, "florencio", "cardenas");
				Conductor c3 = new Conductor(12560383, "enrique", "rodriguez");
				Nodo a=e.getVehiculos().buscar(new Vehiculo(40));
				((Vehiculo) a.getDato()).getConductores().insertar(c1, "34768495");
				((Vehiculo) a.getDato()).getConductores().insertar(c2, "31838080");
				((Vehiculo) a.getDato()).getConductores().insertar(c3, "12560383");
				((Vehiculo) a.getDato()).getConductores().listar();
				break;
			case 3:
				e.getVehiculos().eliminar(new Vehiculo(10));
				e.getVehiculos().recorrerPreOrden();
				break;
			case 4:
				e.imprimirPatentesYModelos();
				break;
			case 5:
				System.out.println("se cargaron un total de "+ e.cantConductoresTotal()+" conductores");
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

