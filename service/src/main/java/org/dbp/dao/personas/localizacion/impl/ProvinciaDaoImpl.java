package org.dbp.dao.personas.localizacion.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dbp.bom.personas.localizacion.Provincia;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.localizacion.ProvinciaDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProvinciaDaoImpl extends GenericDaoImpl<Provincia,Long> implements ProvinciaDao{

	@PersistenceContext private EntityManager entityManager;
	
	public ProvinciaDaoImpl() {
		super(Provincia.class);
	}

	
	@Override
	public Provincia obtenerProvincia(final String nombre){
		final CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Provincia> criteria=criteriaBuilder.createQuery(getClazzE());
		final Root<Provincia> from=criteria.from(getClazzE());
		final Predicate condMunicipio= criteriaBuilder.upper(from.get("nombre")).in(nombre.toUpperCase());
		final TypedQuery<Provincia> query=entityManager.createQuery(criteria.select(from).where(condMunicipio));
		return query.getSingleResult();
	}
}
