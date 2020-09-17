package estructuras;

import modelo.Vehiculo;

import java.util.ArrayList;

public class ArbolVehiculos extends Arbol{
	private ArrayList<Vehiculo> lista;
	
	public ArbolVehiculos() {
		super();
		this.lista = new ArrayList<Vehiculo>();;
	}
	
	public ArrayList<Vehiculo> recorrerPreOrdenVehiculo(){
		lista.clear();
		recorrerPreOrdenVehiculo(this.getRaiz());
		return lista;
	}
	private void recorrerPreOrdenVehiculo(Nodo nodo){
		if(nodo.getIzq()!=null){
			recorrerPreOrdenVehiculo(nodo.getIzq());
		}
		if(nodo.getDer()!=null){
			recorrerPreOrdenVehiculo(nodo.getDer());
		}
		lista.add((Vehiculo) nodo.getDato());
	}

	/*public boolean buscarVehiculo(Vehiculo cli, String patente){
		Nodo n = this.buscar(cli);
		if(((Cliente) n.getDato()).getVehiculos().buscar(new Vehiculo("AA000BB"), patente)<1){
			return false;
		}else{
			return true;
		}
	}*/
}
