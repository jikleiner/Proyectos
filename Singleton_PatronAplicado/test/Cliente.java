package test;

import conexion.Conexion;

public class Cliente {

	public static void main(String[] args) {
//		Conexion c1 = new Conexion();
		Conexion c1 = Conexion.getInstanciaUnica();
		c1.enviarMensaje("Hola");
		c1.enviarMensaje("Patrones de dise�o");
		c1.enviarMensaje("Java");
		
//		Conexion c2 = new Conexion();
		Conexion c2 = Conexion.getInstanciaUnica();
		c2.enviarMensaje("Paradigmas de programaci�n");
		
//		Conexion c3 = new Conexion();
		Conexion c3 = Conexion.getInstanciaUnica();
		c3.enviarMensaje("Patr�n Singleton");
	}
	
}
