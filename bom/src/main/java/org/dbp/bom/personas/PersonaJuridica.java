package org.dbp.bom.personas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonaJuridica extends Persona {

	private String nombreSocial;
	private String nombreComercial;
	
	@ManyToOne
	private PersonaJuridica empresaMaestra;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<DelegacionComercial> delegacionesComerciales;

	public List<DelegacionComercial> getDelegacionesComerciales() {
		return delegacionesComerciales;
	}
	public void setDelegacionesComerciales(
			List<DelegacionComercial> delegacionesComerciales) {
		this.delegacionesComerciales = delegacionesComerciales;
	}

	public PersonaJuridica getEmpresaMaestra() {
		return empresaMaestra;
	}
	public void setEmpresaMaestra(PersonaJuridica empresaMaestra) {
		this.empresaMaestra = empresaMaestra;
	}
	public String getNombreSocial() {
		return nombreSocial;
	}
	public void setNombreSocial(String nombreSocial) {
		this.nombreSocial = nombreSocial;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	
	
}
