package modelo;

import java.util.ArrayList;

import estructuras.Hashable;

public class Conductor implements Hashable{
	private int dni;
	private String nombre;
	private String apellido;
	private ArrayList<String> telefonos;
	
	public Conductor(int dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonos = new ArrayList<String>();
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public ArrayList getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "Conductor [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefonos=" + telefonos
				+ "]";
	}

	@Override
	public int hash(int tablaSize) {
		// TODO Auto-generated method stub
		int x = new Integer(this.dni)%tablaSize;
		return x;
	}
	
}
