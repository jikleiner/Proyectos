package main;

import java.util.ArrayList;
import java.util.Scanner;
import estructura.GrafoViajes;
import estructura.Vertice;
import estructura.VerticeAeropuerto;



public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int sel=-1;
	public static GrafoViajes grafo = new GrafoViajes(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(sel != 0){
			System.out.println("Elija opción:\n1.- Cargar Grafo (pto.2)\n" +
					"2.- Imprimir camino mas corto en costo entre Montevideo y Sidney (pto. 3)\n" +
					"3.- Imprimir camino mas corto en duracion entre Montevideo y Sidney (pto. 4)\n" +
					"4.- Imprimir nombre de aeropuerto y categoria (pto. 5)\n" +
					"5.- Imprimir en pantalla el total de metros cudrados de todos los aeropuertos (por red desde montevideo) (pto. 5))\n" +
					"0.- Salir");
			
			String sele=sc.nextLine();
			sel = Integer.parseInt(sele); 
				
			switch(sel){
			case 1:
				grafo.cargarGrafo();
				break;
			case 2:
				grafo.mostrarCosto();
				break;
			case 3:
				grafo.mostrarTiempo();
				break;
			case 4:
				grafo.mostrarAeropuertosDfs("Montevideo");
				break;
			case 5:
				grafo.mostrarAeropuertosBfs("Montevideo");;
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

