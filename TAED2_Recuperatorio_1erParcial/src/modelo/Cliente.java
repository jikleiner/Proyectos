package modelo;

import estructuras.TablaExploracionLineal;

public class Cliente implements Comparable{
	private Integer codCliente;
	private String nombre;
	private String apellido;
	private Domicilio domicilio;
	private TablaExploracionLineal vehiculos;

	public Cliente(int codCliente, String nombre, String apellido, Domicilio domicilio) {
		super();
		this.codCliente = codCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.vehiculos = new TablaExploracionLineal();
	}
	
	public Cliente(int codCliente){
		this.codCliente = codCliente;
		this.nombre = null;
		this.apellido = null;
		this.domicilio = null;
		this.vehiculos = null;		
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public TablaExploracionLineal getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(TablaExploracionLineal vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio="
				+ domicilio + ", vehiculos=" + vehiculos + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return this.getCodCliente().compareTo(((Cliente) arg0).getCodCliente());
	}
	
}
