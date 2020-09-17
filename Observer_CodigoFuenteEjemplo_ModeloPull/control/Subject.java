package control;

import display.Observer;

public interface Subject {

	public void registrarObserver(Observer o);
	
	public void eliminarObserver(Observer o);
	
	public void notificarObservers();
	
}
