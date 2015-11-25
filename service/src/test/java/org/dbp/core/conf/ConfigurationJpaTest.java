package org.dbp.core.conf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.bom.personas.localizacion.ComunidadAutonoma;
import org.dbp.bom.personas.localizacion.Municipio;
import org.dbp.bom.personas.localizacion.Pais;
import org.dbp.bom.personas.localizacion.Provincia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
/**
 * Test para validar la configuración del JPA.
 * @author david
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestConfiguracion.class)
public class ConfigurationJpaTest {

	@PersistenceContext private EntityManager entityManager;
	
	@Test
	public void testRecuperarUnUsuario(){
		final Asientos asiento=entityManager.find(Asientos.class, 1L);
		assertEquals("El id del usuario 1",Long.valueOf(1L),asiento.getId());
		assertEquals("Validamos la descripcion","prueba1",asiento.getDescripcion());
		final Pais pais=entityManager.find(Pais.class, "AF");
		assertNotNull("Obtener el pais",pais);
		final ComunidadAutonoma comunidad = entityManager.find(ComunidadAutonoma.class, 1L);
		assertNotNull("Obtener la comunidad",comunidad);
		final Provincia provincia = entityManager.find(Provincia.class, 2);
		assertNotNull("Obtener la provincia",provincia);
		final Municipio municipio=entityManager.find(Municipio.class,1L);
		assertNotNull("Obtener el municipio",municipio);
	}
	
}
