package modelo;

import java.util.Arrays;

public class Actividad implements Comparable{
	private String id;
	private String nombre;
	private String[] precedencias;
	private String[] antecedencias;
	private int tiempo;
	
	/**
	 * Constructor de nuestro objeto Actividad
	 * @param id
	 * @param nombre
	 * @param precedencias
	 * @param tiempo
	 */
	public Actividad(String id, String nombre, String[] precedencias, String tiempo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.tiempo = Integer.parseInt(tiempo);
		this.precedencias = precedencias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String[] getPrecedencias() {
		return precedencias;
	}

	public void setPrecedencias(String[] precedencias) {
		this.precedencias = precedencias;
	}
	
	public String[] getAntecedencias() {
		return antecedencias;
	}

	public void setAntecedencias(String[] antecedencias) {
		this.antecedencias = antecedencias;
	}


	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", precedencias=" + Arrays.toString(precedencias)
		+ ", tiempo=" + tiempo + "]";
	}

	@Override
	/**
	 * Metodo compareTo de los Id
	 */
	public int compareTo(Object n) {
		// TODO Auto-generated method stub
		Actividad ac=(Actividad)n;
		return this.getId().compareTo(ac.getId());
	}
	
}
