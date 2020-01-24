/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DiegoB
 */
public class ClsCliente {
     //Se declara una variable de tipo ClsConexion para establecer la conexion
    private controlador.ClsConexion concli=new controlador.ClsConexion();
    
    //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd
    private PreparedStatement sqlCli;
    
    //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
    public ResultSet datosCli;
 

//Metodo para insertar datos en la tabla tbcliente en la bd
public void MtdGuardarCliente(int id_cl, String nom_cli, String ape_cli,String dir_cli, String ema_cli, String img_cli) {
    try{

        concli.conectar();
        sqlCli= concli.confa.prepareStatement("insert into tbcliente values(?,?,?,?,?,?)");
         if(img_cli==""){
        sqlCli.setInt(1, id_cl);
        sqlCli.setString(2, nom_cli);
        sqlCli.setString(3, ape_cli);
        sqlCli.setString(4, dir_cli);
        sqlCli.setString(5, ema_cli);
        sqlCli.setString(6, null);
       
        }
       
        else{
        sqlCli.setInt(1, id_cl);
        sqlCli.setString(2, nom_cli);
        sqlCli.setString(3, ape_cli);
        sqlCli.setString(4, dir_cli);
        sqlCli.setString(5, ema_cli);
        sqlCli.setString(6, img_cli);}
        
        sqlCli.executeUpdate();
        datosCli= sqlCli.getResultSet();
        concli.cerrar();
        
       }
    
    catch(Exception exGuaCli){
    System.out.println("Error al guardar los datos del cliente en ClsCliente: "+exGuaCli.getMessage());
    }
    
    
    }

//Metodo para actualizar la tabla tbcliente en bd
 public void MtdActualizarCliente( String nom_cli, String ape_cli, String dir_cli, String ema_cli, String img_cli,int id_cl){
  
        try{
            
    concli.conectar();
    sqlCli= concli.confa.prepareStatement("update tbcliente set nom_cli=?,ape_cli=?,dir_cli=?,ema_cli=?,fot_cli=? where id_cli=?");
    sqlCli.setString(1, nom_cli);
    sqlCli.setString(2, ape_cli);
    sqlCli.setString(3, dir_cli);
    if(ema_cli.length()==0){
     sqlCli.setString(4, null);
    }
    else{
     sqlCli.setString(4, ema_cli);
    }
   
    sqlCli.setString(5,img_cli);
    sqlCli.setInt(6, id_cl);
    sqlCli.executeUpdate();
    concli.cerrar();
    }
    catch(Exception exActCli){
    System.out.println("Error al actualizar cliente en la clase cliente: "+exActCli.getMessage());}
       
    }

//Metodo para eliminar datos en la tabla tbcliente en bd.
 public void MtdEliminarCliente(int id_cli){
       
   try{
    concli.conectar();
    sqlCli= concli.confa.prepareStatement("delete from tbcliente where id_cli=?");
    sqlCli.setInt(1, id_cli);
    sqlCli.executeUpdate();
   }
    catch(Exception exEliCli){
    System.out.println("Error al eliminar datos de cliente  la clase cliente: "+exEliCli.getMessage());}
  
    }
 
//Metodo para consultar los datos de la tabla tbcliente y tbtelefono_cliente en bd.
 public void MtdListarTablaCliente(){
     concli.conectar();
     try {
         sqlCli = concli.confa.prepareStatement("select id_cli, nom_cli, ape_cli, dir_cli ,ema_cli, num_fijo, num_mov from tbcliente as c inner join tbtelefono_cliente as tc on tc.id_cli_tel = c.id_cli;");
         sqlCli.executeQuery();
         datosCli = sqlCli.getResultSet();
         concli.cerrar();
        
         
     } catch (Exception e) {
            System.out.println("Error al listar Cliente en clase Cliente"+ e.getLocalizedMessage());

     }
     
}
 
 //Metodo para consultar la tabla tbcliente por el campo id en bd.
 public void MtdMostrarTablaCliente(int id){
     concli.conectar();
     try {
         sqlCli = concli.confa.prepareStatement("select id_cli, nom_cli, ape_cli, dir_cli ,ema_cli, num_fijo, num_mov from tbcliente as c inner join tbtelefono_cliente as tc on tc.id_cli_tel = c.id_cli where id_cli = ?");
         sqlCli.setInt(1, id);
         sqlCli.executeQuery();
         datosCli = sqlCli.getResultSet();
         concli.cerrar();
         
     } catch (Exception e) {
            System.out.println("Error al mostrar Cliente en clase Cliente"+ e.getLocalizedMessage());

     }
     
}
 
 //METODOS PARA LA EL TELEFONO DEL CLIENTE
 
 //Metodo para insertar datos en la tabla tbtelefono_cliente en bd.
public void MtdGuardarTelefono_cliente(String telf_cli, String telm_cli,int id_cli){
    concli.conectar();
    try {
        sqlCli=concli.confa.prepareStatement("insert into `tbtelefono_cliente`(`num_fijo`,`num_mov`,`id_cli_tel`) values(?,?,?)");
        if(telf_cli.length()==0 && telm_cli.length()==0){
         sqlCli.setString(1, null);
         sqlCli.setString(2, null);
        sqlCli.setInt(3, id_cli);
        }
        else if (telf_cli.length()==0){
        sqlCli.setString(1, null);
         sqlCli.setString(2, telm_cli);
        sqlCli.setInt(3, id_cli);
        }
        else if(telm_cli.length()==0){
         sqlCli.setString(1, telf_cli);
         sqlCli.setString(2, null);
        sqlCli.setInt(3, id_cli);
        }
        else{
        sqlCli.setString(1, telf_cli);   
        sqlCli.setString(2, telm_cli);
        sqlCli.setInt(3, id_cli);
        }
       
        sqlCli.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error al registrar telefono del cliente en clase cliente: "+e.getLocalizedMessage());
    }
    
}
 
 //Metodo para actualizar datos de la tabla tbtelefono_cliente en bd.
public void   MtdActualizarTelefonoCliente( String telf_cli, String telm_cli, int id_cli_tel){
  
        try{
            
    concli.conectar();
    sqlCli= concli.confa.prepareStatement("update tbtelefono_cliente set num_fijo=?,num_mov=? where id_cli_tel=?");
    if(telf_cli.length()==0){
        sqlCli.setString(1, null);
         sqlCli.setString(2, telm_cli);
         sqlCli.setInt(3, id_cli_tel);
    }
    else if (telm_cli.length()==0){
        sqlCli.setString(1, telf_cli);
        sqlCli.setString(2, null);
        sqlCli.setInt(3, id_cli_tel);
    }
    
    sqlCli.setString(1, telf_cli);
    sqlCli.setString(2, telm_cli);
    sqlCli.setInt(3, id_cli_tel);
    sqlCli.executeUpdate();
    concli.cerrar();
    }
    catch(Exception exActCli){
    System.out.println("Error al actualizar telefono del cliente en la clase cliente: "+exActCli.getMessage());}
       
    }

 //Metodo para eliminar datos en la tabla tbtelefono_cliente en bd.
 public void MtdEliminarTelefonoCliente(int id_cli){
       
   try{
    concli.conectar();
    sqlCli= concli.confa.prepareStatement("delete from tbtelefono_cliente where id_cli_tel=?");
    sqlCli.setInt(1, id_cli);
    sqlCli.executeUpdate();
   }
    catch(Exception exEliCli){
    System.out.println("Error al eliminar datos del telefono del cliente en la clase cliente: "+exEliCli.getMessage());}
  
    }


 
 
}
