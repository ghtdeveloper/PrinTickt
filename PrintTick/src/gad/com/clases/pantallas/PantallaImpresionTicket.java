package gad.com.clases.pantallas;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import gad.com.clases.Archivo.Archivo;
import gad.com.clases.controller.ControllerWeb;
import gad.com.clases.log.ActivityLog;
import gad.com.clases.ticket.Ticket;
import java.awt.Color;
import javax.swing.JButton;
import javax.print.PrintException;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import org.json.JSONException;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

/*


 * Desarrollado por
 * Edison Martinez Frias
 * 16-06-20169
 * @author Dell-AMD
 * 
 */


/*
 * Esta clase esta definida para controlar los
 * estados de los objetos de las vistas.
 */


public class PantallaImpresionTicket
{

	private JFrame frPrincipal;
	static JTextField txtCliente;
	static JTextField txtSerial;
	static JTextField txtTicket;
	static JTextField txtModelo;
	static JTextField txtFecha;
	static  JTextField txtPrioridad;
	ActivityLog aL = new ActivityLog();

	public PantallaImpresionTicket() {
		initialize();
		
	} //Fin del constructor de la class

	private void initialize() {  //Se inicializa todos los controles
		frPrincipal = new JFrame();
		frPrincipal.getContentPane().setForeground(SystemColor.desktop);
		frPrincipal.setResizable(false);
		frPrincipal.getContentPane().setBackground(SystemColor.desktop);
		frPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaImpresionTicket.class.getResource("/Recursos/logoCloud.png")));
		frPrincipal.setTitle("Impresion Ticket");
		frPrincipal.setBounds(100, 100, 908, 310);
		frPrincipal.setLocationRelativeTo(null);
		frPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frPrincipal.getContentPane().setLayout(null);
		final Archivo Arc = new Archivo();

		JLabel lblCLiente = new JLabel("Cliente");
		lblCLiente.setForeground(new Color(255, 255, 255));
		lblCLiente.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblCLiente.setBounds(10, 105, 90, 43);
		frPrincipal.getContentPane().add(lblCLiente);

		JLabel lblSerial = new JLabel("Serial");
		lblSerial.setForeground(new Color(255, 255, 255));
		lblSerial.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblSerial.setBounds(10, 182, 100, 30);
		frPrincipal.getContentPane().add(lblSerial);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(new Color(255, 255, 255));
		lblModelo.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblModelo.setBounds(315, 115, 89, 30);
		frPrincipal.getContentPane().add(lblModelo);

		txtCliente = new JTextField();
		txtCliente.setBackground(Color.DARK_GRAY);
		txtCliente.setForeground(new Color(0, 191, 255));
		txtCliente.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 18));
		txtCliente.setEditable(false);
		txtCliente.setBounds(105, 115, 200, 30);
		frPrincipal.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);

		txtSerial = new JTextField();
		txtSerial.setBackground(Color.DARK_GRAY);
		txtSerial.setForeground(new Color(0, 191, 255));
		txtSerial.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		txtSerial.setEditable(false);
		txtSerial.setColumns(10);
		txtSerial.setBounds(105, 182, 200, 30);
		frPrincipal.getContentPane().add(txtSerial);

		txtModelo = new JTextField();
		txtModelo.setBackground(Color.DARK_GRAY);
		txtModelo.setForeground(new Color(0, 191, 255));
		txtModelo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		txtModelo.setEditable(false);
		txtModelo.setColumns(10);
		txtModelo.setBounds(414, 115, 186, 31);
		frPrincipal.getContentPane().add(txtModelo);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblFecha.setBounds(315, 182, 89, 30);
		frPrincipal.getContentPane().add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBackground(Color.DARK_GRAY);
		txtFecha.setForeground(new Color(0, 191, 255));
		txtFecha.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		txtFecha.setEditable(false);
		txtFecha.setBounds(414, 186, 186, 30);
		frPrincipal.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setForeground(new Color(255, 255, 255));
		lblPrioridad.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblPrioridad.setBounds(610, 118, 110, 24);
		frPrincipal.getContentPane().add(lblPrioridad);

		txtPrioridad = new JTextField();
		txtPrioridad.setBackground(Color.DARK_GRAY);
		txtPrioridad.setForeground(new Color(0, 191, 255));
		txtPrioridad.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		txtPrioridad.setEditable(false);
		txtPrioridad.setBounds(730, 115, 165, 30);
		frPrincipal.getContentPane().add(txtPrioridad);
		txtPrioridad.setColumns(10);

		JPanel PanelSuperior = new JPanel();
		PanelSuperior.setForeground(SystemColor.desktop);
		PanelSuperior.setBackground(SystemColor.desktop);
		PanelSuperior.setBounds(0, 0, 903, 65);
		frPrincipal.getContentPane().add(PanelSuperior);
		PanelSuperior.setLayout(null);

		JLabel lblIdTicket = new JLabel("ID Ticket");
		lblIdTicket.setBounds(10, 5, 184, 61);
		PanelSuperior.add(lblIdTicket);
		lblIdTicket.setIcon(new ImageIcon(PantallaImpresionTicket.class.getResource("/Recursos/ticket_64.png")));
		lblIdTicket.setForeground(new Color(255, 255, 255));
		lblIdTicket.setFont(new Font("Trebuchet MS", Font.BOLD, 23));

		txtTicket = new JTextField();
		txtTicket.setBackground(Color.DARK_GRAY);
		txtTicket.setBounds(204, 26, 150, 30);
		PanelSuperior.add(txtTicket);
		txtTicket.setBorder(new LineBorder(new Color(0, 191, 255), 2));
		txtTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //En este metodo se busca los datos del ticket 

				if(txtTicket.getText().isEmpty())//Se verifica que el ticekt no esta vacio
				{
					JOptionPane.showMessageDialog(txtTicket, "El id de ticket  no puede estar vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

				else {

					String idTicket = txtTicket.getText();//Variable para obtener el id del ticket
					int idTicketH = Integer.parseInt(idTicket);//Se convierte de tipo int a Stirng
					try {
						ControllerWeb cW = new ControllerWeb(idTicketH);//Se crea una instancia para la classe ControllerWeb
						PantallaImpresionTicket.txtCliente.setText(cW.getNombreClienteJSon());//Se obtiene el nombre del cliente 
						PantallaImpresionTicket.txtSerial.setText(cW.getSerialEquiposJSon());//Se obtiene el nombre del serial del equipo 
						PantallaImpresionTicket.txtModelo.setText(cW.getModeloEquipoJSon());//Se obtiene el modelo del equipo. 
						PantallaImpresionTicket.txtFecha.setText(cW.getFechaTicketJSon());//Se obtiene la fecha de creación del ticket.
						PantallaImpresionTicket.txtPrioridad.setText(cW.getPrioridadEquipoJSon());//Se obtiene la prioridad del ticket.
						PantallaImpresionTicket.txtTicket.setText(txtTicket.getText());//Se obtiene el id del ticket.

					} catch (IOException | JSONException c) { aL.crearArchivoLog(c.toString());//Se crea un log si se genera algun error.
					// TODO Auto-generated catch block
					c.printStackTrace();
					}
				}
			}
		});
		txtTicket.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { //Se verifica que el campo del id de ticket no contengan letras.
				char c = e.getKeyChar();
				if(Character.isLetter(c))
				{
					e.consume();
					JOptionPane.showMessageDialog(txtTicket, "El campo ID Ticket no puede contener letras o simbolos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		txtTicket.setForeground(new Color(255, 255, 0));
		txtTicket.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		txtTicket.setColumns(10);

		JButton btnSearchTicket = new JButton("Buscar");
		btnSearchTicket.setBackground(new Color(0, 191, 255));
		btnSearchTicket.setForeground(new Color(255, 255, 255));
		btnSearchTicket.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnSearchTicket.setBounds(361, 22, 86, 36);
		PanelSuperior.add(btnSearchTicket);
		btnSearchTicket.setBorder(null);
		btnSearchTicket.setBorderPainted(false);

		btnSearchTicket.setToolTipText("Buscar ticket");
		btnSearchTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //Para el ingreso manual de los tickets en caso de que el api web falle

				if(txtTicket.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(txtTicket, "El id de ticket  no puede estar vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

				else {

					String idTicket = txtTicket.getText();
					int idTicketH = Integer.parseInt(idTicket);
					try {
						ControllerWeb cW = new ControllerWeb(idTicketH);
						PantallaImpresionTicket.txtCliente.setText(cW.getNombreClienteJSon());
						PantallaImpresionTicket.txtSerial.setText(cW.getSerialEquiposJSon());
						PantallaImpresionTicket.txtModelo.setText(cW.getModeloEquipoJSon());
						PantallaImpresionTicket.txtFecha.setText(cW.getFechaTicketJSon());
						PantallaImpresionTicket.txtPrioridad.setText(cW.getPrioridadEquipoJSon());
						PantallaImpresionTicket.txtTicket.setText(txtTicket.getText());

					} catch (IOException | JSONException e) { aL.crearArchivoLog(e.toString());
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}
			}
		});
		btnSearchTicket.setIcon(null);

		final JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setBounds(449, 22, 86, 36);
		PanelSuperior.add(btnImprimir);
		btnImprimir.setBorder(null);
		btnImprimir.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Arc.crearArchivo(new Ticket(txtCliente.getText(),txtSerial.getText(),txtFecha.getText(),txtTicket.getText(),txtModelo.getText(),txtPrioridad.getText()));
				//Se crea el archivo con los valores de los text box.
				try {

					try {
						Arc.imprimirArchivo();// Se imprime el archivo.
					} catch (PrintException e) {aL.crearArchivoLog(e.toString());}
				}  

				catch (HeadlessException e) {aL.crearArchivoLog(e.toString());


				} catch (FileNotFoundException e) { aL.crearArchivoLog(e.toString());


				} catch (IOException e) { aL.crearArchivoLog(e.toString());

				}

			} 
		});
		btnImprimir.setBackground(new Color(105, 105, 105));
		btnImprimir.setToolTipText("Imprimir Ticket");
		btnImprimir.setIcon(null);

		JButton btnLimpiarCampos = new JButton("Limpiar");
		btnLimpiarCampos.setForeground(new Color(255, 255, 255));
		btnLimpiarCampos.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLimpiarCampos.setBounds(536, 22, 86, 36);
		PanelSuperior.add(btnLimpiarCampos);
		btnLimpiarCampos.setBorder(null);
		btnLimpiarCampos.setBackground(new Color(105, 105, 105));
		btnLimpiarCampos.setToolTipText("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Metodo para limpiar los textBox
				txtTicket.setText("");
				txtCliente.setText("");
				txtSerial.setText("");
				txtModelo.setText("");
				txtFecha.setText("");
				txtPrioridad.setText("");
			}
		});
		btnLimpiarCampos.setIcon(null);

		JLabel lblHabilitarEntrada = new JLabel("Entrada manual");
		lblHabilitarEntrada.setForeground(new Color(255, 255, 255));
		lblHabilitarEntrada.setBounds(632, 27, 118, 25);
		PanelSuperior.add(lblHabilitarEntrada);
		lblHabilitarEntrada.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));

		JRadioButton rdbActivar = new JRadioButton("Activar"); // Si esta activado
		rdbActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( rdbActivar.isSelected())
				{
					btnSearchTicket.setEnabled(false);
					
					txtTicket.setBackground(Color.WHITE);
					txtTicket.setForeground(Color.BLACK);
				
					txtCliente.setBackground(Color.WHITE);
					txtCliente.setEditable(true);
					txtCliente.setForeground(Color.BLACK);
					
					txtSerial.setBackground(Color.WHITE);
					txtSerial.setEditable(true);
					txtSerial.setForeground(Color.BLACK);
					
					txtModelo.setBackground(Color.WHITE);
					txtModelo.setEditable(true);
					txtModelo.setForeground(Color.black);
					
					txtFecha.setBackground(Color.WHITE);
					txtFecha.setEditable(true);
					txtFecha.setForeground(Color.BLACK);
					
					txtPrioridad.setBackground(Color.WHITE);
					txtPrioridad.setEditable(true);
					txtPrioridad.setForeground(Color.BLACK);
				}
				
			}
		});
		rdbActivar.setBackground(new Color(105, 105, 105));
		rdbActivar.setForeground(new Color(255, 255, 255));
		rdbActivar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		rdbActivar.setBounds(745, 11, 122, 25);
		PanelSuperior.add(rdbActivar);

		JRadioButton rdbDesactivar = new JRadioButton("Desactivar"); // Si esta desactivado
		rdbDesactivar.setSelected(true);
		rdbDesactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbDesactivar.isSelected())
				{
					btnSearchTicket.setEnabled(true);
					txtTicket.setBackground(Color.DARK_GRAY);
					txtTicket.setForeground(new Color(255, 255, 0));
					
					txtCliente.setBackground(Color.DARK_GRAY);
					txtCliente.setForeground(new Color(0, 191, 255));
					txtCliente.setEditable(false);
					
					txtSerial.setBackground(Color.DARK_GRAY);
					txtSerial.setForeground(new Color(0, 191, 255));
					txtSerial.setEditable(false);
					
					txtModelo.setBackground(Color.DARK_GRAY);
					txtModelo.setForeground(new Color(0, 191, 255));
					txtModelo.setEditable(false);
					
					txtFecha.setBackground(Color.DARK_GRAY);
					txtFecha.setForeground(new Color(0, 191, 255));
					txtFecha.setEditable(false);
					
					txtPrioridad.setBackground(Color.DARK_GRAY);
					txtPrioridad.setForeground(new Color(0, 191, 255));
					txtPrioridad.setEditable(false);
				}
			}
		});
		rdbDesactivar.setBackground(new Color(105, 105, 105));
		rdbDesactivar.setForeground(new Color(0, 191, 255));
		rdbDesactivar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		rdbDesactivar.setBounds(745, 39, 122, 25);
		PanelSuperior.add(rdbDesactivar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 76, 903, 18);
		frPrincipal.getContentPane().add(separator);
		separator.setForeground(new Color(255, 255, 255));

		JLabel lblConectedTo = new JLabel("Conected to:");
		lblConectedTo.setForeground(Color.WHITE);
		lblConectedTo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblConectedTo.setBounds(0, 244, 110, 31);
		frPrincipal.getContentPane().add(lblConectedTo);

		JLabel lblGadintermecjitbitcom = new JLabel("xxxxxxx.jitbit.com");
		lblGadintermecjitbitcom.setForeground(new Color(0, 191, 255));
		lblGadintermecjitbitcom.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblGadintermecjitbitcom.setBounds(117, 244, 198, 30);
		frPrincipal.getContentPane().add(lblGadintermecjitbitcom);

		JLabel lblPoweredBy = new JLabel("Powered by");
		lblPoweredBy.setForeground(Color.WHITE);
		lblPoweredBy.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblPoweredBy.setBounds(743, 244, 110, 31);
		frPrincipal.getContentPane().add(lblPoweredBy);

		JLabel lblGa = new JLabel("xxx");
		lblGa.setForeground(new Color(255, 255, 255));
		lblGa.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		lblGa.setBounds(846, 244, 31, 30);
		frPrincipal.getContentPane().add(lblGa);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(0, 227, 903, 18);
		frPrincipal.getContentPane().add(separator_1);
	}

	public void getFrame()
	{
		frPrincipal.setVisible(true);
	}
}
