package conexion;

public class Conexion {

	public static final int CERRADA = 0;
	public static final int ESCUCHANDO = 1;
	public static final int SUSPENDIDA = 2;
	
	int estado = CERRADA;
	
	public Conexion() {
		System.out.println("Iniciando la conexión");
		estado = ESCUCHANDO;
	}
	
	public void abrir() {
		if (estado == CERRADA) {
			System.out.println("Abriendo la conexión");
			estado = ESCUCHANDO;
		} else if (estado == ESCUCHANDO) {
			System.out.println("La conexión ya se encuentra abierta");
		} else if (estado == SUSPENDIDA) {
			System.out.println("La conexión ya se encuentra abierta");
		}
	}
	
	public void cerrar() {
		if (estado == CERRADA) {
			System.out.println("La conexión ya se encuentra cerrada");
		} else if (estado == ESCUCHANDO) {
			System.out.println("Cerrando la conexión");
			estado = CERRADA;
		} else if (estado == SUSPENDIDA) {
			System.out.println("Cerrando la conexión");
			estado = CERRADA;
		}
	}
	
	public void reanudar() {
		if (estado == CERRADA) {
			System.out.println("Primero debe abrir la conexión");
		} else if (estado == ESCUCHANDO) {
			System.out.println("La conexión ya se encuentra escuchando");
		}
		else if (estado == SUSPENDIDA) {
			System.out.println("Reanudando la conexión");
			estado = ESCUCHANDO;
		}
	}
	
	public void suspender() {
		if (estado == CERRADA) {
			System.out.println("La conexión no se encuentra abierta para ser suspendida");
		} else if (estado == ESCUCHANDO) {
			System.out.println("Suspendiendo la conexión");
			estado = SUSPENDIDA;
		} else if (estado == SUSPENDIDA) {
			System.out.println("La conexión ya se encuentra suspendia");
		}
	}
	

	public String toString() {
		String s = "Estado Conexión: " + estado;
		return s;
	}
	
}
