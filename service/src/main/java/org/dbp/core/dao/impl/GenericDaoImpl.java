package org.dbp.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dbp.core.dao.GenericDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Exception.class)
public class GenericDaoImpl <E extends Serializable,Id> implements GenericDao<E,Id>{

	@PersistenceContext 
	private EntityManager entityManager;
	
	private final Class<E> clazzE;

	public GenericDaoImpl(final Class<E> clazzE) {
		super();
		this.clazzE = clazzE;
	}

	public Class<E> getClazzE() {
		return clazzE;
	}
	@Override
	public E obtenerId(final Id identificador){
		return entityManager.find(clazzE, identificador);
	}
	@Override
	public void eliminar(final E entidad){
		entityManager.remove(entidad);
	}
	@Override
	public void crear(final E entidad){
		entityManager.persist(entidad);
	}
	@Override
	public E actualizar(final E actualizar){
		return entityManager.merge(actualizar);
	}
	@Override
	public List<E> obtenerTodos(){
		final CriteriaBuilder criteriaBuilde=entityManager.getCriteriaBuilder();
		final CriteriaQuery<E> criteria=criteriaBuilde.createQuery(clazzE);
		final Root<E> from=criteria.from(clazzE);
		final TypedQuery<E> query=entityManager.createQuery(criteria.select(from));
		return query.getResultList();
	}

}
