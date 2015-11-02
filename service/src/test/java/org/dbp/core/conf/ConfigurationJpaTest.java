package org.dbp.core.conf;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.bom.personas.localizacion.ComunidadAutonoma;
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

	@PersistenceContext EntityManager em;
	
	@Test
	public void testRecuperarUnUsuario(){
		Asientos asiento=em.find(Asientos.class, 1L);
		assertEquals("El id del usuario 1",new Long(1L),asiento.getId());
		assertEquals("Validamos la descripcion","prueba1",asiento.getDescripcion());
		Pais pais=em.find(Pais.class, "AF");
		System.out.println(pais);
		ComunidadAutonoma comunidad = em.find(ComunidadAutonoma.class, 1L);
		System.out.println(comunidad);
		Provincia provincia = em.find(Provincia.class, 2);
		System.out.println(provincia);
	}
	
}
