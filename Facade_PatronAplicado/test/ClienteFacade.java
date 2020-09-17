package test;

import componentes.Luces;
import componentes.Pantalla;
import componentes.Proyector;
import componentes.ReproductorDVD;
import componentes.SistemaSonido;
import facade.SistemaEntretenimientoFacade;

public class ClienteFacade {

	public static void main(String args[]) {
		Luces luces = new Luces();
		Pantalla pantalla = new Pantalla();
		Proyector proyector = new Proyector();
		SistemaSonido sonido = new SistemaSonido();
		ReproductorDVD reproductor = new ReproductorDVD();

		SistemaEntretenimientoFacade sistema = new SistemaEntretenimientoFacade(
				luces, 
				pantalla, 
				proyector, 
				sonido, 
				reproductor);
		sonido.setNivel(6);
		sistema.verPelicula("Titanic");
		
		System.out.println("\n");
		
		sistema.finalizarPelicula();
	}
	
}
