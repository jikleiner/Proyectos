package controlador;

import documento.Documento;
import documento.DocumentoAudio;

public class ControladorAudio extends ControladorDocumento{

	@Override
	protected Documento crearDocumento() {
		// TODO Auto-generated method stub
		return new DocumentoAudio();
	}

	
}
