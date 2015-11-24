package org.dbp.dao.persona.localizacion;

import static org.junit.Assert.assertEquals;

import org.dbp.bom.personas.localizacion.Pais;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.dao.personas.localizacion.PaisDao;
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
public class PaisDaoTest {

	@Autowired private PaisDao dao;
	
	@Commit
	@Test
	public void test001ModificarValores(){
		final Pais pais = dao.obtenerId("AF");
		assertEquals("Alfa 3","AFG",pais.getCodAlfa3());
		assertEquals("Codigo númerico",Integer.valueOf(4),pais.getCodNumerico());
		assertEquals("Nombre comun","Afganistán",pais.getNombreComun()); //NOPMD
		assertEquals("Nombre oficial","Afganistán",pais.getNombreOficial());
		pais.setCodAlfa3("A");
		pais.setCodNumerico(1);
		pais.setNombreComun("NC");
		pais.setNombreOficial("NOF");
		dao.actualizar(pais);
	}
	@Test
	public void test002RevisarValores(){
		final Pais pais = dao.obtenerId("AF");
		assertEquals("Alfa 3","AFG",pais.getCodAlfa3());
		assertEquals("Codigo númerico",Integer.valueOf(4),pais.getCodNumerico());
		assertEquals("Nombre comun","Afganistán",pais.getNombreComun());
		assertEquals("Nombre oficial","Afganistán",pais.getNombreOficial());
	}
	
}
