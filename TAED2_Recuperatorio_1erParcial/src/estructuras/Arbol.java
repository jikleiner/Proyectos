package estructuras;

public class Arbol {
	private Nodo raiz;
	private static int cant=0;
	
	public Arbol(){
		this(null);
	}	
	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public boolean esVacio(){
		return this.raiz==null;
	}
	
	public void imprimirArbol(){
		imprimirArbol(this.raiz);
	}
	
	private void imprimirArbol(Nodo nodo){
		if(nodo!=null){
			imprimirArbol(nodo.getIzq());
			System.out.println(nodo.getDato().toString());
			imprimirArbol(nodo.getDer());
		}
	}
	
	public Nodo buscar(Comparable dato){
		return buscar(this.raiz, dato);
	}
	//ver si la comprobacion de si el nodo tiene o no derecho e izquierdo
	//corresponde al mismo if o si correcponde a un if anidado
	private Nodo buscar(Nodo nodo, Comparable dato){
		if(nodo.getDato().compareTo(dato)<0&&nodo.getDer()!=null){
			return buscar(nodo.getDer(),dato);
		}else if(nodo.getDato().compareTo(dato)>0&&nodo.getIzq()!=null){
			return buscar(nodo.getIzq(),dato);
		}else if(nodo.getDato().compareTo(dato)==0){
			return nodo;			
		}else{
			return null;
		}
	}
	
	
	public Nodo buscarMin(){
		return buscarMin(this.raiz);
	}
	private Nodo buscarMin(Nodo nodo){
		if(nodo.getIzq()!=null&&nodo.getIzq().compareTo(nodo)<0){
			return buscarMin(nodo.getIzq());
		}else{
			return nodo;			
		}
	}
	
	
	public Nodo buscarMax(){
		return buscarMax(this.raiz);
	}
	private Nodo buscarMax(Nodo nodo){
		if(nodo.getDer()!=null&&nodo.getDer().compareTo(nodo)>0){
			return buscarMax(nodo.getDer());
		}else{
			return nodo;			
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public void insertar(Comparable dato){
		Nodo n=new Nodo(dato);
		if(esVacio()){
			this.raiz=n;
		}else{
			insertar(this.raiz, n);
		}
		this.cant++;
	}
	private void insertar(Nodo raiz, Nodo nodo){
		if(raiz.compareTo(nodo)>0){
			if(raiz.getIzq()!=null){
				insertar(raiz.getIzq(),nodo);
			}else{
				raiz.setIzq(nodo);
			}
		}else{
			if(raiz.getDer()!=null){
				insertar(raiz.getDer(),nodo);
			}else{
				raiz.setDer(nodo);
			}
		}
	}
	
	
	public void eliminar(Comparable dato){
		Nodo nodo=this.getRaiz();
		Nodo aux=this.getRaiz();
		if(this.esVacio()){
			System.out.println("no hay elementos para eliminar");
		}else{
			eliminar(aux, nodo, dato);			
		}
		Arbol.cant--;
	}
	private void eliminar(Nodo padre, Nodo nodo, Comparable dato){
		//recorre izquierdo
		if(nodo.getDato().compareTo(dato)>0&&nodo.getIzq()!=null){
			padre=nodo;
			nodo=nodo.getIzq();
			eliminar(padre, nodo, dato);
		//recorre derecho
		}else if(nodo.getDato().compareTo(dato)<0&&nodo.getDer()!=null){
			padre=nodo;
			nodo=nodo.getDer();
			eliminar(padre, nodo, dato);
		//si encuentra
		}else if(nodo.getDato().compareTo(dato)==0){
			//si ambos hijos del nodo a eliminar son null
			if(nodo.getDer()==null&&nodo.getIzq()==null){
				//en caso de que el dato sea menor que el padre
				if(padre.compareTo(nodo)<0){
					padre.setIzq(null);
					nodo=null;
				// en caso de que el dato sea mayor
				}else{
					padre.setDer(null);
					nodo=null;
				}
			//si alguno de los hijos del nodo a eliminar no es null
			}else if(nodo.getIzq()!=null||nodo.getDer()!=null){
				//si tiene hijo izquierdo
				if(nodo.getIzq()!=null){
					Nodo auxI= nodo.getIzq();
					Nodo auxD= nodo.getDer();
					Nodo auxE= buscarMax(auxI, auxI.getDer());
					if(auxI==auxE){
						padre.setIzq(auxI);
						padre.getIzq().setDer(auxD);
						nodo=null;
					}else{
						nodo=auxE;
						nodo.setIzq(auxI);
						nodo.setDer(auxD);
						padre.setIzq(nodo);						
					}
					
				//si tiene hijo derecho
				}else{
					Nodo auxI= nodo.getIzq();
					Nodo auxD= nodo.getDer();
					Nodo auxE= buscarMin(auxD, auxD.getDer());
					if(auxD==auxE){
						padre.setIzq(auxD);
						padre.getIzq().setDer(auxI);
						nodo=null;
					}else{
						nodo=auxE;
						nodo.setIzq(auxI);
						nodo.setDer(auxD);
						padre.setIzq(nodo);						
					}
				}
			}
		}
	}
	
	//ver como funcionaria el de buscar min y max para eliminar
	private Nodo buscarMin(Nodo padre, Nodo hijo){
		Nodo aux;
		if(hijo!=null&&hijo.getIzq()!=null){
			padre=hijo;
			hijo=hijo.getIzq();
			return buscarMin(padre, hijo);
		}else{
			return padre;			
		}
	}
	private Nodo buscarMax(Nodo padre, Nodo hijo){
		Nodo aux;
		if(hijo!=null&&hijo.getDer()!=null){
			padre=hijo;
			hijo=hijo.getDer();
			return buscarMax(padre, hijo);
		}else{
			return padre;
		}
	}
	
	
	public void recorrerPreOrden(){
		recorrerPreOrden(this.raiz);
	}
	private void recorrerPreOrden(Nodo nodo){
		System.out.println(nodo.getDato().toString());
		if(nodo.getIzq()!=null){
			recorrerPreOrden(nodo.getIzq());
			
		}
		if(nodo.getDer()!=null){
			recorrerPreOrden(nodo.getDer());
		}
	}
	
	
	public void recorrerInOrden(){
		recorrerInOrden(this.raiz);
	}
	private void recorrerInOrden(Nodo nodo){
		if(nodo.getIzq()!=null){
			recorrerInOrden(nodo.getIzq());
		}
		System.out.println(nodo.getDato().toString());
		if(nodo.getDer()!=null){
			recorrerInOrden(nodo.getDer());
		}
	}
	
	
	public void recorrerPostOrden(){
		recorrerPostOrden(this.raiz);
	}
	private void recorrerPostOrden(Nodo nodo){
		if(nodo.getIzq()!=null){
			recorrerPostOrden(nodo.getIzq());
		}
		if(nodo.getDer()!=null){
			recorrerPostOrden(nodo.getDer());
		}
		System.out.println(nodo.getDato().toString());
	}
	
	
	public int calcularAltura(){
		return calcularAltura(this.raiz); 
	}
	private int calcularAltura(Nodo nodo){
		int i = 0, d = 0;
		if(nodo.getIzq()!=null){
			i = calcularAltura(nodo.getIzq())+1;
		}else if(nodo.getDer()!=null){
			d = calcularAltura(nodo.getDer())+1;			
		}else{
			return 1;
		}
		if(i<d){
			return d;
		}else if(d<i){
			return i;
		}else{
			return i;
		}
	}
	
	
	public int calcularTamaño(){
		return Arbol.cant;
	}
}
