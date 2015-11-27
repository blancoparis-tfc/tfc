package org.dbp.service.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.ComunidadAutonoma;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.localizacion.ComunidadAutonomaDao;
import org.dbp.service.personas.localizacion.ComunidadAutonomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ComunidadAutonomaServiceImpl extends GenericServiceImpl<ComunidadAutonoma,Long> implements ComunidadAutonomaService {

	@Autowired
	public ComunidadAutonomaServiceImpl(final ComunidadAutonomaDao dao) {
		super(dao);
	}

}
