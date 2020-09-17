package documento;

public class DocumentoTexto extends Documento{

	@Override
	public void abrir() {
		// TODO Auto-generated method stub
		System.out.println("abriendo documento de texto");
	}

	@Override
	public void cerrar() {
		// TODO Auto-generated method stub
		System.out.println("cerrando documento de texto");
	}

	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		System.out.println("guardando documento de texto");
	}

	@Override
	public void deshacer() {
		// TODO Auto-generated method stub
		System.out.println("deshaciendo ultima accion en documento de texto");
	}

}
