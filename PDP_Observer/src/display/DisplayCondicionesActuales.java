package display;

import control.ControlClima;
import control.Subjet;

public class DisplayCondicionesActuales implements Observer{

	private float temperatura;
	private float humedad;
	
	private Subjet controlClima;
	
	public DisplayCondicionesActuales(Subjet subject){
		this.controlClima=subject;
		controlClima.registrarObserver(this);
	}
	
	@Override
	public void actualizar(Subjet subject) {
		// TODO Auto-generated method stub
		if(subject instanceof ControlClima){
			ControlClima c = (ControlClima) subject;
			this.temperatura = c.getTemperatura();
			this.humedad = c.getHumedad();
		}
		display();
	}

	public void display(){
		System.out.println("Display Condiciones Actuales - Temperatura: " + temperatura + " - Humedad: "+ humedad+" - Sensacion Termica:");
	}
	
	public void removerSujeto(){
		controlClima.eliminarObserver(this);
	}
	
}
