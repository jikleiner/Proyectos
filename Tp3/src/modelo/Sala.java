package modelo;

import java.util.ArrayList;

public class Sala {
	private int codigo;
	private ArrayList butaca=new ArrayList<Butaca>();
	
	
	public Sala(int codigo) {
		super();
		this.codigo = codigo;
		for (int i = 1; i < 31; i++) {
			Butaca butacaCreada=new Butaca(i);
			butaca.add(butacaCreada);
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList getButaca() {
		return butaca;
	}

	public void setButaca(ArrayList butaca) {
		this.butaca = butaca;
	}


	@Override
	public String toString() {
		return "Sala [codigo=" + codigo + "]";
	}
	
	
	
	
	
	
	
}
