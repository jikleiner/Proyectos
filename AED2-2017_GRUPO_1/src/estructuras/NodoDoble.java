package estructuras;

public class NodoDoble implements Comparable {
	private Comparable dato;
	private NodoDoble ant;
	private NodoDoble sig;
	
	
	
	/**
	 * Constructor de nuestro Nodo doble
	 * @param dato comparable
	 */
	public NodoDoble(Comparable dato) {
		this.dato = dato;
		this.ant = null;
		this.sig = null;
	}

	public Comparable getDato() {
		return dato;
	}
	
	public void setDato(Comparable dato) {
		this.dato = dato;
	}
	
	public NodoDoble getAnt() {
		return ant;
	}
	
	public void setAnt(NodoDoble ant) {
		this.ant = ant;
	}
	
	public NodoDoble getSig() {
		return sig;
	}
	
	public void setSig(NodoDoble sig) {
		this.sig = sig;
	}

	@Override
	/**
	 * Metodo compareTO comparable
	 */
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		NodoDoble n=(NodoDoble)arg0;
		return this.getDato().compareTo(n.getDato());
	}
	
}
