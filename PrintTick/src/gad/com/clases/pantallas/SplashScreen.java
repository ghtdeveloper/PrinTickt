package gad.com.clases.pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import gad.com.clases.controller.ControllerWeb;
import gad.com.clases.log.ActivityLog;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.awt.Color;

/**
 * 
 * Desarrollado por
 * Edison Martinez Frias
 * 16-06-20169
 * @author Dell-AMD
 */


/*
 * Clase definida  para ejecutar el SplashScreen
 * y realizar la conexion con el WebService
 */

public class SplashScreen extends JFrame { //Defino la classe llamada splashScreen la cual hereda de la class JFrame caracteristicas para la creció de la GUI

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JProgressBar progressBar = new JProgressBar();
	static final int MY_MINIMUM = 0;
    static final int MY_MAXIMUM = 100;
    

	public static void main(String[] args) {//Main  de la aplicación
		ActivityLog aL = new ActivityLog();//Agregado el dia 05-06-2019
		SplashScreen frame = new SplashScreen();
		try {
		@SuppressWarnings("unused")
		ControllerWeb cW = new ControllerWeb();//Invoco el la classe del controller web
		} catch(Exception e)
		{
			aL.crearArchivoLog(e.toString());//Agregado el dia 05-06-2019
			e.printStackTrace();//Agregado el dia 05-06-2019
		}//Agregado el dia 05-06-2019
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
		      final int percent = i;
		      try {
		        SwingUtilities.invokeLater(new Runnable() { //Defino el timer para la barra de progreso 
		          public void run() {
		        	  SplashScreen.updateBar(percent);
		        	  
		          }
		        });
		        java.lang.Thread.sleep(40);//Modificado el dia 05-06-2019
		      } catch (InterruptedException e) {
		        ;
		      }
		    }
		if(SplashScreen.updateBar(MY_MAXIMUM) == 100)
		{
			frame.dispose();
			PantallaImpresionTicket pTicket = new PantallaImpresionTicket();//Invoca la pantalla  principal de la aplicación
			pTicket.getFrame();//Obtiene el GUI de la pantala principal
		}
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setResizable(false);
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		progressBar.setForeground(new Color(0, 191, 255));
		progressBar.setStringPainted(true);
		progressBar.setMinimum(MY_MINIMUM);
		progressBar.setMaximum(MY_MAXIMUM);

		progressBar.setBounds(0, 329, 539, 37);
		contentPane.add(progressBar);
	}

	 public static int updateBar(int newValue) {
		 progressBar.setValue(newValue);
		 return 100;
		  }

}
