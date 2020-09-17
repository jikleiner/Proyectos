package estructura;

import modelo.Persona;

public class TablaExploracionLineal extends ExploracionTablaHash {
	
	public TablaExploracionLineal(){
	}	
	
	public int buscarPos(Hashable x) {
		int posicionActual = x.hash(vector.length);
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
	
	@Override
	public void insertar(Hashable x) {
		int posicionAGuardar=buscarPos(x);
		vector[posicionAGuardar]=(Persona) x;
		
	}
}
