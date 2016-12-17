package es.uc3m.tiw.dominio;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Usuario implements Serializable{

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", email=" + email + ", avatar=" + avatar + ", password=" + password + ", ciudad=" + ciudad + "]";
	}
	private static final long serialVersionUID = 1L;
	private long id;
	@NotNull
	@Size(min=2,max=30,message="Introduzca su nombre por favor")
	private String nombre;
	@NotNull
	@Size(min=2,max=50, message="Introduzca su primer apellido por favor")
	private String apellido1;
	@NotNull
	@Size(min=2,max=50, message="Introduzca su segundo apellido por favor")
	private String apellido2;
	@NotNull
	@Email 
	@Size(min=3,max=50,message="Introduzca su email por favor ('usuario@dominio')")
	private String email;
	private String avatar;
	@NotNull
	@Size(min=8,max=20,message="La contraseña debe tener entre {min} y {max} caracteres")
	private String password;
	@NotNull(message="Introduzca su ciudad")
	private String ciudad;
	
	public Usuario() {
	}
	public Usuario(String nombre, String apellido1, String apellido2, String email, String password,
			String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.password = password;
		this.ciudad = ciudad;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}