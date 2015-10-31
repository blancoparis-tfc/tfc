package org.dbp.dao.contabilidad.impl;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.contabilidad.AsientosDao;
import org.springframework.stereotype.Repository;

/**
 * 
 * Tiene las operaciones asociadas a la entidad de asientos.
 * 
 * @author david
 *
 */
@Repository
public class AsientosDaoImpl extends GenericDaoImpl<Asientos,Long> implements AsientosDao {

	public AsientosDaoImpl() {
		super(Asientos.class);
	}

}
