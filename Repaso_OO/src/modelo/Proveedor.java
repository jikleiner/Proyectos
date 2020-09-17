package modelo;

public class Proveedor implements Comparable {

	private String nombre;
	private String direccion;
	private int telefono;
	private Vendedor vendedor;
	
	public Proveedor(String nombre, String direccion, int telefono, Vendedor vend) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.vendedor = vend;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + this.getVendedor().toString() + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		String nom=(String)o;
		return this.getNombre().compareTo(nom);
	}
	
}
