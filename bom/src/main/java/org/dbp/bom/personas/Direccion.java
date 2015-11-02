package org.dbp.bom.personas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Direccion implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	private String direccion;
	
}
