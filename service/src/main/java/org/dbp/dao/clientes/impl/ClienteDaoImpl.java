package org.dbp.dao.clientes.impl;

import org.dbp.bom.clientes.Cliente;
import org.dbp.core.dao.impl.GenericDaoImpl;
import org.dbp.dao.clientes.ClienteDao;
import org.springframework.stereotype.Repository;
@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente,Long> implements ClienteDao{

	public ClienteDaoImpl() {
		super(Cliente.class);
	}

}
