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
	 * Atributos de Usuario que serán almacenados en la Base de Datos
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
		int num = agent.insert("INSERT INTO usuario VALUES('" + nombre + "','" + apellidos + "','" + login + "','"
				+ pass + "','" + correo + "','" + rol + "');");
		if (num != PersonalCorrecto) {
			if (GestorUsuario.login(login, pass)) {
				PersonalCorrecto = 1;
			}			
		}
		return PersonalCorrecto;

	}

	/**
	 * Metodos Getters/Setters
	 * 
	 */
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * metodo equals para comparar dos objetos usuario
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombre_usuario == null) {
			if (other.nombre_usuario != null)
				return false;
		} else if (!nombre_usuario.equals(other.nombre_usuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

}