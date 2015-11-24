package org.dbp.service.persona.localizacion;

import static org.junit.Assert.assertEquals;

import org.dbp.bom.personas.localizacion.Pais;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.service.personas.localizacion.PaisService;
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
public class PaisServiceTest {

	@Autowired private PaisService service;
	
	@Test
	public void test001AssertPais(){
		final Pais pais = service.obtenerId("AF");
		assertEquals("Alfa 3","AFG",pais.getCodAlfa3());
		assertEquals("Codigo númerico",Integer.valueOf(4),pais.getCodNumerico());
		assertEquals("Nombre comun","Afganistán",pais.getNombreComun());
		assertEquals("Nombre oficial","Afganistán",pais.getNombreOficial());
	}
	
}
