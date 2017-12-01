package Persistencia;

import java.sql.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

import java.util.List;

public class AgenteUsuario {
	//instancia del agente
    protected static AgenteUsuario mInstancia=null;
    //Conexion con la base de datos
    protected static Connection mBD;
	//Identificador ODBC de la base de datos
    private static String url="jdbc:mysql://localhost:3307/spotif?user=root&password=root";
    //Driven para conectar con bases de datos MySQL 
    private static String driver="com.mysql.jdbc.Driver";
    
    //Constructor
    private AgenteUsuario()throws Exception {
    	conectar();
    		
    }
    
    //Implementacion del patron singleton
    //Este patron de diseÒo permite implementar clases de las cuales
    //solo existir una instancia
    //http://es.wikipedia.org/wiki/Singleton
     public static AgenteUsuario getAgente() throws Exception{
          if (mInstancia==null){
          mInstancia=new AgenteUsuario();
        }
        return mInstancia;
     }
 
    //Metodo para realizar la conexion a la base de datos 
    private void conectar() throws Exception {
         Class.forName(driver);
         mBD=DriverManager.getConnection(url);
    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception{
    	mBD.close();
    }

    //Metodo para realizar una insercion en la base de datos
    public int insert(String SQL) throws SQLException, Exception{ 
     	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
        int res=0;
    	try{
            res=stmt.executeUpdate();
            stmt.close();
    	    desconectar();
    	    
        }
         catch (SQLException e) {
              if (e instanceof SQLIntegrityConstraintViolationException) {
        // Duplicate entry
        System.out.println("cliente existe");
                } else {
        // Other SQL Exception
            }
        }
        
        return res; 
    	
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int delete(String SQL) throws SQLException,Exception{
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int update(String SQL) throws SQLException,Exception{
    	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    public Vector<Object> select(String SQL) throws SQLException,Exception{
		
		PreparedStatement select = mBD.prepareStatement(SQL);
		ResultSet s = select.executeQuery();
		Vector<Object> vec=new Vector<Object>();
		Vector<Object> auxiliar;
		while (s.next()) {
			auxiliar=new Vector<Object>();
			auxiliar.add((String)s.getString("nombre"));
			auxiliar.add((String)s.getString("apellidos")); 
            auxiliar.add((String)s.getString("login")); 
            auxiliar.add((String)s.getString("password"));
            auxiliar.add((String)s.getString("correo"));
            auxiliar.add((String)s.getString("tipo"));
			vec.add((Vector)auxiliar);
			
		}
                s.close();
		
		return vec;
		
		/*Metodo para realizar una busqueda o seleccion de informacion enla base de datos
	    *El método select develve un vector de vectores, donde cada uno de los vectores
	    *que contiene el vector principal representa los registros que se recuperan de la base de datos.
	    */	
	}
    public Vector<Object> selectcliente(String SQL) throws SQLException,Exception{
		conectar();
		PreparedStatement select = mBD.prepareStatement(SQL);
		ResultSet s = select.executeQuery();
		Vector<Object> vec=new Vector<Object>();
		Vector<Object> auxiliar;
		while (s.next()) {
			auxiliar=new Vector<Object>();
			auxiliar.add((String)s.getString("nombre"));
			auxiliar.add((String)s.getString("apellidos")); 
            auxiliar.add((String)s.getString("dni")); 
            auxiliar.add((String)s.getString("tlf")); 
			vec.add((Vector)auxiliar);
			
		}
                s.close();
                		
		return vec;
		
		/*Metodo para realizar una busqueda o seleccion de informacion enla base de datos
	    *El método select develve un vector de vectores, donde cada uno de los vectores
	    *que contiene el vector principal representa los registros que se recuperan de la base de datos.
	    */	
	}
}