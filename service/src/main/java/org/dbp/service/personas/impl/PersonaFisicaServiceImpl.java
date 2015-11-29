package org.dbp.service.personas.impl;

import org.dbp.bom.personas.PersonaFisica;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.PersonaFisicaDao;
import org.dbp.service.personas.PersonaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaFisicaServiceImpl extends GenericServiceImpl<PersonaFisica,Long> implements PersonaFisicaService {
	
	@Autowired
	public PersonaFisicaServiceImpl(final PersonaFisicaDao dao) {
		super(dao);
	}
	
}
