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

	@PersistenceContext private EntityManager em;
	
	public MunicipioDaoImpl() {
		super(Municipio.class);
	}

	@Override
	public Municipio obtenerMunicipio(String nombre){
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Municipio> criteria=cb.createQuery(Municipio.class);
		Root<Municipio> from=criteria.from(Municipio.class);
		Predicate condMunicipio= cb.upper(from.get("municipio")).in(nombre.toUpperCase());
		TypedQuery<Municipio> query=em.createQuery(criteria.select(from).where(condMunicipio));
		return query.getSingleResult();
	}
}
