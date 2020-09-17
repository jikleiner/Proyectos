package estructura;

public interface TablaHash {
	void insertar(Hashable x);
	void eliminar(Hashable x);
	int buscar(Hashable x,String valor);
	void listar();
	void vaciar();
}
