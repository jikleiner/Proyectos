package model_domain;
//clase base para todos los productos
public abstract class Producto {

	private String nombre;
	private int precioTotal;
	
	public abstract String detalle();
	
	public abstract boolean isEsVacio();


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precioTotal;
	}

	public void setPrecio(int precio) {
		this.precioTotal = precio;
	}

}
