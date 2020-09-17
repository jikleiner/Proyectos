package conexion;

public class Conexion {

	public static final int CERRADA = 0;
	public static final int ESCUCHANDO = 1;
	public static final int SUSPENDIDA = 2;
	
	int estado = CERRADA;
	
	public Conexion() {
		System.out.println("Iniciando la conexi�n");
		estado = ESCUCHANDO;
	}
	
	public void abrir() {
		if (estado == CERRADA) {
			System.out.println("Abriendo la conexi�n");
			estado = ESCUCHANDO;
		} else if (estado == ESCUCHANDO) {
			System.out.println("La conexi�n ya se encuentra abierta");
		} else if (estado == SUSPENDIDA) {
			System.out.println("La conexi�n ya se encuentra abierta");
		}
	}
	
	public void cerrar() {
		if (estado == CERRADA) {
			System.out.println("La conexi�n ya se encuentra cerrada");
		} else if (estado == ESCUCHANDO) {
			System.out.println("Cerrando la conexi�n");
			estado = CERRADA;
		} else if (estado == SUSPENDIDA) {
			System.out.println("Cerrando la conexi�n");
			estado = CERRADA;
		}
	}
	
	public void reanudar() {
		if (estado == CERRADA) {
			System.out.println("Primero debe abrir la conexi�n");
		} else if (estado == ESCUCHANDO) {
			System.out.println("La conexi�n ya se encuentra escuchando");
		}
		else if (estado == SUSPENDIDA) {
			System.out.println("Reanudando la conexi�n");
			estado = ESCUCHANDO;
		}
	}
	
	public void suspender() {
		if (estado == CERRADA) {
			System.out.println("La conexi�n no se encuentra abierta para ser suspendida");
		} else if (estado == ESCUCHANDO) {
			System.out.println("Suspendiendo la conexi�n");
			estado = SUSPENDIDA;
		} else if (estado == SUSPENDIDA) {
			System.out.println("La conexi�n ya se encuentra suspendia");
		}
	}
	

	public String toString() {
		String s = "Estado Conexi�n: " + estado;
		return s;
	}
	
}
