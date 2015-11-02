package org.dbp.dao.personas.impl;

import org.dbp.bom.personas.Persona;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.PersonaDao;
import org.springframework.stereotype.Repository;
@Repository
public class PersonaDaoImpl extends GenericDaoImpl<Persona,Long> implements PersonaDao{

	public PersonaDaoImpl() {
		super(Persona.class);
	}

}
