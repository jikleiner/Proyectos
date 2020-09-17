package modelo;

import estructuras.ListaDoble;
import estructuras.NodoDoble;

public class Grafo {
	private ListaDoble listaVertices;
	private ListaDoble listaAristas;

	public Grafo(ListaDoble listaVertices, ListaDoble listaAristas) {
		this.listaVertices = listaVertices;
		this.listaAristas = listaAristas;
	}

	public ListaDoble getListaVertices() {
		return listaVertices;
	}

	public void setListaVertices(ListaDoble listaVertices) {
		this.listaVertices = listaVertices;
	}

	public ListaDoble getListaAristas() {
		return listaAristas;
	}

	public void setListaAristas(ListaDoble listaAristas) {
		this.listaAristas = listaAristas;
	}

	public int encontrarCamino(String codRouterOrigen, String codRouterDestino) {
		for (int i = 1; i <= this.getListaAristas().cantidadDeElementos(); i++) {

			NodoDoble nodo = new NodoDoble();
			nodo = (NodoDoble) this.getListaAristas().devolverElementoPosEspecifica(i);

			Camino camino = new Camino("", "", "", 0);
			camino = (Camino) nodo.getDato();

			if (camino.getCodRouterDestino().equals(codRouterDestino)
					&& camino.getCodRouterOrigen().equals(codRouterOrigen)) {
				return camino.getCosto();
			}

		}
		return 0;
	}

	/*
	 * public void Dijkstra(String origen, String destino){ int[] distancia;
	 * int[] boleean;
	 * 
	 * for (int i = 1; i <= this.getListaAristas().cantidadDeElementos(); i++){
	 * NodoDoble nodoA = new NodoDoble(); nodoA = (NodoDoble)
	 * this.getListaAristas().devolverElementoPosEspecifica(i); Camino caminoA =
	 * new Camino("", "","", 0); caminoA = (Camino) nodoA.getDato();
	 * 
	 * }
	 * 
	 * }
	 */

}
