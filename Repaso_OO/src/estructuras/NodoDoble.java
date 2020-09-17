package estructuras;

public class NodoDoble {
	private Object dato;
	private NodoDoble ant;
	private NodoDoble sig;
	
	public NodoDoble(Object dato) {
		this.dato = dato;
		this.ant = null;
		this.sig = null;
	}

	public Object getDato() {
		return dato;
	}
	
	public void setDato(Object dato) {
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
	
}
