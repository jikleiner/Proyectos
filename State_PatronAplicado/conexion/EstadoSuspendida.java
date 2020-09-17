package conexion;

public class EstadoSuspendida implements Estado {
	Conexion conexion;

	public EstadoSuspendida(Conexion conexion) {
		this.conexion = conexion;
	}

	public void abrir() {
		System.out.println("La conexi�n (" + conexion.getIdConexion() + ") ya se encuentra abierta");
	}

	public void cerrar() {
		System.out.println("Cerrando la conexi�n: " + conexion.getIdConexion());
		conexion.setEstado(conexion.getEstadoCerrada());
	}

	public void reanudar() {
		System.out.println("Reanudando la conexi�n: " + conexion.getIdConexion());
		conexion.setEstado(conexion.getEstadoEscuchando());
	}

	public void suspender() {
		System.out.println("La conexi�n (" + conexion.getIdConexion() + ") ya se encuentra suspendia");
	}

}
