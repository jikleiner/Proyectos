package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLiteDAO {
	// cambiar URL segun el destino donde se guarde la carpeta de proyecto
	static String url = "jdbc:sqlite:PDP.db";
	static Connection connection = null;
	
	private SQLiteDAO() {
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection(url);
				if (connection != null) {
					JOptionPane.showMessageDialog(null, "Conexion BD OK");
				}
			}
			catch (ClassNotFoundException|SQLException e){
				System.out.println(e);
			}
		}
		return connection;
	}
	
	public static void desconectar() {
		try {
			connection.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		connection = null;
	}
}