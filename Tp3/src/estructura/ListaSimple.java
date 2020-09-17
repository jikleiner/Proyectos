package estructura;

public class ListaSimple implements EstructuraLista{

	private Nodo cabecera;
	private Nodo ultimo;
	
	
	public ListaSimple () {
		this.cabecera = null;
		this.ultimo = null;
	}
		
	public Nodo getCabecera() {
		return cabecera;
	}
	
	public void setCabecera(Nodo primero) {
		this.cabecera = primero;
	}
		
	public Nodo getUltimo() {
		return ultimo;
	}
		
	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}
	
	@Override
	public void Vaciar() {
		this.cabecera = null;
		this.ultimo = null;
	}

	@Override
	public void Insertar(Comparable dato) {
		Nodo nuevo = new Nodo (dato);
		Nodo auxiliar = this.cabecera;
		Nodo auxAnterior = this.cabecera;
		//enlazamos con el único nodo que hay en la lista
		if(this.EsVacia()){
			this.cabecera = nuevo;
			this.ultimo = nuevo;
		}
		//si el nuevo código es menor al que estaba primero
		else if (((Comparable) nuevo.getDato()).compareTo(this.getCabecera().getDato())<0){
			//enlaza el nuevo nodo con el que estaba primero
			nuevo.setRef(this.getCabecera());
			//enlaza la cabecera con nuevo para indicar que es el primero
			this.setCabecera(nuevo);
		}
		else //si el nuevo código es mayor al último
		if (((Comparable) nuevo.getDato()).compareTo(this.getUltimo().getDato())> 0){
			//enlaza el último con el nuevo
			this.ultimo.setRef(nuevo);
			//siguiente del nuevo es Null por ser ahora el último dato
			nuevo.setRef(null);
			//enlaza con nuevo para indicar que es el último nodo
			this.setUltimo(nuevo);
		}
		else{ //está en el medio
			while(auxiliar != null && ((Comparable) nuevo.getDato()).compareTo(auxiliar.getDato()) > 0){
				auxAnterior = auxiliar;
				auxiliar = auxiliar.getRef();
		}
		//sale del while cuando encuentra su lugar, con auxiliar parado en el que le sigue al nuevo nodo y auxAnterior en el anterior nodo
		//enlaza el anterior con el nuevo
		auxAnterior.setRef(nuevo);
		//enlaza el nuevo con el siguiente
		nuevo.setRef(auxiliar);
		}
		
	}

	@Override
	public boolean EsVacia() {
		if (this.cabecera == null && this.ultimo == null){
			return true;
		}
		return false;
	}
	

	@Override
	public boolean Buscar(Comparable dato) {
		Nodo auxiliar = this.cabecera;
		boolean salida = false;
		//recorre la lista
		while(auxiliar != null){
		//compara el código del nodo visitado con el ingresado
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
				salida = true;
			}
			auxiliar = auxiliar.getRef();
		}
		return salida;
	}

	@Override
	public Object Eliminar(Comparable dato) {
		Nodo auxiliar = this.cabecera;
		Nodo auxAnterior = null;
		Object salida = null;
		if (this.EsVacia()){
			return "vacia";
		}
		else //compara con el primero, si es igual
		if(dato.compareTo(this.getCabecera().getDato()) == 0){
			salida = this.cabecera.getDato();
			//cambia cabecera enlazando con el segundo
			this.cabecera = this.cabecera.getRef();
		}
		else //busca si está en la lista
			while(auxiliar != null && dato.compareTo(auxiliar.getDato()) != 0){
				auxAnterior = auxiliar;
				auxiliar = auxiliar.getRef();
			}
			if(auxiliar != null){
				salida = auxiliar.getDato();
				//enlaza el anterior con el siguiente, eliminando el nodo
				auxAnterior.setRef(auxAnterior.getRef().getRef());
		}
		return salida;
	}
	

	@Override
	public String ListarAscendente() {
		String salida = "";
		Nodo auxiliar = this.cabecera;
		while(auxiliar != null){
			salida += auxiliar.getDato().toString()+"\n";
			auxiliar = auxiliar.getRef();
		}
		return salida;
	}

	@Override
	public String ListarDescendente() {
		String salida = "";
		Nodo auxiliar = this.ultimo;
		while(auxiliar != null){
			salida += auxiliar.getDato().toString()+"\n";
			auxiliar = auxiliar.getRef();
		}
		return salida;
	}

}
