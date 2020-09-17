package control;

import display.Observer;

public interface Subjet {

	public void registrarObserver (Observer o);
	
	public void eliminarObserver (Observer o);
	
	public void notificarObserver();
	
}
