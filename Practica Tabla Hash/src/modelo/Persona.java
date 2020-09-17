package modelo;

import estructura.Hashable;

public class Persona implements Hashable,Comparable{
	private String nombre;
	private String apellido;
	private String dni;
	private String sexo;
	
	

	public Persona(String nombre, String apellido, String dni, String sexo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", sexo=" + sexo + "]";
	}

	@Override
	public int hash(int tamañoTabla) {
		int x = new Integer(this.dni) % tamañoTabla;
		return x;
	}

	@Override
	public int compareTo(Object o) {
		Persona p = (Persona)o;
		return this.getDni().compareTo(p.getDni());
	}

}
