package vista;

import java.util.Scanner;

import Estructuras.Arbol;
import Estructuras.TablaExploracionLineal;
import controlador.MiException;
import controlador.Validaciones;

public class Menu {
		
		static Scanner sc = new Scanner(System.in); 
		static int select = -1;
		static String sel = "";
		static Arbol arbolB = new Arbol();
		static Arbol arbolAlumnos = new Arbol();
		
		//menu de opciones para carga de datos
		public static void mostrarMenu() {
			
			
			while(select != 0){
				
				try{
					System.out.println("Elige una opción:\n1.- punto 1\n" +
							"2.- punto 2\n"  +
							"3.- punto 3\n" +
							"4.- punto 4\n" +
							"5.- punto 5\n" +
							"6.- punto 6\n" +
							"0.- Salir");
					
					sel = sc.nextLine();
					Validaciones.numeroCorrecto(sel);
					select = Integer.parseInt(sel); 
					
					
					switch(select){
					case 1: 
						Operaciones.puntoUno(arbolB);
						break;
					case 2: 
						Operaciones.puntoDos(arbolB);
						System.out.println("");
						arbolB.recorrerInOrden();
						System.out.println("");
						arbolB.recorrerPostOrden();
						break;
					case 3: 
						Operaciones.puntoTres(arbolAlumnos);
						break;
					case 4:
						Operaciones.listarAlumnosPuntoCuatro(arbolAlumnos);
						break;
					case 5: 
						Operaciones.puntoCinco(arbolAlumnos);
						break;
					case 6:
						Operaciones.puntoSeis(arbolAlumnos);
					case 0: 
						break;
					default:
						System.out.println("Opcion incorrecta");
						break;
					}
					
					System.out.println("\n");
					
				}catch(MiException e){
					System.out.println(e.getMessage());
				}
			}

		}

}
