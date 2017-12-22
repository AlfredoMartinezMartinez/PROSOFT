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
public class TestBatGestUserInsNull {
	private String nombre;
	private String apellidos;
	private String login;
	private String pass;
	private String correo;
	private String rol;

	public TestBatGestUserInsNull(String nombre, String apellidos, String login, String pass, String correo,
			String rol) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.pass = pass;
		this.correo = correo;
		this.rol = rol;
	}

	/**
	 * 
	 * Bateria de pruebas con distintos usuarios que incluyen null en algun
	 * parametro
	 * 
	 * @return collecion de usuarios
	 * 
	 */
	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { null, "testApe", "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", null, "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", null, "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", null, "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", null, "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", "testCorreo", null }, });
	}

	/**
	 * 
	 * pasa el test si da como resultado una excepcion
	 * 
	 * @throws Exception
	 *             Control de errores
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testInsert() throws Exception {
		GestorUsuario.crearUsuario(nombre, apellidos, login, pass, correo, rol);

	}

}
