package controlador;

import documento.Documento;
import documento.DocumentoTexto;

public class ControladorTexto extends ControladorDocumento {

	public Documento crearDocumento() {
		return new DocumentoTexto();
	}

}
