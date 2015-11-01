package org.dbp.bom.clientes;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.dbp.bom.clientes.enums.TipoDeIdentificadorFiscal;
import org.dbp.bom.clientes.localizacion.Municipio;
import org.dbp.bom.clientes.localizacion.Pais;
import org.dbp.bom.clientes.localizacion.Provincia;

@SuppressWarnings("serial")
@Entity
public class Cliente implements Serializable{
	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private TipoDeIdentificadorFiscal tipoIdentificadorFiscal;
	
	@Column(nullable=false)
	private String identificadorFiscal;
	
	@OneToMany
	private Set<Direccion> direccion;
	
	@OneToMany
	private Set<DatosDeContacto> datosDeContacto;
	
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Provincia provincia;
	
	@ManyToOne	
	private Municipio municipio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeIdentificadorFiscal getTipoIdentificadorFiscal() {
		return tipoIdentificadorFiscal;
	}

	public void setTipoIdentificadorFiscal(
			TipoDeIdentificadorFiscal tipoIdentificadorFiscal) {
		this.tipoIdentificadorFiscal = tipoIdentificadorFiscal;
	}

	public String getIdentificadorFiscal() {
		return identificadorFiscal;
	}

	public void setIdentificadorFiscal(String identificadorFiscal) {
		this.identificadorFiscal = identificadorFiscal;
	}

	public Set<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(Set<Direccion> direccion) {
		this.direccion = direccion;
	}

	public Set<DatosDeContacto> getDatosDeContacto() {
		return datosDeContacto;
	}

	public void setDatosDeContacto(Set<DatosDeContacto> datosDeContacto) {
		this.datosDeContacto = datosDeContacto;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	
	
}
