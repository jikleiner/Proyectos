package estructuras;

public class NodoDoble implements Comparable {
	private Comparable dato;
	private NodoDoble ant;
	private NodoDoble sig;
	
	/**
	 * Constructor del Nodo doble
	 * @param dato comparable
	 */
	
	public NodoDoble(){
		
	}
	
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
	 * Método compareTO de los datos
	 */
	public int compareTo(Object arg0) {
		NodoDoble n=(NodoDoble)arg0;
		return this.getDato().compareTo(n.getDato());
	}

	@Override
	public String toString() {
		return "[" + dato + "]";
	}
	
	
}
