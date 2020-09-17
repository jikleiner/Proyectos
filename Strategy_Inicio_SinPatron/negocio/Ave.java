package negocio;

public abstract class Ave {

	public abstract void mostrarInformacion();
	
	public void descansar() {
		System.out.println("Estoy descansando");
	}
	
	public void dormir() {
		System.out.println("Estoy durmiendo");
	}
	
	public void volar() {
		System.out.println("Estoy volando");
	}
	
}
