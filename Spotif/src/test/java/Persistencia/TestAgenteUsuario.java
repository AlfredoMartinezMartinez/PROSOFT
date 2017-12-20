package Persistencia;

import Dominio.Usuario;

import java.sql.*;
import java.util.Vector;

import static org.junit.Assert.*;

import org.junit.Before;
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

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test que devuelve verdadero si se ha introducido correctamente el usuario
	 * 
	 * @throws Exception
	 *             control de errores
	 * @throws SQLException
	 *             error sintaxis
	 */

	@Test
	public void testInsert() throws Exception{
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_1 = "INSERT INTO usuario VALUES('testNom','testApellido','testLog','testPass','testCorreo','testRol')";
		int esperado = 1;
		int obtenido = mInstancia.insert(SQL_insert_1);
		assertTrue(esperado == obtenido);
	}

	@Test
	public void testInsert2() throws Exception {
		int expected=0;
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_2 = "Hola Test";
		int retorno=mInstancia.insert(SQL_insert_2);
		assertTrue(retorno==expected);
	}

	@Test
	public void testInsert3() throws Exception {
		int expected=0;
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_3 = "INSERT INTO usuario VALUES('testNom','testApellido','testLog','testPass','testCorreo','testRol')";
		int retorno=mInstancia.insert(SQL_insert_3);
		assertTrue(retorno==expected);
	}

	@Test(expected = SQLException.class)
	public void testInsert4() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_4 = null;
		mInstancia.insert(SQL_insert_4);
		fail("Para SQL nula la prueba debe pasar");
	}

	@Test
	public void testUpdate() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_1 = "UPDATE usuario SET nombre='testNom2',apellidos='testApe2' WHERE login='testLog'";
		int esperado = 1;
		int obtenido = mInstancia.update(SQL_update_1);
		assertTrue(esperado == obtenido);
	}

	@Test(expected = SQLException.class)
	public void testUpdate2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_2 = "Modifica nombre testNom por TestNom2";
		mInstancia.update(SQL_update_2);
		fail("Para SQL con sintaxis incorrecta la prueba debe pasar");
	}
	
	@Test(expected = SQLException.class)
	public void testUpdate3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_3 = null;
		mInstancia.update(SQL_update_3);
		fail("Para SQL nula la prueba debe pasar");
	}


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
	
	
	@Test(expected = SQLException.class)
	public void testSelect2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_2 = "Dame los datos de 456";
		mInstancia.update(SQL_select_2);
		fail("Para sintaxis incorrecta la prueba debe pasar");
	}
	
	
	@Test(expected = SQLException.class)
	public void testSelect3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_3 = null;
		mInstancia.update(SQL_select_3);
		fail("Para SQL nula la prueba debe pasar");
	}

	@Test
	public void testZDelete() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM `spotif`.`usuario` WHERE `login`='testLog';";
		int esperado = 1;
		int obtenido = mInstancia.delete(SQL_delete_1);
		assertTrue(esperado == obtenido);
	}

	@Test(expected = SQLException.class)
	public void testZDelete2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_2 = "Adios Test";
		mInstancia.delete(SQL_delete_2);
		fail("Para Sintaxis incorrecta la prueba debe pasar");

	}
	@Test(expected = SQLException.class)
	public void testZDelete3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_3 = null;
		mInstancia.delete(SQL_delete_3);
		fail("Para SQL nula la prueba debe pasar");

	}


}
