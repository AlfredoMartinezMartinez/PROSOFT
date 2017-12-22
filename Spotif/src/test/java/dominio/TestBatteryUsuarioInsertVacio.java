package dominio;

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

import dominio.Usuario;
import persistencia.AgenteUsuario;

/**
 * 
 * @author Prosoft
 * @version 2.1
 *
 */
@RunWith(Parameterized.class)
public class TestBatteryUsuarioInsertVacio {

	private String nombre;
	private String apellidos;
	private String login;
	private String pass;
	private String correo;
	private String rol;

	public TestBatteryUsuarioInsertVacio(String nombre, String apellidos, String login, String pass, String correo,
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
	 * Bateria de pruebas con distintos usuarios que incluyen cadena vacia
	 * 
	 * @return collecion de usuarios
	 * 
	 */

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { 
				{ "", "testApe", "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "", "testLog", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "", "testPass", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", "", "testCorreo", "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", "", "testRol" },
				{ "testNombre", "testApe", "testLog", "testPass", "testCorreo", "" }, });
	}

	/**
	 * pasa el test si no introduce los usuarios de la bateria de pruebas en BBDD
	 * 
	 * @throws Exception
	 *             Control de errores
	 *             
	 */
	@Test
	public void testInsert() throws Exception {
		assertEquals(0, Usuario.insert(nombre, apellidos, login, pass, correo, rol));

	}
}
