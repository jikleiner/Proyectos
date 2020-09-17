package estructura;

public class AristaViaje extends Arista{
	private float tiempo;

	public AristaViaje(String origen, String destino, int costo, float tiempo) {
		super(origen, destino, costo);
		this.tiempo = tiempo;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "AristaViaje [tiempo=" + tiempo + "]";
	}
	
}
