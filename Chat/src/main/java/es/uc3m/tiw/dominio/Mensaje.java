package es.uc3m.tiw.dominio;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MENSAJES")
public class Mensaje {
	@Id	
	@GeneratedValue(strategy = AUTO)
	private long id;
	private long origenId;
	private long destinoId;
	private long productoId;
	public long getProductoId() {
		return productoId;
	}
	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}
	private String mensaje;
	
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
