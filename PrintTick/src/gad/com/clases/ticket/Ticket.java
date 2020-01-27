package gad.com.clases.ticket;

/*

 * Desarrollado por
 * Edison Martinez Frias
 * 16-06-20169
 * @author Dell-AMD
 * 
 */


/*
 * Clase definida para utilizar el modelo de la clase ticket 
 * para acceder a las propiedades de esta por medio del constructor.
 */

public class Ticket 
{
	

	//Defino las varibles de la clase
	private String nombreCliente;
	private String serialEquipo;
	private String idTicket;
	private String modeloEquipo;
	private String fecha; 
	private String estatusEquipo;

	//Defino los get y los set para los metodos de la clase
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getSerialEquipo() {
		return serialEquipo;
	}
	public void setSerialEquipo(String serialEquipo) {
		this.serialEquipo = serialEquipo;
	}
	public String getIdTicket() {
		return idTicket;
	} 
	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}
	public String getModeloEquipo() {
		return modeloEquipo;
	}
	public void setModeloEquipo(String modeloEquipo) {
		this.modeloEquipo = modeloEquipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstatusEquipo() {
		return estatusEquipo;
	}
	public void setEstatusEquipo(String estatusEquipo) {
		this.estatusEquipo = estatusEquipo;
	}


	public Ticket(String nC, String seEqp,String fech,String idT,String mod,String estEq)// Defino mi constructor de la clase con sus parametros
	{
		this.nombreCliente = nC;
		this.serialEquipo = seEqp;
		this.fecha = fech;
		this.idTicket = idT;
		this.modeloEquipo = mod;
		this.estatusEquipo = estEq;
	}//Fin del constructor


	public Ticket() {}//Realiza una sobreescritura de mi constructor.

}//Fin de la class ticket




