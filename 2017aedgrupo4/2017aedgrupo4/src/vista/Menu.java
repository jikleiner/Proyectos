package vista;


import java.util.ArrayList;
import java.util.Scanner;

import estructura.ListaSimple;
import estructura.TablaHash;
import modelo.Estudiante;

public class Menu {
	
	private static Scanner scanner = new Scanner(System.in); 
	private static int select = -1; 
	private static Operaciones ops;
	private static ListaSimple listaSimpleAlumno=new ListaSimple();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static ArrayList<Estudiante> arrayListAlumno=new ArrayList();
	static TablaHash tablaH=new TablaHash();
	
	@SuppressWarnings("static-access")
	public static void mostrarMenu() {
		
		
		while(select != 0){
			
			//try{
				System.out.println("Elige opción:\n1.- Seleccione el archivo CSV a cargar\n" +
						"2.- Mostrar datos archivo CSV\n" +
						"3.- Cargar archivo en lista enlazada\n" +
						"4.- Buscar por legajo secuencialmente en la lista enlazada y mostrar las demoras de consultas\n" +
						"5.- Cargar archivo en tabla hash\n" +
						"6.- Buscar legajo en tabla hash\n" +
						"7.- Mostrar porcentaje de carga\n" +
						"0.- Salir");
				
				select = Integer.parseInt(scanner.nextLine()); 
	
				
				switch(select){
				case 1: 
					ops.seleccionArchivo(arrayListAlumno);
					break;
				case 2: 
					ops.mostrarEstudiantes(arrayListAlumno);
					break;
				case 3: 
					ops.cargarListaSimple(listaSimpleAlumno,arrayListAlumno);
					break;
				case 4: 
					ops.buscarAlumno(listaSimpleAlumno);
					break;
				case 5: 
					tablaH.borrado();
					ops.cargarTablaHash(arrayListAlumno,tablaH);
					break;
				case 6: 
					ops.buscarTablaH(tablaH);
					break;
				case 7:
					float porcen=(float)tablaH.getCantElementos()/tablaH.getTamaño();
					System.out.println("nivel de carga = " + porcen + "%");;
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n");
				
			/*}catch(Exception e){
				System.out.println("Solo se pueden seleccionar archivos de tipo csv");
			}*/
		}

	}
	



}
