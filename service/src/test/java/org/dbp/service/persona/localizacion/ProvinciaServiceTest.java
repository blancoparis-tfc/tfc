package org.dbp.service.persona.localizacion;

import static org.junit.Assert.assertEquals;

import org.dbp.bom.personas.localizacion.Provincia;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.service.personas.localizacion.ProvinciaService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = TestConfiguracion.class)
public class ProvinciaServiceTest {

	@Autowired private ProvinciaService service;
	
	@Test
	public void test001BuscarUnaProvincia(){
		Provincia provincia = service.obtenerProvincia("Segovia");
		// 40
		assertEquals("El código esperado", new Integer(40), provincia.getId());
		assertEquals("El nombre","Segovia",provincia.getNombre());
		
	}
}
