package negocio;

import comportamientos.VueloElevado;

public class Halcon extends Ave {

	public Halcon() {
		comportamientoVuelo = new VueloElevado();
	}
	
	public void mostrarInformacion() {
		System.out.println("Soy un halcón");
	}
	
}
