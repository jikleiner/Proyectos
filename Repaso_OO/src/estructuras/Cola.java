package estructuras;


public class Cola implements ListaEnlazada{
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
		if(esVacio()){
			pri=nvo;
			ult=nvo;
		}else{
			ult.setSig(nvo);
			ult=nvo;
		}
	}
	
	public void eliminar(){
		if(pri.getSig()==null){
			pri=null;
			ult=null;
		}else{
			pri=pri.getSig();
		}
	}
	
	public void vaciar(){
		pri=null;
		ult=null;
		aux=null;
	}
	
	public void listar(){
		if(esVacio()){
			System.out.println("no hay elementos que mostrar");
		}else if(pri==ult){
			System.out.println(pri.getDato().toString()+"\n");
		}else{
			aux=pri;
			do{
				System.out.println(aux.getDato().toString()+"\n");
				aux=aux.getSig();
			}while(aux!=null);
		}
	}
	
	public Object buscar(Object o){
		if(o==pri.getDato()){
			return pri.getDato();
		}else{
		 	aux=pri.getSig();
			while(aux!=o){
			aux=aux.getSig();	
			}
			return aux.getDato();
		}
	}
	
}