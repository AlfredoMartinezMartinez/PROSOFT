package dominio;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBatGestUserInsVacio {

	private String nombre;
	private String apellidos;
	private String login;
	private String pass;
	private String correo;
	private String rol;

	public TestBatGestUserInsVacio(String nombre, String apellidos, String login, String pass, String correo,
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
		return Arrays.asList(new Object[][] { { "", "testApe", "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "", "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", "", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", "", "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", "testCorreo", "" },
				});
	}

	@Test
	public void testInsert() throws Exception {
		assertEquals(false, GestorUsuario.crearUsuario(nombre, apellidos, login, pass, correo, rol));

	}

}
