package control;

import java.util.ArrayList;

import display.Observer;

public class ControlClima implements Subjet{

	private float temperatura;
	private float humedad;
	private float presion;
	private float indiceCalor;
	
	private ArrayList<Observer> observers;
	
	
	public ControlClima (){
		observers= new ArrayList<Observer>();
	}
	
	@Override
	public void registrarObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void eliminarObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	public void cambioDatos(){
		notificarObserver();
	}
	
	@Override
	public void notificarObserver() {
		// TODO Auto-generated method stub
		for(Observer o : observers){
			o.actualizar(this);
		}
	}
	
	//este metodo tiene como proposito poder testear la aplicacion
	public void setDatos(float temperatura, float humedad, float presion, float indiceCalor){
		this.temperatura=temperatura;
		this.humedad=humedad;
		this.presion=presion;
		this.indiceCalor=indiceCalor;
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

	public float getIndiceCalor() {
		return indiceCalor;
	}

	
}
