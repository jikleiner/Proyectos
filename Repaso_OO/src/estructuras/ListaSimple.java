package estructuras;

public class ListaSimple implements ListaEnlazadaS{
	private Nodo cabezera;
	private Nodo ultimo;
	
	public Nodo getCabezera() {
		return cabezera;
	}

	public void setCabezera(Nodo pri) {
		this.cabezera = pri;
	}

	public Nodo getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}
	
	@Override
	public void Vaciar() {
		// TODO Auto-generated method stub
		this.cabezera.setSig(null);
		this.ultimo=null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void Insertar(Comparable dato) {
		// TODO Auto-generated method stub
		  Nodo nuevo = new Nodo (dato);
		  Nodo auxiliar = this.cabezera.getSig();
		  Nodo auxAnterior = this.cabezera.getSig();
		  if(this.EsVacia()){
			  this.cabezera.setSig(nuevo);
			  this.ultimo = nuevo;
		  }else if(((Comparable) nuevo.getDato()).compareTo(this.getCabezera().getSig().getDato())<0){
			  nuevo.setSig(this.getCabezera().getSig());
			  this.cabezera.setSig(nuevo);
		  }else if(((Comparable) nuevo.getDato()).compareTo(this.getUltimo().getDato())>0){
			  this.ultimo.setSig(nuevo);
			  nuevo.setSig(null);
			  this.setUltimo(nuevo);
		  }else{
			  while(auxiliar != null && ((Comparable) nuevo.getDato()).compareTo(auxiliar.getDato()) > 0){
				  auxAnterior = auxiliar;
				  auxiliar = auxiliar.getSig();
			  }
			  auxAnterior.setSig(nuevo);
			  nuevo.setSig(auxiliar);
		  }
	}

	@Override
	public boolean EsVacia() {
		// TODO Auto-generated method stub
		if(cabezera.getSig()==null){
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean Buscar(Comparable dato) {
		// TODO Auto-generated method stub
		Nodo auxiliar = this.cabezera.getSig();
		boolean salida = false;
		while(auxiliar != null){
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
				salida = true;
			}else{
				auxiliar = auxiliar.getSig();
			}
		}
		return salida;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object Eliminar(Comparable dato) {
		// TODO Auto-generated method stub
		Nodo auxiliar = this.cabezera.getSig();
		Nodo auxAnterior = null;
		Object salida = null;
		if (this.EsVacia()){
			System.out.println("Lista Vacia");
		}else if(dato.compareTo(this.getCabezera().getSig().getDato()) == 0){
				salida = this.cabezera.getSig().getDato();
				this.cabezera.setSig(cabezera.getSig().getSig());
				}else{
					while(auxiliar != null && dato.compareTo(auxiliar.getDato()) != 0){
						auxAnterior = auxiliar;
						auxiliar = auxiliar.getSig();
					}
					if(auxiliar != null){
						salida = auxiliar.getDato();
						auxAnterior.setSig(auxAnterior.getSig());
					}
				}
		return salida;
		}

	@Override
	public String ListarAscendente() {
		// TODO Auto-generated method stub
	    String salida = "";
	    Nodo auxiliar = this.cabezera.getSig();
	    while(auxiliar != null){
	    	salida += auxiliar.getDato().toString()+"\n";
	    	auxiliar = auxiliar.getSig();
	    	}
	    return salida;
	}

}
