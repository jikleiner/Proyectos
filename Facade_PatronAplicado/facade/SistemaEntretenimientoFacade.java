package facade;

import componentes.Luces;
import componentes.Pantalla;
import componentes.Proyector;
import componentes.ReproductorDVD;
import componentes.SistemaSonido;

public class SistemaEntretenimientoFacade {

	Luces luces;
	Pantalla pantalla;
	Proyector proyector;
	SistemaSonido sonido;
	ReproductorDVD reproductor;

	public SistemaEntretenimientoFacade(Luces luces, Pantalla pantalla, Proyector proyector, SistemaSonido sonido,
			ReproductorDVD reproductor) {
		this.luces = luces;
		this.pantalla = pantalla;
		this.proyector = proyector;
		this.sonido = sonido;
		this.reproductor = reproductor;
	}

	public void verPelicula(String pelicula) {
		System.out.println("Preparando componentes para ver película...");

		luces.apagar();
		pantalla.bajar();
		proyector.encender();
		sonido.encender();
		sonido.setNivel(8);
		reproductor.encender();
		reproductor.reproducir(pelicula);

	}

	public void finalizarPelicula() {
		System.out.println("Apagando componentes...");

		luces.encender();
		pantalla.subir();
		proyector.apagar();
		sonido.apagar();
		reproductor.detener();
		reproductor.apagar();
	}

}
