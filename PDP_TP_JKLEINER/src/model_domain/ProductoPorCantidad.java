package model_domain;

public class ProductoPorCantidad extends Producto{
	
	private int cantidad;
	private int precioPorUnidad;

	@Override
	public String detalle() {
		// TODO Auto-generated method stub
		return "nombre "+this.getNombre()+" - precio total: "+this.getPrecio()+
				" - cantidad "+this.cantidad+" - precio por unidad:"+this.getPrecioPorUnidad();
	}

	@Override
	public boolean isEsVacio() {
		if(this.cantidad==0&this.getPrecio()==0&this.getNombre()==null){
			return true;
		}else{
			return false;			
		}
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioPorUnidad() {
		return precioPorUnidad;
	}

	public void setPrecioPorUnidad(int precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}

}
