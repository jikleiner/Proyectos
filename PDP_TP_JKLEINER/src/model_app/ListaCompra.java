package model_app;
import java.util.ArrayList;

import model_domain.Producto;

public class ListaCompra{
	
	private ArrayList<Producto> lista;
	private Descuento descuento;

	public void agregar(Producto producto) {
		// TODO Auto-generated method stub
		this.lista.add(producto);
	}

	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.lista.remove(numero);
	}

	public ArrayList<Producto> getLista() {
		return lista;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public ListaCompra() {
		super();
		this.lista = new ArrayList<Producto>();
	}

}
