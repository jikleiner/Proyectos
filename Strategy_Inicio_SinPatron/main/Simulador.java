package main;

import negocio.Ave;
import negocio.Canario;
import negocio.Halcon;
import negocio.Pinguino;

public class Simulador {

	public static void main(String args[]) {
		Ave canario = new Canario();
		canario.mostrarInformacion();
		canario.dormir();
		
		System.out.println();
		
		Ave halcon = new Halcon();
		halcon.mostrarInformacion();
		halcon.descansar();
		halcon.volar();
		
		System.out.println();
		
		Ave pinguino = new Pinguino();
		pinguino.mostrarInformacion();
		pinguino.descansar();
		pinguino.volar(); // Los pinguinos no pueden volar!
	}
	
}
