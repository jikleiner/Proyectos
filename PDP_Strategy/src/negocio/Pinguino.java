package negocio;

import comportamientos.NoVuelo;

public class Pinguino extends Ave{
	
	public Pinguino(){
		
		comportamientoVuelo=new NoVuelo();
		
	}
	
	public void mostrarInformacion(){
		
		System.out.println("soy un pinguino");
		
	}

}
