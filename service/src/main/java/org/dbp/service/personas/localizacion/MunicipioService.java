package org.dbp.service.personas.localizacion;

import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.core.dao.GenericService;

public interface MunicipioService extends GenericService<Municipio,Long>{
	public  Municipio obtenerMunicipio(String nombre);
}
