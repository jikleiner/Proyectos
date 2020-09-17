package estructuras;

public interface ListaEnlazadaD {
	/**
	 * Interfaz donde indicamos los metodos a usar
	 */
	public void Vaciar();
	public void Insertar(Comparable dato);
	public boolean EsVacia();
	public boolean Buscar(Comparable dato);
	public Object Eliminar(Comparable dato);
	public String ListarAscendente();
	public String ListarDescendente();
	} 
