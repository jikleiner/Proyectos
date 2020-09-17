package modelo;

public class Router implements Comparable {
	private String codigo;
	private String nombre;
	
	public Router(String codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	@Override
	public String toString() {
		return codigo;
	}

	@Override
	public int compareTo(Object n) {
		Router router=(Router)n;
		return this.getCodigo().compareTo(router.getCodigo());
	}
	
	
}
