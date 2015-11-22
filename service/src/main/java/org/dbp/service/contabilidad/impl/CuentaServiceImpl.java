package org.dbp.service.contabilidad.impl;

import org.dbp.bom.contabilidad.Cuenta;
import org.dbp.core.dao.impl.GenericServiceImpl;
import org.dbp.dao.contabilidad.CuentaDao;
import org.dbp.service.contabilidad.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl extends GenericServiceImpl<Cuenta,String> implements CuentaService{
	
	@Autowired
	public CuentaServiceImpl(final CuentaDao dao) {
		super(dao);
	}

}
