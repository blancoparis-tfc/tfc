package org.dbp.dao.personas.localizacion.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.personas.localizacion.MunicipioDao;
import org.springframework.stereotype.Repository;


@Repository
public class MunicipioDaoImpl extends GenericDaoImpl<Municipio,Long> implements MunicipioDao{

	@PersistenceContext private EntityManager entityManager;
	
	public MunicipioDaoImpl() {
		super(Municipio.class);
	}

	@Override
	public Municipio obtenerMunicipio(final String nombre){
		final CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		final CriteriaQuery<Municipio> criteria=criteriaBuilder.createQuery(getClazzE());
		final Root<Municipio> from=criteria.from(getClazzE());
		final Predicate condMunicipio= criteriaBuilder.upper(from.get("municipio")).in(nombre.toUpperCase());
		final TypedQuery<Municipio> query=entityManager.createQuery(criteria.select(from).where(condMunicipio));
		return query.getSingleResult();
	}
}
