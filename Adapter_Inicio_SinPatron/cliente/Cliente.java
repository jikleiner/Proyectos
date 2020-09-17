package cliente;

import negocio.MotorCombustion;
import negocio.MotorElectrico;
import negocio.MotorGasolina;

public class Cliente {
	
	public static void main(String args[]) {
		MotorCombustion motorGasolina = new MotorGasolina();
		test(motorGasolina);
		
		MotorElectrico motorElectrico = new MotorElectrico();
		test(motorElectrico); // No compila!
	}
	
	public static void test(MotorCombustion motor) {
		motor.encender();
		motor.acelerar();
		motor.apagar();
	}
	
}
