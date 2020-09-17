package estructuras;

public interface ListaEnlazada {
	public abstract boolean esVacio();
	public abstract void agregar(Object o);
	public abstract void eliminar();
	public abstract void vaciar();
	public abstract void listar();
	public abstract Object buscar(Object o);

}
