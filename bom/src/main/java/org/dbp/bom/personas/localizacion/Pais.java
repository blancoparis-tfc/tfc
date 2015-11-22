package org.dbp.bom.personas.localizacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Definición de los paises
 * 
 * Nota: Vamos a seguir el ISO 3166-1. usaremos el alf-2. 
 * @author david
 *
 */
@SuppressWarnings("serial")
@Entity
public class Pais implements Serializable{

	@Id
	@Column(length=2)
	private String idAlfa2;

	@Column(length=3)
	private String codAlfa3;
	@Column(length=3)
	private Integer codNumerico;  
	
	private String nombreComun;
	private String nombreOficial;

	public String getIdAlfa2() {
		return idAlfa2;
	}

	public void setIdAlfa2(String idAlfa2) {
		this.idAlfa2 = idAlfa2;
	}

	public String getCodAlfa3() {
		return codAlfa3;
	}

	public void setCodAlfa3(String codAlfa3) {
		this.codAlfa3 = codAlfa3;
	}

	public Integer getCodNumerico() {
		return codNumerico;
	}

	public void setCodNumerico(Integer codNumerico) {
		this.codNumerico = codNumerico;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreOficial() {
		return nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}


	
	
}
