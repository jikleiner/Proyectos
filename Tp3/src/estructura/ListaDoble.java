package estructura;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Entrada;

public class ListaDoble<T extends Object> implements EstructuraLista{

	private NodoDoble cabecera;
	private NodoDoble ultimo;
	
	
	public ListaDoble () {
		this.cabecera = null;
		this.ultimo = null;
	}
	
	public NodoDoble getCabecera() {
		return cabecera;
	}

	public void setCabecera(NodoDoble cabecera) {
		this.cabecera = cabecera;
	}

	public NodoDoble getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodoDoble ultimo) {
		this.ultimo = ultimo;
	}

	@Override
	public void Vaciar() {
		this.cabecera = null;
		this.ultimo = null;
	}

	@Override
	public void Insertar(Comparable dato) {
		NodoDoble nuevo = new NodoDoble (dato);
		
		
		NodoDoble<Object> nvo = new NodoDoble (dato);
		if(this.EsVacia()){
			this.cabecera = nuevo;
			this.ultimo = nuevo;
		}else if(!(menorPrimero(nuevo))&&!(mayorUltimo(nuevo))){
			//medio(nuevo);
		}
	}

	public void medio(NodoDoble nuevo,NodoDoble auxiliar,NodoDoble auxAnterior) {
	
			nuevo.setSig(auxAnterior.getSig());
			auxAnterior.setSig(nuevo);
			nuevo.setAnt(auxAnterior);
			auxiliar.setAnt(nuevo);
	}
	
	public void insertarEnListaVacia(NodoDoble nuevo){
		this.cabecera = nuevo;
		this.ultimo = nuevo;
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
		NodoDoble auxiliar = this.cabecera;
		boolean salida = false;
		
		while(auxiliar != null){
		
			if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
				salida = true;
				return salida;
			}
			auxiliar = auxiliar.getSig();
		}
		return salida;
	}
	
	@Override
	public Object Eliminar(Comparable dato) {
		NodoDoble auxiliar = this.cabecera;
		
		Object salida = null;
		if (this.EsVacia()){
			return "vacia";
		}
		//si esta en el primer lugar
		else if(dato.compareTo(this.getCabecera().getDato()) == 0){
			salida = this.cabecera.getDato();
			this.cabecera = this.cabecera.getSig();
			if(cabecera!=null){
				this.cabecera.setAnt(null);
			}
			return salida;
			
		}//si esta en el ultimo lugar
		else if(dato.compareTo(this.getUltimo().getDato()) == 0){
			salida = this.ultimo.getDato();
			this.ultimo = this.ultimo.getAnt();
			if(ultimo!=null){
				this.ultimo.setSig(null);
			}
			return salida;
		}//si esta en el medio
		else{
			while(auxiliar != null){
				
				if(((Comparable) auxiliar.getDato()).compareTo(dato) == 0){
					salida = auxiliar.getDato();
					auxiliar.getSig().setAnt(auxiliar.getAnt());
					auxiliar.getAnt().setSig(auxiliar.getSig());
					return salida;
				}
				auxiliar = auxiliar.getSig();
			
			}
		}
		return salida;
		
	}
	
	public boolean eliminarUnicoElemento(NodoDoble nuevo){
		if(((Comparable) nuevo.getDato()).compareTo(this.getCabecera().getDato()) == 0 && this.getCabecera()==this.getUltimo()){
			
			this.setCabecera(null);
			this.setUltimo(null);
			return true;
			}
		return false;
	}
	
	public boolean eliminarPrimero(NodoDoble nuevo) {

		if (((Comparable) nuevo.getDato()).compareTo(this.getCabecera().getDato()) == 0) {

			this.cabecera = this.cabecera.getSig();
			if (cabecera != null) {
				this.cabecera.setAnt(null);
				return true;
			}
		}
		return false;
	}
	
	public boolean eliminarUltimo(NodoDoble nuevo) {

		if (((Comparable) nuevo.getDato()).compareTo(this.getUltimo().getDato()) == 0) {

			this.ultimo = this.ultimo.getAnt();
			if (ultimo != null) {
				this.ultimo.setSig(null);
				return true;
			}
		}
		return false;
	}
	
	public void eliminarMedio(NodoDoble nuevo, NodoDoble auxiliar){
		
		if(((Comparable) auxiliar.getDato()).compareTo(nuevo.getDato()) == 0){
			auxiliar.getSig().setAnt(auxiliar.getAnt());
			auxiliar.getAnt().setSig(auxiliar.getSig());
		}
		
		
	}
	

	@Override
	public String ListarAscendente() {
		String salida = "";
		NodoDoble auxiliar = this.cabecera;
		while(!vacia(auxiliar)){
			salida += auxiliar.getDato().toString()+"\n";
			auxiliar = auxiliar.getSig();
		}
		return salida;
	}
	

	@Override
	public String ListarDescendente() {
		String salida = "";
		NodoDoble auxiliar = this.ultimo;
		while(auxiliar != null){
			salida += auxiliar.getDato().toString()+"\n";
			auxiliar = auxiliar.getAnt();
		}
		return salida;
	}
	
	/**
	 * 
	 * @param auxiliar
	 * @return
	 */
	public  boolean vacia(NodoDoble auxiliar){
		if(auxiliar == null){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param nuevo
	 * @return
	 */
	public boolean menorPrimero(NodoDoble nuevo){
		
		if (((Comparable) nuevo.getDato()).compareTo(this.getCabecera().getDato())<0){
			 nuevo.setSig(cabecera);
			 cabecera.setAnt(nuevo);
			 cabecera=nuevo;
			 return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param nuevo
	 * @return
	 */
	public boolean mayorUltimo(NodoDoble nuevo){
		if (((Comparable) nuevo.getDato()).compareTo(this.getUltimo().getDato())> 0){
			
			this.ultimo.setSig(nuevo);
			nuevo.setAnt(ultimo);
			nuevo.setSig(null);
			ultimo = nuevo; 
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Cliente> Listar() {
		String salida = "";
		NodoDoble auxiliar = this.cabecera;
		ArrayList<Cliente> lista = new ArrayList();
		while(!vacia(auxiliar)){
			lista.add((Cliente)auxiliar.getDato());
			salida += auxiliar.getDato().toString()+"\n";
			auxiliar = auxiliar.getSig();
		}
		return lista;
	}
}
