package documento;

public class DocumentoTexto extends Documento {

	public void abrir() {
		System.out.println("Abriendo documento de texto");
	}
	
	public void cerrar() {
		System.out.println("Cerrando documento de texto");
	}
	
	public void guardar() {
		System.out.println("Guardando documento de texto");
	}
	
	public void deshacer() {
		System.out.println("Deshaciendo �ltima acci�n en documento de texto");
	}

}
