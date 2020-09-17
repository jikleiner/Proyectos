package estructura;

import java.util.ArrayList;

public class Vertice implements Comparable {
	private String nombre;
	private ArrayList<Vertice> adyacentes;
	private boolean visto;
	private int distancia;
	private Vertice anterior;
	
	public Vertice(String nombre) {
		super();
		this.nombre = nombre;
		this.visto = false;
		this.adyacentes = new ArrayList();
		this.distancia = 99999; 
		this.anterior = null;
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

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public Vertice getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return "Vertice [nombre=" + nombre + ", distancia=" + distancia + "]";
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
