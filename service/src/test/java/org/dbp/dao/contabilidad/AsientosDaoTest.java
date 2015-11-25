package org.dbp.dao.contabilidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.dbp.bom.contabilidad.Asientos;
import org.dbp.bom.contabilidad.enums.TipoMovimientoContable;
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
public class AsientosDaoTest {

	@Autowired private AsientosDao asientosDao;
	
	@Test
	public void testObtenerId(){
		final Asientos asiento= asientosDao.obtenerId(1L);
		assertEquals("Esperamos el ID:",Long.valueOf(1L),asiento.getId());
		assertEquals("Esperamo la descripción:","prueba1",asiento.getDescripcion());
		assertEquals("Número de asientos",2,asiento.getLineas().size());
		assertEquals("linea 1 Id",Long.valueOf(1L),asiento.getLineas().get(0).getId());
		assertEquals("linea 1 Tipo",TipoMovimientoContable.H,asiento.getLineas().get(0).getTipoMovimientoContable());
		assertEquals("linea 2 Id",Long.valueOf(2L),asiento.getLineas().get(1).getId());
		assertEquals("linea 1 Tipo",TipoMovimientoContable.D,asiento.getLineas().get(1).getTipoMovimientoContable());
	}
	@Test
	public void testObtenerTodos(){
		final List<Asientos> asientos = asientosDao.obtenerTodos();
		assertEquals("Se esperan n elementos",2,asientos.size());
		assertEquals("Esperamos el ID :",Long.valueOf(1L),asientos.get(0).getId());
		assertEquals("Esperamo la descripción :","prueba1",asientos.get(0).getDescripcion());

		assertEquals("Esperamos el Id",Long.valueOf(2L),asientos.get(1).getId());
		assertEquals("Esperamo la descripción ","prueba2",asientos.get(1).getDescripcion());
	}
	@Test
	public void testEliminar(){
		asientosDao.eliminar(asientosDao.obtenerId(1L));
		assertNull("No esperamos encontrar el elemento 1", asientosDao.obtenerId(1L));
		final Asientos asiento=asientosDao.obtenerId(2L);
		assertEquals("Esperamos el ID ",Long.valueOf(2L),asiento.getId());
		assertEquals("Esperamo la descripción ","prueba2",asiento.getDescripcion());
		asientosDao.eliminar(asientosDao.obtenerId(2L));
		assertNull("No esperamos encontrar el elemento 2", asientosDao.obtenerId(2L));
	}
	
	@Test
	public void testCrear(){
		final Asientos asiento = new Asientos();
		asiento.setDescripcion("david");
		asientosDao.crear(asiento);
		final Long identificador=asiento.getId();
		assertEquals("Esperamos que tenemos el núevo elemento",3,asientosDao.obtenerTodos().size());
		final Asientos resultado=asientosDao.obtenerId(identificador);
		assertEquals("Esperamos el ID",identificador,resultado.getId());
		assertEquals("Esperamo la descripción","david",resultado.getDescripcion());
	}
	@Test
	public void testActualizar(){
		Asientos asiento= asientosDao.obtenerId(1L);
		assertEquals("Esperamos el ID",Long.valueOf(1L),asiento.getId());
		assertEquals("Esperamo la descripción","prueba1",asiento.getDescripcion());
		asiento.setDescripcion("perico");
		asientosDao.actualizar(asiento);
		asiento= asientosDao.obtenerId(1L);
		assertEquals("Esperamos el ID",Long.valueOf(1L),asiento.getId());
		assertEquals("Esperamo la descripción","perico",asiento.getDescripcion());
	}
	
}
