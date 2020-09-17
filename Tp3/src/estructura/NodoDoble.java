package estructura;

public class NodoDoble<T extends Object>{
	private T dato;//cualquier tipo de valor,
	private NodoDoble<T> sig;
	private NodoDoble<T> ant;
	
	public NodoDoble() {
		this.dato = null;
		this.sig = null;
		this.ant = null;
	}
	public T getDato() {
		return dato;
	}


	public void setDato(T dato) {
		this.dato = dato;
	}


	public NodoDoble<T> getSig() {
		return sig;
	}


	public void setSig(NodoDoble<T> sig) {
		this.sig = sig;
	}


	public NodoDoble<T> getAnt() {
		return ant;
	}


	public void setAnt(NodoDoble<T> ant) {
		this.ant = ant;
	}


	public NodoDoble(T dato) {
		this.dato = dato;
	}
	public NodoDoble(T dato, NodoDoble sig) {
		this.dato = dato;
		this.sig = sig;
	}
	public NodoDoble(T dato, NodoDoble sig, NodoDoble ant) {
		this.dato = dato;
		this.sig = sig;
		this.ant = ant;
	}
}
