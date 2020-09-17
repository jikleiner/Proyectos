package modelo;

import Estructuras.Hashable;
import Estructuras.TablaExploracionLineal;

public class Alumno implements Comparable{
	private String nombre;
	private String apellido;
	private int legajo;
	private TablaExploracionLineal materias;

	public Alumno(String nombre, String apellido, int legajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.materias=new TablaExploracionLineal();
	}

	public Alumno(Integer le) {
		// TODO Auto-generated constructor stub
		super();
		this.nombre = null;
		this.apellido = null;
		this.legajo = le;
		this.materias=null;		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public TablaExploracionLineal getMaterias() {
		return materias;
	}

	public void setMaterias(TablaExploracionLineal materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", legajo=" + legajo + "]";
	}


	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Integer otro = (Integer) ((Alumno) arg0).getLegajo();
		Integer este = this.legajo;
		return este.compareTo(otro);
	}
}
