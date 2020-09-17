package model_app;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasBD {
	
	private static String registro = "INSERT INTO login (id, password) VALUES (?, ?)";
	private static String busqueda = "SELECT id FROM login WHERE id IN (?)";
	

	public static  void  registrarUsuario(String  ID,  String  pass) {
		try {
			PreparedStatement sentenciaSQL = ConexionBD.getConnection().prepareStatement(registro);
			sentenciaSQL.setString(1, ID);
			sentenciaSQL.setString(2, pass);
			int i = sentenciaSQL.executeUpdate();
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "Usuario creado con exito");
			}else{
				JOptionPane.showMessageDialog(null, "Error al registrar usuario");
			}
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	public static  boolean  buscarUsuario(String  ID, String pass) {
		boolean msgResult = false;
		try {
			PreparedStatement sentenciaSQL = ConexionBD.getConnection().prepareStatement(busqueda);
			boolean result = sentenciaSQL.execute(ID);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Bienvenido "+ID);
				msgResult = true;
			}else{
				JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
				msgResult = false;
			}
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return msgResult;
	}
}
