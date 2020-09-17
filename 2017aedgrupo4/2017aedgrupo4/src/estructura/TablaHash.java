package estructura;

import lib.NumerosException;
import lib.Validacion;
import modelo.Estudiante;

public class TablaHash {

	private Nodo[] tablaH;
	private int tamaño;
	private int cantElementos;
	private int cantColiciones;
	
	public TablaHash(){
		this.tamaño=211;
		tablaH=new Nodo[tamaño-1];
		this.cantElementos=0;
		this.cantColiciones=0;
	}
	
	public Nodo[] getTablaH() {
		return tablaH;
	}
	public void setTablaH(Nodo[] tablaH) {
		this.tablaH = tablaH;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public int getCantElementos() {
		return cantElementos;
	}
	public void setCantElementos(int cantElementos) {
		this.cantElementos = cantElementos;
	}
	public int getCantColiciones() {
		return cantColiciones;
	}
	public void setCantColiciones(int cantColiciones) {
		this.cantColiciones = cantColiciones;
	}

	public int funcionHash(String llave) throws NumerosException{
		int codHash=0;
		String sCodHash=llave.substring(4);
		Validacion.numeroCorrecto(sCodHash);
		codHash=Integer.parseInt(sCodHash);
		codHash=(int) (Math.pow(codHash, 2))%this.getTamaño();						
		return codHash;
	}
	
	public void insercion(String llave, Object dato) throws NumerosException{
		Nodo aux=new Nodo();
		if(tablaH[this.funcionHash(llave)]==null){
			tablaH[this.funcionHash(llave)]=new Nodo();
			tablaH[this.funcionHash(llave)].setDato(dato);
			this.setCantElementos(this.cantElementos+1);
		}else{
			aux=tablaH[this.funcionHash(llave)];
			while(aux.getRef()!=null){
				aux=aux.getRef();
			}
			aux.setRef(new Nodo());
			aux.getRef().setDato(dato);
			this.cantColiciones++;
			this.setCantElementos(this.cantElementos+1);
		}
	}
	
	public Estudiante busqueda(String leg) throws NumerosException{
		Estudiante estudiante=null;
		Nodo n;
		if(tablaH[this.funcionHash(leg)].getDato()!=null){
			n=tablaH[this.funcionHash(leg)];
			estudiante=(Estudiante)tablaH[this.funcionHash(leg)].getDato();
			while(estudiante.getLegajo().equals(leg)!=true&&n.getRef()!=null){
				n=n.getRef();
				estudiante=(Estudiante) n.getDato();
			}
			if(!estudiante.getLegajo().equals(leg)){
				System.out.println("posicion vacia en la tabla");
				estudiante=null;
				return estudiante;
			}else{
				return estudiante;
			}
		}else{
			System.out.println("posicion vacia en la tabla");
			estudiante=null;
			return estudiante;
		}
	}
	
	public void borrado(){
		for(int i=0;i<this.tablaH.length;i++){
			tablaH[i]=null;
		}
		this.setCantElementos(0);
		this.setCantColiciones(0);
	}

}
