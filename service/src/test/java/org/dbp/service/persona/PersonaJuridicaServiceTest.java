package org.dbp.service.persona;

import static org.junit.Assert.assertTrue;

import org.dbp.core.conf.TestConfiguracion;
import org.dbp.service.personas.PersonaJuridicaService;
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
public class PersonaJuridicaServiceTest {

	@Autowired private PersonaJuridicaService service;
	
	@Test
	public void test001RecuperarTodos(){
		assertTrue("No esperamos ningun cliente",service.obtenerTodos().isEmpty());
	}
	
}
