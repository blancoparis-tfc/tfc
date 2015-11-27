package org.dbp.service.personas.impl;

import org.dbp.bom.personas.Persona;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.PersonaDao;
import org.dbp.service.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements PersonaService{

	@Autowired
	public PersonaServiceImpl(final PersonaDao dao) {
		super(dao);
	}

}
