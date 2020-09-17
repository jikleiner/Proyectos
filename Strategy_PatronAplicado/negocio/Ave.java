package negocio;

import comportamientos.ComportamientoVuelo;

public abstract class Ave {

	protected ComportamientoVuelo comportamientoVuelo;
	
	public abstract void mostrarInformacion();
	
	public void descansar() {
		System.out.println("Estoy descansando");
	}
	
	public void dormir() {
		System.out.println("Estoy durmiendo");
	}
	
	public void ejecutarVuelo(){
		comportamientoVuelo.volar();
	}
	
	public void setComportamientoVuelo(ComportamientoVuelo cVuelo) {
		comportamientoVuelo = cVuelo;
	}
	
}
