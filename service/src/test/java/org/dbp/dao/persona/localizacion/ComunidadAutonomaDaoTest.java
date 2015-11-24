package org.dbp.dao.persona.localizacion;

import static org.junit.Assert.*;

import org.dbp.bom.personas.localizacion.ComunidadAutonoma;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.dao.personas.localizacion.ComunidadAutonomaDao;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = TestConfiguracion.class)
public class ComunidadAutonomaDaoTest {

	@Autowired private ComunidadAutonomaDao dao;
	
	@Commit
	@Test
	public void test001ModificarNombre(){
		final ComunidadAutonoma camunidadAutonoma=dao.obtenerId(1L);
		assertEquals("Nombre de la provincia","Andalucía",camunidadAutonoma.getNombre());
		camunidadAutonoma.setNombre("Perico");
		dao.actualizar(camunidadAutonoma);
	}
	
	@Test
	public void test002AssertModificarNombre(){
		final ComunidadAutonoma camunidadAutonoma=dao.obtenerId(1L);
		assertEquals("Nombre de la provincia","Andalucía",camunidadAutonoma.getNombre());
	}
}
