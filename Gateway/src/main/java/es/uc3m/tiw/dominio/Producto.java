package es.uc3m.tiw.dominio;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Producto {
	
	private int id;
	@NotNull
	@Size(min=2,max=30,message="Introduzca titulo para su producto")
	private String titulo;
	@NotNull
	private String categoria;
	@NotNull
	@Size(min=2,max=30,message="Introduzca la descripcion del producto que desea vender")
	private String descripcion;
	private String image;
	private String estado;
	private String ciudad;
	@NotNull
	private int precio;
	private long usuario;
	
	public Producto(String titulo, String categoria, String descripcion,String imagen, int precio, long usuario, String ciudad, String estado) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.image=imagen;
		this.precio = precio;
		this.usuario = usuario;
		this.ciudad = ciudad;
		this.estado = estado;
	}
	public Producto(){
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public long getUsuario() {
		return usuario;
	}
	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String imagen) {
		this.image = imagen;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", descripcion=" + descripcion
				+ ", image=" + image + ", estado=" + estado + ", ciudad=" + ciudad + ", precio=" + precio + ", usuario="
				+ usuario + "]";
	}
	


	
	
}
