package persistencia;

//import java.awt.List;
import java.sql.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

public class Agente_Musica {
	
	//instancia del agente
    protected static Agente_Musica mInstancia=null;
    //Conexion con la base de datos
    protected static Connection mBD;
	//Identificador ODBC de la base de datos
    private static String url="jdbc:mysql://localhost:3307/spotif?user=root&password=root";
    //Driven para conectar con bases de datos MySQL 
    private static String driver="com.mysql.jdbc.Driver";
    
  //Constructor
    private Agente_Musica()throws Exception {
    	conectar();
    		
    }
    
  //Implementacion del patron singleton
    //Este patron de diseño permite implementar clases de las cuales
    //solo existir una instancia
    //http://es.wikipedia.org/wiki/Singleton
     public static Agente_Musica getAgente() throws Exception{
          if (mInstancia==null){
          mInstancia=new Agente_Musica();
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

}