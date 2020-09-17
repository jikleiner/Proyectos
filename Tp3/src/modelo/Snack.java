package modelo;

public class Snack {
	private String nombre;
	private int tama�o;
	private int montoTotal;
	private int cantidad;
	
	public Snack(String nombre, int tama�o, int cantidad) {
		super();
		this.nombre = nombre;
		this.tama�o = tama�o;
		this.calcularMonto(cantidad,tama�o);
		this.cantidad = cantidad;
	}
	
	public void calcularMonto(int cantidad,int tama�o){
		if(tama�o==1 && nombre.equals("gaseosa")){
			this.montoTotal=cantidad*20;
		}else if(tama�o==2 && nombre.equals("gaseosa")){
			this.montoTotal=cantidad*35;
		}else if(tama�o==3 && nombre.equals("gaseosa")){
			this.montoTotal=cantidad*40;
		}
		
		if(tama�o==1 && nombre.equals("pochoclo")){
			this.montoTotal=cantidad*45;
		}else if(tama�o==2 && nombre.equals("pochoclo")){
			this.montoTotal=cantidad*55;
		}else if(tama�o==3 && nombre.equals("pochoclo")){
			this.montoTotal=cantidad*60;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}

	public int getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Snack [nombre=" + nombre + ", tama�o=" + tama�o + ", montoTotal=" + montoTotal + ", cantidad="
				+ cantidad + "]";
	}
	
	
	

}
