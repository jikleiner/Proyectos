package conexion;

public class Conexion {

	private int idConexion;

	Estado estadoCerrada;
	Estado estadoEscuchando;
	Estado estadoSuspendida;

	Estado estado;

	public Conexion() {

		estadoCerrada = new EstadoCerrada(this);
		estadoEscuchando = new EstadoEscuchando(this);
		estadoSuspendida = new EstadoSuspendida(this);

		asignarIdConexion();
		System.out.println("Iniciando la conexión: " + idConexion);
		estado = estadoEscuchando;
	}

	public void abrir() {
		estado.abrir();
	}

	public void cerrar() {
		estado.cerrar();
	}

	public void reanudar() {
		estado.reanudar();
	}

	public void suspender() {
		estado.suspender();
	}

	// Setters and Getters
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstadoCerrada() {
		return estadoCerrada;
	}

	public Estado getEstadoEscuchando() {
		return estadoEscuchando;
	}

	public Estado getEstadoSuspendida() {
		return estadoSuspendida;
	}

	public int getIdConexion() {
		return idConexion;
	}

	public void asignarIdConexion() {
		idConexion = (int) (Math.random() * 100);
	}

	public String toString() {
		String s = "Estado Conexión: " + estado;
		return s;
	}

}
