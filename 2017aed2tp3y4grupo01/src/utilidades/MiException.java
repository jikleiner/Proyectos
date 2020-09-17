package utilidades;

public class MiException extends Exception {
	/**
	 * Método que muestra por consola el texto que se pase por parametro en la variable msj, cuando se produce una excepción
	 * @param msj
	 */
	public MiException(String msj) {
		super(msj);
	}
}
