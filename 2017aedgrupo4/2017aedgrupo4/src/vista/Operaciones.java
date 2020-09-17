package vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import estructura.ListaSimple;
import estructura.TablaHash;
import lib.NumerosException;
import modelo.Estudiante;

public class Operaciones {

	static Scanner scanner = new Scanner(System.in); 

	/**
	 * pide la ruta completa y el nombre del archivo
	 * 
	 * @param listaEstudiante
	 */
	public static void seleccionArchivo(ArrayList<Estudiante> listaEstudiante) {
		System.out.println("Ingrese la ruta y el nombre del archivo a cargar");
		String archivo = scanner.nextLine();
		leerArchivo(archivo,listaEstudiante);
	}

	/**
	 * lee los datos del archivo linea por linea y los guarda en una lista de alumnos
	 * 
	 * @param archivo
	 * @param listaEstudiante
	 */
	private static void leerArchivo(String archivo,ArrayList<Estudiante> listaEstudiante) {
		FileReader fr = null;
        BufferedReader br = null;
        try {
            File archivoF = new File(archivo);
            fr = new FileReader(archivoF);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            String separador = ",";
            if(linea.split(separador).length==1){
            	separador = ";";
            }
            while (linea != null) {
                String[] estudiante = linea.split(separador);
                Estudiante e= new Estudiante(estudiante[0],estudiante[1],estudiante[2],estudiante[3]);
                listaEstudiante.add(e);
                linea = br.readLine();
            	}
	        }catch (IOException ex) {
	            System.err.println("Archivo no encontrado ");
	        } finally {
	            try {
	                if (br != null) {
	                    br.close();
	                }
	                if (fr != null) {
	                    fr.close();
	                }
	            } catch (IOException ex) {
	                System.err.println("Ocurrio una excepcion al procesar el archivo: " + ex.getMessage());
	            }
	        }
		
	}
	
	/**
	 *  muestra todos los datos cargados en la lista
	 * 
	 * @param listaEstudiante
	 */
	public static void mostrarEstudiantes(ArrayList<Estudiante> listaEstudiante) {
		if(listaEstudiante.isEmpty()){
			System.out.println("no se cargo ningun dato en la lista");
		}else{
			for(Estudiante estu: listaEstudiante){
				System.out.println(estu.toString());
			}
		}	}

	/**
	 * Carga los alumnos en lista simplemente enlazada
	 * 
	 * @param listaAlmunos
	 * @param listaEstudiante
	 */
	public static void cargarListaSimple(ListaSimple listaAlmunos, ArrayList<Estudiante> listaEstudiante) {
		
		listaAlmunos.Vaciar();
		for (Estudiante estudiante : listaEstudiante) {
			listaAlmunos.Insertar(estudiante);
		}
		System.out.println("Estudiantes cargados correctamente en lista simplemente enlazada");		
	}

	
	public static void buscarAlumno(ListaSimple listaAlmunos) {

		System.out.println("Ingrese legajo del estudiante a buscar");
		String legajo = scanner.nextLine();
		long tiempoInicio = System.nanoTime();
		
		if(listaAlmunos.Buscar(legajo)){
			long tiempoFin = System.nanoTime();
			long diferencia = tiempoFin-tiempoInicio;
			System.out.println("El alumno se encuentra en la lista/n"+"El tiempo que se tomo la busqueda fue de :" + diferencia+" nano segundos");
			
		}else{
			long tiempoFin = System.nanoTime();
			long diferencia = tiempoFin-tiempoInicio;
			System.out.println("El alumno no se encuentra en la lista"+"El tiempo que se tomo la busqueda fue de :" + diferencia+" nano segundos");
			
		}
		
	}
	
	public static void cargarTablaHash(ArrayList<Estudiante> arrayListAlumno,TablaHash tablaH){
		try {
		for(int i=1;i<arrayListAlumno.size();i++){
			String subLeg=arrayListAlumno.get(i).getLegajo();

				tablaH.insercion(subLeg, arrayListAlumno.get(i));
			}
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Archivo cargado con exito. Coliciones: "+tablaH.getCantColiciones());
	}

	public static void buscarTablaH(TablaHash tablaH){
		try {
			System.out.println("ingrese Legajo a buscar:");
			String leg=scanner.nextLine();
			long tiempoInicio = System.nanoTime();
			Estudiante estudiante;
			if(tablaH.busqueda(leg)==null){
				System.out.println("estudiante no encontrado");
				long tiempoFin = System.nanoTime();
				long diferencia = tiempoFin-tiempoInicio;	
				System.out.println("El tiempo que se tomo la busqueda fue de :" + diferencia+" nano segundos");
			}else{
				estudiante=tablaH.busqueda(leg);
				System.out.println("estudiante encontrado!\n"+estudiante.toString());
				long tiempoFin = System.nanoTime();
				long diferencia = tiempoFin-tiempoInicio;
				System.out.println("El tiempo que se tomo la busqueda fue de :" + diferencia+" nano segundos");
			}
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
