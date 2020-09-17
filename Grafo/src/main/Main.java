package main;
import java.util.ArrayList;
import java.util.Scanner;

import estructura.GrafoIterador;
import estructura.Vertice;


public class Main {

		public static void main (String [] args){
			GrafoIterador miGrafo = new GrafoIterador();
			miGrafo.crearVertice("a");
			miGrafo.crearVertice("b");
			miGrafo.crearVertice("c");
			miGrafo.crearVertice("d");
			miGrafo.crearVertice("e");
			miGrafo.crearVertice("f");
			miGrafo.crearVertice("g");
			miGrafo.crearArista("a", "b", 1);
			miGrafo.crearArista("b", "c", 2);
			miGrafo.crearArista("c", "d", 3);
			miGrafo.crearArista("d", "e", 4);
			miGrafo.crearArista("a", "f", 5);
			miGrafo.crearArista("f", "g", 6);
			//das
			Scanner sc = new Scanner(System.in);
			
			int sel=-1;
			
			while(sel != 0){
				System.out.println("Elija opción:\n1.- recorrido dfs\n" +
						"2.- bfs\n" +
						"3.- crear arista\n" +
						"4.- crear vertice\n" +
						"5.- dijstra\n" +
						"6.- floywarshall\n" +
						"7.- recorrer profundidad\n" +
						"8.- calcular tamaño\n" +
						"9.- eliminar nodo\n" +
						"0.- Salir");
				
				String sele=sc.nextLine();
				sel = Integer.parseInt(sele); 
				
				switch(sel){
				case 1:
					miGrafo.DFS("a", "g");
					break;
				case 2:
					miGrafo.bfs2("a", "g");
					break;
				case 3:
					miGrafo.crearArista("a", "c", 10);
					System.out.println(miGrafo.toString());
					break;
				case 4:
					miGrafo.crearVertice("z");
					System.out.println(miGrafo.toString());
					break;
				case 5:
					miGrafo.dijkstra(new Vertice ("a"));
					break;
				case 6:
					miGrafo.floydWarshall("a", "e");
					break;
				case 7:
					miGrafo.DFS_recorrido("a");
					break;
				case 8:
					miGrafo.BFS_recorrido("a");
					break;
				case 9:
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
			}
			
		}
}
