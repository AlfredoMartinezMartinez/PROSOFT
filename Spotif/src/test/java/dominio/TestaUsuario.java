package dominio;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import dominio.Usuario;
import persistencia.AgenteUsuario;

import org.junit.FixMethodOrder;

/**
 * 
 * @author Prosoft
 * @version 2.1
 * 
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestaUsuario {
	
	/**
	 * test que da como verdadero si el usuario esperado es el mismo que el usuario
	 * leido con login y password; True True = True
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testRead() throws Exception {
		Usuario expected = new Usuario("alfredo", "martinez", "1234", "5678", "alfred@gmasd.com", "usuario");
		Usuario obtenido = Usuario.read("1234", "5678");
		assertEquals(expected, obtenido);
	}

	/**
	 * test que da como verdadero si no existe el password;usuario devuelto igual a
	 * null True False = False
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testRead2() throws Exception {
		Usuario expected = null;
		Usuario obtenido = Usuario.read("1234", "error");
		assertEquals(expected, obtenido);

	}

	/**
	 * test que da como verdadero si no existe el login;usuario devuelto igual a
	 * null True False = False
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testRead3() throws Exception {
		Usuario expected = null;
		Usuario obtenido = Usuario.read("error", "5678");
		assertEquals(expected, obtenido);

	}

	/**
	 * test que da como verdadero si no existe el login ni el password;usuario
	 * devuelto igual a null False False = False
	 * 
	 * @throws Exception
	 *             control de excepciones
	 */
	@Test
	public void testRead4() throws Exception {
		Usuario expected = null;
		Usuario obtenido = Usuario.read("error", "error");
		assertEquals(expected, obtenido);

	}

	/**
	 * test que da verdadero si se inserta correctamente un usuario en la BBDD
	 * 
	 * @throws Exception
	 *             Control de Excepciones
	 */
	@Test
	public void testZInsert() throws Exception {
		int expected = 1;
		int obtenido = Usuario.insert("testNom", "testApellido", "testLog", "testPass", "testCorreo", "testRol");
		assertTrue(expected == obtenido);

	}

	/**
	 * Test que da verdadero si se intenta insertar un cliente que existe
	 * 
	 * @throws Exception
	 *             Control de excepciones
	 */
	@Test
	public void testZInsert2() throws Exception {
		int expected = 0;
		int obtenido = Usuario.insert("testNom", "testApellido", "testLog", "testPass", "testCorreo", "testRol");

		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM `spotif`.`usuario` WHERE `login`='testLog';";
		mInstancia.delete(SQL_delete_1);

		assertTrue(expected == obtenido);

	}

}
