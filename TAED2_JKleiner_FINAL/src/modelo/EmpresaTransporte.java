package modelo;

import java.util.ArrayList;

import estructuras.ArbolVehiculos;

public class EmpresaTransporte {
	private String nombre;
	private String cuit;
	private ArbolVehiculos vehiculos;

	public EmpresaTransporte(String nombre, String cuit) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
		this.vehiculos = new ArbolVehiculos();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public ArbolVehiculos getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArbolVehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public void imprimirPatentesYModelos(){
		ArrayList<Vehiculo> v =this.vehiculos.recorrerPreOrdenVehiculo();
		for(Vehiculo a : v){
			System.out.println("patente: "+a.getPatente()+", modelo: "+a.getModelo());
		}
	}
	
	public int cantConductoresTotal(){
		int cant=0;
		ArrayList<Vehiculo> vh=this.vehiculos.recorrerPreOrdenVehiculo();
		for(Vehiculo v : vh){
			cant=cant+v.getConductores().contarConductores();
		}
		return cant;
	}

	@Override
	public String toString() {
		return "EmpresaTransporte [nombre=" + nombre + ", cuit=" + cuit + ", vehiculos=" + vehiculos + "]";
	}
	
}
