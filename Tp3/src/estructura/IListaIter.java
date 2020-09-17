package estructura;

public interface IListaIter <T extends Object> {
		//declara dos constants para los mensajes
		static final String MSJ_NO_ENCONTRADO="Elemento no encontrado";
		static final String MSJ_FALLO_ELIMINACION="Fallo eliminacion elemento no encontrado";
		public void imprimir();
		void insertarOrdenado(T dato);
		void insertar (T x,T y);
		void avanzar();
		boolean estaDentro();
		T recuperar();
		void primero();
		boolean buscar (T x);
		void eliminar (T x);
		
}

