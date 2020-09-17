package Factory;

import negocio.*;

public interface AutoFactory {

	public Chasis crearChasis();
	public Motor crearMotor();
	public Freno crearFreno();
}
