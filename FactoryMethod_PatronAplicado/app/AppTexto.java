package app;

import controlador.ControladorDocumento;
import controlador.ControladorTexto;

public class AppTexto {

    public static void main(String args[]) {
        ControladorDocumento controlador = null;

        controlador = new ControladorTexto();
        controlador.nuevoDocumento();

        controlador.guardarDocumento();
    }

}
