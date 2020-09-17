package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import estructuras.ListaDoble;
import estructuras.NodoDoble;
import modelo.Camino;
import modelo.Grafo;
import modelo.Router;
import utilidades.*;

public class Operaciones {

	public static void cargarArchivo(ListaDoble listaRouters, ListaDoble listaCaminos) {
		NodoDoble n = listaRouters.getCabezera();

		if (n == null) {

			System.out.println("Ingrese la opcion deseada");
			System.out.println("1.- Cargar archivo desde ruta");
			System.out.println("2.- Buscar archivo por nombre");

			int opcion = Validaciones.validarIntEntrada();

			switch (opcion) {
			case 1:
				String archivo = Validaciones.stringSinEspacios("Ingrese la ruta y el nombre del archivo a cargar");
				leerArchivo(archivo, listaRouters, listaCaminos);
				break;
			case 2:
				String archivoNombre = Validaciones
						.stringSinEspacios("Ingrese el nombre del archivo con su extención:\nfichero = ");
				String carpeta = Validaciones
						.stringSinEspacios("\nDirectorio de inicio de la busqueda:\ndirectorio = ");

				String re = buscarArchivo(archivoNombre, new File(carpeta));

				if (re == "") {
					System.out.println("Archivo no encontrado");
				} else {
					leerArchivo(re, listaRouters, listaCaminos);
				}
				break;
			default:
				System.err.println("Seleccione una opción dentro del rango.\n");
				break;
			}
		} else
			System.out.println(
					"Ya hay routers cargados. Para cargar un nuevo archivo, primero vacie la tabla de routers");
	}

	public static String buscarArchivo(String argFichero, File argFile) {
		String retorno = "";
		File[] lista = argFile.listFiles();

		if (lista != null) {
			for (File elemento : lista) {
				if (elemento.isDirectory())
					buscarArchivo(argFichero, elemento);
				else if (argFichero.equalsIgnoreCase(elemento.getName()))
					return retorno = elemento.getAbsolutePath();
			}
		}
		return retorno;

	}

	private static void leerArchivo(String archivo, ListaDoble listaRouters, ListaDoble listaCaminos) {
		FileReader fr = null;
		BufferedReader br = null;
		NodoDoble n = null;

		try {
			File archivoF = new File(archivo);
			fr = new FileReader(archivoF);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			String separador = ";";
			linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(separador);

				if (datos[2].equals("N")) {
					Router r = new Router(datos[0], datos[1]);
					n = new NodoDoble(r);
					listaRouters.Insertar(n);
				}

				if (datos[2].equals("A")) {
					Camino c = new Camino(datos[0], datos[4], datos[5], Integer.parseInt(datos[3]));
					n = new NodoDoble(c);
					listaCaminos.Insertar(n);
				}
				linea = br.readLine();
			}
			System.out.println("Archivo cargado con éxito");
		} catch (IOException ex) {
			System.out.println("Archivo no encontrado");
		}
	}

	public static void vaciarRouters(ListaDoble listaRouters, ListaDoble listaCaminos) {
		NodoDoble n = listaRouters.getCabezera();
		String salida = "";

		if (n == null)
			System.out.println("No hay routers cargados");
		else {
			System.out.println("Esta seguro que desea eliminar el buffer del proyecto?\n"
					+ "Routers cargados hasta el momento:\n");
			while (n != null) {
				salida += ((NodoDoble) n.getDato()).getDato().toString() + "\n";
				n = n.getSig();
			}
			System.out.println(salida);
			System.out.println("1.- SI");
			System.out.println("2.- NO");

			int opcion = Validaciones.validarIntEntrada();

			switch (opcion) {
			case 1:
				listaRouters.Vaciar();
				listaCaminos.Vaciar();
				System.out.println("Borrado de buffer exitoso");
				break;
			case 2:
				System.out.println("Borrado de buffer cancelado");
				break;
			default:
				System.err.println("Seleccione una opción dentro del rango.\n");
				break;
			}

		}
	}

	public static void generarGrafo(ListaDoble listaRouters, ListaDoble listaCaminos, Grafo grafo) {
		grafo = new Grafo(listaRouters, listaCaminos);

		System.out.println("La matriz de adyacencia es la siguiente:");
		System.out.print("   ");
		for (int i = 1; i <= grafo.getListaVertices().cantidadDeElementos(); i++)
			System.out.print(grafo.getListaVertices().devolverElementoPosEspecifica(i) + " ");
		System.out.println();

		for (int i = 1; i <= grafo.getListaVertices().cantidadDeElementos(); i++) {
			System.out.print(grafo.getListaVertices().devolverElementoPosEspecifica(i) + " ");
			for (int j = 1; j <= grafo.getListaVertices().cantidadDeElementos(); j++) {
				NodoDoble nodoA = new NodoDoble();
				nodoA = (NodoDoble) grafo.getListaVertices().devolverElementoPosEspecifica(i);
				Router routerA = new Router("", "");
				routerA = (Router) nodoA.getDato();

				NodoDoble nodoB = new NodoDoble();
				nodoB = (NodoDoble) grafo.getListaVertices().devolverElementoPosEspecifica(j);
				Router routerB = new Router("", "");
				routerB = (Router) nodoB.getDato();
				if(grafo.encontrarCamino(routerA.getCodigo(), routerB.getCodigo()) <= 9) {
					System.out.print(grafo.encontrarCamino(routerA.getCodigo(), routerB.getCodigo()) + "   ");
				}else {
				System.out.print(grafo.encontrarCamino(routerA.getCodigo(), routerB.getCodigo()) + "  ");
				}
			}
			System.out.println();
		}

	}

	public static void opcion3(ListaDoble listaRouters, ListaDoble listaCaminos) {
		System.out.println("1.- Cargar nuevo router");
		System.out.println("2.- Cargar nuevo camino");

		int opcion = Validaciones.validarIntEntrada();

		switch (opcion) {
		case 1:
			cargarRouter(listaRouters, listaCaminos);
			break;
		case 2:
			cargarCamino(listaRouters, listaCaminos);
			break;
		default:
			System.err.println("Seleccione una opción dentro del rango.\n");
			break;
		}

	}

	public static void cargarRouter(ListaDoble listaRouters, ListaDoble listaCaminos) {

		String codigo = Validaciones.esString("Por favor, inserte el código del nuevo router").toUpperCase();
		String nombre = Validaciones.esString("Por favor, ingrese el nombre del nuevo router");

		Router r = new Router(codigo, nombre);
		NodoDoble n = new NodoDoble(r);

		if (listaRouters.Buscar(n)) {
			System.err.println("El router con el código " + codigo + " ya existe, por favor intente con otro");
			System.out.println();
		} else {
			listaRouters.Insertar(n);
			System.out.println("El router ha sido cargado exitosamente");
		}
	}

	public static void cargarCamino(ListaDoble listaRouters, ListaDoble listaCaminos) {
		String codigo = Validaciones.esString("Por favor, inserte el código del nuevo camino");
		int costo = Validaciones.esEntero("Por favor, ingrese el costo del nuevo camino");
		String origen = Validaciones.esString("Por favor, inserte el origen del nuevo camino");
		String destino = Validaciones.esString("Por favor, inserte el destino del nuevo camino");

		Camino c = new Camino(codigo, origen, destino, costo);
		NodoDoble n = new NodoDoble(c);
		listaCaminos.Insertar(n);
		System.out.println("El camino ha sido cargado exitosamente");
	}
	
	/*public static void opcion5(Grafo grafo){
		String codigoOrigen = Validaciones.esString("Por favor, inserte el código del router ORIGEN").toUpperCase();
		
		Router r = new Router(codigoOrigen, null);
		NodoDoble n = new NodoDoble(r);
		
		if (!grafo.getListaVertices().Buscar(n)) {
			System.err.println("El router con el código " + codigoOrigen + " no existe, por favor intente con otro");
			System.out.println();
		}
		
		String codigoDestino = Validaciones.esString("Por favor, inserte el código del router DESTINO").toUpperCase();
		
		Router r2 = new Router(codigoOrigen, null);
		NodoDoble n2 = new NodoDoble(r2);
		
		if (!grafo.getListaVertices().Buscar(n2)) {
			System.err.println("El router con el código " + codigoDestino + " no existe, por favor intente con otro");
			System.out.println();
		}
		
		grafo.Dijkstra(codigoOrigen, codigoDestino);
	
	}*/

}
