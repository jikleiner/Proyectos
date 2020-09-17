package estructura;

public class Nodo {
	
	private Object dato;
	private Nodo ref;
	
	public Nodo() {
		
	}
	
	
	public Nodo(Object dato) {
		super();
		this.dato = dato;
		this.ref = null;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public Nodo getRef() {
		return ref;
	}
	public void setRef(Nodo nodo) {
		this.ref = nodo;
	} 
	

}
