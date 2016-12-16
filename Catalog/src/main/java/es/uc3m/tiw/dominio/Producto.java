package es.uc3m.tiw.dominio;


import static javax.persistence.GenerationType.AUTO;


import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;
	@Column(length = 30, nullable = false)
	private String titulo;
	@Column(length = 30, nullable = false)
	private String categoria;
	@Column(length = 500, nullable = false)
	private String descripcion;
	@Column(length = 30, nullable = false)
	private String estado;
	@Lob
    @Column(nullable = true)
    private String image;
	@Column(length = 30, nullable = false)
	private String ciudad;
	@Column(nullable = true)
	private int precio;
	@Column(nullable = false)
	private int usuario;
	
	public Producto(String titulo, String categoria, String descripcion,String imagen, int precio, int usuario, String ciudad, String estado) {
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
	
	public Producto() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
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
	
	
}
