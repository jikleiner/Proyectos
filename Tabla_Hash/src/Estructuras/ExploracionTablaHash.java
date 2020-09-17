package Estructuras;

public abstract class ExploracionTablaHash implements ITablaHash{

	private static final int TAMA�O_TABLA_POR_DEFECTO = 11;
	protected EntradaHash [] vector;
	private int tama�oActual;
	
	private final void crearVector(int tama�oVector){
		vector = new EntradaHash[tama�oVector];
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
		this.tama�oActual = 0;
		for(int i = 0; i<vector.length; i++){
			vector[i]=null;
		}
	}
	
	public ExploracionTablaHash(){
		crearVector(TAMA�O_TABLA_POR_DEFECTO);
		vaciar();
	}
	
}
