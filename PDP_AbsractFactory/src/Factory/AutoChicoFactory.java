package Factory;

import negocio.*;

public class AutoChicoFactory implements AutoFactory{

	@Override
	public Chasis crearChasis() {
		// TODO Auto-generated method stub
		return new ChasisChico();
	}

	@Override
	public Motor crearMotor() {
		// TODO Auto-generated method stub
		return new Motor100();
	}

	@Override
	public Freno crearFreno() {
		// TODO Auto-generated method stub
		return new FrenoAsistido();
	}

}
