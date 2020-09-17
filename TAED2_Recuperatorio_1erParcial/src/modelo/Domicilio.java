package modelo;

public class Domicilio {
	private String calle;
	private int numero;
	private String barrio;

	public Domicilio(String calle, int numero, String barrio) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", numero=" + numero + ", barrio=" + barrio + "]";
	}
	
	
}
