package org.dbp.service.personas.localizacion;

import org.dbp.bom.personas.localizacion.Provincia;
import org.dbp.core.dao.GenericService;

public interface ProvinciaService extends GenericService<Provincia,Long>{

	public  Provincia obtenerProvincia(String nombre); //NOPMD
	
}
