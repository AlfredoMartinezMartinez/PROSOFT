package Persistencia;

import java.sql.SQLException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAgenteUsuario {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAgente() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		//
		assertTrue(mInstancia != null);
	}

	@Test
	public void testInsert() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_1 = "INSERT INTO usuario VALUES('testNom','testApellido','testLog','testPass','testCorreo','testRol')";
		int esperado = 1;
		int obtenido = mInstancia.insert(SQL_insert_1);
		assertTrue(esperado == obtenido);
	}

	@Test
	public void testInsert2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_2 = "Hola Test";
		try {
			mInstancia.insert(SQL_insert_2);

		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testUpdate() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_1 = "UPDATE usuario SET nombre='testNom2',apellidos='testApe2' WHERE login='testLog'";
		int esperado = 1;
		int obtenido = mInstancia.update(SQL_update_1);
		assertTrue(esperado == obtenido);
	}

	@Test
	public void testUpdate2() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_update_2 = "Modifica nombre testNom por TestNom2";
		try {
			mInstancia.update(SQL_update_2);

		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testDelete() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM usuario WHERE login='testLog'";
		int esperado = 1;
		int obtenido = mInstancia.delete(SQL_delete_1);
		assertTrue(esperado == obtenido);
	}

	@Test
	public void testDelete2() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_2 = "Adios Test";
		try {
			mInstancia.delete(SQL_delete_2);

		} catch (Exception e) {
			assertTrue(true);
		}

	}

	/*
	 * @Test public void testSelect() { fail("Not yet implemented"); // TODO }
	 * 
	 * 
	 * @Test public void testDesconectar() { fail("Not yet implemented"); // TODO }
	 */

}
