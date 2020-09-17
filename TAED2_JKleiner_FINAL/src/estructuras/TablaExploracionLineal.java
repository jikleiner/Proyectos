package estructuras;

public abstract class TablaExploracionLineal extends ExploracionTablaHash{

	protected int buscarPos(Hashable x){
		int colision=0;
		int posicionActual = x.hash(vector.length);
		while (vector[posicionActual]!=null&&!vector[posicionActual].getElemento().equals(x)){
			posicionActual+=2*++colision-1;
			if(posicionActual>=vector.length){
				posicionActual-=vector.length;
			}
		}
		//System.out.println("para el elemento "+ x.toString() + "posicion: " + posicionActual);
		return posicionActual;
	}

	public int buscar(Hashable obj, String val){
		int posicionActual = obj.hash(vector.length);
		int i = 0;
		int encontrado = 0;
		while (i != 11) {//ver el tamaño del while
			i++;
			if (vector[posicionActual] != null) {
				if (val.equals(vector[posicionActual].getClaveH())) {//evaluar el uso de este equals
					encontrado = 1;
					return encontrado;
				}
				if (posicionActual == vector.length) {
					posicionActual = 0;
				}
			}

		}
		return encontrado;
	}
	public void listar(){
		int i = 0;
		while(i<vector.length){
			if(vector[i]!=null){
				System.out.println(vector[i].toString());				
			}
			i++;
		}
	}

}
