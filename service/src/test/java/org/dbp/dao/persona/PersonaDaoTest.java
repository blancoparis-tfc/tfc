package org.dbp.dao.persona;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.dbp.bom.personas.DatosDeContacto;
import org.dbp.bom.personas.Direccion;
import org.dbp.bom.personas.Persona;
import org.dbp.bom.personas.enums.TipoDeIdentificadorFiscal;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.dao.personas.PersonaDao;
import org.dbp.service.personas.localizacion.MunicipioService;
import org.dbp.service.personas.localizacion.PaisService;
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
public class PersonaDaoTest {

	@Autowired private PersonaDao personaDao;
	@Autowired private PaisService paisService;
	@Autowired private MunicipioService municipioService;
	
	private static Long idDelPersona;
	
	/**
	 * Vanos a crear una persona con los datos minimos.
	 */
	@Commit
	@Test
	public void test001CrarUnUsuario(){
		final Persona persona = datosBasicosDeLaCreacionDeLaPersona();
		personaDao.crear(persona);
		assertNotNull("Es espera un id",persona.getId());
		idDelPersona=persona.getId();
	}

	private Persona datosBasicosDeLaCreacionDeLaPersona() {
		final Persona persona = new Persona();
		persona.setIdentificadorFiscal("1111111F");
		persona.setTipoIdentificadorFiscal(TipoDeIdentificadorFiscal.DNI);
		persona.setMunicipio(municipioService.obtenerId(1L));
		persona.setPais(paisService.obtenerId("ES"));
		return persona;
	}
	
	@Commit
	@Test
	public void test002AssertElUsuarioEliminarlo(){
		final Persona persona = personaDao.obtenerId(idDelPersona);
		assertEquals("IdentificadorFiscal","1111111F",persona.getIdentificadorFiscal());
		assertEquals("El tipo de ident4ifciador fiscal",TipoDeIdentificadorFiscal.DNI,persona.getTipoIdentificadorFiscal());
		assertTrue("No esperamos los datos de contacto",persona.getDatosDeContacto().isEmpty());
		assertTrue("No esperamos las dirrecciones",persona.getDireccion().isEmpty());
		assertEquals("El pais","ES",persona.getPais().getIdAlfa2());
		assertEquals("El municipio",Long.valueOf(1L),persona.getMunicipio().getId());
		personaDao.eliminar(persona);
	}
	
	@Test
	public void test003AssertEliminar(){
		final Persona persona = personaDao.obtenerId(idDelPersona);
		assertNull("No se espera el registro",persona);
	}
	
	// Prueba Crear los datos de contacto y dirección y ver que se persistan.
	@Commit
	@Test
	public void test004CrearLoConTodosLosDatos(){
		final Persona persona = datosBasicosDeLaCreacionDeLaPersona();
		final Set<DatosDeContacto> datosDeContacto = new HashSet<DatosDeContacto>();
		final DatosDeContacto datoDeContacto = new DatosDeContacto();
		datoDeContacto.setNombre("Perico el de los Palotes");
		datoDeContacto.setTelefono("913115512");
		datoDeContacto.setDireccionDeCorreo("prueba@gmail.com");
		datoDeContacto.setDireccion(new Direccion());
		datoDeContacto.getDireccion().setDireccion("C\\ pez");
		datosDeContacto.add(datoDeContacto);
		persona.setDatosDeContacto(datosDeContacto);
		personaDao.crear(persona);
		assertNotNull("Es espera un id",persona.getId());
		idDelPersona=persona.getId();
	}
	
	@Test
	public void test005AssertLosDatosDeConctacto(){
		final Persona persona = personaDao.obtenerId(idDelPersona);
		assertEquals("IdentificadorFiscal","1111111F",persona.getIdentificadorFiscal());
		assertEquals("El tipo de ident4ifciador fiscal",TipoDeIdentificadorFiscal.DNI,persona.getTipoIdentificadorFiscal());
		assertTrue("No esperamos las dirrecciones",persona.getDireccion().isEmpty());
		assertEquals("El pais","ES",persona.getPais().getIdAlfa2());
		assertEquals("El municipio",Long.valueOf(1L),persona.getMunicipio().getId());
		assertEquals(" Se esperan los datos de contacto",1,persona.getDatosDeContacto().size());
		final DatosDeContacto datoDeContacto=persona.getDatosDeContacto().stream().findAny().get();
		assertEquals("El nombre del contacto","Perico el de los Palotes",datoDeContacto.getNombre());
		assertEquals("Telefono","913115512",datoDeContacto.getTelefono());
		assertEquals("Direccion de correo","prueba@gmail.com",datoDeContacto.getDireccionDeCorreo());
		assertEquals("Direccion","C\\ pez",datoDeContacto.getDireccion().getDireccion());
	}
	@Commit
	@Test
	public void test006AddContacto(){
		final Persona persona = personaDao.obtenerId(idDelPersona);
		final Direccion direccion = new Direccion();
		direccion.setDireccion("C\\ pez");
		persona.getDireccion().add(direccion);
		personaDao.actualizar(persona);
		assertEquals("Los datos de la persona",1,persona.getDireccion().size());
	}
	@Commit
	@Test
	public void test007AsssertConElContacto(){
		final Persona persona = personaDao.obtenerId(idDelPersona);
		assertEquals("IdentificadorFiscal","1111111F",persona.getIdentificadorFiscal());
		assertEquals("El tipo de ident4ifciador fiscal",TipoDeIdentificadorFiscal.DNI,persona.getTipoIdentificadorFiscal());
		assertEquals("El pais","ES",persona.getPais().getIdAlfa2());
		assertEquals("El municipio",Long.valueOf(1L),persona.getMunicipio().getId());
		assertEquals(" Se esperan los datos de contacto",1,persona.getDatosDeContacto().size());
		final DatosDeContacto datoDeContacto=persona.getDatosDeContacto().stream().findAny().get();
		assertEquals("El nombre del contacto","Perico el de los Palotes",datoDeContacto.getNombre());
		assertEquals("Telefono","913115512",datoDeContacto.getTelefono());
		assertEquals("Direccion de correo","prueba@gmail.com",datoDeContacto.getDireccionDeCorreo());
		assertEquals("Direccion","C\\ pez",datoDeContacto.getDireccion().getDireccion());
		assertEquals("Direccion","C\\ pez",persona.getDireccion().stream().findAny().get().getDireccion());
		personaDao.eliminar(persona);
	}

	@Test
	public void test008AssertEliminar(){
		final Persona persona = personaDao.obtenerId(idDelPersona);
		assertNull("No se espera el registro",persona);
	}
}