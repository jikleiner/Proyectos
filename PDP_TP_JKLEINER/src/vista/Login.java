package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import dto.UserDTO;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Login extends JFrame{
	/*
	 * panel encargado del login de usuario
	 */
	private JPanel contentPane;
	private JTextField textFieldID;
	private JPasswordField passwordField;
	private JButton btnRegister;
	private JButton btnLogIn;
	private JButton btnCancel;
	private JLabel lblId;
	private JLabel lblPassword;
	private JLabel lblBien;
	private RegistroUser reg;
	private App ap;
	
	/**
	 * Launch the application.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//ventana de registro
		reg = new RegistroUser();
		contentPane.add(reg);
		//ventana de app
		ap = new App();
		contentPane.add(ap);
		//variable de referencia
		@SuppressWarnings("unused")
		Login log = this;
		
		//crea los botones y añade los listeners
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				reg.setVisible(true);
			}
		});
		//login
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(loginBd()!=false){
					JOptionPane.showMessageDialog(null, "Bienvenido");
					ap.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
				}
			}
		});		
		//configura los botones
		btnRegister.setBounds(167, 193, 89, 23);
		btnLogIn.setBounds(66, 193, 89, 23);
		btnCancel.setBounds(268, 193, 89, 23);
		//crea y configura los labels
		lblId = new JLabel("ID");
		lblId.setBounds(109, 61, 46, 14);
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(85, 118, 70, 14);
		lblBien = new JLabel("Bienvenido");
		lblBien.setBounds(189, 11, 86, 14);
		//crea los textField
		textFieldID = new JTextField();
		passwordField = new JPasswordField();
		//configura los field
		textFieldID.setBounds(189, 58, 86, 20);
		textFieldID.setColumns(10);
		passwordField.setBounds(189, 115, 86, 20);
		//añade los componentes al JPanel
		contentPane.add(btnCancel);
		contentPane.add(btnRegister);
		contentPane.add(btnLogIn);
		contentPane.add(lblId);
		contentPane.add(lblPassword);
		contentPane.add(lblBien);
		contentPane.add(textFieldID);
		contentPane.add(passwordField);
		//hace visible la ventana
		this.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public boolean loginBd(){
		boolean retorno = false;
		UserDTO user = UserDAO.buscarUsuario(textFieldID.getText(), passwordField.getText());
		if(user.getNombre().equals(textFieldID.getText())){
			if(user.getPass().equals(passwordField.getText())){
					retorno = true;
			}
		}else{
			retorno = false;
		}
		return retorno;
	}

}
