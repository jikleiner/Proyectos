package estructuras;

public interface ListaEnlazadaD {
	/**
	 * Métodos que luego deberan usar las clases que implementen esta interface
	 */
	public void Vaciar();
	public void Insertar(Comparable dato);
	public boolean EsVacia();
	public boolean Buscar(Comparable dato);
	public Object Eliminar(Comparable dato);
	public String ListarAscendente();
	public String ListarDescendente();
	public int cantidadDeElementos();
	
} 
