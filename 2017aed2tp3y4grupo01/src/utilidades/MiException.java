package utilidades;

public class MiException extends Exception {
	/**
	 * M�todo que muestra por consola el texto que se pase por parametro en la variable msj, cuando se produce una excepci�n
	 * @param msj
	 */
	public MiException(String msj) {
		super(msj);
	}
}
