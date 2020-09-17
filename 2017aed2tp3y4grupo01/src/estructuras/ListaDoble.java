package estructuras;

public class ListaDoble implements ListaEnlazadaD{
	private NodoDoble cabezera;
	private NodoDoble ultimo;
	
	public NodoDoble getCabezera() {
		return cabezera;
	}

	public void setCabezera(NodoDoble pri) {
		this.cabezera = pri;
	}

	public NodoDoble getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoDoble ult) {
		this.ultimo = ult;
	}
	
	@Override
	/**
	 * Método que vacía la lista doble
	 */
	public void Vaciar() {
		this.setCabezera(null);
		this.setUltimo(null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Método que inserta un dato en una lista doble
	 * Primero corrobora si se encuentra vacía nuestra, en caso afirmativo la crea e insertam el nuevo nodo
	 * Si no es vacia, compara si el dato es menor o mayor al lugar donde se lo quiere insertar
	 */
	public void Insertar(Comparable dato) {
		  NodoDoble nuevo = new NodoDoble (dato);
		  NodoDoble auxiliar = this.cabezera;
		  NodoDoble auxAnterior = this.cabezera;
		  
		  if(this.EsVacia()){
			  this.cabezera = nuevo;
			  this.ultimo = nuevo;
		  }else if(((Comparable) nuevo.getDato()).compareTo(this.getCabezera().getDato())<0){
			  this.cabezera.setAnt(nuevo);
			  nuevo.setSig(this.getCabezera());
			  this.setCabezera(nuevo);
		  }else if(((Comparable) nuevo.getDato()).compareTo(this.getUltimo().getDato())>0){
			  this.ultimo.setSig(nuevo);
			  nuevo.setAnt(this.getUltimo());
			  this.setUltimo(nuevo);
		  }else{
			  while(auxiliar != null && ((Comparable) nuevo.getDato()).compareTo(auxiliar.getDato()) > 0){
				  auxAnterior = auxiliar;
				  auxiliar = auxiliar.getSig();
			  }
			  auxAnterior.setSig(nuevo);
			  auxiliar.setAnt(nuevo);
			  nuevo.setAnt(auxAnterior);
			  nuevo.setSig(auxiliar);
		  }
	}

	@Override
	/**
	 * Método que indica si una lista doble esta o no vacía
	 */
	public boolean EsVacia() {
		if(cabezera==null&&ultimo==null)
			return true;
		else
			return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Método que busca un dato del tipo comparable
	 */
	public boolean Buscar(Comparable dato) {
		NodoDoble auxiliar = this.getCabezera();
		boolean salida = false;
		
		while(auxiliar != null){
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
				salida = true;
				return salida;
			}else
				auxiliar = auxiliar.getSig();
		}
		return salida;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused", "null" })
	/**
	 * Método que busca un objeto del tipo comparable
	 * @param dato comparable
	 * @return dato
	 */
	public Object BuscarOb(Comparable dato) {
		NodoDoble auxiliar = this.getCabezera();
		boolean salida = false;
		
		while(auxiliar != null&salida!=true){
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0)
				salida = true;
			else
				auxiliar = auxiliar.getSig();
		}
		return auxiliar.getDato();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Método que permite eliminar un dato comparable
	 * Primero chequea si esta vacía la lista
	 * Luego compara los datos hasta encontrar el que dato a eliminar
	 */
	public Object Eliminar(Comparable dato) {
		NodoDoble auxiliar = this.getCabezera();
		NodoDoble auxAnterior = null;
		Object salida = null;
		
		if (this.EsVacia())
			System.out.println("Lista Vacia");
		else if(dato.compareTo(this.getCabezera().getDato()) == 0){
			if(dato.compareTo(this.getUltimo().getDato()) == 0){
				salida = this.cabezera.getDato();
				this.setCabezera(null);
				this.setUltimo(null);				
			}else{
				salida = this.cabezera.getDato();
				this.setCabezera(this.cabezera.getSig());				
			}
		}else if(dato.compareTo(this.getUltimo().getDato()) == 0){
			salida = this.ultimo.getDato();
			this.setUltimo(ultimo.getAnt());
			ultimo.setSig(null);
		}else{
			while(auxiliar != null && dato.compareTo(auxiliar.getDato()) != 0){
				auxAnterior = auxiliar;
				auxiliar = auxiliar.getSig();
			}
			if(auxiliar != null){
				salida = auxiliar.getDato();
				auxAnterior.setSig(auxiliar.getSig());
				auxiliar.getSig().setAnt(auxAnterior);
			}
		}
		return salida;
	}

	@Override
	/**
	 * Método que lista de forma Ascendente los datos de una lista
	 */
	public String ListarAscendente() {
	    String salida = "";
	    NodoDoble auxiliar = this.getCabezera();
	    
	    if(this.EsVacia()==true)
	    	System.out.println("no se an cargado datos aun");
	    else{
		    while(auxiliar != null){
		    	salida += auxiliar.getDato().toString()+"\n";
		    	auxiliar = auxiliar.getSig();
		    }	    	
	    }
	    return salida;
	}

	@Override
	/**
	 * Método que lista de forma Descendente los datos de una lista
	 */
	public String ListarDescendente() {
	    String salida = "";
	    NodoDoble auxiliar = this.getUltimo();
	    
	    if(this.EsVacia()==true)
	    	System.out.println("no se an cargado datos aun");
	    else{
		    while(auxiliar != null){
		    	salida += auxiliar.getDato().toString()+"\n";
		    	auxiliar = auxiliar.getAnt();
		    }
	    }
	    return salida;
	}

	
	
	public int cantidadDeElementos() 
    {
	if (EsVacia())
	{
	    return 0;
	} else
	{
		NodoDoble aux = this.getCabezera();
	    int contador = 1;

	    while(aux != this.getUltimo())
	    {
		contador++;
		aux = aux.getSig();
	    }
	    return contador;
	}
    }
	
	public Comparable devolverElementoPosEspecifica(int posicion)
    {
	NodoDoble aux = this.cabezera;

	if (this.EsVacia())
	    return null;
	else
	{
	    posicion--;
	    while(posicion != 0)
	    {
		aux = aux.getSig();
		posicion--;
	    }
	    return aux.getDato();
	}
    }
}
