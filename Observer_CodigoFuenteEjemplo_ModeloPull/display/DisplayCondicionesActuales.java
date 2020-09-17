package display;

import control.ControlClima;
import control.Subject;

public class DisplayCondicionesActuales implements Observer {
	
	private float temperatura;
	private float humedad;
	
	private Subject controlClima;

	public DisplayCondicionesActuales(Subject subject) {
		this.controlClima = subject;
		controlClima.registrarObserver(this);
	}
	
	public void actualizar(Subject subject) {
		if (subject instanceof ControlClima) {
			ControlClima c = (ControlClima) subject;
			this.temperatura = c.getTemperatura();
			this.humedad = c.getHumedad();
			
			display();
		}
	}
	
	public void display() {
		System.out.println("Display Condiciones Actuales - Temperatura: " + temperatura + " - Humedad: " + humedad);
	}
	
}
