package es.uc3m.tiw.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;


@Entity
@Table(name="ADMINISTRADOR")
public class Administrador {
	@Id	
	@GeneratedValue(strategy = AUTO)
	private long idadmin;
	@Column(length = 30, nullable = false)
	private String nombre;
	@Column(length = 30, nullable = false)
	private String apellido1;
	@Column(length = 30, nullable = true)
	private String apellido2;
	@Column(length = 100, nullable = false,unique = true)
	private String email;
	@Column(length = 30, nullable = false)
	private String password;
	@Column(length = 30, nullable = false)
	private String ciudad;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	public Administrador(String nombre, String apellido1, String apellido2, String email, String password,
			String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.password = password;
		this.ciudad = ciudad;
	}
	public long getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	

}
