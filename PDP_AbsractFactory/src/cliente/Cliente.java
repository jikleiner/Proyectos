package cliente;

import Factory.AutoChicoFactory;
import Factory.AutoFactory;
import Factory.AutoGrandeFactory;
import negocio.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		//cliente.fabricarAuto("chico");
		AutoFactory autoChicoFactory = new AutoChicoFactory();
		//cliente.fabricarAuto("grande");
		AutoFactory autoGrandeFactory = new AutoGrandeFactory();
	}

	
	public void fabricarAuto(AutoFactory factory){
		Motor motor = factory.crearMotor();
		Chasis chasis = factory.crearChasis();
		Freno freno = factory.crearFreno();
		
		System.out.println("contruyendo Auto con "+motor+" "+chasis+" "+freno);
		
	}

	/*
	public void fabricarAuto(String tipoAuto){
		Motor motor =null;
		Chasis chasis = null;
		Freno freno =null;
		if(tipoAuto.equalsIgnoreCase("Chico")){
			motor = new Motor100();
			chasis = new ChasisChico();
			freno = new FrenoAsistido();
		}else if(tipoAuto.equalsIgnoreCase("Grande")){
			motor = new Motor180();
			chasis = new ChasisGrande();
			freno = new FrenoElectrico();
		}
		System.out.println("contruyendo Auto con "+motor.toString()+" "+chasis.toString()+" "+freno.toString());
	}
	*/


}
