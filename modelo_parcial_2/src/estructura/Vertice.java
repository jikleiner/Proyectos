package estructura;

import java.util.ArrayList;

public class Vertice implements Comparable {
	private String nombre;
	private ArrayList<Vertice> adyacentes;
	private boolean visto;

	public Vertice(String nombre) {
		super();
		this.nombre = nombre;
		this.visto = false;
		this.adyacentes = new ArrayList();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVisto() {
		return visto;
	}

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

	public ArrayList<Vertice> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(ArrayList<Vertice> adyacentes) {
		this.adyacentes = adyacentes;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 instanceof String) {
			return this.getNombre().compareTo((String) arg0);
		}else{
			return this.getNombre().compareTo(((Vertice)arg0).getNombre());
		}
	}

}
