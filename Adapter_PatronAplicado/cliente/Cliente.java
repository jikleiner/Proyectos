package cliente;

import adapter.MotorElectricoAdapter;
import negocio.MotorCombustion;
import negocio.MotorElectrico;
import negocio.MotorGasolina;

public class Cliente {
	
	public static void main(String args[]) {
		MotorCombustion motorGasolina = new MotorGasolina();
		test(motorGasolina);
		
		System.out.println("\n");
		
		MotorElectrico motorElectrico = new MotorElectrico();
		
		MotorCombustion motorElectricoAdapter = new MotorElectricoAdapter(motorElectrico);
		test(motorElectricoAdapter);
	}
	
	public static void test(MotorCombustion motor) {
		motor.encender();
		motor.acelerar();
		motor.apagar();
	}
	
}
