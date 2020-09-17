package modelo;

public class Butaca  {
	private Integer numero;
	private boolean ocupado;
	
	public Butaca(int numero) {
		super();
		this.numero = numero;
		this.ocupado=false;
		
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "Butaca [Numero=" + numero + ", ocupado=" + ocupado + "]";
	}


}
