package test;

import componentes.Luces;
import componentes.Pantalla;
import componentes.Proyector;
import componentes.ReproductorDVD;
import componentes.SistemaSonido;

public class Cliente {

	public static void main(String args[]) {
		String pelicula = "Titanic";
		
		Luces luces = new Luces();
		Pantalla pantalla = new Pantalla();
		Proyector proyector = new Proyector();
		SistemaSonido sonido = new SistemaSonido();
		ReproductorDVD reproductor = new ReproductorDVD();

		System.out.println("Preparando componentes...");
		luces.apagar();
		pantalla.bajar();
		proyector.encender();
		sonido.encender();
		sonido.setNivel(8);
		reproductor.encender();
		reproductor.reproducir(pelicula);

		System.out.println("\n");
		
		System.out.println("Deteniendo componentes...");
		luces.encender();
		pantalla.subir();
		proyector.apagar();
		sonido.apagar();
		reproductor.detener();
		reproductor.apagar();
	}
	
}
