package controlador;

import documento.Documento;
import documento.DocumentoImagen;

public class ControladorImagen extends ControladorDocumento {

    public Documento crearDocumento() {
        return new DocumentoImagen();
    }
    
    

}
