package app;

import controlador.ControladorDocumento;
import controlador.ControladorImagen;

public class AppImagen {

    public static void main(String args[]) {
        ControladorDocumento controlador = null;

        controlador = new ControladorImagen();
        controlador.nuevoDocumento();

        controlador.guardarDocumento();
    }

}
