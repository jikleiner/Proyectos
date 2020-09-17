package controler;

import model_domain.Producto;
import model_domain.ProductoPorCantidad;

public class ControladorProductoPorCantidad extends ControladorProducto{

	public void setearProductoPorCantidad(String nombre, int precioTotal, int cantidad, int precio) {
		// TODO Auto-generated method stub
		ProductoPorCantidad pr = new ProductoPorCantidad();
		pr.setNombre(nombre);
		pr.setPrecio(precioTotal);
		pr.setCantidad(cantidad);
		pr.setPrecioPorUnidad(precio);
		this.setProducto(pr);
	}
	
	@Override
	public Producto crearProducto() {
		// TODO Auto-generated method stub
		return new ProductoPorCantidad();
	}


}
