package org.dbp.service.persona.localizacion;

import static org.junit.Assert.assertEquals;

import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.service.personas.localizacion.MunicipioService;
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
public class MunicipioServiceTest {

	@Autowired private MunicipioService service;
	
	@Test 
	public void testObtenerMunicipio(){
		Municipio municipio=service.obtenerMunicipio("Segovia");
		assertSegovia(municipio);
	}

	private void assertSegovia(Municipio municipio) {
		assertEquals("nombre de municipio","Segovia",municipio.getMunicipio());
		assertEquals("provincia","Segovia",municipio.getProvincia().getNombre());
		assertEquals("Comunidad autonoma","Castilla y León",municipio.getProvincia().getComunidadAutonoma().getNombre());
	}
	
}
