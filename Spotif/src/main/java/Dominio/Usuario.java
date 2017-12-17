package Dominio;
import java.util.Vector;

import Persistencia.*;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String nombre_usuario;
	private String password;	
	private String correo;
	private String rol;
	
	public Usuario(){
		this.nombre_usuario = null;
		this.password = null;
        this.rol= null;
                        
	}
        
        //Constructor para la creación de un Personal
	public Usuario(String nombre, String apellidos,String nombre_usuario,String password,String correo,String rol){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_usuario=nombre_usuario;
		this.password=password;		
		this.correo=correo;
        this.rol= rol;
                
	}
	
	//Selección de un personal de la base de datos a partir del mLogin y el mPassword
	public static Usuario read(String nombre_usuario, String password) throws Exception{
		String l,g;
		Usuario u = null;
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT nombre, apellidos, login, password, correo, tipo FROM usuario WHERE login = '"+nombre_usuario+"' COLLATE utf8_bin AND password = '"+password+"' COLLATE utf8_bin";
		
		AgenteUsuario a = AgenteUsuario.getAgente();
		Vector<Object> res = a.select(SQL_Consulta);
		
		if (res.size() == 1){
			aux = (Vector<Object>) res.elementAt(0);                        
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1),(String) aux.elementAt(2),(String) aux.elementAt(3),(String) aux.elementAt(4),(String) aux.elementAt(5));
		}
		return u;
	}
     
	//Inserción de un nuevo personal en la base de datos
	public static int insert(String nombre,String apellidos,String login,String pass,String correo, String rol) throws Exception{
		int PersonalCorrecto=0;
		AgenteUsuario agent= AgenteUsuario.getAgente();
		agent.insert("INSERT INTO usuario VALUES('"+nombre+"','"+apellidos+"','"+login+"','"+pass+"','"+correo+"','"+rol+"');");
		if (GestorUsuario.login(nombre,pass)){
			PersonalCorrecto=1;
		}
		
		return PersonalCorrecto;
		
		/*Debe implementarse la lógica para insertar el contenido de un objeto personal en la base de datos
		 *Los objetos de la capa de dominio se comunican con el agente para enviarle sus peticiones
		 *AYUDA1: la consulta para realizar la inserción es la siguiente
		 * "INSERT INTO personal VALUES('"+this.mLogin+"','"+this.mPassword+"');"
		 *AYUDA2: Del mismo modo que para consultar la información, el agente provee de un método "select",
		 *para hacer una inserción el agente provee de un método "insert"
		 */
	}
        
        public String getRol(){
        return rol;
        }
    
        public void setRol(String rol){
        this.rol= rol;
        }

}