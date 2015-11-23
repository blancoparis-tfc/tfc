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
import org.springframework.test.annotation.Commit;
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
		final Provincia provincia = service.obtenerProvincia("Segovia");
		assertSegovia(provincia);
	}

	@Commit
	@Test
	public void test002ModificarProvincia(){
		final Provincia provincia = service.obtenerProvincia("Segovia");
		provincia.setNombre("perico");
		provincia.setComunidadAutonoma(null);
		service.actualizar(provincia);
	}

	@Test
	public void test003AssertQueNoSeHaModificadoLaProvincia(){
		final Provincia provincia = service.obtenerProvincia("Segovia");
		assertSegovia(provincia);
	}

	
	private void assertSegovia(final Provincia provincia) {
		assertEquals("El código esperado", new Integer(40), provincia.getId());
		assertEquals("El nombre","Segovia",provincia.getNombre());
		assertEquals(" comunidad ",new Long(7L), provincia.getComunidadAutonoma().getId());
	}

}
