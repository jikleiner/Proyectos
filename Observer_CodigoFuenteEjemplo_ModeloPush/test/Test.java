package test;

import control.ControlClima;
import display.DisplayCondicionesActuales;

public class Test {

	public static void main(String args[]) {
		ControlClima controlClima = new ControlClima();
		
		DisplayCondicionesActuales condicionesActuales = new DisplayCondicionesActuales(controlClima);
		//DisplayPronostico pronostico = new DisplayPronostico(controlClima);
		
		// Simulación de datos
		controlClima.setDatos(30, 70, 980);
		
		controlClima.setDatos(22, 65, 960);
		
		controlClima.setDatos(25, 80, 990);
		
		condicionesActuales.removerSujeto();
		
		controlClima.setDatos(20, 90, 980);
	}
	
}
