package controlador;

import documento.Documento;
import documento.DocumentoImagen;

public class ControladorImagen extends ControladorDocumento{

	@Override
	protected Documento crearDocumento() {
		// TODO Auto-generated method stub
		return new DocumentoImagen();
	}

}
