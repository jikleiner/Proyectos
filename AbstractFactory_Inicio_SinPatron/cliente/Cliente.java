package cliente;

import negocio.Chasis;
import negocio.ChasisChico;
import negocio.ChasisGrande;
import negocio.Freno;
import negocio.FrenoAsistido;
import negocio.FrenoElectrico;
import negocio.Motor;
import negocio.Motor100;
import negocio.Motor120;
import cliente.Cliente;

public class Cliente {
	
	public static void main(String args[]) {
		Cliente cliente = new Cliente();
		
		cliente.fabricarAuto("Chico");
		
		cliente.fabricarAuto("Grande");
	}

	public void fabricarAuto(String tipoAuto){
		Motor motor = null;
		Chasis chasis = null;
		Freno frenos = null;
		
		if (tipoAuto.equalsIgnoreCase("Chico")) {
			motor = new Motor100();
			chasis = new ChasisChico();
			frenos = new FrenoAsistido();
		} else if (tipoAuto.equalsIgnoreCase("Grande")) {
			motor = new Motor120();
			chasis = new ChasisGrande();
			frenos = new FrenoElectrico();
		}
		
		System.out.println("Construyendo auto con" +
				" motor: " + motor + 
				" chasis: " + chasis +
				" frenos: " + frenos);
	}
	
}
