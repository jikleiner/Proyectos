package factory;

import factory.AutoFactory;
import negocio.Chasis;
import negocio.ChasisChico;
import negocio.Freno;
import negocio.FrenoAsistido;
import negocio.FrenoElectrico;
import negocio.Motor;
import negocio.Motor100;

public class AutoChicoFactory implements AutoFactory {
	
	public Chasis crearChasis() {
		return new ChasisChico();
	}

	public Motor crearMotor() {
		return new Motor100();
	}

	public Freno crearFrenos() {
		return new FrenoAsistido();
		//return new FrenoElectrico(); //se puede modificar la configuracion sin que el cliente tenga que modificar su codigo
	}
}
