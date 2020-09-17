package modelo;

import estructuras.TablaConductores;

public class Vehiculo implements Comparable{
	private Integer id;
	private String modelo;
	private String marca;
	private String patente;
	private TablaConductores conductores;

	public Vehiculo(int id){
		super();
		this.id = id;
	}
	
	public Vehiculo(int id, String modelo, String marca, String patente) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.patente = patente;
		this.conductores = new TablaConductores();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public TablaConductores getConductores() {
		return conductores;
	}

	public void setConductores(TablaConductores conductores) {
		this.conductores = conductores;
	}


	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", patente=" + patente
				+ ", conductores=" + conductores + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(((Vehiculo) arg0).getId());
	}
}
