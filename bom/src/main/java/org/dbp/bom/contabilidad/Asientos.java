package org.dbp.bom.contabilidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
@SuppressWarnings("serial")
@Entity
public class Asientos implements Serializable{
	
	@Id
	@TableGenerator(name = "ASIENTOS_GEN",
     table = "SECUENCIAS", pkColumnName = "SEQ_NAME",
     valueColumnName = "SEQ_ASIENTOS",  pkColumnValue = "SEQUENCE"
     ,allocationSize=1,initialValue=1000)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ASIENTOS_GEN")
	private Long id;
	
	private String descripcion;
	@OneToMany(mappedBy="asiento")
	private List<LineasAsiento> lineas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LineasAsiento> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineasAsiento> lineas) {
		this.lineas = lineas;
	}

	
	
}
