package org.dbp.service.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.Pais;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.localizacion.PaisDao;
import org.dbp.service.personas.localizacion.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl extends GenericServiceImpl<Pais,String> implements PaisService{
	
	@Autowired
	public PaisServiceImpl(final PaisDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
