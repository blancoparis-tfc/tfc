package org.dbp.service.contabilidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.bom.contabilidad.LineasAsiento;
import org.dbp.bom.contabilidad.enums.TipoMovimientoContable;
import org.dbp.core.conf.TestConfiguracion;
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
public class AsientosServiceTest {

	@Autowired private AsientosService asientoService;
	@Autowired private CuentaService cuentaService;
	
	private static Long identificador;
	
	@Test
	public void test001Buscar(){
		final Asientos asiento=asientoService.obtenerId(1L);
		assertEquals("Id",Long.valueOf(1),asiento.getId());
	}
	@Commit
	@Test
	public void test002Crear(){
		final Asientos asiento = new Asientos();
		asiento.setDescripcion("Asiento de prueba");
		asiento.setLineas(new ArrayList<LineasAsiento>());
		final LineasAsiento linea=new LineasAsiento();
		linea.setAsiento(asiento);
		linea.setImporte(BigDecimal.valueOf(1000));
		linea.setTipoMovimientoContable(TipoMovimientoContable.D);
		linea.setConcepto("Prueba");
		linea.setCuenta(cuentaService.obtenerId("4000"));
		asiento.getLineas().add(linea);
		asientoService.crear(asiento);
		identificador=asiento.getId();
		assertNotNull("Existe el identificador", identificador);
	}
	
	@Test
	public void test003Recuperar(){
		final Asientos asiento = asientoService.obtenerId(identificador);
		assertEquals("Revisar la descricpción","Asiento de prueba",asiento.getDescripcion());
		assertEquals("Número de elementos",1,asiento.getLineas().size());
		assertEquals("Linea de importe",1000L,asiento.getLineas().get(0).getImporte().intValue());
		assertEquals("Concepto de la linea","Prueba",asiento.getLineas().get(0).getConcepto());
	}
	
	@Commit
	@Test
	public void test004eliminar(){
		final Asientos asiento = asientoService.obtenerId(identificador);
		assertNotNull("Existe el asiento", asiento);
		asientoService.eliminar(asiento);
	}
	
	@Test
	public void test005Recuperar(){
		final Asientos asiento = asientoService.obtenerId(identificador);
		assertNull("No se espera el asiento por que ha sido borrado.",asiento);
	}
}
