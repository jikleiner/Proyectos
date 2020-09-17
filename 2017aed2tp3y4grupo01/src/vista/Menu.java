package vista;

import controlador.Operaciones;
import estructuras.ListaDoble;
import modelo.Grafo;
import utilidades.Validaciones;

public class Menu {
	static ListaDoble listaRouters = new ListaDoble();
	static ListaDoble listaCaminos = new ListaDoble();
	static Grafo grafo = new Grafo(listaRouters, listaCaminos);

		
	public void menuPrincipal(){
		System.out.println("1. Inicializar y cargar el archivo de entrada de la tabla de routers.");
		System.out.println("2. Vaciar la tabla de routers.");
		System.out.println("3. Cargar Router / Camino de forma manual.");
		System.out.println("4. Generar Grafo y Mostrar Matriz de Adyacencia.");
		System.out.println("5. Calcular y mostrar el camino más corto entre 2 routers.");	
		
		int opcion = Validaciones.validarIntEntrada();		
		   	
			switch(opcion){
			case 1: 
				Operaciones.cargarArchivo(listaRouters, listaCaminos);
				menuPrincipal();
				break;
			case 2:
				Operaciones.vaciarRouters(listaRouters, listaCaminos);	
				menuPrincipal();
				break;
			case 3:
				Operaciones.opcion3(listaRouters, listaCaminos);	
				menuPrincipal();			
				break;	
			case 4:
				Operaciones.generarGrafo(listaRouters, listaCaminos, grafo);
				menuPrincipal();				
				break;	
			case 5:
				System.out.println("El punto 5 no está realizado");
				//Operaciones.opcion5(listaRouters, listaCaminos, grafo);
				menuPrincipal();				
				break;			
			default:
				System.err.println("Seleccione una opción dentro del rango.\n");
				menuPrincipal();
				break;			
			}		
	}
		
}
