package negocio;

import comportamientos.VueloElevado;

public class Pato extends Ave{
	
	public Pato(){
		comportamientoVuelo=new VueloElevado();
	}
	
	public void mostrarInformacion(){
		
		System.out.println("soy un pato");
		
	}
}
