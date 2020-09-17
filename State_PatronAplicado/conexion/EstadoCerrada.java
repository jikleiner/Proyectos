package conexion;

public class EstadoCerrada implements Estado {
	Conexion conexion;

	public EstadoCerrada(Conexion conexion) {
		this.conexion = conexion;
	}

	public void abrir() {
		conexion.asignarIdConexion();
		System.out.println("Abriendo la conexi�n: " + conexion.getIdConexion());
		conexion.setEstado(conexion.getEstadoEscuchando());
	}

	public void cerrar() {
		System.out.println("La conexi�n ya se encuentra cerrada");
	}

	public void reanudar() {
		System.out.println("Primero debe abrir la conexi�n");
	}

	public void suspender() {
		System.out.println("La conexi�n no se encuentra abierta para ser suspendida");
	}

}
