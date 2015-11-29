package org.dbp.dao.persona;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.dbp.bom.personas.DatosDeContacto;
import org.dbp.bom.personas.DelegacionComercial;
import org.dbp.bom.personas.Direccion;
import org.dbp.bom.personas.PersonaJuridica;
import org.dbp.bom.personas.enums.TipoDeIdentificadorFiscal;
import org.dbp.core.conf.TestConfiguracion;
import org.dbp.dao.personas.PersonaJuridicaDao;
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
//@SuppressWarnings("PMD.TooManyMethods")
public class PersonaJuridicaDaoTest { //NOPMD

	private static final String DIRECCION_PRUEBA = "C\\ pez";
	@Autowired private PersonaJuridicaDao dao;
	@Autowired private PaisService paisService;
	@Autowired private MunicipioService municipioService;
	
	private static Long idDelPersona;
	private static Long idSubPersona;
	
	@Commit
	@Test
	public void test001CreacionUsuario(){
		final PersonaJuridica persona = crearPersonaJuridica();
		
		dao.crear(persona);
		assertNotNull("Es espera un id",persona.getId());
		idDelPersona=persona.getId();
	}


	
	@Test
	public void test002AssertCliente(){
		final PersonaJuridica persona = dao.obtenerId(idDelPersona);
		assertEmpresaMaestra(persona);
	}



	
	@Commit
	@Test
	public void test003CrearUnEmpresa(){
		final PersonaJuridica empresaMaestra = dao.obtenerId(idDelPersona);
		final PersonaJuridica persona = crearPersonaJuridica();
		persona.setNombreComercial("Empresa del grupo");
		persona.setNombreSocial("SubSl");
		persona.setEmpresaMaestra(empresaMaestra);
		dao.crear(persona);
		assertNotNull("Es espera un id",persona.getId());
		idSubPersona=persona.getId();
	}
	
	@Test
	public void test004assertSubEmpresa(){
		final PersonaJuridica persona = dao.obtenerId(idSubPersona);
		assertSubGrupo(persona);
		assertEmpresaMaestra(persona.getEmpresaMaestra());
		assertEquals("Mirar que esta en el subgrupo",persona,persona.getEmpresaMaestra().getSubGrupo().get(0));
	}

	@Commit
	@Test
	public void test005quitarLaEmpresa(){
		final PersonaJuridica persona = dao.obtenerId(idSubPersona);
		persona.setEmpresaMaestra(null);
		assertNull("No tiene empresa maestra",persona.getEmpresaMaestra());
		dao.actualizar(persona);
	}
	@Test
	public void test006assertSinEmpresa(){
		final PersonaJuridica persona = dao.obtenerId(idDelPersona);
		final PersonaJuridica subEmpresa = dao.obtenerId(idSubPersona);
		assertEmpresaMaestra(persona);
		assertSubGrupo(subEmpresa);
		assertTrue("Ya no tiene sub empresas",persona.getSubGrupo().isEmpty());
		assertNull("No tiene que tener Empresa",persona.getEmpresaMaestra());
	}
	
	
	@Commit
	@Test
	public void test007Eliminar(){
		final PersonaJuridica persona = dao.obtenerId(idDelPersona);
		assertNotNull("Se espera la persona juridica",persona);
		dao.eliminar(persona);
	}
	
	@Test
	public void test008ValidarQueSeHaBorradoCorrectamente(){
		assertNull("No se espera la persona fisica",dao.obtenerId(idDelPersona));
		final PersonaJuridica subEmpresa = dao.obtenerId(idSubPersona);
		assertSubGrupo(subEmpresa);
		assertNull("No tiene que tener Empresa",subEmpresa.getEmpresaMaestra());
	}
	
	@Commit
	@Test
	public void test009Eliminar(){
		final PersonaJuridica persona = dao.obtenerId(idSubPersona);
		assertNotNull("Se espera la persona juridica",persona);
		dao.eliminar(persona);
	}
	
	@Test
	public void test010ValidarQueSeHaBorradoCorrectamente(){
		assertNull("No se espera la persona fisica",dao.obtenerId(idDelPersona));
		assertNull("No se espera la persona fisica",dao.obtenerId(idSubPersona));
	}
	
	private PersonaJuridica datosBasicosDeLaCreacionDeLaPersona() {
		final PersonaJuridica persona = new PersonaJuridica();
		persona.setIdentificadorFiscal("1111111F");
		persona.setTipoIdentificadorFiscal(TipoDeIdentificadorFiscal.DNI);
		persona.setMunicipio(municipioService.obtenerId(1L));
		persona.setPais(paisService.obtenerId("ES"));
		return persona;
	}
	
	private PersonaJuridica crearPersonaJuridica() {
		final PersonaJuridica persona = datosBasicosDeLaCreacionDeLaPersona();
		final Set<DatosDeContacto> datosDeContacto = new HashSet<DatosDeContacto>();
		final DatosDeContacto datoDeContacto = new DatosDeContacto();
		datoDeContacto.setNombre("Perico el de los Palotes");
		datoDeContacto.setTelefono("913115512");
		datoDeContacto.setDireccionDeCorreo("prueba@gmail.com");
		datoDeContacto.setDireccion(new Direccion());
		datoDeContacto.getDireccion().setDireccion(DIRECCION_PRUEBA);
		datosDeContacto.add(datoDeContacto);
		final Direccion direccion = new Direccion();
		direccion.setDireccion(DIRECCION_PRUEBA);
		persona.setDatosDeContacto(datosDeContacto);
		persona.setDireccion(new HashSet<Direccion>());
		persona.getDireccion().add(direccion);
		persona.setNombreComercial("Perico");
		persona.setNombreSocial("El de los palotes");
		persona.setDelegacionesComerciales(new ArrayList<DelegacionComercial>());
		final DelegacionComercial delegacionComercial = new DelegacionComercial();
		delegacionComercial.setNombre("Delegacion comercial");
		delegacionComercial.setPersonaJuridica(persona);
		delegacionComercial.setDatosDeContacto(persona.getDatosDeContacto().stream().findAny().get());
		delegacionComercial.setDireccion(persona.getDireccion().stream().findFirst().get());
		persona.getDelegacionesComerciales().add(delegacionComercial);
		return persona;
	}
	
	private void assertEmpresaMaestra(final PersonaJuridica persona) {
		assertEquals("IdentificadorFiscal","1111111F",persona.getIdentificadorFiscal());
		assertEquals("El tipo de ident4ifciador fiscal",TipoDeIdentificadorFiscal.DNI,persona.getTipoIdentificadorFiscal());
		assertEquals("El pais","ES",persona.getPais().getIdAlfa2());
		assertEquals("El municipio",Long.valueOf(1L),persona.getMunicipio().getId());
		assertEquals(" Se esperan los datos de contacto",1,persona.getDatosDeContacto().size());
		final DatosDeContacto datoDeContacto=persona.getDatosDeContacto().stream().findAny().get();
		assertEquals("El nombre del contacto","Perico el de los Palotes",datoDeContacto.getNombre());
		assertEquals("Telefono","913115512",datoDeContacto.getTelefono());
		assertEquals("Direccion de correo","prueba@gmail.com",datoDeContacto.getDireccionDeCorreo());
		assertEquals("Direccion ",DIRECCION_PRUEBA,datoDeContacto.getDireccion().getDireccion());
		assertEquals("Direccion  ",DIRECCION_PRUEBA,persona.getDireccion().stream().findAny().get().getDireccion());
		assertEquals("Nombre","Perico",persona.getNombreComercial());
		assertEquals("Apellidos","El de los palotes",persona.getNombreSocial());
		final DelegacionComercial delegacionComercial = persona.getDelegacionesComerciales().stream().findFirst().get();
		assertEquals("Nombre de la delegación comercial","Delegacion comercial",delegacionComercial.getNombre());
		assertEquals("Ver que esta bien hecho el enlace",persona,delegacionComercial.getPersonaJuridica());
		assertEquals("Direccion   ",persona.getDireccion().stream().findFirst().get(),delegacionComercial.getDireccion());
		assertEquals("Datos de contacto",persona.getDatosDeContacto().stream().findFirst().get(),delegacionComercial.getDatosDeContacto());
	}
	
	private void assertSubGrupo(final PersonaJuridica persona) {
		assertEquals("IdentificadorFiscal","1111111F",persona.getIdentificadorFiscal());
		assertEquals("El tipo de ident4ifciador fiscal",TipoDeIdentificadorFiscal.DNI,persona.getTipoIdentificadorFiscal());
		assertEquals("El pais","ES",persona.getPais().getIdAlfa2());
		assertEquals("El municipio",Long.valueOf(1L),persona.getMunicipio().getId());
		assertEquals(" Se esperan los datos de contacto",1,persona.getDatosDeContacto().size());
		final DatosDeContacto datoDeContacto=persona.getDatosDeContacto().stream().findAny().get();
		assertEquals("El nombre del contacto","Perico el de los Palotes",datoDeContacto.getNombre());
		assertEquals("Telefono","913115512",datoDeContacto.getTelefono());
		assertEquals("Direccion de correo","prueba@gmail.com",datoDeContacto.getDireccionDeCorreo());
		assertEquals("Direccion",DIRECCION_PRUEBA,datoDeContacto.getDireccion().getDireccion());
		assertEquals("Direccion",DIRECCION_PRUEBA,persona.getDireccion().stream().findAny().get().getDireccion());
		assertEquals("nombre comercial","Empresa del grupo",persona.getNombreComercial());
		assertEquals("nombre social","SubSl",persona.getNombreSocial());
		final DelegacionComercial delegacionComercial = persona.getDelegacionesComerciales().stream().findFirst().get();
		assertEquals("Nombre de la delegación comercial","Delegacion comercial",delegacionComercial.getNombre());
		assertEquals("Ver que esta bien hecho el enlace",persona,delegacionComercial.getPersonaJuridica());
		assertEquals("Direccion",persona.getDireccion().stream().findFirst().get(),delegacionComercial.getDireccion());
		assertEquals("Datos de contacto",persona.getDatosDeContacto().stream().findFirst().get(),delegacionComercial.getDatosDeContacto());
	}
}
