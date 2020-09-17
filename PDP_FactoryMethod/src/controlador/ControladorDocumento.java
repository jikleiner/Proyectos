package controlador;

import documento.Documento;

public abstract class ControladorDocumento {

	private Documento documento = null;
	
	public void nuevoDocumento(){
		System.out.println("nuevo documento");
		documento = crearDocumento();
		documento.abrir();
	}
	
	public void guardarDocumento(){
		System.out.println("guardar documento");
		documento.guardar();
	}
	
	protected abstract Documento crearDocumento();
	
}
