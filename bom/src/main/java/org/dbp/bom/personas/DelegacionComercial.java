package org.dbp.bom.personas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class DelegacionComercial implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="personaJuridicaId")
	private PersonaJuridica personaJuridica;
	
	private String nombre;
	
	@ManyToOne
	private Direccion direccion;
	
	@ManyToOne
	private DatosDeContacto datosDeContacto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public DatosDeContacto getDatosDeContacto() {
		return datosDeContacto;
	}

	public void setDatosDeContacto(DatosDeContacto datosDeContacto) {
		this.datosDeContacto = datosDeContacto;
	}

	public PersonaJuridica getPersonaJuridica() {
		return personaJuridica;
	}

	public void setPersonaJuridica(PersonaJuridica personaJuridica) {
		this.personaJuridica = personaJuridica;
	}

	
	
}
