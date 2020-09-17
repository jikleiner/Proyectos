package estructura;

public interface ListaEnlazadaS {
	public void Vaciar();
	public void Insertar(Comparable dato);
	public boolean EsVacia();
	public boolean Buscar(Comparable dato);
	public Object Eliminar(Comparable dato);
	public String ListarAscendente();
	}