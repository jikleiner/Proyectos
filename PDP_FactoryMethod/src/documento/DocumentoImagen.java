package documento;

public class DocumentoImagen extends Documento{

	@Override
	public void abrir() {
		// TODO Auto-generated method stub
		System.out.println("abrir documento de imagen");
	}

	@Override
	public void cerrar() {
		// TODO Auto-generated method stub
		System.out.println("cerrando documento de imagen");
	}

	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		System.out.println("guardando documento de imagen");
	}

	@Override
	public void deshacer() {
		// TODO Auto-generated method stub
		System.out.println("deshaciendo ultima accion en documento de imagen");
	}
	
	

}
