package main;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import estructura.GrafoViajes;
import estructura.Vertice;



public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int sel=-1;
	public static GrafoViajes grafo = new GrafoViajes(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grafo.crearVertice("Buenos Aires");
		grafo.crearVertice("Cordoba");
		grafo.crearVertice("San Juan");
		grafo.crearVertice("Mendoza");
		grafo.crearVertice("Salta");
		grafo.crearVertice("Tucuman");
		grafo.crearVertice("Iguazu");
		grafo.crearArista("Buenos Aires", "Cordoba", 1442, (float) 1.5 , 16, 20);
		grafo.crearArista("Buenos Aires", "San Juan", 19001, 2, 13, 21);
		grafo.crearArista("Buenos Aires", "Mendoza", 2449, 2, 19, 8);
		grafo.crearArista("Buenos Aires", "Salta", 2026, 3, 12, 2);
		grafo.crearArista("Buenos Aires", "Tucuman", 2400, (float) 2.5, 8, 16);
		grafo.crearArista("Cordoba", "San Juan", 2009, (float)1.5, 23, 15);
		grafo.crearArista("Cordoba", "Mendoza", 1833, 2, 14, 3);
		grafo.crearArista("Cordoba", "Iguazu", 1435, 3, 7, 5);
		grafo.crearArista("Salta", "Iguazu", 1747, 2, 13, 14);
		grafo.crearArista("Salta", "Mendoza", 2058, 3, 6, 6);
		grafo.crearArista("Salta", "Tucuman", 2627, 2, 11, 1);

		
		while(sel != 0){
			System.out.println("Elija opción:\n1.- Camino mas corto entre Buenos Aires - Iguazu en cantidad de vuelos\n" +
					"2.- Camino mas corto entre Buenos Aires - Iguazu en tiempo\n" +
					"3.- Camino mas corto entre Buenos Aires - Iguazu en costo\n" +
					"4.- Mostrar 3 caminos desde Cordoba a Tucuman (tiempo de vuelo+costo)\n" +
					"0.- Salir");
			
			String sele=sc.nextLine();
			sel = Integer.parseInt(sele); 
				
			switch(sel){
			case 1:
				Vertice a = grafo.bfsBusqueda("Buenos Aires","Iguazu");
				System.out.println(a.getDistancia());
				while(a.getAnterior()!=null){
					System.out.println(a.toString());
					a=a.getAnterior();
				}
				System.out.println(a.toString());
				break;
			case 2:
				ArrayList<Vertice> retorno1 = grafo.devolverCaminoFW_tiempo("Buenos Aires", "Iguazu");
				for(Vertice v:retorno1){
					System.out.print(v.getNombre()+" ");		
				}
				System.out.println(grafo.devolverFW_tiempo("Buenos Aires", "Iguazu"));
				break;
			case 3:
				ArrayList<Vertice> retorno2 = grafo.devolverCaminoFW("Buenos Aires", "Iguazu");
				for(Vertice v:retorno2){
					System.out.print(v.getNombre()+" ");;					
				}
				System.out.println(grafo.devolverFW_costo("Buenos Aires", "Iguazu"));
				break;
			case 4:
				break;
			case 0: 
				System.exit(0);;
				break;
			default:
				System.out.println("Número no reconocido");
				break;
			}
				
		}

	}
}

