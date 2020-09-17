package estructuras;

public class Pila implements ListaEnlazada{
	private Nodo pri;
	private Nodo ult;
	private Nodo aux;
	
	public Nodo getPri() {
		return pri;
	}

	public void setPri(Nodo pri) {
		this.pri = pri;
	}

	public Nodo getUlt() {
		return ult;
	}

	public void setUlt(Nodo ult) {
		this.ult = ult;
	}

	public Nodo getAux() {
		return aux;
	}

	public void setAux(Nodo aux) {
		this.aux = aux;
	}

	public boolean esVacio(){
		if(pri==null){
			return true;
		}else{
			return false;
		}
	}
	
	public void agregar(Object o){
		Nodo nvo=new Nodo(o);
		nvo.setSig(null);
		if(ult==null){
			ult=nvo;
			pri=nvo;
		}else{
			nvo.setSig(pri);
			pri=nvo;
		}	
	}
	
	public void eliminar(){
		if(esVacio()){
			System.out.println("esta vacia");
		}else if(pri==ult){
			pri=null;
			pri.setSig(null);
			ult=null;
		}else{
			ult=ult.getSig();
		}
	}
	
	public void vaciar(){
		ult=null;
		pri=null;
		aux=null;
	}
	
	public void listar(){
		if(esVacio()){
			System.out.println("no hay elementos que mostrar");
		}else if(ult==pri){
			System.out.println(ult.getDato().toString()+"\n");
		}else{
			System.out.println(pri.getDato().toString()+"\n");
			aux=pri.getSig();
			while(aux!=null){
				System.out.println(aux.getDato().toString()+"\n");
				aux=aux.getSig();
			}
		}
	}
	
	public Object buscar(Object o){
		if(o==ult.getDato()){
			return ult.getDato();
		}else{
		 	aux=ult.getSig();
			while(aux!=o){
			aux=aux.getSig();	
			}
			return aux.getDato();
		}
	
	}
	
}
