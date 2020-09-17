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
	public void Vaciar() {
		// TODO Auto-generated method stub
		this.setCabezera(null);
		this.setUltimo(null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Metodo que inserta un dato en nuestra lista doble
	 * Primero corroboramos si se encuentra vacia nuestra lista doble, en caso afirmativo la creamos e insertamos el nuevo nodo
	 * Si no es vacia, comparamos si el dato es menor o mayor a donde lo queremos insertar
	 */
	public void Insertar(Comparable dato) {
		// TODO Auto-generated method stub
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
	 * Metodo que nos indica si nuestra lista doble esta o no vacia
	 */
	public boolean EsVacia() {
		// TODO Auto-generated method stub
		if(cabezera==null&&ultimo==null){
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Metodo que nos permite buscar un dato comparable
	 */
	public boolean Buscar(Comparable dato) {
		// TODO Auto-generated method stub
		NodoDoble auxiliar = this.getCabezera();
		boolean salida = false;
		while(auxiliar != null){
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
				salida = true;
				return salida;
			}else{
				auxiliar = auxiliar.getSig();
			}
		}
		return salida;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused", "null" })
	/**
	 * Metedo que nos permite buscar un objeto comparable
	 * @param dato comparable
	 * @return dato
	 */
	public Object BuscarOb(Comparable dato) {
		// TODO Auto-generated method stub
		NodoDoble auxiliar = this.getCabezera();
		boolean salida = false;
		while(auxiliar != null&salida!=true){
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
				salida = true;
			}else{
				auxiliar = auxiliar.getSig();
			}
		}
		return auxiliar.getDato();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Metodo que nos permite eliminar un dato comparable
	 * Chequeamos primero si esta vacia nuestra lista
	 * Luego compara los datos hasta encontrar el que queriamos eliminar
	 */
	public Object Eliminar(Comparable dato) {
		// TODO Auto-generated method stub
		NodoDoble auxiliar = this.getCabezera();
		NodoDoble auxAnterior = null;
		Object salida = null;
		if (this.EsVacia()){
			System.out.println("Lista Vacia");
		}else if(dato.compareTo(this.getCabezera().getDato()) == 0){
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
	 * Metodo que nos permite listar de forma Ascendete nuestros datos de la lista
	 */
	public String ListarAscendente() {
		// TODO Auto-generated method stub
	    String salida = "";
	    NodoDoble auxiliar = this.getCabezera();
	    if(this.EsVacia()==true){
	    	System.out.println("no se an cargado datos aun");
	    }else{
		    while(auxiliar != null){
		    	salida += auxiliar.getDato().toString()+"\n";
		    	auxiliar = auxiliar.getSig();
		    }	    	
	    }
	    return salida;
	}

	@Override
	/**
	 * Metodo que nos permite listar de forma Descendente nuestros datos de la lista
	 */
	public String ListarDescendente() {
		// TODO Auto-generated method stub
	    String salida = "";
	    NodoDoble auxiliar = this.getUltimo();
	    if(this.EsVacia()==true){
	    	System.out.println("no se an cargado datos aun");
	    }else{
		    while(auxiliar != null){
		    	salida += auxiliar.getDato().toString()+"\n";
		    	auxiliar = auxiliar.getAnt();
		    }
	    }
	    return salida;
	}
	
	
}
