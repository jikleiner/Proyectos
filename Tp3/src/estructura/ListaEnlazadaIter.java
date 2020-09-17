package estructura;

public class ListaEnlazadaIter <T extends Object> implements IListaIter<T> {
	protected ListaDoble<T> laLista;
	protected NodoDoble<T> actual;
	
	
	public ListaEnlazadaIter(ListaDoble unaLista) {
		laLista=unaLista;
	}
	
	
	
	
	@Override
	public void imprimir() {
		if (laLista.EsVacia()) {
			System.out.println("Es Vacia");
			return;
			}
			NodoDoble<T> aux = laLista.getCabecera();
			while (aux != null) {
			System.out.println (aux.getDato());
			aux = aux.getSig();
			}
			System.out.println( "\n" );
		
	}

	@Override
	public void insertarOrdenado(T dato) {
		NodoDoble<Object> nvo = new NodoDoble (dato);
		if(dato!=null){
			if(laLista.EsVacia()){
				laLista.insertarEnListaVacia(nvo);
			}else if(!(laLista.menorPrimero(nvo))&&!(laLista.mayorUltimo(nvo))){
				NodoDoble auxiliar = laLista.getCabecera();
				NodoDoble auxAnterior = laLista.getCabecera();
					while(auxiliar != null && ((Comparable) nvo.getDato()).compareTo(auxiliar.getDato()) > 0){
						auxAnterior = auxiliar;
						auxiliar = auxiliar.getSig();
					}
					laLista.medio(nvo, auxiliar, auxAnterior);
			}
		}
		
	}

	@Override
	public void insertar(T x, T y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanzar() {
		if(actual!=null) {
			actual=actual.getSig();
			}
		
	}

	@Override
	public boolean estaDentro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T recuperar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void primero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean buscar(T x) {
		NodoDoble auxiliar = laLista.getCabecera();
		boolean salida = false;
		
		while(auxiliar != null){
		
			if(((Comparable) auxiliar.getDato()).compareTo(x) == 0){
				salida = true;
				return salida;
			}
			auxiliar = auxiliar.getSig();
		}
		return salida;
	}

	@Override
	public void eliminar(T x) {
		NodoDoble<Object> nvo = new NodoDoble (x);
		NodoDoble auxiliar = laLista.getCabecera();
		if(x!=null){
			if(laLista.EsVacia()){
				System.out.println("No hay elementos en la lista");
			}else if(!(laLista.eliminarUnicoElemento(nvo))&&!(laLista.eliminarPrimero(nvo))&&!(laLista.eliminarUltimo(nvo))){
				while(auxiliar != null){
					laLista.eliminarMedio(nvo,auxiliar);
					auxiliar = auxiliar.getSig();
				
				}
			}
		}
		
	}

}
