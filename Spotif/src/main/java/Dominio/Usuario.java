package Dominio;

import java.util.Vector;

import Persistencia.*;

/**
 * Clase que permite crear objetos usuario.
 * 
 * @author PROSOFT
 *
 */
public class Usuario {
	private String nombre;
	private String apellidos;
	private String nombre_usuario;
	private String password;
	private String correo;
	private String rol;

	public Usuario() {
		this.nombre_usuario = null;
		this.password = null;
		this.rol = null;
	}

	/**
	 * Atributos de Usuario que ser�n almacenados en la Base de Datos
	 * 
	 * @param nombre
	 *            Atributo Nombre
	 * @param apellidos
	 *            Atributo Apellidos
	 * @param nombre_usuario
	 *            Atributo Login
	 * @param password
	 *            Atributo password
	 * @param correo
	 *            Atributo email
	 * @param rol
	 *            Atributo rol
	 */
	public Usuario(String nombre, String apellidos, String nombre_usuario, String password, String correo, String rol) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.correo = correo;
		this.rol = rol;
	}

	/**
	 * Metodo que lee un usuario de la base de datos a partir del nombre de usuario
	 * y password
	 * 
	 * @param nombre_usuario
	 *            Login
	 * @param password
	 *            Password
	 * @return u Usuario con todos sus atributos
	 * @throws Exception
	 *             Control de error
	 */
	public static Usuario read(String nombre_usuario, String password) throws Exception {
		String l, g;
		Usuario u = null;
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT nombre, apellidos, login, password, correo, tipo FROM usuario WHERE login = '"
				+ nombre_usuario + "' COLLATE utf8_bin AND password = '" + password + "' COLLATE utf8_bin";

		AgenteUsuario a = AgenteUsuario.getAgente();
		Vector<Object> res = a.select(SQL_Consulta);

		if (res.size() == 1) {
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1), (String) aux.elementAt(2),
					(String) aux.elementAt(3), (String) aux.elementAt(4), (String) aux.elementAt(5));
		}
		return u;
	}

	/**
	 * Metodo que introduce en la base de datos un nuevo usuario
	 * 
	 * @param nombre
	 *            Nombre usuario
	 * @param apellidos
	 *            Apellidos usuario
	 * @param login
	 *            Login usuario
	 * @param pass
	 *            Password usuario
	 * @param correo
	 *            Correo Usuario
	 * @param rol
	 *            Rol usuario
	 * @return PersonalCorrecto Numero que identifica si esta registrado o no el
	 *         usuario
	 * @throws Exception
	 *             Control de errores
	 */
	public static int insert(String nombre, String apellidos, String login, String pass, String correo, String rol)
			throws Exception {
		int PersonalCorrecto = 0;
		AgenteUsuario agent = AgenteUsuario.getAgente();
		agent.insert("INSERT INTO usuario VALUES('" + nombre + "','" + apellidos + "','" + login + "','" + pass + "','"
				+ correo + "','" + rol + "');");
		if (GestorUsuario.login(nombre, pass)) {
			PersonalCorrecto = 1;
		}
		return PersonalCorrecto;

		/*
		 * Debe implementarse la l�gica para insertar el contenido de un objeto
		 * personal en la base de datos Los objetos de la capa de dominio se comunican
		 * con el agente para enviarle sus peticiones AYUDA1: la consulta para realizar
		 * la inserci�n es la siguiente
		 * "INSERT INTO personal VALUES('"+this.mLogin+"','"+this.mPassword+"');"
		 * AYUDA2: Del mismo modo que para consultar la informaci�n, el agente provee
		 * de un m�todo "select", para hacer una inserci�n el agente provee de un
		 * m�todo "insert"
		 */
	}

	/**
	 * Metodo que devuelve el tipo de usuario
	 * 
	 * @return rol Devuelve el rol del usuario
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Metodo que permite establecer el tipo de usuario
	 * 
	 * @param rol
	 *            Cambia rol del usuario
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

}