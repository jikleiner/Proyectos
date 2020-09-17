package Estructuras;

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
		if(nodo.getIzq().getDato().compareTo(dato)<0&nodo.getIzq()!=null){
			buscar(nodo.getIzq(),dato);
		}else if(nodo.getDer().getDato().compareTo(dato)>0&nodo.getDer()!=null){
			buscar(nodo.getIzq(),dato);
		}
		return nodo;
	}
	
	
	public void buscarMin(){
		buscarMin(this.raiz);
	}
	private void buscarMin(Nodo nodo){
		if(nodo.getIzq().compareTo(nodo)<0&nodo.getIzq()!=null){
			buscarMin(nodo.getIzq());
		}
		System.out.println(nodo.getDato().toString());
	}
	
	
	public Nodo buscarMax(){
		return buscarMax(this.raiz);
	}
	private Nodo buscarMax(Nodo nodo){
		if(nodo.getDer().compareTo(nodo)>0&nodo.getDer()!=null){
			buscarMax(nodo.getDer());
		}
		return nodo;
	}
	
	
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
				if(raiz.getIzq().compareTo(nodo)<0){
					insertar(raiz.getIzq(),nodo);
				}
			}else{
				raiz.setIzq(nodo);
			}
		}else{
			if(raiz.getDer()!=null){
				if(raiz.getDer().compareTo(nodo)>0){
					insertar(raiz.getDer(),nodo);
				}
			}else{
				raiz.setDer(nodo);
			}
		}
	}
	
	
	public void eliminar(Comparable dato){
		Nodo nodo=null;
		Nodo aux=this.getRaiz();
		if(this.raiz.getDato().compareTo(dato)==0){
			this.setRaiz(null);
			aux=null;
		}else if(this.raiz.getDato().compareTo(dato)<0){
			nodo=aux.getDer();
		}else if(aux.getDato().compareTo(dato)>0){
			nodo=aux.getIzq();
		}
		eliminar(aux, nodo, dato);
		Arbol.cant--;
	}
	private void eliminar(Nodo aux, Nodo nodo, Comparable dato){
		if(nodo.getDato().compareTo(dato)<0&nodo.getIzq()!=null){
			aux=nodo;
			nodo=nodo.getIzq();
			eliminar(aux, nodo, dato);
		}else if(nodo.getDato().compareTo(dato)>0&nodo.getDer()!=null){
			aux=nodo;
			nodo=nodo.getDer();
			eliminar(aux, nodo, dato);
		}else if(nodo.getDato().compareTo(dato)==0){
			/*
			 * nodo hoja
			 */
			if(nodo.getDer()==null&nodo.getIzq()==null){
				nodo=null;
				if(aux.compareTo(nodo)<0){
					aux.setIzq(null);
				}else{
					aux.setDer(null);					
				}
			/*
			 * nodo con un hijo
			 */
			}else if(nodo.getDer()!=null|nodo.getIzq()!=null){
				if(nodo.getIzq()!=null&nodo.getDer()==null){
					if(aux.compareTo(nodo)<0){
						aux.setIzq(nodo.getIzq());
						nodo=nodo.getIzq();
					}else{
						aux.setDer(nodo.getIzq());
						nodo=nodo.getIzq();						
					}
				}else if(nodo.getDer()!=null&nodo.getIzq()==null){
					if(aux.compareTo(nodo)<0){
						aux.setIzq(nodo.getDer());
						nodo=nodo.getDer();
					}else{
						aux.setDer(nodo.getDer());
						nodo=nodo.getDer();						
					}
				/*
				 * nodo con dos hijos
				 * mayor de los menores
				 */
				}else if(nodo.getDer()!=null&nodo.getIzq()!=null){
					//si no tiene hijos
					if(aux.compareTo(nodo)<0){
						nodo=buscarMax(nodo.getIzq());
						aux.setIzq(nodo.getIzq());
					}else{
						nodo=buscarMax(nodo.getIzq());
						aux.setDer(nodo.getIzq());
					}	
				}
			}
		}
	}
	
	
	public void recorrerPreOrden(){
		recorrerPreOrden(this.raiz);
	}
	private void recorrerPreOrden(Nodo nodo){
		System.out.println(nodo.getDato().toString());
		if(nodo.getIzq()!=null){
			recorrerPreOrden(nodo.getIzq());
		}else if(nodo.getDer()!=null){
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
		}else if(nodo.getDer()!=null){
			recorrerPostOrden(nodo.getDer());
		}
		System.out.println(nodo.getDato().toString());
	}
	
	
	public int calcularAltura(){
		return calcularAltura(this.raiz, 1, 1); 
	}
	private int calcularAltura(Nodo nodo,int acuIz,int acuDe){
		if(nodo.getIzq()!=null){
			calcularAltura(nodo.getIzq(), acuIz+1, acuDe);
		}
		if(nodo.getDer()!=null){
			calcularAltura(nodo.getIzq(), acuIz, acuDe+1);
		}
		if(acuIz>acuDe){
			return acuIz;
		}else{
			return acuDe;
		}
	}
	
	
	public int calcularTamaño(){
		return Arbol.cant;
	}
}
