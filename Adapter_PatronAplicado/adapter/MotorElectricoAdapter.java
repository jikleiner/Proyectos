package adapter;

import negocio.MotorCombustion;
import negocio.MotorElectrico;

public class MotorElectricoAdapter implements MotorCombustion {
	MotorElectrico motorElectrico;
	
	public MotorElectricoAdapter(MotorElectrico motorElectrico) {
		this.motorElectrico = motorElectrico;
	}

	public void encender() {
		motorElectrico.conectar();
		motorElectrico.activar();
	}

	public void apagar() {
		motorElectrico.desconectar();
	}

	public void acelerar() {
		for (int i=0; i<5 ; i++) {
			motorElectrico.acelerar();
		}
	}
	
}
