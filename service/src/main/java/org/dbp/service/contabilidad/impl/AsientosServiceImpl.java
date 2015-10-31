package org.dbp.service.contabilidad.impl;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.contabilidad.AsientosDao;
import org.dbp.service.contabilidad.AsientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsientosServiceImpl extends GenericServiceImpl<Asientos,Long> implements AsientosService {

	private AsientosDao dao;
	
	@Autowired
	public AsientosServiceImpl(AsientosDao dao) {
		super(dao);
		this.dao=dao;
	}

}
