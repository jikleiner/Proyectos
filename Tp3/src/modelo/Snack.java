package modelo;

public class Snack {
	private String nombre;
	private int tamaño;
	private int montoTotal;
	private int cantidad;
	
	public Snack(String nombre, int tamaño, int cantidad) {
		super();
		this.nombre = nombre;
		this.tamaño = tamaño;
		this.calcularMonto(cantidad,tamaño);
		this.cantidad = cantidad;
	}
	
	public void calcularMonto(int cantidad,int tamaño){
		if(tamaño==1 && nombre.equals("gaseosa")){
			this.montoTotal=cantidad*20;
		}else if(tamaño==2 && nombre.equals("gaseosa")){
			this.montoTotal=cantidad*35;
		}else if(tamaño==3 && nombre.equals("gaseosa")){
			this.montoTotal=cantidad*40;
		}
		
		if(tamaño==1 && nombre.equals("pochoclo")){
			this.montoTotal=cantidad*45;
		}else if(tamaño==2 && nombre.equals("pochoclo")){
			this.montoTotal=cantidad*55;
		}else if(tamaño==3 && nombre.equals("pochoclo")){
			this.montoTotal=cantidad*60;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
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
		return "Snack [nombre=" + nombre + ", tamaño=" + tamaño + ", montoTotal=" + montoTotal + ", cantidad="
				+ cantidad + "]";
	}
	
	
	

}
