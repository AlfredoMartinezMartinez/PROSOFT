package Dominio;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Persistencia.AgenteUsuario;

@RunWith(Parameterized.class)
public class TestUsuarioInsertNull {
	private String nombre;
	private String apellidos;
	private String login;
	private String pass;
	private String correo;
	private String rol;

	public TestUsuarioInsertNull(String nombre, String apellidos, String login, String pass, String correo,
			String rol) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.pass = pass;
		this.correo = correo;
		this.rol = rol;
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { null, "testApe", "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", null, "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", null, "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", null, "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", null, "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", "testCorreo", null }, });
	}

	@Test(expected = NullPointerException.class)
	public void testInsert() throws Exception {
		Usuario.insert(nombre, apellidos, login, pass, correo, rol);

	}

}
