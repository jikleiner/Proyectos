package Estructuras;

public class EntradaHash {
	private Hashable elemento;
	private boolean esActivo;

	public EntradaHash(Hashable elemento, boolean esActivo) {
		super();
		this.elemento = elemento;
		this.esActivo = esActivo;
	}

	public EntradaHash(Hashable elemento) {
		super();
		this.elemento = elemento;
	}

	public Hashable getElemento() {
		return elemento;
	}

	public void setElemento(Hashable elemento) {
		this.elemento = elemento;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}
}

