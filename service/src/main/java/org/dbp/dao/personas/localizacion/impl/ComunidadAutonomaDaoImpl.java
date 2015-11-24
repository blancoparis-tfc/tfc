package org.dbp.dao.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.ComunidadAutonoma;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.localizacion.ComunidadAutonomaDao;
import org.springframework.stereotype.Repository;

@Repository
public class ComunidadAutonomaDaoImpl extends GenericDaoImpl<ComunidadAutonoma,Long> implements ComunidadAutonomaDao{

	public ComunidadAutonomaDaoImpl() {
		super(ComunidadAutonoma.class);
	}

}
