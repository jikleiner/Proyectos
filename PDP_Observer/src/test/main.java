package test;

import control.ControlClima;
import display.DisplayCondicionesActuales;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControlClima controlClima = new ControlClima();
		
		DisplayCondicionesActuales condicionesActuales = new DisplayCondicionesActuales(controlClima);
		
		
		
		controlClima.setDatos(30, 70, 980, 32);
		
		controlClima.setDatos(22, 65, 960, 19);
		
		controlClima.setDatos(25, 80, 990, 27);
		
	}

}
