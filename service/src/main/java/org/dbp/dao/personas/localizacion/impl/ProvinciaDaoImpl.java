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

	@PersistenceContext private EntityManager em;
	
	public ProvinciaDaoImpl() {
		super(Provincia.class);
	}

	
	@Override
	public Provincia obtenerProvincia(String nombre){
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Provincia> criteria=cb.createQuery(getClazzE());
		Root<Provincia> from=criteria.from(getClazzE());
		Predicate condMunicipio= cb.upper(from.get("nombre")).in(nombre.toUpperCase());
		TypedQuery<Provincia> query=em.createQuery(criteria.select(from).where(condMunicipio));
		return query.getSingleResult();
	}
}
