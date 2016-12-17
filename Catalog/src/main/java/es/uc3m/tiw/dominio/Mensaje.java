package es.uc3m.tiw.dominio;

import java.io.Serializable;

public class Mensaje implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long origenId;
	private long destinoId;
	private long productoId;
	private String mensaje;
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", origenId=" + origenId + ", destinoId=" + destinoId + ", productoId="
				+ productoId + ", mensaje=" + mensaje + "]";
	}
	public Mensaje(){
		
	}
	public long getProductoId() {
		return productoId;
	}
	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}
	public Mensaje(long id, long origenId, long destinoId, String mensaje, long producto) {
		super();
		this.id = id;
		this.origenId = origenId;
		this.destinoId = destinoId;
		this.mensaje = mensaje;
		this.productoId = producto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrigenId() {
		return origenId;
	}
	public void setOrigenId(long origenId) {
		this.origenId = origenId;
	}
	public long getDestinoId() {
		return destinoId;
	}
	public void setDestinoId(long destinoId) {
		this.destinoId = destinoId;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
