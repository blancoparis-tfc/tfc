package org.dbp.bom.personas.localizacion;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComunidadAutonoma {

	@Id
	private Long id;

	private String nombre;

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



	
}