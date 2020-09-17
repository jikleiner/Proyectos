package modelo;

import java.util.ArrayList;

import estructura.ListaSimple;

public class Caja {
	private int numero;
	private ArrayList<Snack> snack;
	private Entrada entrada;
	

	public Caja(int numero, Entrada entrada) {
		super();
		this.numero = numero;
		this.entrada = entrada;
	}
	
	public Caja(int numero, ArrayList<Snack> snack) {
		super();
		this.numero = numero;
		this.snack = snack;
	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public  ArrayList<Snack> getSnack() {
		return snack;
	}

	public void setSnack( ArrayList<Snack> snack) {
		this.snack = snack;
	}

	public Entrada getListaEntrada() {
		return entrada;
	}

	public void setListaEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	@Override
	public String toString() {
		return "Caja [numero=" + numero + ", snack=" + snack + ", Entrada=" + entrada + "]";
	}
	
	
	
	

}
