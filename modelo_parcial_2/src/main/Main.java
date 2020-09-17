package main;

import java.util.ArrayList;
import java.util.Scanner;

import estructura.GrafoViajes;
import estructura.Vertice;



public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static int sel=-1;
	public static GrafoViajes grafo = new GrafoViajes(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grafo.crearVertice("Cordoba");
		grafo.crearVertice("Buenos Aires");
		grafo.crearVertice("Mendoza");
		grafo.crearVertice("Lima");
		grafo.crearVertice("Santiago");
		grafo.crearVertice("San Pablo");
		grafo.crearArista("Cordoba", "Buenos Aires", 1300, 1);
		grafo.crearArista("Cordoba", "Lima", 4500, 6);
		grafo.crearArista("Cordoba", "Santiago", 2500, (float) 1.5);
		grafo.crearArista("Cordoba", "San Pablo", 2300, 2);
		grafo.crearArista("Cordoba", "Mendoza", 1000, 1);
		grafo.crearArista("Buenos Aires", "Lima", 4000, 4);
		grafo.crearArista("Buenos Aires", "San Pablo", 2600, 2);
		grafo.crearArista("Mendoza", "Santiago", 1800, 1);
		grafo.crearArista("Mendoza", "Lima", 5100, 5);
			
		while(sel != 0){
			System.out.println("Elija opción:\n1.- recorrido mas rapido Cordoba-Lima\n" +
					"2.- Costo camino mas rapido Cordoba-Lima\n" +
					"3.- Camino de menor escala Buenos Aires-Lima\n" +
					"4.- Reducir costo de camino mas rapido Santiago-San Pablo 10%\n" +
					"5.- Aumentar costo del camino de menor escalas San Pablo-Lima 5%\n" +
					"0.- Salir");
			
			String sele=sc.nextLine();
			sel = Integer.parseInt(sele); 
				
			switch(sel){
			case 1:
				ArrayList<Vertice> retorno1 = grafo.devolverCaminoFW_tiempo("Cordoba", "Lima");
				for(Vertice v:retorno1){
					System.out.println(v.toString());
				}
				break;
			case 2:
				System.out.println(grafo.devolverFW_costoMenorTiempo("Cordoba", "Lima"));
				break;
			case 3:
				ArrayList<Vertice> retorno2 = grafo.devolverCaminoFW("Buenos Aires", "Lima");
				for(Vertice v:retorno2){
					System.out.println(v.toString());
				}				
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 0: 
				break;
			default:
				System.out.println("Número no reconocido");
				break;
			}
				
		}

	}
}

