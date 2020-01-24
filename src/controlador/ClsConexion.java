/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DiegoB
 */
public class ClsConexion {
      public Connection confa= null;//Objeto de la connexion.
    
    public void conectar(){
    String db= "jdbc:mysql://localhost:3306/bdurben";//controlador bd: mysql//nombre del servidor:puerto/nombre bd a conectar
        String usuario="root";
        String password="basedatos";
        try{
        //String controlador ACCESS= "sun.jdbc.odbc.JdbcObdcDriver";
        String controlador="com.mysql.jdbc.Driver";//Carga la libreria de conexion.
       
        Class.forName(controlador);//como instanciar  DriverManager.getConnection(db,usuario,password)la conexion "Controlador".
        confa= DriverManager.getConnection(db,usuario,password);//creo la conexion con la ruta de conexion.
        System.out.println("Conexion exitosa con la base de datos"+db);// mensaje de verificacion de la conexion.
        }
       
    catch(Exception errcon){
            System.out.println("Error en la conexion a la base de datos: "+errcon.getMessage());
    }
    }
    
    public void cerrar(){
    if(confa==null){
        try{
    confa.close();
    }
    catch(Exception errcer){
    System.out.println("Error al cerrar la conexion: "+errcer.getMessage());
    }
    }
    }
    
}
