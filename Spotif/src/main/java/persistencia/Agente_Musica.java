package persistencia;

import java.sql.*;

/**
 * Clase que implementa los metodos necesarios para relacionar a la musica con la BBDD
 * 
 * @author PROSOFT
 *
 */
public class Agente_Musica {
	protected static Agente_Musica mInstancia = null;
	protected static Connection mBD;
	private static String url = "jdbc:mysql://localhost:3307/spotif?user=root&password=root";
	private static String driver = "com.mysql.jdbc.Driver";

	private Agente_Musica() throws Exception {
		conectar();
	}

	/**
	 * Metodo que implementa el patron singleton, el cual permite de una clase solo
	 * haya una instancia.
	 * 
	 * @return mInstancia
	 * @throws Exception Control de Errores
	 */
	public static Agente_Musica getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new Agente_Musica();
		}
		return mInstancia;
	}

	/**
	 * Metodo que realiza la conexion con la BBDD
	 * 
	 * @throws Exception Control de Errores
	 */
	private void conectar() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url);
	}

	/**
	 * Metodo que realiza la desconexion con la BBDD.
	 * 
	 * @throws Exception Control de Errores
	 */
	public void desconectar() throws Exception {
		mBD.close();
	}

}