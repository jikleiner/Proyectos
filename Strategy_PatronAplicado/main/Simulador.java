package main;

import negocio.Ave;
import negocio.Halcon;
import negocio.Pinguino;
import comportamientos.VueloElevado;

public class Simulador {

	public static void main(String args[]) {
		Ave halcon = new Halcon();
		halcon.mostrarInformacion();
		halcon.descansar();
		halcon.ejecutarVuelo();
		
		System.out.println("\n");
		
		Ave pinguino = new Pinguino();
		pinguino.mostrarInformacion();
		pinguino.descansar();
		pinguino.ejecutarVuelo();
		
		// Cambio dinámicamente el comportamiento de pinguino
		pinguino.setComportamientoVuelo(new VueloElevado());
		pinguino.ejecutarVuelo();
	}
	
}
