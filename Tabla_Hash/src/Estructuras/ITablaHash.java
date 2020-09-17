package Estructuras;

public interface ITablaHash {
	public abstract void insertar(Hashable x);
	public abstract void eliminar(Hashable x);
	public abstract int buscar(Hashable x, String val);
	public abstract void vaciar();
	
}
