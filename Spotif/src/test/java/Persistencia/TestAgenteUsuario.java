package Persistencia;

import Dominio.Usuario;

import java.sql.*;
import java.util.Vector;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;

/**
 * 
 * @author Prosoft
 * @version 2.1
 * 
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAgenteUsuario {

	/**
	 * Test que devuelve verdadero si se ha introducido correctamente el usuario
	 * 
	 * @throws Exception
	 *             control de errores
	 * 
	 */

	@Test
	public void testInsert() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_1 = "INSERT INTO usuario VALUES('testNom','testApellido','testLog','testPass','testCorreo','testRol')";
		int esperado = 1;
		int obtenido = mInstancia.insert(SQL_insert_1);
		assertTrue(esperado == obtenido);
	}

	/**
	 * Test que devuelve verdadero si hay un error en la sintaxis de la sentencia
	 * SQL. Error recogido en el código de la clase AgenteUsuario con try-catch
	 * 
	 * @throws Exception
	 *             control de errores
	 */
	@Test
	public void testInsert2() throws Exception {
		int expected = 0;
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_2 = "Hola Test";
		int retorno = mInstancia.insert(SQL_insert_2);
		assertTrue(retorno == expected);
	}

	/**
	 * Test que devuelve verdadero si el usuario ya está en la BBDD. Error recogido
	 * en el código de la clase AgenteUsuario con try-catch
	 * 
	 * @throws Exception
	 *             control de errores
	 * 
	 */

	@Test
	public void testInsert3() throws Exception {
		int expected = 0;
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_3 = "INSERT INTO usuario VALUES('testNom','testApellido','testLog','testPass','testCorreo','testRol')";
		int retorno = mInstancia.insert(SQL_insert_3);
		assertTrue(retorno == expected);
	}

	/**
	 * Test que devuelve verdadero si el el resultado de introducir una cadena
	 * "null" da como resultado SQLException
	 * 
	 * @throws Exception
	 *             control de errores
	 */

	@Test(expected = SQLException.class)
	public void testInsert4() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_4 = null;
		mInstancia.insert(SQL_insert_4);
	}

	/**
	 * Test que devuelve verdadero si hay un error en la sintaxis de la sentencia
	 * SQL. Error recogido en el código de la clase AgenteUsuario con try-catch
	 * 
	 * @throws Exception
	 *             control de errores
	 */
	@Test
	public void testInsert5() throws Exception {
		int expected = 0;
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_2 = "";
		int retorno = mInstancia.insert(SQL_insert_2);
		assertTrue(retorno == expected);
	}

	/**
	 * Test que devuelve verdadero si se ha actualizado bien un usuario de la BBDD
	 * 
	 * @throws Exception
	 *             control de errores
	 */
	@Test
	public void testUpdate() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_1 = "UPDATE usuario SET nombre='testNom2',apellidos='testApe2' WHERE login='testLog'";
		int esperado = 1;
		int obtenido = mInstancia.update(SQL_update_1);
		assertTrue(esperado == obtenido);
	}

	/**
	 * Test que devuelve verdadero si se produce un error de sentencia SQL
	 * 
	 * @throws Exception
	 *             control de errores
	 */
	@Test(expected = SQLException.class)
	public void testUpdate2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_2 = "Modifica nombre testNom por TestNom2";
		mInstancia.update(SQL_update_2);
	}

	/**
	 * Test que devuelve verdadero si se produce un error de sentencia SQL
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testUpdate3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_3 = "";
		mInstancia.update(SQL_update_3);
	}

	/**
	 * Test que devuelve verdadero si se produce un error por sentencia SQL con
	 * valor "null"
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testUpdate4() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_3 = null;
		mInstancia.update(SQL_update_3);
	}

	/**
	 * Test que devuelve verdadero si devuelve los mismos datos indicados en el
	 * Usuario esperado. Gracias por enseñarnos la creacion del metodo equals en 2
	 * segundos.Muy util
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test
	public void testSelect() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_1 = "SELECT * FROM usuario WHERE login='testLog'";
		Usuario expected = new Usuario("testNom", "testApellido", "testLog", "testPass", "testCorreo", "testRol");
		Usuario u = null;
		Vector<Object> aux = null;
		Vector<Object> res = mInstancia.select(SQL_select_1);
		if (res.size() == 1) {
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1), (String) aux.elementAt(2),
					(String) aux.elementAt(3), (String) aux.elementAt(4), (String) aux.elementAt(5));
		}
		assertTrue(expected.equals(u));

	}

	/**
	 * Test que devuelve verdadero si hay un error de sintaxis de sentencia SQL
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testSelect2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_2 = "Dame los datos de 456";
		mInstancia.update(SQL_select_2);
	}

	/**
	 * Test que devuelve verdadero si hay un error de sintaxis de sentencia SQL
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testSelect3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_3 = "";
		mInstancia.update(SQL_select_3);
	}

	/**
	 * Test que de devuelve verdadero si hay SQLException con una sentencia SQL null
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testSelect4() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_4 = null;
		mInstancia.update(SQL_select_4);
	}

	/**
	 * Test que devuelve verdadero si no hay datos con el statement enviado
	 * devolviendo 0 como tamaño del vector
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test
	public void testSelect5() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_1 = "SELECT * FROM usuario WHERE login='testLog2'";
		Usuario expected = new Usuario("testNom", "testApellido", "testLog", "testPass", "testCorreo", "testRol");
		Usuario u = null;
		Vector<Object> aux = null;
		Vector<Object> res = mInstancia.select(SQL_select_1);

		assertTrue(res.size() == 0);

	}

	/**
	 * Test que devuelve verdadero si el usuario se ha borrado de la BBDD
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test
	public void testZDelete() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM `spotif`.`usuario` WHERE `login`='testLog';";
		int esperado = 1;
		int obtenido = mInstancia.delete(SQL_delete_1);
		assertTrue(esperado == obtenido);
	}

	/**
	 * Test que devuelve verdadero si hay error de sintaxis SQL
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testZDelete2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_2 = "Adios Test";
		mInstancia.delete(SQL_delete_2);
	}

	/**
	 * Test que devuelve verdadero si hay error de sintaxis SQL
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testZDelete3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_3 = "Adios Test";
		mInstancia.delete(SQL_delete_3);

	}

	/**
	 * Test que devuelve verdadero si hay error por sentencia SQL "null"
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	@Test(expected = SQLException.class)
	public void testZDelete4() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_4 = null;
		mInstancia.delete(SQL_delete_4);

	}

}
