package vista;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controler.ControladorProductoPorCantidad;
import model_app.ListaCompra;
import model_domain.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AñadirProducto extends JInternalFrame {
	private JTextField textFieldNomProd;
	private JTextField textFieldPrecio;
	private JLabel lblPrecio;
	private JButton btnAadir;
	private JButton btnCancel;
	private JLabel lblNombreProducto;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidad;
	private JTextArea textAreaPrecioTotal;
	private JLabel lblPrecioTotal;
	private AñadirProducto addP;
	
	/**
	 * Create the frame.
	 */
	public AñadirProducto(ListaCompra lista) {
		setBounds(100, 100, 450, 227);
		getContentPane().setLayout(null);
		
		btnAadir = new JButton("A\u00F1adir");
		btnCancel = new JButton("Cancelar");
		lblPrecio = new JLabel("Precio");
		textFieldNomProd = new JTextField();
		textFieldPrecio = new JTextField();
		lblNombreProducto = new JLabel("Nombre Producto");
		lblCantidad = new JLabel("Cantidad");
		SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1);
		spinnerCantidad = new JSpinner(sm);
		textAreaPrecioTotal = new JTextArea();
		lblPrecioTotal = new JLabel("Precio Total");
		
		addP = this;
		
		btnAadir.setBounds(264, 150, 77, 23);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.agregar(addProduct());
				App.actualizarTabla();
				addP.dispose();
			}
		});
		btnCancel.setBounds(347, 150, 77, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addP.dispose();
			}
		});
		lblPrecio.setBounds(28, 62, 47, 14);
		textFieldNomProd.setBounds(125, 8, 274, 20);
		textFieldNomProd.setColumns(10);
		textFieldPrecio.setBounds(125, 58, 195, 20);
		textFieldPrecio.setColumns(10);
		lblNombreProducto.setBounds(29, 11, 86, 14);
		lblCantidad.setBounds(29, 123, 46, 14);
		spinnerCantidad.setBounds(125, 120, 46, 20);
		textAreaPrecioTotal.setBounds(125, 151, 110, 20);
		lblPrecioTotal.setBounds(29, 156, 86, 14);
		
		
		getContentPane().add(btnAadir);
		getContentPane().add(btnCancel);
		getContentPane().add(lblPrecio);
		getContentPane().add(textFieldNomProd);
		getContentPane().add(textFieldPrecio);
		getContentPane().add(lblNombreProducto);
		getContentPane().add(lblCantidad);
		getContentPane().add(spinnerCantidad);
		getContentPane().add(textAreaPrecioTotal);
		getContentPane().add(lblPrecioTotal);
	}
	
	
	//verificar como se cargan los datos
	public Producto addProduct(){
		String nom=textFieldNomProd.getText();
		int preTotal=Integer.parseInt(textAreaPrecioTotal.getText());
		int can=(Integer) spinnerCantidad.getValue();
		int preUni=Integer.parseInt(textFieldPrecio.getText());
		
		ControladorProductoPorCantidad ctrl = new ControladorProductoPorCantidad();
		ctrl.crearProducto();
		((ControladorProductoPorCantidad) ctrl).setearProductoPorCantidad(nom, preTotal, can, preUni);
		return ctrl.getProducto();
	}
}
