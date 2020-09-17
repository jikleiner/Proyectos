package estructura;

public class AristaViaje extends Arista{
	private float duracion;
	private int HsSalidaIda;
	private int HsSalidaVuelta;

	public AristaViaje(String origen, String destino, int costo, float duracion, int hsSalidaIda, int hsSalidaVuelta) {
		super(origen, destino, costo);
		this.duracion = duracion;
		HsSalidaIda = hsSalidaIda;
		HsSalidaVuelta = hsSalidaVuelta;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public int getHsSalidaIda() {
		return HsSalidaIda;
	}

	public void setHsSalidaIda(int hsSalidaIda) {
		HsSalidaIda = hsSalidaIda;
	}

	public int getHsSalidaVuelta() {
		return HsSalidaVuelta;
	}

	public void setHsSalidaVuelta(int hsSalidaVuelta) {
		HsSalidaVuelta = hsSalidaVuelta;
	}

	@Override
	public String toString() {
		return "AristaViaje [duracion=" + duracion + ", HsSalidaIda=" + HsSalidaIda + ", HsSalidaVuelta="
				+ HsSalidaVuelta + "]";
	}
	
}
