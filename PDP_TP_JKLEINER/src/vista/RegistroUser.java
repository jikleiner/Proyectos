package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.UserDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RegistroUser extends JInternalFrame{

	
	private JTextField textFieldUserId;
	private JPasswordField textFieldPass1;
	private JPasswordField textFieldPassConfirm;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JLabel lblRepetirContrasea;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	public RegistroUser() {
		setBounds(100, 100, 359, 265);
		getContentPane().setLayout(null);
		//inicializa las variables
		textFieldUserId = new JTextField();
		textFieldPass1 = new JPasswordField();
		textFieldPassConfirm = new JPasswordField();
		lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		btnConfirmar = new JButton("Confirmar");
		btnCancelar = new JButton("Cancelar");
		//variable que guarda referencia a este objeto
		RegistroUser ventana = this;
		//configura los componentes
		textFieldUserId.setBounds(181, 40, 104, 20);
		textFieldUserId.setColumns(10);
		textFieldPass1.setBounds(181, 71, 104, 20);
		textFieldPass1.setColumns(10);
		textFieldPassConfirm.setBounds(181, 102, 104, 20);
		textFieldPassConfirm.setColumns(10);
		lblNombreDeUsuario.setBounds(67, 43, 104, 14);
		lblContrasea.setBounds(67, 74, 86, 14);
		lblRepetirContrasea.setBounds(67, 105, 104, 14);
		btnConfirmar.setBounds(82, 179, 89, 23);
		btnCancelar.setBounds(200, 179, 89, 23);
		//añade los componentes
		getContentPane().add(textFieldUserId);		
		getContentPane().add(textFieldPass1);
		getContentPane().add(textFieldPassConfirm);
		getContentPane().add(lblNombreDeUsuario);
		getContentPane().add(lblContrasea);
		getContentPane().add(lblRepetirContrasea);		
		getContentPane().add(btnConfirmar);
		getContentPane().add(btnCancelar);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(userReg()==true){
					JOptionPane.showMessageDialog(null, "Usuario creado con exito");
					ventana.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Error al registrar usuario");
				}
				
			}
		});
		getContentPane().add(btnCancelar);		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ventana.dispose();
			}
		});

	}

	@SuppressWarnings("deprecation")
	public boolean userReg(){
		return UserDAO.registrarUsuario(textFieldUserId.getText(), textFieldPass1.getText());
	}
	

}
