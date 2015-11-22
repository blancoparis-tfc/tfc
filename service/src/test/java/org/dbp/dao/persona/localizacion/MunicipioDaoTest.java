package org.dbp.dao.persona.localizacion;

import static org.junit.Assert.assertEquals;

import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.dao.personas.localizacion.MunicipioDao;
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
public class MunicipioDaoTest {

	@Autowired private MunicipioDao municipioDao;
	
	@Test
	public void test001ConsultarUnMunicipio(){
		Municipio municipio=municipioDao.obtenerId(6024L);
		assertSegovia(municipio);
	}

	@Commit
	@Test
	public void test002IntentamosModificarElNombre(){
		Municipio municipio=municipioDao.obtenerId(6024L);
		municipio.setMunicipio("Segovia2");
		municipioDao.actualizar(municipio);
	}
	
	@Test
	public void test003ValidamosQueSegoviaNoSeHaModificado(){
		Municipio municipio=municipioDao.obtenerId(6024L);
		assertSegovia(municipio);
	}
	
	@Commit
	@Test
	public void test004QuitamosLaProvincia(){
		Municipio municipio=municipioDao.obtenerId(6024L);
		municipio.setProvincia(null);
		municipioDao.actualizar(municipio);
	}
	
	@Test
	public void test005ValidamosQueNoSeHaQuitadoLaProvincia(){
		Municipio municipio=municipioDao.obtenerId(6024L);
		assertSegovia(municipio);
	}
	
	@Test
	public void test006BuscarPorNombre(){
		Municipio municipio=municipioDao.obtenerMunicipio("Segovia");
		assertSegovia(municipio);
	}
	private void assertSegovia(Municipio municipio) {
		assertEquals("nombre de municipio","Segovia",municipio.getMunicipio());
		assertEquals("provincia","Segovia",municipio.getProvincia().getNombre());
		assertEquals("Comunidad autonoma","Castilla y León",municipio.getProvincia().getComunidadAutonoma().getNombre());
	}
}
