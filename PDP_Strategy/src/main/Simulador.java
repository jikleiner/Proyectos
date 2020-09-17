package main;
import comportamientos.VueloElevado;
import negocio.*;

public class Simulador {
	public static void main(String args[]){
		Ave pato = new Pato();
		pato.mostrarInformacion();
		pato.descansar();
		pato.dormir();
		pato.ejecutarVuelo();
		
		System.out.println();
		
		Ave halcon=new Halcon();
		halcon.mostrarInformacion();
		halcon.descansar();
		halcon.dormir();
		halcon.ejecutarVuelo();
		
		System.out.println();
		
		Ave pinguino=new Pinguino();
		pinguino.mostrarInformacion();
		pinguino.descansar();
		pinguino.dormir();
		pinguino.ejecutarVuelo();
		
		//cambio dinamicamente el compotamiento vuelo
		pinguino.setCompotamientoVuelo(new VueloElevado());
		pinguino.ejecutarVuelo();
		
		
		
	}
}
