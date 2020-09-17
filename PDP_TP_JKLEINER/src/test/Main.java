package test;

import javax.swing.JOptionPane;

import dao.SQLiteDAO;
import vista.Login;

/*NOMBRE DE APP: Gastalo Justo
 * aplicacion breve que sirva para controlar los gastos realizados
 * a la hora de realizar compras, especialmente en supermercados. se basa en una lista de compras
 * dinamica en la cual se cargan objetos de tipo producto que poseen datos como marca y precio
 * 
 * 
 * se eligio la implementacion del patron de arquitectura MVC.
 * se usa tambien:
 * Factory Method: para la creacion de los objetos "producto".
 * DAO/DTO
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLiteDAO.getConnection();
		try {
			Login log = new Login();
			log.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			e.printStackTrace();
		}
	}
}
	
