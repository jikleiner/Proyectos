package test;

import control.ControlClima;
import display.DisplayCondicionesActuales;

public class Test {

	public static void main(String args[]) {
		ControlClima controlClima = new ControlClima();
		
		DisplayCondicionesActuales condicionesActuales = new DisplayCondicionesActuales(controlClima);
		
		// Simulación de datos
		controlClima.setDatos(30, 70, 980, 33);
		
		controlClima.setDatos(22, 65, 960, 24);
		
		controlClima.setDatos(25, 80, 990, 27);
		
	}
	
}
