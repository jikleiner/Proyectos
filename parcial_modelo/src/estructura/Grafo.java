package estructura;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.tree.TreePath;

public abstract class Grafo {
	/*
	 * ALGORITMOS: 1 DFS 2 BFS 3 DIJKSTRA 4 FLOY WARSHALL 5 CAMINO MINIMO SIN
	 * CALCULAR COSTO DE ARISTAS 6 CAMINO MINIMO ENTRE DOS NODOS CUALQUIERA
	 * CALCULANDO COSTO
	 */
	private ArrayList<Vertice> listaVertices;
	private ArrayList<Arista> listaArista;
	private Vertice[][] verticesFWCosto;
	private int[][] costosFW;

	public Grafo() {
		super();
		this.listaVertices = new ArrayList();
		this.listaArista = new ArrayList();
	}

	protected ArrayList<Vertice> getListaVertices() {
		return listaVertices;
	}

	protected ArrayList<Arista> getListaArista() {
		return listaArista;
	}
	
	public Vertice[][] getVerticesFWCosto() {
		return verticesFWCosto;
	}

	public void setVerticesFWCosto(Vertice[][] verticesFWCosto) {
		this.verticesFWCosto = verticesFWCosto;
	}

	public int[][] getCostosFW() {
		return costosFW;
	}

	public void setCostosFW(int[][] costosFW) {
		this.costosFW = costosFW;
	}
	
	public void crearVertice(String nomb) {
		Vertice v = new Vertice(nomb);
		listaVertices.add(v);
	}

	
	protected void cargarAdyacencias(Arista nueva){
		for(Vertice actual:listaVertices){
			if(nueva.getDestino().equals(actual.getNombre())){
				for(Vertice link:listaVertices){
					if(nueva.getOrigen().equals(link.getNombre())){
						actual.getAdyacentes().add(link);
					}
				}
			}
			if(nueva.getOrigen().equals(actual.getNombre())){
				for(Vertice link:listaVertices){
					if(nueva.getDestino().equals(link.getNombre())){
						actual.getAdyacentes().add(link);
					}
				}
			}
		}
	}
	
	public Vertice devolverVertice(String dato){
		Vertice vertice = null;
		for(Vertice actual:listaVertices){
			if(actual.getNombre().equals(dato)){
				vertice = actual;
			}
		}
		return vertice;
	}
	
	public void dijkstra(String origen) {
		Vertice x =  this.devolverVertice(origen);// nodo inicial
		Vertice a = x;// nodo copia inicial		
		ArrayList<String> vistos = new ArrayList();
		ArrayList<String> marcados = new ArrayList();
		ArrayList<Integer> costos = new ArrayList();
		for (int i = 0; i < listaVertices.size(); i++) {
			marcados.add(listaVertices.get(i).getNombre());
		}
		costos.add(0);
		vistos.add(a.getNombre());
		marcados.remove(a.getNombre());
		Integer auxCosto = 0;
		String auxOrigen = "";
		/*
		 * algoritmo de resolucion
		 */
		for(String cada : marcados){
			auxCosto=9999;
			for(int i=0; i<vistos.size();i++){
				for(int j=0; j<listaArista.size();j++){
					if(listaArista.get(j).getOrigen()==vistos.get(i)&listaArista.get(j).getDestino()==cada){
						if(listaArista.get(j).getCosto()<auxCosto){
							auxCosto=listaArista.get(j).getCosto()+costos.get(i);
							auxOrigen=vistos.get(i);
						}
					}
					if(listaArista.get(j).getDestino()==vistos.get(i)&listaArista.get(j).getOrigen()==cada){
						if(listaArista.get(j).getCosto()<auxCosto){
							auxCosto=listaArista.get(j).getCosto()+costos.get(i);
							auxOrigen=vistos.get(i);
						}						
					}						
				}
			}
			costos.add(auxCosto);
			vistos.add(cada);
		}
		/*
		 * se muestra el resultado
		 */
		System.out.println("los caminos minimos acumuladoses el de los vertices:");
		for (String cada : vistos) {
			System.out.println(cada+" - costo minimo desde 1er vertice: " + costos.get(vistos.indexOf(cada)));
		}
	}

	private void floydWarshall() {
		this.verticesFWCosto = new Vertice[this.getListaVertices().size()][this.getListaVertices().size()];
		this.costosFW = new int[this.getListaVertices().size()][this.getListaVertices().size()];

		int fila = 0;
		int columna = 0;
		int k = 0;
		/*
		 * se carga la matriz dependencia del algoritmo
		 */
		for (int i = 0; i < costosFW.length; i++) {
			for (int j = 0; j < costosFW.length; j++) {
				costosFW[i][j] = 99999;
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
			verticesFWCosto[fila][columna] = this.devolverVertice(aux.getDestino());
			verticesFWCosto[columna][fila] = this.devolverVertice(aux.getOrigen());

			costosFW[fila][columna] = aux.getCosto();
			costosFW[columna][fila] = aux.getCosto();
			fila = 0;
			columna = 0;
		}
		for (int i = 0; i < verticesFWCosto.length; i++){
			for (int j = 0; j < verticesFWCosto.length; j++){
				if(i!=j){
					if(verticesFWCosto[i][j]==null){
						verticesFWCosto[i][j]=this.getListaVertices().get(i);
					}					
				}
			}
		}
		/*
		 * algoritmo de resolucion
		 */
		while (k < verticesFWCosto.length) {
			for (fila = 0; fila < verticesFWCosto.length; fila++) {
				for (columna = 0; columna < verticesFWCosto.length; columna++) {
					if (fila != k & columna != k & fila != columna) {
						if ((costosFW[fila][k] + costosFW[k][columna]) < costosFW[fila][columna]) {
							verticesFWCosto[fila][columna] = verticesFWCosto[fila][k];
							costosFW[fila][columna] = costosFW[fila][k] + costosFW[k][columna];
						}
					}
				}
			}
			k++;
		}
	}
	
	public ArrayList<Vertice> devolverCaminoFW(String ini, String fin){
		/*
		 * se devuelve el valor del camino optimo
		 */
		floydWarshall();
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
					retorno.add(this.verticesFWCosto[i][j]);
					start=this.verticesFWCosto[i][j];
					break;
				} else {
					j++;
				}
			}			
		}
		return retorno;
	}
	
	public int devolverFW_costo(String ini, String fin){
		/*
		 * se devuelve el valor del camino optimo
		 */
		floydWarshall();
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
		return this.costosFW[i][j];
	}
	
	public void dfsRecorrido(String inicio){
		Vertice ini=devolverVertice(inicio);
        Stack<Vertice> pila = new Stack();
		if(ini != null){
            pila.add(ini);
            while(pila.size() > 0){
                Vertice verticeVisitado=pila.pop();
                if(verticeVisitado.isVisto() == false){
                    verticeVisitado.setVisto(true);
                    System.out.print(verticeVisitado.getNombre()+",");                
                    pila.addAll(verticeVisitado.getAdyacentes());
                }
            }
        }
		for(Vertice actual:getListaVertices()){
			actual.setVisto(false);
		}
	}

	public void bfsRecorrido(String inicio){
		Vertice ini=devolverVertice(inicio);
        Queue<Vertice> cola = new LinkedList<Vertice>();
		if(ini != null){
            cola.add(ini);
            while(cola.size() > 0){
                Vertice verticeVisitado=cola.poll();
                if(verticeVisitado.isVisto() == false){
                    verticeVisitado.setVisto(true);
                    System.out.print(verticeVisitado.getNombre()+",");                
                    cola.addAll(verticeVisitado.getAdyacentes());
                }
            }
        }
		for(Vertice actual:getListaVertices()){
			actual.setVisto(false);
		}
	}
	
	public Vertice bfsBusqueda(String inicio, String fin){
		Vertice ini=devolverVertice(inicio);
		Vertice end=devolverVertice(fin);
		int i=0;
        Queue<Vertice> cola = new LinkedList<Vertice>();
		if(ini != null){			
            cola.add(ini);
            while(cola.size() > 0){
                Vertice verticeVisitado=cola.poll();
                if(verticeVisitado.isVisto() == false){
        			ini.setDistancia(i);
                	verticeVisitado.setVisto(true);
                    for(Vertice c:verticeVisitado.getAdyacentes()){
                    	if(c.isVisto()!=true){
                    		if(c.getDistancia()>999){
                    			c.setAnterior(verticeVisitado);
                        		c.setDistancia(verticeVisitado.getDistancia()+1);	                    			
                    		}
                    	}
                    	
                    }
                    cola.addAll(verticeVisitado.getAdyacentes());
                }
            }
        }
		for(Vertice actual:getListaVertices()){
			actual.setVisto(false);
		}
		return end;
	}	
}
