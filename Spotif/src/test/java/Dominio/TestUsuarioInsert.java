package Dominio;

import static org.junit.Assert.*;

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
public class TestUsuarioInsert {
	private String nombre;
	private String apellidos;
	private String login;
	private String pass;
	private String correo;
	private String rol;

	public TestUsuarioInsert(String nombre, String apellidos, String login, String pass, String correo, String rol) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.pass = pass;
		this.correo = correo;
		this.rol = rol;
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][]{
			{null,"testApe","testLog","testPass","testCorreo","testRol"},
			{"testNombre",null,"testLog","testPass","testCorreo","testRol"},
			{"testNombre","testApe",null,"testPass","testCorreo","testRol"},
			{"testNombre","testApe","testLog",null,"testCorreo","testRol"},
			{"testNombre","testApe","testLog","testPass",null,"testRol"},
			{"testNombre","testApe","testLog","testPass","testCorreo",null},
		});
	}

	@BeforeClass
	public static void inicia() {
		

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		AgenteUsuario mInstancia = AgenteUsuario.getAgente();
		String SQL_delete_1 = "DELETE FROM `spotif`.`usuario` WHERE `login`='testLog';";
		mInstancia.delete(SQL_delete_1);
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented"); // TODO
	}

}
