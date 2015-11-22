package org.dbp.dao.personas.localizacion;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dbp.bom.personas.localizacion.Provincia;
import org.dbp.core.dao.GenericDao;

public interface ProvinciaDao extends GenericDao<Provincia,Long>{

	public abstract Provincia obtenerProvincia(String nombre);

}
