package org.dbp.dao.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.Pais;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.localizacion.PaisDao;
import org.springframework.stereotype.Repository;

@Repository
public class PaisDaoImpl extends GenericDaoImpl<Pais,String> implements PaisDao{

	public PaisDaoImpl() {
		super(Pais.class);
	}

}
