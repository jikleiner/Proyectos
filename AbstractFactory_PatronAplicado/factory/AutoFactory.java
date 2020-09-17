package factory;

import negocio.Chasis;
import negocio.Freno;
import negocio.Motor;

public interface AutoFactory {

	public Chasis crearChasis();
	public Motor crearMotor();
	public Freno crearFrenos();
	
}
