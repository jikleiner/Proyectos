package test;

import conexion.Conexion;

public class Test {

	public static void main(String args[]) {
		Conexion conexion = new Conexion();
		
		conexion.abrir(); 		// Abriendo conexi�n
		conexion.cerrar(); 		// Cerrando conexi�n
		conexion.abrir(); 		// Abriendo conexi�n
		conexion.suspender();	// Suspendiendo conexi�n
		conexion.reanudar(); 	// Reanudando conexi�n
		conexion.reanudar(); 	// Intentando volver a reanudar conexi�n
		conexion.suspender(); 	// Supendiendo conexi�n
		conexion.abrir(); 		// Abriendo conexi�n
		conexion.cerrar(); 		// Cerrando conexi�n
	}
	
}
