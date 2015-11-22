package org.dbp.dao.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.Provincia;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.localizacion.ProvinciaDao;

public class ProvinciaDaoImpl extends GenericDaoImpl<Provincia,Long> implements ProvinciaDao{

	public ProvinciaDaoImpl() {
		super(Provincia.class);
	}

}
