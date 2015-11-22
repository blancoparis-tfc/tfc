package org.dbp.core.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <E extends Serializable,Id>{

	public E obtenerId(Id identificador); //NOPMD

	public void eliminar(E entidad); //NOPMD
	
	public void crear(E entidad); //NOPMD
	
	public E actualizar(E entidad); //NOPMD
	
	public List<E> obtenerTodos(); //NOPMD
	
}
