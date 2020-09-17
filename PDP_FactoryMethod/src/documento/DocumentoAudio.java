package documento;

public class DocumentoAudio extends Documento{

	@Override
	public void abrir() {
		// TODO Auto-generated method stub
		System.out.println("abriendo documento de audio");
	}

	@Override
	public void cerrar() {
		// TODO Auto-generated method stub
		System.out.println("cerrando documento de audio");
	}

	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		System.out.println("guardando documento de audio");
	}

	@Override
	public void deshacer() {
		// TODO Auto-generated method stub
		System.out.println("deshaciendo ultima accion de documento de audio");
	}

}
