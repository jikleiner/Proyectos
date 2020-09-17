package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

import estructuras.ListaDoble;
import estructuras.NodoDoble;
import lib.MiException;
import lib.Validaciones;
import modelo.Actividad;


public class Operaciones {
	static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Metodo q nos permite cargar archivos al programa
	 * @param listaAct (lista doble)
	 */
	public static void cargarArchivo(ListaDoble listaAct){
		try {
			NodoDoble n=listaAct.getCabezera();
			String salida="";
			if(n == null){
				System.out.println("Ingrese la opcion deseada\n"
						+ "1.- Cargar archivo desde ruta\n"
						+ "2.- Buscar archivo por nombre");
			
				String sel=sc.nextLine();		
				Validaciones.numeroCorrecto(sel);
				int s=Integer.parseInt(sel);
			
				if(s==1){
					System.out.println("Ingrese la ruta y el nombre del archivo a cargar");
					String archivo = sc.nextLine();
					leerArchivo(archivo,listaAct);
				}else if(s==2){
					String archivoNombre = "";
					String carpeta = "";
					System.out.print ("Ingrese el nombre del archivo con su extencion:\nfichero = " );
					archivoNombre = sc.nextLine();
					System.out.print ("\nDirectorio de inicio de la busqueda:\ndirectorio = ");
					carpeta = sc.nextLine();
					String re = buscarArchivo(archivoNombre, new File(carpeta));
					if(re==""){
						System.out.println("Archivo no encontrado");
					}else{
						leerArchivo(re,listaAct);	
					}
				}else{
					System.out.println("Número ingresado incorreto");
				}
			}else
				System.out.println("Ya hay tareas cargadas. Para cargar un nuevo archivo, primero vacie la tabla de actividades");
		} catch (MiException e) {
			System.out.println(e.getMessage());
		}		
	}

	/**
	 * Metodo que nos permite buscar un archivo dentro del sistema
	 * @param argFichero
	 * @param argFile
	 * @return el archivo
	 */
	public static String buscarArchivo (String argFichero, File argFile) {
		String retorno = "";
		File[] lista = argFile.listFiles();
		if (lista != null) {
			for (File elemento : lista) {
				if (elemento.isDirectory()) {
					buscarArchivo (argFichero, elemento);
				} else if (argFichero.equalsIgnoreCase(elemento.getName())) {
					return	retorno=elemento.getAbsolutePath();
				}
			}
		}
		return retorno;
		//Si se desea mostrar sólo la ruta, sin incluir el nombre del fichero, modifica esta linea:
		//System.out.println (elemento.getAbsoluteFile());
		//Por esta otra:
		//System.out.println (elemento.getParentFile());

	}
	
	@SuppressWarnings("null")
	/**
	 * Metodo que nos permite leer un archivo
	 * @param archivo
	 * @param listaAct
	 */
	private static void leerArchivo(String archivo,	ListaDoble listaAct) {
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
                String[] enlaces = datos[2].split(" "); 
                Actividad e= new Actividad(datos[0],datos[1],enlaces,datos[3]); //Creamos el objeto actividad como esta planteado en el problema
                n = new NodoDoble(e); //creamos un nodo doble con el objeto actividad ya creado
                listaAct.Insertar(n); //insertamos el nodo en nuestra lista
                linea = br.readLine();
            	}
            System.out.println("Archivo cargado con éxito");
	        }catch (IOException ex) {
	            System.out.println("Archivo no encontrado ");
	        }
	}

	/**
	 * Metodo que nos permite vaciar (eliminar) los objetos "Actividades" de nuestra lista doble
	 * @param listaAct
	 */
	public static void vaciarActividades(ListaDoble listaAct) {
		// TODO Auto-generated method stub
		try {
			NodoDoble n=listaAct.getCabezera();
			String salida="";
			if(n==null){
				System.out.println("No hay tareas cargadas"); //Comprobamos si hay tareas cargadas
			}else{
				System.out.println("Esta seguro que desea eliminar el buffer del proyecto?\n"
						+ "Actividades cargadas hasta el momento:\n");   //preguntamos si realmente queremos eliminar
			    while(n != null){
			    	salida += ((NodoDoble) n.getDato()).getDato().toString()+"\n";
			    	n = n.getSig();
			    }	    	
			    System.out.println(salida);
				System.out.println("1.- SI\n2.- NO"); //pregunta de control
				String s = sc.nextLine();
				Validaciones.numeroCorrecto(s); //validamos
				int sel = Integer.parseInt(s);
				if(sel==1){
					listaAct.Vaciar();
					System.out.println("Borrado de buffer exitoso");
				}else if(sel==2){
					System.out.println("Borrado de buffer cancelado");
					return;
				}else{
					System.out.println("Número incorrecto!");
				}				
			}
		} catch (MiException e) {
			System.out.println(e.getMessage());;
		}
	}

	//Pide el ingreso por teclado de un id de actividad
	public static String pedirIdActividad(){
		System.out.println("Ingrese id de la actividad (letra)");
		String id = sc.nextLine();
		id = Validaciones.rangoLetras("A", "Z", id, "Ingrese solo una letra");
		return id;
	}
	
	//Comprueba si existe el mismo id cargado en lista de tareas para no ingresarlo nuevamente
	public static boolean existeId(ListaDoble listaAct, String id){
		NodoDoble z=listaAct.getCabezera(); 
		boolean find=false;
		
		while(z!=null||find!=false){
			if(((Actividad) ((NodoDoble) z.getDato()).getDato()).getId().equalsIgnoreCase(id)){
				System.out.println("No se puede ingresar una tarea con ID ya cargado");
				find=true;
				return find;
			}else{
				z=z.getSig();
			}
		}
		return find;
	}
	
	//Comprueba que las predecesora ingresada por teclado, exista en la lista de tareas
	public static boolean existePredecesora(ListaDoble listaAct, String id){
		NodoDoble z=listaAct.getCabezera(); 
		boolean find=false;
		
		while(z!=null||find!=false){
			if(((Actividad) ((NodoDoble) z.getDato()).getDato()).getId().equalsIgnoreCase(id)){
				find=true;
				//System.out.println(find);
				return find;
			}else{
				z=z.getSig();
			}
		}
		return find;
	}


/**
 * Metodo que nos permite cargar manualmente la lista doble con los objetos "Actividad"
 * @param listaAct
 */
	public static void cargarActividadManual(ListaDoble listaAct) {
		try {
				String id= pedirIdActividad();
				boolean aux = false;
				while(aux == false){
					if(existeId(listaAct, id)){
						id = pedirIdActividad();
						aux= false;}
					else{
						aux=true;
						break;
					}
				}
				
			
			System.out.println("Ingrese descripcion de la actividad");
			String nombre = sc.nextLine();
			Validaciones.soloLetras(nombre); //validamos la descripcion de la actividad
			
			NodoDoble z=listaAct.getCabezera(); 
			String[] tar = null;
			
			if(z != null){
				System.out.println("Indicar cantidad de tareas precedentes");
				int n = Validaciones.esIntPositivo("Ingrese un número válido");
				tar = new String[n];
			
				for(int i = 0; i<tar.length; i++){
					System.out.println("Ingrese la "+(i+1)+"° tarea precedente:");
					String a = sc.nextLine();
				
					boolean aux2 = false;
					while(aux2 == false){
						if(existePredecesora(listaAct, a)){
							tar[i] = a;
							aux2=true;
							break;
						}else{
							System.out.println("Ingrese un ID válido");
							a = sc.nextLine();
						}	
					}
			}
			}
			
			System.out.println("Ingrese tiempo de la tarea(solo números)");
			int t = Validaciones.esIntPositivo("Ingrese un número válido");//validamos el tiempo de la tarea
			String tiempo = String.valueOf(t);
			
			Actividad act = new Actividad(id, nombre, tar, tiempo); //creamos el objeto "Actividad"
			NodoDoble f= new NodoDoble(act); //creamos un nodo doble y carggamos el objeto actividad
			listaAct.Insertar(f);
			System.out.println("La actividad se cargo con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Metodo que nos permite cargar las precedencias de las Actividades
	 * @param listaAct
	 */
	public static void cargarPrecedencias(ListaDoble listaAct){
		NodoDoble n = listaAct.getCabezera();
		NodoDoble s = null;
		Actividad aux;
		String[] list;
		boolean salida = false;
		if(n!=null){
			aux=(Actividad) ((NodoDoble) n.getDato()).getDato();
			list = ((Actividad) ((NodoDoble) n.getDato()).getDato()).getPrecedencias();
			
			if(!list[0].isEmpty()){
				for(int i=0; i<list.length;i++){
					s=n.getAnt();
					while(s != null & salida!=true){
						if(aux.compareTo(((Actividad) ((NodoDoble) s.getDato()).getDato()).getId())==0){
							((NodoDoble) n.getDato()).setSig((NodoDoble) ((NodoDoble) s.getDato()).getDato());
							salida = true;
						}else{
							s = s.getSig();
						}
					}						
				}					
			}
		}
	}
	
	/**
	 * Metodo que nos permite cargar las Antecedencias de las Actividades
	 * @param listaAct
	 */
	public static void cargarAntecedencias(ListaDoble listaAct){
		NodoDoble n = listaAct.getCabezera();
		NodoDoble nDup = null;
		NodoDoble s = n.getSig();
		Actividad aux = null;;
		while(n!=null&&s!=null){
			String[] list;
			String[] listAnt;
			String ant="";
			nDup = listaAct.getCabezera();
			aux=(Actividad) ((NodoDoble) n.getDato()).getDato();
			while(nDup!=null){
				list = ((Actividad) ((NodoDoble) nDup.getDato()).getDato()).getPrecedencias();				
				if(list[0]!=""){
					for(int i=0; i<list.length;i++){
						if(aux.getId().equals(list[i])){
							ant+=((Actividad) ((NodoDoble) nDup.getDato()).getDato()).getId();
						}	
					}
				}
				nDup=nDup.getSig();
			}
			listAnt=new String[ant.length()];
			for(int i=0;i<listAnt.length;i++){
				listAnt[i]=ant.substring(i, i+1);
			}
			aux.setAntecedencias(listAnt);
			n=n.getSig();
		}
		String[] list;
		boolean salida = false;
		if(n!=null){
			aux=(Actividad) ((NodoDoble) n.getDato()).getDato();
			list = ((Actividad) ((NodoDoble) n.getDato()).getDato()).getAntecedencias();
			if(list[0]!=""){
				for(int i=0; i<list.length;i++){
					s=n.getAnt();
					while(s != null&salida!=true){
						if(aux.compareTo(((Actividad) ((NodoDoble) s.getDato()).getDato()).getId())==0){
							((NodoDoble) n.getDato()).setAnt((NodoDoble) ((NodoDoble) s.getDato()).getDato());
							salida = true;
						}else{
							s = s.getSig();
						}
					}						
				}					
			}
		}
	}			
	
	/**
	 * Metodo que nos carga y muestra la Matriz de Adyacencia
	 * @param listaAct
	 */
	public static void mostrarMatriz(ListaDoble listaAct) {
		NodoDoble n=listaAct.getCabezera();
		Actividad a=null;
		String[] list;
		String espacio="  ";
		String salida=espacio;
		String a1="";
		int cant=0; 
		while(n!=null){
			cant=cant+1;
			n=n.getSig();
		}
		int[][] mat = new int[cant][cant];
		n = listaAct.getCabezera();
		int i=0;
		while(n!=null){
			a=(Actividad) ((NodoDoble) n.getDato()).getDato();
			list=a.getPrecedencias();
			for(int j = 0; j<list.length;j++){
				if(correlacion(list[j])<26){
					mat[i][correlacion(list[j])]=1;		
				}
			}
			n=n.getSig();
			i=i+1;
		}
		i=0;
		n=listaAct.getCabezera();
		while(n!=null){
			a=(Actividad) ((NodoDoble) n.getDato()).getDato();
			list=a.getAntecedencias();
			for(int j = 0; j<list.length;j++){
				if(correlacion(list[j])<26){
					mat[i][correlacion(list[j])]=1;		
				}
			}
			n=n.getSig();
			i=i+1;
		}					
		n=listaAct.getCabezera();
		System.out.println("   Matriz de adyacencia");
		System.out.println("");
	    while(n != null){
	    	salida += ((Actividad) ((NodoDoble) n.getDato()).getDato()).getId()+"  ";
	    	n = n.getSig();
	    }	    	
		System.out.println("   "+salida);
		n=listaAct.getCabezera();
		for(i = 0;i<mat.length;i++){
			salida="  ";
			salida+=((Actividad) ((NodoDoble) n.getDato()).getDato()).getId()+espacio;
			for(int j = 0;j<mat.length;j++){
				a1=Integer.toString(mat[i][j]);
				salida += a1;
				salida += espacio;
			}
			System.out.println(salida);
			n=n.getSig();
		}
	}

	/**
	 * Metodo que nos permite crear la correlacion de la matriz
	 * @param pal
	 * @return correlacion
	 */
	public static int correlacion(String pal){
		int num = 0;
		if(pal.equalsIgnoreCase("A")){
			num=0;		
		}else if(pal.equalsIgnoreCase("B")){
			num=1;
		}else if(pal.equalsIgnoreCase("C")){
			num=2;
		}else if(pal.equalsIgnoreCase("D")){
			num=3;
		}else if(pal.equalsIgnoreCase("E")){
			num=4;
		}else if(pal.equalsIgnoreCase("F")){
			num=5;
		}else if(pal.equalsIgnoreCase("G")){
			num=6;
		}else if(pal.equalsIgnoreCase("H")){
			num=7;
		}else if(pal.equalsIgnoreCase("I")){
			num=8;
		}else if(pal.equalsIgnoreCase("J")){
			num=9;
		}else if(pal.equalsIgnoreCase("K")){
			num=10;
		}else if(pal.equalsIgnoreCase("L")){
			num=11;
		}else if(pal.equalsIgnoreCase("M")){
			num=12;
		}else if(pal.equalsIgnoreCase("N")){
			num=13;
		}else if(pal.equalsIgnoreCase("Ñ")){
			num=14;
		}else if(pal.equalsIgnoreCase("O")){
			num=15;
		}else if(pal.equalsIgnoreCase("P")){
			num=16;
		}else if(pal.equalsIgnoreCase("Q")){
			num=17;
		}else if(pal.equalsIgnoreCase("R")){
			num=18;
		}else if(pal.equalsIgnoreCase("S")){
			num=19;
		}else if(pal.equalsIgnoreCase("T")){
			num=20;
		}else if(pal.equalsIgnoreCase("U")){
			num=21;
		}else if(pal.equalsIgnoreCase("V")){
			num=22;
		}else if(pal.equalsIgnoreCase("W")){
			num=23;
		}else if(pal.equalsIgnoreCase("X")){
			num=24;
		}else if(pal.equalsIgnoreCase("Y")){
			num=25;
		}else if(pal.equalsIgnoreCase("Z")){
			num=26;
		}else{
			num=99;
		}
		return num;
	}

	/**
	 * Metodo que nos permite calcular y mostrar el camino critico
	 */
	public static void mostrarCaminoCritico(ListaDoble listaAct) {
		// TODO Auto-generated method stub
		//utiliza actividad auxiliar para las siguientes actividades cargadas en la lista
		//como asi tambien auxiliar matriz de String para el atributo de las siguientes actividades a analizar
		NodoDoble n=listaAct.getCabezera();//nodo de la iteracion principal
		int iter=0;
		//se miden el tamaño que debera tener el vecor que guardara los ID
		while(n!=null){
			iter++;
			n=n.getSig();
		}
		n=listaAct.getCabezera();//se vuelve a n al primer nodo
		NodoDoble auxS=n;//auxiliar para las iteraciones
		String[] antAux;//auxiliar para precedencias 
		String actAux=((Actividad) ((NodoDoble) n.getDato()).getDato()).getId();//actividad a evaluar
		String[] auxPre=new String[iter];//vector donde se guardara las ID del camino critico
		int[] durPre=new int[iter];//vector donde se guardaran las duraciones de las actividades que componen el camino critico
		iter=1;//se vuelve el iterador a 1
		auxPre[0]=((Actividad) ((NodoDoble) n.getDato()).getDato()).getId();
		durPre[0]=((Actividad) ((NodoDoble) n.getDato()).getDato()).getTiempo();
		String actSig=((Actividad) ((NodoDoble) n.getDato()).getDato()).getId();//variable que determina el id de actividad a evaluar
		int dur=0;//atributo para guardar el mayor tiempo que se encuentre dentro de las antecedencias a evaluar
		int auxDur=0;
		int camCrit=((Actividad) ((NodoDoble) n.getDato()).getDato()).getTiempo();//se carga en variable que sumara los tiempos el de la primer actividad
		//partiendo de la raiz se busca el siguiente nodo conectado que tenga el menor tiempo
		while(n!=null){
			auxS=listaAct.getCabezera();//se setea el valor de nuestro nodo iterador
			while(actAux!=((Actividad) ((NodoDoble) auxS.getDato()).getDato()).getId()){
				auxS=auxS.getSig();
			}
			antAux=((Actividad) ((NodoDoble) n.getDato()).getDato()).getAntecedencias();
			if(antAux!=null){//se evalua que el vector tenga siguientes
				for(int i=0;i<antAux.length;i++){
					while(auxS!=null){
						if(antAux[i].equalsIgnoreCase(((Actividad) ((NodoDoble) auxS.getDato()).getDato()).getId())){
							auxDur=((Actividad) ((NodoDoble) auxS.getDato()).getDato()).getTiempo();
							if(dur<((Actividad) ((NodoDoble) auxS.getDato()).getDato()).getTiempo()){
								dur=auxDur;//se evalua que el el nodo de la antecedencia sea el de menor tiempo;
								actSig=((Actividad) ((NodoDoble) auxS.getDato()).getDato()).getId();
							}
						}
						auxS=auxS.getSig();
					}
					auxS=listaAct.getCabezera();
				}
			}
			//evalua si es la ultima actividad a calcular, caso contrario agrega los datos obtenidos
			if(actSig!=auxPre[iter-1]){
				camCrit=camCrit+dur;
				durPre[iter]=dur;
				dur=0;
				auxPre[iter]=actSig;
				actAux=actSig;
				n=n.getSig();
				iter++;				
			}else{
				break;
			}
		}
		actSig="";
		for(int i=0;i<auxPre.length;i++){
			if(auxPre[i]!=null){
				actSig+=auxPre[i]+" ";				
			}else{
				break;
			}
		}
		System.out.print("el camino critico es la sucecion de actividades "+actSig
				+ "\n suma un tiempo total de "+camCrit);
	}
}
