package modelo;

public class Camino implements Comparable {
	private String codigo;
	private String codRouterOrigen;
	private String codRouterDestino;
	private int costo;
	
	public Camino(String codigo, String codRouterOrigen, String codRouterDestino, int costo){
		this.codigo = codigo;
		this.codRouterOrigen = codRouterOrigen;
		this.codRouterDestino = codRouterDestino;
		this.costo = costo;
	}
	
	public String getCodRouterOrigen() {
		return codRouterOrigen;
	}
	public void setCodRouterOrigen(String codRouterOrigen) {
		this.codRouterOrigen = codRouterOrigen;
	}
	public String getCodRouterDestino() {
		return codRouterDestino;
	}
	public void setCodRouterDestino(String codRouterDestino) {
		this.codRouterDestino = codRouterDestino;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int compareTo(Object n) {
		Camino camino=(Camino)n;
		return this.getCodigo().compareTo(camino.getCodigo());
	}

	@Override
	public String toString() {
		return "Camino [codigo=" + codigo + ", codRouterOrigen=" + codRouterOrigen + ", codRouterDestino="
				+ codRouterDestino + ", costo=" + costo + "]";
	}

}
