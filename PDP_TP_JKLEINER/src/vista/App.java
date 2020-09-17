package vista;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model_app.Descuento;
import model_app.ListaCompra;
import model_domain.Producto;
import model_domain.ProductoPorCantidad;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class App extends JInternalFrame {
	private JTable table;
	private JButton btnAñadirProd;
	private JButton btnDescuento;
	private JButton btnFinCompra;
	private static JLabel lblImporteTotal;
	private JLabel lblDescuento;
	private AñadirProducto addProd;
	private static ListaCompra lista;
	private JTextField txtFldDesc;
	private String[] columnNames= {"Producto",
			"Precio Unidad",
			"Cantidad",
			"Precio Total"};
	private static DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private static App ventana;
	
	/**
	 * Create the frame.
	 */
	public App() {
		lista = new ListaCompra();
		setBounds(10, 10, 725, 508);
		getContentPane().setLayout(null);
		//crea todos los componentes
		modelo = new DefaultTableModel ();
		btnAñadirProd = new JButton("A\u00F1adir Producto");
		btnDescuento = new JButton("Cargar Descuento");
		btnFinCompra = new JButton("Finalizar Compra");
		lblImporteTotal = new JLabel("$");
		txtFldDesc = new JTextField();
		lblImporteTotal.setBackground(Color.WHITE);
		lblDescuento = new JLabel("Descuento");
		//JTable
		modelo.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(modelo);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(239, 40, 436, 384);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);		

		table.setVisible(true);
		
		ventana = this;
		//modelo.newDataAvailable(null);
		
		addProd = new AñadirProducto(lista);
		//configura los componentes
		lblDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(12, 302, 171, 25);
		btnAñadirProd.setBounds(12, 13, 171, 64);
		btnDescuento.setBounds(13, 81, 171, 64);
		txtFldDesc.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtFldDesc.setBounds(12, 338, 171, 57);
		btnFinCompra.setBounds(8, 406, 171, 64);
		txtFldDesc.setColumns(10);
		addProd.setLocation(78, 40);
		lblImporteTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblImporteTotal.setBounds(18, 231, 171, 65);
		//configura los action de los JButton
		btnAñadirProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirProducto();
			}
		});
		btnDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDescuento();
			}
		});
		btnFinCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarCompra();
				System.exit(0);
			}
		});
		//agrega los componentes al contenedor
		getContentPane().add(btnAñadirProd);
		getContentPane().add(btnDescuento);
		getContentPane().add(btnFinCompra);
		getContentPane().add(lblImporteTotal);
		getContentPane().add(txtFldDesc);
		getContentPane().add(lblDescuento);
		getContentPane().add(addProd);
		
	}
	
	public static void actualizarTabla(){
		int rowCount= modelo.getRowCount();
		int total = 0;
		String[] arregloLista = new String[4];
		for (int i = rowCount - 1; i >= 0; i--) {
		    modelo.removeRow(i);
		}
		for(Producto prod : lista.getLista()){
			arregloLista[0]=prod.getNombre();
			arregloLista[1]=Integer.toString(prod.getPrecio());
			arregloLista[2]=Integer.toString(((ProductoPorCantidad) prod).getCantidad());
			arregloLista[3]=Integer.toString(((ProductoPorCantidad) prod).getPrecioPorUnidad());
			modelo.addRow(arregloLista);
			total=total+prod.getPrecio();
		}
		lblImporteTotal.setText("$"+Integer.toString(total));
	}
	
	
	public void añadirProducto (){
		addProd.setVisible(true);
		addProd.moveToFront();
	}
	
	public void cargarDescuento (){
		//validar datos para evitar excepciones
		if(txtFldDesc.getText()!=null){
			int desc = Integer.parseInt(txtFldDesc.getText());
			Descuento des = new Descuento(desc);
			lista.setDescuento(des);
			JOptionPane.showMessageDialog(null, "Descuento cargado con exito!");
		}else{
			JOptionPane.showMessageDialog(null, "Importe invalido o nulo!");
		}
	}
	
	public void finalizarCompra (){
		JOptionPane.showMessageDialog(null, "COMPRA FINALIZADA, IMPORTE TOTAL: $"+lblImporteTotal.getText());
	}
	
}
