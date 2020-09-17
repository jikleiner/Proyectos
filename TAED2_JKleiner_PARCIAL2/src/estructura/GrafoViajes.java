package estructura;
import java.util.ArrayList;

public class GrafoViajes extends Grafo {

	private Vertice[][] verticesFWTiempo;
	private float[][] tiemposFW;
	private int[][] costoMenorTiempoFW;
	
	public GrafoViajes() {
		super();
	}

	public Vertice[][] getVerticesFWTiempo() {
		return verticesFWTiempo;
	}

	public void setVerticesFWTiempo(Vertice[][] verticesFW) {
		this.verticesFWTiempo = verticesFW;
	}

	public float[][] getTiemposFW() {
		return tiemposFW;
	}

	public void setTiemposFW(float[][] tiemposFW) {
		this.tiemposFW = tiemposFW;
	}
	
	public void cargarGrafo(){
		this.crearVerticeAeropuerto("Montevideo", 3000, "Regional");
		this.crearVerticeAeropuerto("Cordoba", 2000, "Regional");
		this.crearVerticeAeropuerto("Sao Paulo", 10000, "Internacional");
		this.crearVerticeAeropuerto("Quito", 4000, "Regional");
		this.crearVerticeAeropuerto("Lima", 7000, "Internacional");
		this.crearVerticeAeropuerto("Santiago", 7000, "Internacional");
		this.crearVerticeAeropuerto("Sidney", 10000, "Internacional");
		this.crearArista("Montevideo", "Cordoba", 300, 90);
		this.crearArista("Montevideo", "Sao Paulo", 200, 70);
		this.crearArista("Sao Paulo", "Quito", 300, 400);
		this.crearArista("Sao Paulo", "Lima", 400, 300);
		this.crearArista("Sao Paulo", "Santiago", 420, 200);
		this.crearArista("Sao Paulo", "Cordoba", 330, 125);
		this.crearArista("Cordoba", "Lima", 250, 180);
		this.crearArista("Cordoba", "Santiago", 150, 80);
		this.crearArista("Quito", "Lima", 150, 100);
		this.crearArista("Santiago", "Sidney", 450, 500);
		this.crearArista("Lima", "Sidney", 400, 400);		
	}

	public void mostrarCosto(){
		int vuelta = this.devolverFW_costo("Montevideo", "Sidney");
		ArrayList<Vertice> costo=this.devolverCaminoFW("Montevideo", "Sidney");
		for(Vertice v:costo){
			System.out.println(v.getNombre());
		}
		System.out.println("con un costo de u$d: " + vuelta);		
	}

	public void mostrarTiempo(){
		int vueltaTiempo = this.devolverFW_tiempo("Montevideo", "Sidney");
		ArrayList<Vertice> tiempo=this.devolverCaminoFW_tiempo("Montevideo", "Sidney");
		for(Vertice a:tiempo){
			System.out.println(a.getNombre());
		}
		System.out.println("con un tiempo de minutos: " + vueltaTiempo);		
	}
	
	public void mostrarAeropuertosDfs(String inicio){
		ArrayList<Vertice> esto = this.dfsRecorrido(inicio);
		for(Vertice v:esto){
			System.out.println(v.getNombre()+" - "+((VerticeAeropuerto) v).getCategoria());
		}
	}
	
	public void mostrarAeropuertosBfs(String inicio){
		ArrayList<Vertice> esto = this.bfsRecorrido(inicio);
		int tamaño=0;
		for(Vertice v:esto){
			tamaño+=((VerticeAeropuerto) v).getSuperficie();
		}
		System.out.println("total de m2 de todos los aeropuertos: "+tamaño);
	}
	
	public void crearArista(String origen, String destino, int costo, int duracion ) {
		// ver tema de vertices que puedan estar no creados y se deseen incluir
		// en la arista
		AristaViaje a = new AristaViaje(origen, destino, costo, duracion);
		this.getListaArista().add(a);
		this.cargarAdyacencias(a);
	}
	
	public void crearVerticeAeropuerto(String nombre, int superficie, String categoria) {
		VerticeAeropuerto v = new VerticeAeropuerto(nombre, superficie, categoria);
		getListaVertices().add(v);
	}
	
	private void floydWarshall_tiempo() {
		this.verticesFWTiempo = new Vertice[this.getListaVertices().size()][this.getListaVertices().size()];
		this.tiemposFW = new float[this.getListaVertices().size()][this.getListaVertices().size()];
		
		int fila = 0;
		int columna = 0;
		int k = 0;
		/*
		 * se carga la matriz dependencia del algoritmo
		 */
		for (int i = 0; i < tiemposFW.length; i++) {
			for (int j = 0; j < tiemposFW.length; j++) {
				tiemposFW[i][j] = 99999;
			}
		}
		for (int i = 0; i < this.getListaArista().size(); i++) {
			AristaViaje aux = (AristaViaje) this.getListaArista().get(i);
			while (this.getListaVertices().get(fila).getNombre() != aux.getOrigen() & fila <= this.getListaVertices().size()) {
				fila++;
			}
			while (this.getListaVertices().get(columna).getNombre() != aux.getDestino() & columna <= this.getListaVertices().size()) {
				columna++;
			}
			verticesFWTiempo[fila][columna] = this.devolverVertice(aux.getDestino());
			verticesFWTiempo[columna][fila] = this.devolverVertice(aux.getOrigen());

			tiemposFW[fila][columna] = aux.getDuracion();
			tiemposFW[columna][fila] = aux.getDuracion();
			
			fila = 0;
			columna = 0;
		}
		for (int i = 0; i < verticesFWTiempo.length; i++){
			for (int j = 0; j < verticesFWTiempo.length; j++){
				if(i!=j){
					if(verticesFWTiempo[i][j]==null){
						verticesFWTiempo[i][j]=this.getListaVertices().get(i);
					}					
				}
			}
		}
		/*
		 * algoritmo de resolucion
		 */
		while (k < verticesFWTiempo.length) {
			for (fila = 0; fila < verticesFWTiempo.length; fila++) {
				for (columna = 0; columna < verticesFWTiempo.length; columna++) {
					if (fila != k & columna != k & fila != columna) {
						if ((tiemposFW[fila][k] + tiemposFW[k][columna]) < tiemposFW[fila][columna]) {
							verticesFWTiempo[fila][columna] = verticesFWTiempo[fila][k];
							tiemposFW[fila][columna] = tiemposFW[fila][k] + tiemposFW[k][columna];
						}
					}
				}
			}
			k++;
		}
	}
	
	public ArrayList<Vertice> devolverCaminoFW_tiempo(String ini, String fin){
		/*
		 * se devuelve el valor del camino optimo
		 */
		floydWarshall_tiempo();
		ArrayList<Vertice> retorno=new ArrayList<Vertice>();
		Vertice start = this.devolverVertice(ini);
		Vertice end = this.devolverVertice(fin);
		int i = 0;
		int j = 0;
		retorno.add(this.getListaVertices().get(this.getListaVertices().indexOf(start)));
		while(retorno.contains(end)!=true){
			while (i < this.getListaVertices().size()) {
				if (this.getListaVertices().get(i).compareTo(start) == 0) {
					break;
				} else {
					i++;
				}
			}
			while (j < this.getListaVertices().size()) {
				if (this.getListaVertices().get(j).compareTo(end) == 0) {
					retorno.add(this.verticesFWTiempo[i][j]);
					start=this.verticesFWTiempo[i][j];
					break;
				} else {
					j++;
				}
			}			
		}
		return retorno;
	}

	public int devolverFW_tiempo(String ini, String fin){
		/*
		 * se devuelve el valor del camino optimo
		 */
		floydWarshall_tiempo();
		Vertice start = this.devolverVertice(ini);
		Vertice end = this.devolverVertice(fin);
		int i = 0;
		int j = 0;
		while (i < this.getListaVertices().size()) {
			if (this.getListaVertices().get(i).compareTo(start) == 0) {
				break;
			} else {
				i++;
			}
		}
		while (j < this.getListaVertices().size()) {
			if (this.getListaVertices().get(j).compareTo(end) == 0) {
				break;
			} else {
				j++;
			}
		}			
		return (int) tiemposFW[i][j];
	}
	
	public float devolverFW_costoMenorTiempo(String ini, String fin){
		/*
		 * se devuelve el valor del camino optimo
		 */
		floydWarshall_tiempo();
		Vertice start = this.devolverVertice(ini);
		Vertice end = this.devolverVertice(fin);
		int i = 0;
		int j = 0;
		while (i < this.getListaVertices().size()) {
			if (this.getListaVertices().get(i).compareTo(start) == 0) {
				break;
			} else {
				i++;
			}
		}
		while (j < this.getListaVertices().size()) {
			if (this.getListaVertices().get(j).compareTo(end) == 0) {
				start=this.verticesFWTiempo[i][j];
				break;
			} else {
				j++;
			}
		}			
		return this.costoMenorTiempoFW[i][j];
	}

	
}
