package conexion;

public class EstadoEscuchando implements Estado {
	Conexion conexion;

	public EstadoEscuchando(Conexion conexion) {
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
		System.out.println("La conexi�n (" + conexion.getIdConexion() + ") ya se encuentra escuchando");
	}

	public void suspender() {
		System.out.println("Suspendiendo la conexi�n: " + conexion.getIdConexion());
		conexion.setEstado(conexion.getEstadoSuspendida());
	}

}
