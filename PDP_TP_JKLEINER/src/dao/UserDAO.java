package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import dto.UserDTO;

public class UserDAO {
	
	private static String registro = "INSERT INTO login (id, password) VALUES (?, ?)";
	private static String busqueda = "SELECT * FROM login WHERE id = (?)";
	

	public static  boolean  registrarUsuario(String  ID,  String  pass) {
		boolean msgResult = false;
		try {
			PreparedStatement sentenciaSQL = SQLiteDAO.getConnection().prepareStatement(registro);
			sentenciaSQL.setString(1, ID);
			sentenciaSQL.setString(2, pass);
			int i = sentenciaSQL.executeUpdate();
			if (i == 1) {
				msgResult = true;
			}else{
				msgResult = false;
			}
			SQLiteDAO.desconectar();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return msgResult;
	}
	
	public static  UserDTO  buscarUsuario(String  ID, String pass) {
		UserDTO DTO= new UserDTO();
		try {
			PreparedStatement sentenciaSQL = SQLiteDAO.getConnection().prepareStatement(busqueda);
			sentenciaSQL.setString(1, ID);
			ResultSet rs = sentenciaSQL.executeQuery();
			if (!rs.isClosed()){
				DTO.setNombre(rs.getString(1));
				DTO.setPass(rs.getString(2));
			}
			SQLiteDAO.desconectar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return DTO;
	}
}
