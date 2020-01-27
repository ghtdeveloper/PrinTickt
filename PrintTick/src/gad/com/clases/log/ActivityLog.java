package gad.com.clases.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//Importo mis librerias


/**
 * Desarrollado por
 * Edison Martinez Frias
 * 16-06-2016
 *  @author Dell-AMD
 * 
 */

/*
 * 
 * Classe definida para capturar las excepciones capturadas por el sistema.
 */

public class ActivityLog  ///Defino el nombre de mi class
{
	private String rutaArchivo = "C:\\Log PrintDesk\\logInfo.log";//Defino la ruta del archivo a crear

	public void crearArchivoLog(String message)//Metodo para crear el archivo log recibe como parametro una variable tipo String.
	{
		Logger log = Logger.getLogger(rutaArchivo);//Creo una instancia  para la clase Logger y le indico en que ruta esta el archivo.
		FileHandler fh;//Defino el la cabecera para el log
		try
		{
			fh = new FileHandler(rutaArchivo,true);//Indico en que ruta esta el archivo y le especifico que creee un archivo nuevo para cada log generado
			log.addHandler(fh);//Agrego las informaciones del log al archivo.
			SimpleFormatter form = new SimpleFormatter();//Especifico el formato para el log
			fh.setFormatter(form);//Agrego el formato	
			log.log(Level.SEVERE,message);//Identifico el tipo de nivel del log

		} catch(SecurityException | IOException e) { e.printStackTrace();}

	}//Fin del metodo crearArchivo

}//Fin de la class ActivityLog
