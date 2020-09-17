package controler;

import model_domain.Producto;

public abstract class ControladorProducto {
	
	private Producto producto = null;
	
    public void nuevoProducto() {
    	producto = crearProducto();
    }
    
    protected abstract Producto crearProducto();

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}
    
}
