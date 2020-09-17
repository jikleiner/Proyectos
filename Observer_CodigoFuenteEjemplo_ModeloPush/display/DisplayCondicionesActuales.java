package display;

import control.Subject;

public class DisplayCondicionesActuales implements Observer {
	
	private float temperatura;
	private float humedad;
	
	private Subject controlClima;

	public DisplayCondicionesActuales(Subject subject) {
		this.controlClima = subject;
		controlClima.registrarObserver(this);
	}
	
	public void actualizar(float temperatura, float humedad, float presion) {
		this.temperatura = temperatura;
		this.humedad = humedad;
		display();
	}
	
	public void display() {
		System.out.println("Display Condiciones Actuales - Temperatura: " + temperatura + " - Humedad: " + humedad);
	}
	
	public void removerSujeto() {
		controlClima.eliminarObserver(this);
	}
	
}
