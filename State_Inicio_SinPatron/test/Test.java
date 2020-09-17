package test;

import conexion.Conexion;

public class Test {

	public static void main(String args[]) {
		Conexion conexion = new Conexion();
		
		conexion.abrir(); 		// Abriendo conexión
		conexion.cerrar(); 		// Cerrando conexión
		conexion.abrir(); 		// Abriendo conexión
		conexion.suspender();	// Suspendiendo conexión
		conexion.reanudar(); 	// Reanudando conexión
		conexion.reanudar(); 	// Intentando volver a reanudar conexión
		conexion.suspender(); 	// Supendiendo conexión
		conexion.abrir(); 		// Abriendo conexión
		conexion.cerrar(); 		// Cerrando conexión
	}
	
}
