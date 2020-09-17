package conexion;

import java.util.Random;

public class Conexion {
	
	private int idSocket;

	public Conexion() {
		Random r = new Random();
		idSocket = r.nextInt(10);
		System.out.println("Abriendo socket: " + idSocket);
	}
	
	public void enviarMensaje(String mensaje) {
		System.out.println("Enviando mensaje: " + mensaje + " a través del socket: " + idSocket);
	}
	
}
