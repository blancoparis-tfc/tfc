package org.dbp.dao.personas.impl;

import org.dbp.bom.personas.PersonaJuridica;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.PersonaJuridicaDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaJuridicaDaoImpl extends GenericDaoImpl<PersonaJuridica,Long> implements PersonaJuridicaDao{

	public PersonaJuridicaDaoImpl() {
		super(PersonaJuridica.class);
	}

}
