package test;

import conexion.Conexion;

public class Cliente {

	public static void main(String[] args) { 
		Conexion c1 = new Conexion();
		c1.enviarMensaje("Hola");
		c1.enviarMensaje("Patrones de dise�o");
		c1.enviarMensaje("Java");
		
		Conexion c2 = new Conexion();
		c2.enviarMensaje("Paradigmas de programaci�n");
		
		Conexion c3 = new Conexion();
		c3.enviarMensaje("Patr�n Singleton");
	}
	
}
