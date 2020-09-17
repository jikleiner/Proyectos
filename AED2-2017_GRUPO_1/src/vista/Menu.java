package vista;


import java.util.Scanner;
import estructuras.ListaDoble;
import lib.MiException;
import lib.Validaciones;
import controlador.Operaciones;


public class Menu {
	
	static Scanner sc = new Scanner(System.in); 
	static int select = -1;
	static String sel = "";
	static ListaDoble listaAct = new ListaDoble();
	
	//menu de opciones para carga de datos
	public static void mostrarMenu() {
		
		
		while(select != 0){
			
			try{
				System.out.println("Elige una opción:\n1.- Inicializar y cargar archivo de entrada de tabla de actividades\n" +
						"2.- Vaciar la tabla de actividades\n"  +
						"3.- Cargar actividad manual\n" +
						"4.- Generar Grafo y mostrar Matriz de Adyacencia \n" +
						"5.- Mostrar el camino critico \n" +
						"0.- Salir");
				
				sel = sc.nextLine();
				Validaciones.numeroCorrecto(sel);
				select = Integer.parseInt(sel); 
	
				
				switch(select){
				case 1: 
					Operaciones.cargarArchivo(listaAct);
					break;
				case 2: 
					Operaciones.vaciarActividades(listaAct);					
					break;
				case 3: 
					Operaciones.cargarActividadManual(listaAct);
					break;
				case 4:
					try {	
							Operaciones.cargarPrecedencias(listaAct);
							Operaciones.cargarAntecedencias(listaAct);
							Operaciones.mostrarMatriz(listaAct);
							break;
					} catch (Exception e) {
						System.out.println("No hay tareas guardadas en memoria");
						break;
					}
				case 5: 
					Operaciones.mostrarCaminoCritico(listaAct);
					break;
				case 0: 
					System.out.println("Adiós!");
					break;
				default:
					System.out.println("Número no reconocido");
					break;
				}
				
				System.out.println("\n");
				
			}catch(MiException e){
				System.out.println(e.getMessage());
			}
		}

	}
	



}
