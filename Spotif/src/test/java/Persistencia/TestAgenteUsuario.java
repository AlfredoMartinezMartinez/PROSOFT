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
		} catch (SQLException e) {
			//
		}

	}

	@Test
	public void testInsert3() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_insert_3 = "INSERT INTO usuario VALUES('testNom','testApellido','testLog','testPass','testCorreo','testRol')";
		try {
			mInstancia.insert(SQL_insert_3);
		} catch (SQLException e) {
			//
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
	public void testSelect() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_select_1 = "SELECT * FROM usuario WHERE login='testLog'";
		Usuario expected=new Usuario("testNom","testApellido","testLog","testPass","testCorreo","testRol");
		Usuario u = null;
		Vector<Object> aux = null;
		Vector<Object> res = mInstancia.select(SQL_select_1);
		if (res.size() == 1) {
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1), (String) aux.elementAt(2),
					(String) aux.elementAt(3), (String) aux.elementAt(4), (String) aux.elementAt(5));
		}
	/*	assertTrue(u.get.equals("testNom") && u.getApellidos().equals("testApellido")
				&& u.getPassword().equals("testPass") && u.getNombre_usuario().equals("testLog")
				&& u.getCorreo().equals("testCorreo") && u.getRol().equals("testRol"));*/
		assertTrue(u.equals(expected));

	}

	@Test
	public void testZDelete() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM `spotif`.`usuario` WHERE `login`='testLog';";
		int esperado = 1;
		int obtenido = mInstancia.delete(SQL_delete_1);
		assertTrue(esperado == obtenido);
	}

	@Test
	public void testZDelete2() throws Exception, SQLException {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_2 = "Adios Test";
		try {
			mInstancia.delete(SQL_delete_2);

		} catch (Exception e) {
			assertTrue(true);
		}

	}

	/*
	 * 
	 * 
	 * 
	 * @Test public void testDesconectar() { fail("Not yet implemented"); // TODO }
	 */

}
