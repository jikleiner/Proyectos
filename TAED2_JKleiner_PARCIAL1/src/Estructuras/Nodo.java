package Estructuras;

public class Nodo implements Comparable{
	private Comparable dato;
	private Nodo der;
	private Nodo izq;
	private int nivel;

	public Nodo(){
		this.dato=null;
	}
	public Nodo(Comparable dato) {
		super();
		this.dato = dato;
	}
	public Nodo(Comparable dato, Nodo izq, Nodo der, int nivel){
		this.dato=dato;
		this.der=der;
		this.izq=izq;
		this.nivel=nivel;
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public Comparable getDato() {
		return dato;
	}
	public void setDato(Comparable dato) {
		this.dato = dato;
	}
	public Nodo getDer() {
		return der;
	}
	public void setDer(Nodo der) {
		this.der = der;
	}
	public Nodo getIzq() {
		return izq;
	}
	public void setIzq(Nodo izq) {
		this.izq = izq;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Nodo n=(Nodo)arg0;
		return this.getDato().compareTo(n.getDato());
	}
	
}
