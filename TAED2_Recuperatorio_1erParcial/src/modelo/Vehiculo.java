package modelo;

import estructuras.Hashable;

public class Vehiculo implements Hashable, Comparable{
	private String patente;
	private int modelo;
	private String marca;

	public Vehiculo(String patente, int modelo, String marca) {
		super();
		this.patente = patente;
		this.modelo = modelo;
		this.marca = marca;
	}

	public Vehiculo(String patente2) {
		// TODO Auto-generated constructor stub
		this.patente = patente2;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public int getModelo() {
		return modelo;
	}
	
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", modelo=" + modelo + ", marca=" + marca + "]";
	}

	@Override
	public int hash(int tablaSize) {
		// TODO Auto-generated method stub
 		int x = new Integer(this.patente.substring(2, 5))%tablaSize;
 		return x;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getPatente().compareTo(((Vehiculo) o).getPatente());
	}
	
}
