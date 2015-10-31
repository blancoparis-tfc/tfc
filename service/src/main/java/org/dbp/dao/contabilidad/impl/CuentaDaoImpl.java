package org.dbp.dao.contabilidad.impl;

import org.dbp.bom.contabilidad.Cuenta;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.contabilidad.CuentaDao;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaDaoImpl extends GenericDaoImpl<Cuenta,String> implements CuentaDao {

	public CuentaDaoImpl() {
		super(Cuenta.class);
	}

}
