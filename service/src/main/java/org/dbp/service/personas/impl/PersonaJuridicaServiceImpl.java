package org.dbp.service.personas.impl;

import org.dbp.bom.personas.PersonaJuridica;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.PersonaJuridicaDao;
import org.dbp.service.personas.PersonaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonaJuridicaServiceImpl extends GenericServiceImpl<PersonaJuridica,Long> implements PersonaJuridicaService {
	
	@Autowired
	public PersonaJuridicaServiceImpl(final PersonaJuridicaDao dao) {
		super(dao);
	}

}
