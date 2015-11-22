package org.dbp.dao.personas.localizacion;

import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.core.dao.GenericDao;

public interface MunicipioDao extends GenericDao<Municipio,Long>{

	public Municipio obtenerMunicipio(String nombre); //NOPMD

}
