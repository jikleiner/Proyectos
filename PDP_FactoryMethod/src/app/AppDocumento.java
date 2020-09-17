package app;

import controlador.*;


public class AppDocumento {

	public static void main (String args[]){
		
		ControladorDocumento controlador =null;
		
		controlador=new ControladorAudio();
		controlador.nuevoDocumento();
		
		controlador.guardarDocumento();
		
	}
	
}
