package control;

import java.util.ArrayList;
import java.util.List;
import display.Observer;

public class ControlClima implements Subject {

	private float temperatura;
	private float humedad;
	private float presion;

	private List observers;
	
	public ControlClima() {
		observers = new ArrayList();
	}
	
	public void registrarObserver(Observer o) {
		observers.add(o);
	}
	
	public void eliminarObserver(Observer o) {
		observers.remove(o);
	}
	
	// Modelo Push
	public void notificarObservers() {
		for (int i=0 ; i<observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.actualizar(temperatura, humedad, presion);
		}
	}
	
	public void cambioDatos() {
		notificarObservers();
	}
	
	// Este método tiene como propósito poder testear la aplicación
	public void setDatos(float temperatura, float humedad, float presion) {
		this.temperatura = temperatura;
		this.humedad = humedad;
		this.presion = presion;
		cambioDatos();
	}

	public float getTemperatura() {
    	return temperatura;
    }

	public float getHumedad() {
    	return humedad;
    }

	public float getPresion() {
    	return presion;
    }
	
}
