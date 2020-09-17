package modelo;

import java.util.ArrayList;
import estructuras.ListaDoble;

public class Vendedor extends Persona implements Comparable{
	
	private int legajo;
	private ArrayList telefonosContacto;

	public Vendedor(String nombre, String apellido, int edad, int legajo, ArrayList tel) {
		super(nombre, apellido, legajo);
		this.legajo = legajo;
		this.telefonosContacto = tel;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public ArrayList getTelefonosContacto() {
		return telefonosContacto;
	}

	public void setTelefonosContacto(ArrayList telefonosContacto) {
		this.telefonosContacto = telefonosContacto;
	}

	@Override
	public String toString() {
		return super.toString() + ", legajo=" + legajo +  "]";
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		String leg=(String) arg0;
		String legAct=Integer.toString(this.getLegajo());
		return legAct.compareTo(leg);
	}
	
}
