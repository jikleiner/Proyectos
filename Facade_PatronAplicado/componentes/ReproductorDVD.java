package componentes;

public class ReproductorDVD {
	
	public void encender() {
		System.out.println("Encendiendo Reproductor DVD");
	}
	
	public void apagar() {
		System.out.println("Apagando Reproductor DVD");
	}
	
	public void reproducir(String pelicula) {
		System.out.println("Reproduciendo pel�cula " + pelicula + " en Reproductor DVD");
	}
	
	public void detener() {
		System.out.println("Deteniendo reproducci�n de pel�cula en Reproductor DVD");
	}
	
}
