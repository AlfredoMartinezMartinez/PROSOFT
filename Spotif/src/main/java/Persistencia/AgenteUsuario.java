package Persistencia;

import java.sql.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

import java.util.List;

/**
 * Clase que implementa los metodos necesarios para relacionar a los usuarios
 * con la BBDD
 * 
 * @author PROSOFT
 *
 */
public class AgenteUsuario {
	protected static AgenteUsuario mInstancia = null;
	protected static Connection mBD;
	private static String url = "jdbc:mysql://localhost:3307/spotif?user=root&password=root";
	private static String driver = "com.mysql.jdbc.Driver";

	private AgenteUsuario() throws Exception {
		conectar();

	}

	/**
	 * Metodo que implementa el patron singleton, el cual permite de una clase solo
	 * haya una instancia.
	 * 
	 * @return mInstancia Instancia de Agente Usuario
	 * @throws Exception
	 *             Control de Errores
	 */
	public static AgenteUsuario getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new AgenteUsuario();
		}
		return mInstancia;
	}

	/**
	 * Metodo que realiza la conexion con la BBDD.
	 * 
	 * @throws Exception
	 *             Control de Errores
	 */
	private void conectar() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url);
	}

	/**
	 * Metodo que realiza la desconexion con la BBDD.
	 * 
	 * @throws Exception
	 *             Control de Errores
	 */
	public void desconectar() throws Exception {
		mBD.close();
	}

	/**
	 * Metodo para realizar una insercion en la base de datos
	 * 
	 * @param SQL
	 *            Intruccion SQL de insercion de usuario
	 * @return res Parametro del resultado de la insercion
	 * @throws SQLException
	 *             Control de Errores SQL
	 * @throws Exception
	 *             Control de Errores
	 */
	public int insert(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
			stmt.close();
			desconectar();

		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("cliente existe");
			} 
			if(e instanceof SQLSyntaxErrorException) {
				System.out.println("Error de sintaxis");
			}
		}
		return res;
	}

	/**
	 * Metodo para realizar una eliminacion en la base de datos
	 * 
	 * @param SQL
	 *            Instruccion SQL de borrado
	 * @return res Resultado de la ejecucion SQL
	 * @throws SQLException
	 *             Control de Errores SQL
	 * @throws Exception
	 *             Control de Errores
	 */
	public int delete(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	/**
	 * Metodo para realizar una actualizacion en la base de datos
	 * 
	 * @param SQL
	 *            Instruccion SQL de actualizacion
	 * @return Resultado de la ejecucion SQL
	 * @throws SQLException
	 *             Control de Errores SQL
	 * @throws Exception
	 *             Control de Errores
	 */
	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	/**
	 * Metodo que lee un usuario de la BBDD
	 * 
	 * @param SQL
	 *            Instruccion SQL de lectura
	 * @return vec Vector de vectores, donde cada uno de los vectores que contiene
	 *         el vector principal representa los registros que se recuperan de la
	 *         base de datos.
	 * @throws SQLException
	 *             Control de Errores SQL
	 * @throws Exception
	 *             Control de Errores
	 */
	public Vector<Object> select(String SQL) throws SQLException, Exception {
		PreparedStatement select = mBD.prepareStatement(SQL);
		ResultSet s = select.executeQuery();
		Vector<Object> vec = new Vector<Object>();
		Vector<Object> auxiliar;
		while (s.next()) {
			auxiliar = new Vector<Object>();
			auxiliar.add((String) s.getString("nombre"));
			auxiliar.add((String) s.getString("apellidos"));
			auxiliar.add((String) s.getString("login"));
			auxiliar.add((String) s.getString("password"));
			auxiliar.add((String) s.getString("correo"));
			auxiliar.add((String) s.getString("tipo"));
			vec.add((Vector) auxiliar);

		}
		s.close();
		return vec;
	}

}