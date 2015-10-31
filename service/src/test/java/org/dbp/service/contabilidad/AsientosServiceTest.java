package org.dbp.service.contabilidad;

import static org.junit.Assert.*;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.core.conf.TestConfiguracion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestConfiguracion.class)
public class AsientosServiceTest {

	@Autowired private AsientosService asientoService;

	@Test
	public void testBuscar(){
		Asientos asiento=asientoService.obtenerId(1L);
		assertEquals("Id",new Long(1),asiento.getId());
	}

}
