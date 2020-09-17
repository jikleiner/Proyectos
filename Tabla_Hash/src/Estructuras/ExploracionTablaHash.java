package Estructuras;

public abstract class ExploracionTablaHash implements ITablaHash{

	private static final int TAMAÑO_TABLA_POR_DEFECTO = 11;
	protected EntradaHash [] vector;
	private int tamañoActual;
	
	private final void crearVector(int tamañoVector){
		vector = new EntradaHash[tamañoVector];
	}
	
	private int buscarPos(Hashable obj){
		int posicionActual = obj.hash(vector.length);
		if(vector[posicionActual]==null){
			return posicionActual;
		}else{
			while(vector[posicionActual]!=null){
				if(posicionActual>= vector.length){
					posicionActual-= vector.length;
				}else{
					posicionActual++;
				}
			}	
		}
		return posicionActual;	
	}
		
	public void eliminar(Hashable x){
		int posicionActual = x.hash(vector.length);
		if (vector[posicionActual] != null) {
			vector[posicionActual]=null;
			System.out.println("Se elimino correctamente");
		} else {
			System.out.println("No se encuentra en la lista");
		}
	}
		
	public void insertar(Hashable obj){
		int posicionAGuardar=buscarPos(obj);
		vector[posicionAGuardar]=(EntradaHash)obj;
	}
	
	public final void vaciar(){
		this.tamañoActual = 0;
		for(int i = 0; i<vector.length; i++){
			vector[i]=null;
		}
	}
	
	public ExploracionTablaHash(){
		crearVector(TAMAÑO_TABLA_POR_DEFECTO);
		vaciar();
	}
	
}
