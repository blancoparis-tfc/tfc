package org.dbp.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dbp.core.dao.GenericDao;
import org.dbp.core.dao.GenericService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Exception.class)
public class GenericServiceImpl <E extends Serializable,ID> implements GenericService<E,ID>{

	private GenericDao<E,ID> dao;
	
	public GenericServiceImpl(GenericDao<E, ID> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public E obtenerId(ID id) {
		return dao.obtenerId(id);
	}

	@Override
	public void eliminar(E entidad) {
		dao.eliminar(entidad);
	}

	@Override
	public void crear(E entidad) {
		dao.crear(entidad);
	}

	@Override
	public E actualizar(E entidad) {
		return dao.actualizar(entidad);
	}

	@Override
	public List<E> obtenerTodos() {
		return dao.obtenerTodos();
	}

	
	
}
