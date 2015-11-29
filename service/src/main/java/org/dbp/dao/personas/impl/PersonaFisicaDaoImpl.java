package org.dbp.dao.personas.impl;

import org.dbp.bom.personas.PersonaFisica;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.PersonaFisicaDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaFisicaDaoImpl extends GenericDaoImpl<PersonaFisica,Long> implements PersonaFisicaDao{

	public PersonaFisicaDaoImpl() {
		super(PersonaFisica.class);
	}

}
