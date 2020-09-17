package controlador;

import documento.Documento;
import documento.DocumentoTexto;

public class ControladorTexto extends ControladorDocumento{

	@Override
	protected Documento crearDocumento() {
		// TODO Auto-generated method stub
		return new DocumentoTexto();
	}

}
