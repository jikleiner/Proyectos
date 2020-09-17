package modelo;



public class Entrada implements Comparable{
	private Sala sala;
	private String fecha;
	private Butaca butaca;
	private Cliente cliente;
	private int monto;
	
	public Entrada(Sala sala, String fecha, Butaca butaca, Cliente cliente) {
		super();
		this.sala = sala;
		this.fecha = fecha;
		this.butaca = butaca;
		this.cliente = cliente;
		this.monto = obtenerMonto();
	}

	public int obtenerMonto() {
		if(cliente.obtenerEdad()<18){
			return 70;
		}else{
			return 120;
		}
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Entrada [sala=" + sala + ", fecha=" + fecha + ", butaca=" + butaca + ", cliente=" + cliente + ", monto="
				+ monto + "]";
	}

	@Override
	public int compareTo(Object o) {
		Entrada butaca = (Entrada)o;
		return this.getButaca().getNumero().compareTo(butaca.getButaca().getNumero());
	}

	

}
