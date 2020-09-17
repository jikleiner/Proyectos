package modelo;

import Estructuras.Hashable;

public class Materia implements Hashable, Comparable{
	private String nombreMateria;
	private int cod;

	public Materia(String nombreMateria, int cod) {
		super();
		this.nombreMateria = nombreMateria;
		this.cod = cod;
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "Materia [nombreMateria=" + nombreMateria + ", cod=" + cod + "]";
	}

	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Integer otro = (Integer) arg0;
		Integer este = this.cod;
		return este.compareTo(otro);
	}
	
	@Override
	public int hash(int tablaSize) {
		 int x = new Integer(this.cod)%tablaSize;
		 return x;
	}

	
}
