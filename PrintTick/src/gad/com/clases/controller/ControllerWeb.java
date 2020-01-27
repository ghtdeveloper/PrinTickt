package gad.com.clases.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import gad.com.clases.log.ActivityLog;

//Importo todas mis librerias

/**
 * Desarrollado por
 * Edison Martinez Frias
 * 16-06-2016
 * @author Dell-AMD
 *
 */

/*
 * Esta clase esta definida para realizar todas las peticiones en
 * el WebService
 * Contiene los metodos para acceder a los arreglos Json y/o a los
 * objetos.
 */

public class ControllerWeb //Inicio de la ControllerWeb
{
	private String salida = null;
	private String salida2 = null;
	//Defino los nombres de mis variables.
	ActivityLog aL = new ActivityLog();//Creo una instancia para la class ActivityLog

	JSONObject job = new JSONObject();//Creo una instancia para la class JSONObject
	JSONArray array = new JSONArray();//Creo una instancia para la class JSONArray

	/*
	 * La class Controller es el corazón de la aplicación ya que en esta se 
	 * definen las api por las cuales se puede acceder a las informaciones
	 * del ticket del web service.
	 * 
	 * Se realiza una sobreescribe el constructor dos veces porque para poder
	 * realizar la consulta de las informaciones porque primero debo de verificar
	 * mis credenciales para proceder a realizar las consultas de las informaciones
	 * de los tickets.
	 * 
	 */
	
	
	public ControllerWeb() //Constructor definido para verificar mis credenciales en el web service.
	{
		try {
			URL url = new URL("https://gadintermec.jitbit.com/helpdesk/api/Authorization");//Ingreso el URL con el api
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();//Realiza la apertura de la conexión
			//@SuppressWarnings("unused")
			//String credencialesUsuario = username + ":" +password;
			//String userCredentials = "e.martinez@gadint.com:12345678";
			//String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
			String basicAuth = "Basic ZS5tYXJ0aW5lekBnYWRpbnQuY29tOjEyMzQ1Njc4";//Convierto el username + : el password en un encode de tipo64
			//Modificar este encode tuvo un fallo el dia 05-03-2019

			conn.setRequestProperty ("Authorization", basicAuth);//Le envio el tipo de solicitud a realizar
			conn.setRequestMethod("GET");//Le indico el metodo de solicitud.
			conn.setRequestProperty("Accept", "application/json");//Le indico la propiedad de la solicitud.
			conn.setUseCaches(false);//Le especifico si se va a utilizar cache.
			conn.setDoInput(true);//Envio la salida
			conn.setDoOutput(true);//***************
			conn.connect();//Le indico que se conecte

			if (conn.getResponseCode() != 200) {//Si el tiempo de repuesta es diferente a 200 entonces la conexion no ha sido exitosa.
				throw new RuntimeException("Failed : HTTP error code : "//Despliego la excepción. //Error en esta linea
						+ conn.getResponseCode() + conn.getContentLength());
				

			}

			BufferedReader br = new BufferedReader(new InputStreamReader(//Creo un objeto de la classe BufferedReader para leer toda la informaciona generada por el api.
					(conn.getInputStream())));//Capturo la repuesta de la conexión.

			@SuppressWarnings("unused")
			String output;//Defino esta variable para captura las informaciones del objeto br.
			while ((output = br.readLine()) != null) {//Con este bucle obtengo todas las informaciones de la api y utilizo las varible output para guardar todos esos datos.

			}
            br.close();//Cierro el flujo del objeto br
			conn.disconnect();//Desconecto el objeto conn del api.

		} catch (MalformedURLException e) { aL.crearArchivoLog(e.toString());//Capturo si se produce una excepcion con el metodo crearArchivoLog
			

			e.printStackTrace();

		} catch (IOException e) {  aL.crearArchivoLog(e.toString());

			e.printStackTrace();

		}


	}


	public ControllerWeb(int idTicket) throws IOException, JSONException//Constructor definido para capturar los datos del api del ticket del helpdesk.
	{
		URL url = new URL("https://gadintermec.jitbit.com/helpdesk/api/ticket/"+idTicket); // Utilizo esta api para acceder a informaciones del ticket utilizo la varible idTicket para especificar exactamente a que ticket obtener los datos.
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String basicAuth = "Basic ZS5tYXJ0aW5lekBnYWRpbnQuY29tOjEyMzQ1Njc4";
		conn.setRequestProperty ("Authorization", basicAuth);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.connect();

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode() + conn.getContentLength());

		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output = null;
		while ((output = br.readLine()) != null) {
			salida2 = output;//Salida2 tendra el valor de todas las informaciones que tenga la variable output.

		}
		br.close(); //Fecha  ultima modificacion 3/9/2018
		conn.disconnect();


		URL url2 = new URL("https://gadintermec.jitbit.com/helpdesk/api/TicketCustomFields?id="+idTicket);
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
		conn2.setRequestProperty ("Authorization", basicAuth);
		conn2.setRequestMethod("GET");
		conn2.setRequestProperty("Accept", "application/json");
		conn2.setUseCaches(false);
		conn2.setDoInput(true);
		conn2.setDoOutput(true);
		conn2.connect();

		if (conn2.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn2.getResponseCode() + conn2.getContentLength());
		}

		br = new BufferedReader(new InputStreamReader(
				(conn2.getInputStream())));

		String output2 = null;
		while ((output2 = br.readLine()) != null) {

			salida = output2;//Salida tendra el valor de todas las informaciones que tenga la variable output2.
		}
		br.close();//Fecha ultima modificacion 3/9/2018
		conn2.disconnect();


	}


	/*
	 * Para poder acceder a las informaciones
	 * como CLIENTE , SERIAL , FECHA, PRIORIDAD , MODELO
	 * Utilizo las clases JSOObject y JSONArray
	 * en los JSOObject se acceder por el nombre del objeto
	 * mientras que en los JSOArray se acceder por el indice del objeto
	 * 
	 * 
	 */


	public String getFechaTicketJSon() throws JSONException   //Metodo para obtener la fecha de creacion del ticket
	{  
		job = new JSONObject(salida2);
		String fecha =  job.getString("IssueDate").substring(0, 10);//Especifico hasta que longitud de caracteres deseo capturar.
		return fecha;  
	}// Fecha  ultima modificacion 3/9/2018 


	/*
	public int getIDTicketJSon()  throws JSONException // Metodo para obtener el id del ticket -,-
	{
	     job = new JSONObject(salida2);
		int idTicket =  job.getInt("TicketID");
		return idTicket;	
	}//IDTicket ultima modificacion  3/9/2018
	 */

	public String getSerialEquiposJSon() throws JSONException //  Metodo para obtener serial valores Json
	{
		array = new JSONArray(salida);
		job = (JSONObject) array.get(0);
		String serialEquipo = job.getString("Value");
		return serialEquipo;

	}// Serial Fecha  ultima modificacion  3/9/2018 

 

	public String getModeloEquipoJSon() throws JSONException //  Metodo para obtener modelo valores Json
	{
		array = new JSONArray(salida);
		job = (JSONObject) array.get(1);
		String modeloEquipo =	job.getString("Value");
		return modeloEquipo;

	}// Modelo ultima modificacion  3/9/2018


	public String getNombreClienteJSon() throws JSONException //  Metodo para obtener nombre cliente  Json
	{
		array  = new JSONArray(salida);
		job = (JSONObject) array.get(3);
		String nombreCliente =	job.getString("Value"); // Para recortar la longitud del nombre
		return nombreCliente;
	}// Fin del metodo getNombreCliente 

	public String getPrioridadEquipoJSon() throws JSONException //  Metodo para obtener prioridad /contrato/Garantia valores Json
	{
		array = new JSONArray(salida);
		job = (JSONObject) array.get(4);
		String prioridadEquipo =	job.getString("Value");
		return prioridadEquipo;
	}//Prioridad Fecha  ultima modificacion  3/9/2018

}// Fin de la class ControllerWeb
