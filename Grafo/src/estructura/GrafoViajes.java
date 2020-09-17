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

	public void crearArista(String origen, String destino, int peso, float tiempo, int ida, int vuelta) {
		// ver tema de vertices que puedan estar no creados y se deseen incluir
		// en la arista
		AristaViaje a = new AristaViaje(origen, destino, peso, tiempo, ida, vuelta);
		this.getListaArista().add(a);
		this.cargarAdyacencias(a);
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

	public float devolverFW_tiempo(String ini, String fin){
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
		return (float)tiemposFW[i][j];
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
