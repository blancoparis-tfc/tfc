package org.dbp.bom.clientes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class DatosDeContacto implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	private String telefono;
	private String nombre;
	@ManyToOne
	private Direccion direccion;
	
	private String direccionDeCorreo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getDireccionDeCorreo() {
		return direccionDeCorreo;
	}

	public void setDireccionDeCorreo(String direccionDeCorreo) {
		this.direccionDeCorreo = direccionDeCorreo;
	}
}
