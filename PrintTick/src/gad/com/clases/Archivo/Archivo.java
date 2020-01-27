package gad.com.clases.Archivo; //Paquete de la class Archivo

//Importo todas mis librerias

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import gad.com.clases.log.ActivityLog;
import gad.com.clases.ticket.Ticket;


/**
 * Desarrollado por
 * Edison Martinez Frias
 * 16-06-2016
 * @author Dell-AMD
 *
 */

/*
 *   En esta clase se crea el archivo .txt el cual luego se imprime mediante
 *   el metodo llamado imprimirArchivo()
 *   
 *   El archivo esta elaborado en un idioma de comando IPL.
 * 
 * 
 */

public class Archivo //Inicio de la class Archivo
{
	ActivityLog aL = new ActivityLog();//Para invocar la funcionar para crear el archivo de log

	public void crearArchivo(Ticket t)//Metodo para crear el archivo se le pasa como argumento un objeto de la clase ticket.
	{
		FileWriter fichero = null;
		PrintWriter pw = null;
		String file = "TikcetHD.txt";// Nombre del archivo
		try
		{
			fichero = new FileWriter("C:\\ticketHD\\"+file);//Se le pasa la ruta y el nombre del archivo.
			pw = new PrintWriter(fichero);
			pw.println("<STX><ESC>P<ETX><STX>F*<ETX>");
			pw.println("<STX>H1;f3;o529,33;c26;b0;h58;w67;d3,GAD<ETX>");
			pw.println("<STX>H2;f3;o550,869;c26;b0;h28;w20;d3,Fecha:<ETX>");
			pw.println("<STX>H3;f3;o534,1026;c26;b0;h20;w23;d3,"+ t.getFecha() +"<ETX>");// Variable Fecha
			pw.println("<STX>H4;f3;o366,74;c26;b0;h31;w26;d3,"+ t.getNombreCliente() +"<ETX>"); //Variable cliente
			pw.println("<STX>H5;f3;o236,91;c26;b0;h44;w29;d3,Serial<ETX>");
			pw.println("<STX>H6;f3;o267,623;c26;b0;h28;w20;d3,Prioridad:<ETX>");
			pw.println("<STX>H7;f3;o268,967;c26;b0;h28;w28;d3," + t.getEstatusEquipo() +"<ETX>");// Variable estatus   
			pw.println("<STX>H8;f3;o179,623;c26;b0;h28;w22;d3,Modelo:<ETX>");      
			pw.println("<STX>H9;f3;o179,929;c26;b0;h28;w23;d3,"+ t.getModeloEquipo() + "<ETX>");//Variable modelo           
			pw.println("<STX>L10;f1;o481,1373;l524;w6<ETX>");    
			pw.println("<STX>L11;f1;o270,1368;l1368;w6<ETX>");
			pw.println("<STX>B12;f3;o468,1080;c17,200,0;w6;h7;d3,"+ t.getIdTicket() + "<ETX>"); // Variable valor codigo de barra id ticket  
			pw.println("<STX>H13;f3;o360,789;c26;b0;h28;w29;d3,"+ t.getIdTicket() + "<ETX>"); // variable id de ticket   
			pw.println("<STX>B14;f3;o242,360;c17,200,0;w7;h7;d3,"+ t.getSerialEquipo() + "<ETX>");//variable valor codigo de barra serial equipo
			pw.println("<STX>H15;f3;o100,74;c26;b0;h34;w23;d3,"+ t.getSerialEquipo() +"<ETX>");// variable serial equipo
			pw.println("<STX>D0<ETX>");   
			pw.println("<STX>R<ETX>");    
			pw.println("<STX><SI>l13<ETX>");
			pw.println("<STX><ESC>E*,1<CAN><ETX>");
			pw.println("<STX><RS>1<US>1<ETB><ETX>");
			pw.flush();
			pw.close();
		}
		catch(Exception e)  
		{
			aL.crearArchivoLog(e.toString());//Se invoca el metodo para crear el archivo en caso de que se genere una excepción
		}

	} 

	public void imprimirArchivo() throws PrintException, IOException //Metodo para imprimir el archivo
	{
		DocPrintJob job = null;//Creo un objeto de la clase DocPrintJob para poder utilizar la funcion llamada createPrintJob
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);//Busco los servicios de impresion disponible en la computadora(usuario)
		PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();//Busco la impresora por default que este en los servicios de impresion.
		HashPrintRequestAttributeSet attrib1 = new HashPrintRequestAttributeSet();//Creo los atributos para la impresión.
		attrib1.remove(new Copies(1));//Remuevo los atributos de impresión por si salen mas de dos impresiones para un solo ticket.
		PrintService selectedPrintService = ServiceUI.printDialog(null, 150, 150, printServices, defaultPrintService, DocFlavor.INPUT_STREAM.AUTOSENSE, attrib1);
		//Con el PrintService se crea la ventana grafica para buscar los servicios de impresion(Impresoras) disponibles en la computadora(usuario).
		try
		{
			job = selectedPrintService.createPrintJob();//Creo el trabajo de  impresion

		}catch(NullPointerException e) {}

		FileInputStream fS = null;//Invoco esta clase para buscar la ruta donde esta mi archivo a imprimir
		try 
		{
			fS = new FileInputStream("C:\\ticketHD\\TikcetHD.txt"); //Ruta donde esta el  archivo txt a imprimir
		} catch (FileNotFoundException e){ }


		Doc doc = new SimpleDoc(fS,DocFlavor.INPUT_STREAM.AUTOSENSE, null);//Especifica en que formato se encuentra el txt que se va a imprimir

		try {
			if(job != null)
			{
				job.print(doc, null);//Utilizo mi objeto llamado job para invocar el metodo .print() el cual genera la impresion del .txt
			}

		} catch (PrintException e) {
		}

	}//Fin dle metodo imprimirArchivo

}// Fin de la class Archivo
