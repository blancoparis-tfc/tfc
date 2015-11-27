package org.dbp.service.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.Provincia;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.localizacion.ProvinciaDao;
import org.dbp.service.personas.localizacion.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl extends GenericServiceImpl<Provincia,Long> implements ProvinciaService{
	
	private final ProvinciaDao dao;
	
	@Autowired
	public ProvinciaServiceImpl(final ProvinciaDao dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public Provincia obtenerProvincia(final String nombre) {
		return dao.obtenerProvincia(nombre);
	}

}
