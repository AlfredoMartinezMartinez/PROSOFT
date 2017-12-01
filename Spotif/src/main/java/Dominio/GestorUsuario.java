package Dominio;

public class GestorUsuario {

	/**
	 * 
	 * @param usuario
	 */
	public static boolean crearUsuario(String nombre,String apellidos,String login,String pass,String correo, String rol) throws Exception{
		// TODO - implement GestorUsuario.crearUsuario
		boolean registrado=false;
		int t=Usuario.insert(nombre,apellidos,login,pass,correo,rol);
		if(t==1)
			registrado=true;		
		
		return registrado;
		
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre_usuario
	 * @param password
	 */
	public static boolean login(String nombre_usuario, String password) throws Exception {
		// TODO - implement GestorUsuario.login
        boolean autenticado = false;
        Usuario t=Usuario.read(nombre_usuario,password);
        

        if(t != null){
            
        	autenticado = true;}
        
        return autenticado;
        
        //throw new UnsupportedOperationException();
	}
	
	public static String tipo(String nombre_usuario, String password) throws Exception {
		// TODO - implement ControlAcceso.Autenticar
                String rol = null;
                Usuario t=Usuario.read(nombre_usuario,password);
                rol=t.getRol();
		          
		//if(t != null)
                    
			
                
		return rol;
                
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param usuario
	 */
	

	public boolean eliminarUsuario(Usuario usuario){
		// TODO - implement GestorUsuario.eliminarUsuario
		throw new UnsupportedOperationException();
	}

}