package es.uc3m.tiw.dominio;

import java.io.Serializable;

public class MensajeMostrado implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private long propietario;
	private long idOrigen;
	private long idproducto;
	private String origen;
	private String producto;
	private String mensaje;
	public MensajeMostrado(){
		
	}

	public MensajeMostrado(long id, long propietario, long idproducto, String origen, long idOrigen, String producto, String mensaje) {
		super();
		this.id = id;
		this.propietario = propietario;
		this.idproducto = idproducto;
		this.origen = origen;
		this.producto = producto;
		this.mensaje = mensaje;
		this.idOrigen = idOrigen;
	}

	public void clonarMensaje(long id, long propietario, long idproducto, String origen, String producto, String mensaje){
		this.id = id;
		this.propietario = propietario;
		this.idproducto = idproducto;
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
	public long getPropietario() {
		return propietario;
	}
	public void setPropietario(long propietario) {
		this.propietario = propietario;
	}
	public long getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(long idproducto) {
		this.idproducto = idproducto;
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

	public long getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(long idOrigen) {
		this.idOrigen = idOrigen;
	}
	
}
