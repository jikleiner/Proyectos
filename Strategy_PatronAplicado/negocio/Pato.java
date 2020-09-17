package negocio;

import comportamientos.NoVuelo;

public class Pato extends Ave {
	
	public Pato() {
		comportamientoVuelo = new NoVuelo();
	}
	
	public void mostrarInformacion() {
		System.out.println("Soy un pato");
	}

}
