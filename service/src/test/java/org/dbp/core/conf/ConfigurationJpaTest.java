package org.dbp.core.conf;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dbp.bom.contabilidad.Asientos;
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

	@PersistenceContext EntityManager em;
	
	@Test
	public void testRecuperarUnUsuario(){
		Asientos asiento=em.find(Asientos.class, 1L);
		assertEquals("El id del usuario 1",new Long(1L),asiento.getId());
		assertEquals("Validamos la descripcion","prueba1",asiento.getDescripcion());
	}
	
}
