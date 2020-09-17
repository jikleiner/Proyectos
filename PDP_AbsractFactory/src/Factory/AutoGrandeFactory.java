package Factory;

import negocio.*;

public class AutoGrandeFactory implements AutoFactory{

	@Override
	public Chasis crearChasis() {
		// TODO Auto-generated method stub
		return new ChasisGrande();
	}

	@Override
	public Motor crearMotor() {
		// TODO Auto-generated method stub
		return new Motor180();
	}

	@Override
	public Freno crearFreno() {
		// TODO Auto-generated method stub
		return new FrenoElectrico();
	}

}
