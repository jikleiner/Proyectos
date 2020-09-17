package factory;

import factory.AutoFactory;
import negocio.Chasis;
import negocio.ChasisGrande;
import negocio.Freno;
import negocio.FrenoElectrico;
import negocio.Motor;
import negocio.Motor120;

public class AutoGrandeFactory implements AutoFactory {

	public Chasis crearChasis() {
		return new ChasisGrande();
	}

	public Motor crearMotor() {
		return new Motor120();
	}

	public Freno crearFrenos() {
		return new FrenoElectrico();
	}
	
}
