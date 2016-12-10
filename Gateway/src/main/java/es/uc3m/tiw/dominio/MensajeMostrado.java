package es.uc3m.tiw.dominio;

import java.io.Serializable;

public class MensajeMostrado implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String origen;
	private String producto;
	private String mensaje;
	public MensajeMostrado(){
		
	}
	public MensajeMostrado(long id, String origen, String producto, String mensaje) {
		super();
		this.id = id;
		this.origen = origen;
		this.producto = producto;
		this.mensaje = mensaje;
	}
	public void clonarMensaje(long id, String origen, String producto, String mensaje){
		this.id = id;
		this.origen = origen;
		this.producto = producto;
		this.mensaje = mensaje;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
