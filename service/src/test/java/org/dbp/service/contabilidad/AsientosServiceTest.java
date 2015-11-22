package org.dbp.service.contabilidad;

import static org.junit.Assert.*;

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
	
	@Test
	public void test001Buscar(){
		Asientos asiento=asientoService.obtenerId(1L);
		assertEquals("Id",new Long(1),asiento.getId());
	}
	@Commit
	@Test
	public void test002Crear(){
		Asientos asiento = new Asientos();
		asiento.setDescripcion("Asiento de prueba");
		asiento.setLineas(new ArrayList<LineasAsiento>());
		LineasAsiento linea=new LineasAsiento();
		linea.setAsiento(asiento);
		linea.setImporte(BigDecimal.valueOf(1000));
		linea.setTipoMovimientoContable(TipoMovimientoContable.D);
		linea.setConcepto("Prueba");
		linea.setCuenta(cuentaService.obtenerId("4000"));
		asiento.getLineas().add(linea);
		asientoService.crear(asiento);
		System.out.println("eco");
	}

	@Test
	public void test003Recuperar(){
		Asientos asiento = asientoService.obtenerId(1001L);
		assertEquals("Revisar la descricpción","Asiento de prueba",asiento.getDescripcion());
		assertEquals("Número de elementos",1,asiento.getLineas().size());
		assertEquals("Linea de importe",1000L,asiento.getLineas().get(0).getImporte().intValue());
		assertEquals("Concepto de la linea","Prueba",asiento.getLineas().get(0).getConcepto());
	}
	@Commit
	@Test
	public void test004eliminar(){
		asientoService.eliminar(asientoService.obtenerId(1001L));
	}
	
	@Test
	public void test005Recuperar(){
		Asientos asiento = asientoService.obtenerId(1001L);
		assertNull("No se espera el asiento por que ha sido borrado.",asiento);
	}
}
