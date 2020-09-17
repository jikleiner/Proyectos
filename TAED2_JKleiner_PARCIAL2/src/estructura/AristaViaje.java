package estructura;

public class AristaViaje extends Arista{
	private int duracion;

	public AristaViaje(String origen, String destino, int costo, int duracion) {
		super(origen, destino, costo);
		this.duracion = duracion;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "AristaViaje [duracion=" + duracion + "]";
	}	
}
