package org.dbp.service.personas.localizacion.impl;

import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.personas.localizacion.MunicipioDao;
import org.dbp.service.personas.localizacion.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MunicipioServiceImpl extends GenericServiceImpl<Municipio,Long> implements MunicipioService{

	private final MunicipioDao dao;
	
	@Autowired
	public MunicipioServiceImpl(final MunicipioDao dao) {
		super(dao);
		this.dao=dao;
	}

	@Override
	public Municipio obtenerMunicipio(final String nombre) {
		return this.dao.obtenerMunicipio(nombre);
	}

}
