package vista;


import java.util.ArrayList;
import java.util.Scanner;

import estructura.ArbolBinario;
import estructura.ExploracionTablaHash;
import estructura.TablaExploracionLineal;
import modelo.Persona;





public class Menu {
	
	static Scanner scanner = new Scanner(System.in); 
	static int select = -1; 
	static Operaciones ops;
	static ExploracionTablaHash e = new ExploracionTablaHash();
	static TablaExploracionLineal l= new TablaExploracionLineal();
	static protected Persona [] vector = new Persona[11];
	
	
	
	
	
	//menu de opciones para carga de datos
	public static void mostrarMenu() {
		
		
		while(select != 0){
			
			try{
				System.out.println("Elige opción:\n1.- Cargar Persona" +
						"\n2.- Verificar si persona existe\n"  +
						"3.- Eliminar persona\n"  +
						"4.- Listar Personas\n"  +
						"5.- Cantidad de personas de sexo femenino\n"  +
						"0.- Salir");
				
				select = Integer.parseInt(scanner.nextLine()); 
	
				
				switch(select){
				case 1: 
					ops.CargarPersona(e,l);
					break;
				case 2:
					ops.VerficarExistencia(e,l);
					break;
				case 3:
					ops.eliminarPersona(l);
					break;
				case 4:
					ops.listar(l);
					break;
				case 5:
					ops.sumarFemenino(l);
					break;
				case 0:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n");
				
			}catch(Exception e){
				System.out.println(e.getMessage().toString());
			}
		}

	}
	



}
