package controlador;

import documento.Documento;

public abstract class ControladorDocumento {

    private Documento documento = null;

    public void nuevoDocumento() {
        System.out.println("Nuevo documento");
        documento = crearDocumento();
        documento.abrir();
    }

    public void guardarDocumento() {
        System.out.println("Guardar documento");
        documento.guardar();
    }

    protected abstract Documento crearDocumento();

}
