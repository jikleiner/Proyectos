package negocio;

import comportamientos.ComportamientoVuelo;

public abstract class Ave {
	
	protected ComportamientoVuelo comportamientoVuelo;
	
	public abstract void mostrarInformacion();
	
	public void dormir(){
		System.out.println("estoy durmiendo");
	}

	public void descansar(){
		System.out.println("estoy descansando");
	}
	
	/*public void volar(){
		System.out.println("estoy volando");
	}*/
	
	public void ejecutarVuelo(){
		comportamientoVuelo.volar();
	}
	
	public void setCompotamientoVuelo(ComportamientoVuelo compo){
		this.comportamientoVuelo=compo;
	}
	
}
