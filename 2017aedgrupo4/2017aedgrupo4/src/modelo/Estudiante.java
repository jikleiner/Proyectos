package modelo;


public class Estudiante implements Comparable {
	
	private String legajo;
	private String nombre;
	private String apellido;
	private String promedio;
	
	public Estudiante(String legajo, String nombre, String apellido, String promedio) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.promedio = promedio;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
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

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "Estudiante [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", promedio="
				+ promedio + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof String){
			String estudiante = (String)o;
			return this.getLegajo().compareTo(estudiante);
		}else{
			Estudiante estudiante = (Estudiante)o;
			return this.getLegajo().compareTo(estudiante.getLegajo());
		}
		
	}
	
		
	
	

}
