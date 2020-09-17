package documento;

public class DocumentoImagen extends Documento {

	public void abrir() {
		System.out.println("Abriendo documento de imagen");
	}
	
	public void cerrar() {
		System.out.println("Cerrando documento de imagen");
	}
	
	public void guardar() {
		System.out.println("Guardando documento de imagen");
	}
	
	public void deshacer() {
		System.out.println("Deshaciendo última acción en documento de imagen");
	}
	
}
