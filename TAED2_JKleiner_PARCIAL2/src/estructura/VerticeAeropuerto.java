package estructura;

public class VerticeAeropuerto extends Vertice{
	private int superficie;
	private String categoria;

	public VerticeAeropuerto(String nombre, int superficie, String categoria2) {
		super(nombre);
		this.superficie = superficie;
		this.categoria = categoria2;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "VerticeAeropuerto [superficie=" + superficie + ", categoria=" + categoria + "]";
	}
	
	
}
