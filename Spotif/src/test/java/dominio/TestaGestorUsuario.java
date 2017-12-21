package dominio;

import static org.junit.Assert.*;

import org.junit.Test;
import java.sql.SQLException;
import org.junit.runners.MethodSorters;

import persistencia.AgenteUsuario;

import org.junit.FixMethodOrder;

/**
 * 
 * @author Prosoft
 * @version 2.1
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestaGestorUsuario {

	/**
	 * Test que pasa si el resultado es true si se inserta un cliente que no existe
	 * 
	 * @throws Exception
	 *             Control de excepciones
	 */
	@Test
	public void testZCrearUsuario1() throws Exception {
		boolean expected = true;
		boolean obtenido = GestorUsuario.crearUsuario("testNom", "testApellido", "testLog", "testPass", "testCorreo",
				"testRol");
		assertTrue(expected == obtenido);

	}

	/**
	 * Test que pasa si el resultado es false si se intenta insertar un cliente que
	 * existe
	 * 
	 * @throws Exception
	 *             Control de excepciones
	 */
	@Test
	public void testZCrearUsuario2() throws Exception {
		boolean expected = false;
		boolean obtenido = GestorUsuario.crearUsuario("testNom", "testApellido", "testLog", "testPass", "testCorreo",
				"testRol");

		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM `spotif`.`usuario` WHERE `login`='testLog';";
		mInstancia.delete(SQL_delete_1);

		assertTrue(expected == obtenido);

	}
	
	/**
	 * test que pasa si obtenemos un login correcto
	 * True True = True
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testLogin1() throws Exception {
		boolean expected = true;
		boolean obtenido = GestorUsuario.login("1234", "5678");
		assertEquals(expected, obtenido);
	}
	
	/**
	 * test que pasa si obtenemos un login incorrecto
	 * True False = False
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testLogin2() throws Exception {
		boolean expected = false;
		boolean obtenido = GestorUsuario.login("1234", "error");
		assertEquals(expected, obtenido);
	}
	
	/**
	 * test que pasa si obtenemos un login incorrecto
	 * False True = False
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testLogin3() throws Exception {
		boolean expected = false;
		boolean obtenido = GestorUsuario.login("1234", "error");
		assertEquals(expected, obtenido);
	}
	
	/**
	 * test que pasa si obtenemos un login incorrecto
	 * False False = False
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testLogin4() throws Exception {
		boolean expected = false;
		boolean obtenido = GestorUsuario.login("error", "error");
		assertEquals(expected, obtenido);
	}
	
	@Test
	public void testTipo1() throws Exception{
		String expected="usuario";
		String obtenido=GestorUsuario.tipo("1234", "5678");		
		assertEquals(expected,obtenido);				
	}
	@Test
	public void testTipo2() throws Exception{
		String expected="admin";
		String obtenido=GestorUsuario.tipo("1234", "5678");		
		assertNotEquals(expected,obtenido);				
	}
	
	@Test
	public void testTipo3() throws Exception{
		String expected="admin";
		String obtenido=GestorUsuario.tipo("admin", "admin");		
		assertEquals(expected,obtenido);				
	}
	@Test(expected=NullPointerException.class)
	public void testTipo4() throws Exception{		
		String obtenido=GestorUsuario.tipo("error", "5678");	
		System.out.println(obtenido);					
	}
	

}
