package estructuras;

import modelo.Cliente;
import modelo.Vehiculo;

import java.util.ArrayList;

public class ArbolClientes extends Arbol{
	private ArrayList<Cliente> lista;
	
	public ArbolClientes() {
		super();
		this.lista = new ArrayList<Cliente>();;
	}
	
	public ArrayList<Cliente> recorrerPostOrdenCliente(){
		recorrerPostOrdenCliente(this.getRaiz());
		return lista;
	}
	private void recorrerPostOrdenCliente(Nodo nodo){
		if(nodo.getIzq()!=null){
			recorrerPostOrdenCliente(nodo.getIzq());
		}
		if(nodo.getDer()!=null){
			recorrerPostOrdenCliente(nodo.getDer());
		}
		lista.add((Cliente) nodo.getDato());
	}

	public boolean buscarVehiculo(Cliente cli, String patente){
		Nodo n = this.buscar(cli);
		if(((Cliente) n.getDato()).getVehiculos().buscar(new Vehiculo("AA000BB"), patente)<1){
			return false;
		}else{
			return true;
		}
	}
}
