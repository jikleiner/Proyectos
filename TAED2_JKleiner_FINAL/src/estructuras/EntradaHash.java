package estructuras;

public class EntradaHash {
	private Hashable elemento;
	private String claveH;
	private boolean esActivo;

	public EntradaHash(Hashable elemento, String claveH) {
		super();
		this.elemento = elemento;
		this.claveH = claveH;
		this.esActivo = true;
	}

	public EntradaHash(Hashable elemento) {
		super();
		this.elemento = elemento;
		this.esActivo = true;
	}

	public Hashable getElemento() {
		return elemento;
	}

	public void setElemento(Hashable elemento) {
		this.elemento = elemento;
	}

	public String getClaveH() {
		return claveH;
	}

	public void setClaveH(String claveH) {
		this.claveH = claveH;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	@Override
	public String toString() {
		return this.elemento.toString();
	}
	
	
}

