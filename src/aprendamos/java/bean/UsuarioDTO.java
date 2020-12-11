package aprendamos.java.bean;

import java.io.Serializable;

// DTO : Data Transfer Object
// Tambien conocido como VO (Value Object)

import java.util.*;

// UN DTO consta de 2 clases la clase Value Object que solo contiene 
// atributos, constructor y métodos getters y setters y una clase Business Object
// que es donde esta nuestros métodos para nuestro CRUD
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String clave;
	private String nombre;
	private Date fecnac;
	private String direccion;
	private String distrito;
	private String telefono;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecnac() {
		return fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
