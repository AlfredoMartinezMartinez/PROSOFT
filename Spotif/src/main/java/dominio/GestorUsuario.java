package dominio;

/**
 * Clase que se encarga de la gestion de los usuarios.
 * 
 * @author PROSOFT
 *
 */
public class GestorUsuario {

	/**
	 * Metodo que se encarga de la creacion de un usuario
	 * 
	 * @param nombre
	 *            Atributo para el nombre de usuario tipo cadena
	 * @param apellidos
	 *            Atributo para los apellidos del usuario tipo cadena
	 * @param login
	 *            Atributo para el login del usuario tipo cadena
	 * @param pass
	 *            Atributo para el pass del usuario tipo cadena
	 * @param correo
	 *            Atributo para el correo del usuario tipo cadena
	 * @param rol
	 *            Atributo que indica el rol de usuario tipo cadena
	 * @return registrado Devuelve true si se ha creado bien
	 * 
	 * @throws Exception
	 *             Control de errores
	 */
	public static boolean crearUsuario(String nombre, String apellidos, String login, String pass, String correo,
			String rol) throws Exception {
		boolean registrado = false;
		int t = Usuario.insert(nombre, apellidos, login, pass, correo, rol);
		if (t == 1)
			registrado = true;

		return registrado;

	}

	/**
	 * Metodo que se encarga de logear al usuario, comprobando para ello si el
	 * nombre de usuario y la password son correctas
	 * 
	 * @param nombreUsuario
	 *            Atributo para el nombre de usuario tipo cadena
	 * @param password
	 *            Atributo para el password de usuario tipo cadena
	 * @return autenticado Devuelve true si el usario se encuentra registrado, sino
	 *         devuelve false
	 * @throws Exception
	 *             Control de errores
	 */
	public static boolean login(String nombreUsuario, String password) throws Exception {
		boolean autenticado = false;
		Usuario t = Usuario.read(nombreUsuario, password);

		if (t != null) {

			autenticado = true;
		}

		return autenticado;

	}

	/**
	 * Metodo que comprueba que tipo de usario es, es decir administrador, o usuario
	 * normal.
	 * 
	 * @param nombre_usuario
	 *            Atributo para el nombre de usuario tipo cadena
	 * @param password
	 *            Atributo para el password de usuario tipo cadena
	 * @return rol devuelve que tipo de usuario es en función de su nombre de
	 *         usuario y password
	 * @throws Exception
	 *             Control de errores
	 */
	public static String tipo(String nombre_usuario, String password) throws Exception {
		String rol = null;
		Usuario t = Usuario.read(nombre_usuario, password);
		rol = t.getRol();
		return rol;

	}

	/**
	 * Metodo que comprueba si el usuario ha sido eliminado correctamente. No
	 * implementado
	 * 
	 * @param usuario
	 *            Usuario a eliminar
	 * @return Devuelve true si la eliminacion ha sido correcta
	 */
	public boolean eliminarUsuario(Usuario usuario) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo que permite la generacion de mensajes. No implementado
	 * 
	 * @param msg
	 *            Mensaje a generar
	 * @return Devuelve true si se ha generado bien el mensaje
	 */
	public boolean generarMensaje(String msg) {
		throw new UnsupportedOperationException();
	}

}