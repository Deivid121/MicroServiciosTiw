package es.uc3m.tiw.dominio;

public class Producto {
	private int id;
	private String titulo;
	private String categoria;
	private String descripcion;
	private String estado;
	private String ciudad;
	private String imagen;
	private int usuario;
	
	public Producto(int id, String titulo, String categoria, String descripcion, String estado, String ciudad,
			String imagen, int usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.estado = estado;
		this.ciudad = ciudad;
		this.imagen = imagen;
		this.usuario = usuario;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
}
