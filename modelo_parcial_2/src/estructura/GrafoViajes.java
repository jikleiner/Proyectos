package estructura;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

	private void floydWarshall_tiempo() {
		this.verticesFWTiempo = new Vertice[this.getListaVertices().size()][this.getListaVertices().size()];
		this.tiemposFW = new float[this.getListaVertices().size()][this.getListaVertices().size()];
		this.costoMenorTiempoFW = new int[this.getListaVertices().size()][this.getListaVertices().size()];
		
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

			tiemposFW[fila][columna] = aux.getTiempo();
			tiemposFW[columna][fila] = aux.getTiempo();
			
			costoMenorTiempoFW[fila][columna] = aux.getCosto();
			costoMenorTiempoFW[columna][fila] = aux.getCosto();
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
							costoMenorTiempoFW[fila][columna] = costoMenorTiempoFW[fila][k] + costoMenorTiempoFW[k][columna];
						}
					}
				}
			}
			k++;
			/*
		 	* System.out.println(tiemposFW[0][0]+"|"+tiemposFW[0][1]+"|"+tiemposFW[0][2]+"|"+tiemposFW[0][3]+"|"+tiemposFW[0][4]+"|"+tiemposFW[0][5]+"");
			* System.out.println(tiemposFW[1][0]+"|"+tiemposFW[1][1]+"|"+tiemposFW[1][2]+"|"+tiemposFW[1][3]+"|"+tiemposFW[1][4]+"|"+tiemposFW[1][5]+"");
			* System.out.println(tiemposFW[2][0]+"|"+tiemposFW[2][1]+"|"+tiemposFW[2][2]+"|"+tiemposFW[2][3]+"|"+tiemposFW[2][4]+"|"+tiemposFW[2][5]+"");
			* System.out.println(tiemposFW[3][0]+"|"+tiemposFW[3][1]+"|"+tiemposFW[3][2]+"|"+tiemposFW[3][3]+"|"+tiemposFW[3][4]+"|"+tiemposFW[3][5]+"");
			* System.out.println(tiemposFW[4][0]+"|"+tiemposFW[4][1]+"|"+tiemposFW[4][2]+"|"+tiemposFW[4][3]+"|"+tiemposFW[4][4]+"|"+tiemposFW[4][5]+"");
			* System.out.println(tiemposFW[5][0]+"|"+tiemposFW[5][1]+"|"+tiemposFW[5][2]+"|"+tiemposFW[5][3]+"|"+tiemposFW[5][4]+"|"+tiemposFW[5][5]+"");
			* System.out.println("");
			* System.out.println("null"+"|"+verticesFWTiempo[0][1].toString()+"|"+verticesFWTiempo[0][2].toString()+"|"+verticesFWTiempo[0][3].toString()+"|"+verticesFWTiempo[0][4].toString()+"|"+verticesFWTiempo[0][5].toString()+"");
			* System.out.println(verticesFWTiempo[1][0].toString()+"|"+"null"+"|"+verticesFWTiempo[1][2].toString()+"|"+verticesFWTiempo[1][3].toString()+"|"+verticesFWTiempo[1][4].toString()+"|"+verticesFWTiempo[1][5].toString()+"");
			* System.out.println(verticesFWTiempo[2][0].toString()+"|"+verticesFWTiempo[2][1].toString()+"|"+"null"+"|"+verticesFWTiempo[2][3].toString()+"|"+verticesFWTiempo[2][4].toString()+"|"+verticesFWTiempo[2][5].toString()+"");
			* System.out.println(verticesFWTiempo[3][0].toString()+"|"+verticesFWTiempo[3][1].toString()+"|"+verticesFWTiempo[3][2].toString()+"|"+"null"+"|"+verticesFWTiempo[3][4].toString()+"|"+verticesFWTiempo[3][5].toString()+"");
			* System.out.println(verticesFWTiempo[4][0].toString()+"|"+verticesFWTiempo[4][1].toString()+"|"+verticesFWTiempo[4][2].toString()+"|"+verticesFWTiempo[4][3].toString()+"|"+"null"+"|"+verticesFWTiempo[4][5].toString()+"");
			* System.out.println(verticesFWTiempo[5][0].toString()+"|"+verticesFWTiempo[5][1].toString()+"|"+verticesFWTiempo[5][2].toString()+"|"+verticesFWTiempo[5][3].toString()+"|"+verticesFWTiempo[5][4].toString()+"|"+"null"+"");
			* System.out.println("");
			*/
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
				start=this.verticesFWTiempo[i][j];
				break;
			} else {
				j++;
			}
		}			
		return this.tiemposFW[i][j];
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


	@Override
	public void DFS(String inicio, String fin) {
		// TODO Auto-generated method stub
		//auxiliares
		ArrayList<String> listaVertices = new ArrayList();
		ArrayList<Arista> listaArista = this.getListaArista();
		//
		for(Vertice v : this.getListaVertices()){
			listaVertices.add(v.getNombre());
		}
		String start = inicio;
		String siguiente = start;
		boolean encontrado = false;
		boolean haySiguiente = false;
		Stack<String> pilaCamino = new Stack();
		ArrayList<String> listaVisitados = new ArrayList();
		if (listaVertices.contains(fin) == true) {
			pilaCamino.add(start);
			while (encontrado != true) {
				haySiguiente = false;
				for (int i = 0; i < listaArista.size(); i++) {
					if (listaArista.get(i).getOrigen() == siguiente) {
						if (listaVisitados.contains(listaArista.get(i).getDestino()) == false & pilaCamino.contains(listaArista.get(i).getDestino()) == false) {
							siguiente = listaArista.get(i).getDestino();
							pilaCamino.add(siguiente);
							listaVisitados.add(siguiente);
							haySiguiente = true;
							break;
						}
					} else if (listaArista.get(i).getDestino() == siguiente) {
						if (listaVisitados.contains(listaArista.get(i).getOrigen()) == false & pilaCamino.contains(listaArista.get(i).getDestino()) == false) {
							siguiente = listaArista.get(i).getOrigen();
							pilaCamino.add(siguiente);
							listaVisitados.add(siguiente);
							haySiguiente = true;
							break;
						}
					}
				}
				if (siguiente == fin) {
					encontrado = true;
				}else if (haySiguiente == false) {
					pilaCamino.clear();
					pilaCamino.add(start);
					siguiente=start;
				}

			}
			System.out.println("el menor camino entre los vertices es de :" + (pilaCamino.size()-1) + " aristas");
		} else {
			System.out.println("el nombre de vertice buscado no es valido");
		}
	}
	
	@Override
	public void BFS(String inicio, String fin) {
		// TODO Auto-generated method stub
		//auxiliares
		ArrayList<String> listaVertices = new ArrayList();
		ArrayList<Arista> listaArista = this.getListaArista();
		//
		for(Vertice v : this.getListaVertices()){
			listaVertices.add(v.getNombre());
		}
		String start = inicio;
		String siguiente = "";
		boolean encontrado = false;
		Queue<String> colaNoVisitados = new PriorityQueue<String>();
		ArrayList<String> listaVisitados = new ArrayList();
		// buscar vertices conectados a la raiz o inicio
		if (listaVertices.contains(fin) == true) {
			colaNoVisitados.add(start);
			while (colaNoVisitados.isEmpty() | encontrado != true) {
				if (start != fin) {
					for (int i = 0; i < listaArista.size(); i++) {
						if (listaArista.get(i).getOrigen() == start) {
							if (listaVisitados.contains(listaArista.get(i).getDestino()) == false) {
								colaNoVisitados.add(listaArista.get(i).getDestino());
								siguiente = listaArista.get(i).getDestino();
							}
						} else if (listaArista.get(i).getDestino() == start) {
							if (listaVisitados.contains(listaArista.get(i).getOrigen()) == false) {
								colaNoVisitados.add(listaArista.get(i).getOrigen());
								siguiente = listaArista.get(i).getDestino();
							}
						}
					}
					if(siguiente!=start){
						listaVisitados.add(colaNoVisitados.peek());
						colaNoVisitados.remove();
						start = colaNoVisitados.peek();						
					}else{
						listaVisitados.add(start);
						listaVisitados.remove(inicio);
						colaNoVisitados.clear();
						start = inicio;
						colaNoVisitados.add(start);
					}
				} else {
					encontrado = true;
				}
			}
		} else {
			System.out.println("el nombre de vertice buscado no es valido");
		}
		System.out.println("el menor camino entre los vertices es de :" + " aristas");
	}

	
}
