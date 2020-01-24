/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Propietario
 */
public class ClsIngreso {
    
    //Se declara una variable de tipo ClsConexion para establecer la conexion
    controlador.ClsConexion conx = new  controlador.ClsConexion();
    
  //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd
  public PreparedStatement Sql;  
  
  //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
  public ResultSet datos;
 
  //Variable de tipo boolean
  public boolean ejecutado;
  
  //Variable de tipo cadena.
  public String mensaje;
  
  

  //Metodo para insertar datos en la tabla  tbsesion en bd
  public void MtdGuardarAdmi(String id,String usu, String pass, String nom, String ema,String fec){
      try {
          conx.conectar();
          Sql = conx.confa.prepareStatement("insert into tbsesion  values(?,?,?,?,?,?)");
          Sql.setString(1, id);
          Sql.setString(2, usu);
          Sql.setString(3, pass);
          Sql.setString(4, nom);
          Sql.setString(5, ema);
          Sql.setString(6, fec);
          Sql.executeUpdate();
          conx.cerrar();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Error al guardar administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);

      }
  }
  
  //Metodo para actualizar la tabla tbsesion en bd.
  public void MtdActuaAdmi(String usu,String nom, String ema, String cod_usu){
      try {
          conx.conectar();
          Sql = conx.confa.prepareStatement("update tbsesion set usu_ses =?,nom_usu_ses=?,ema_ses=? where id_usu_ses =?");
          Sql.setString(1, usu);
          Sql.setString(2, nom);
          Sql.setString(3, ema);
          Sql.setString(4, cod_usu);
          Sql.executeUpdate();
          conx.cerrar();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error al actualizar administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);

      }
  }
  
  //Metodo para eliminar registros de la tabla tbsesion por campo identificacion en bd.
  public void MtdElminarAdm(String cod_usu){
      try {
          conx.conectar();
          Sql= conx.confa.prepareStatement("delete from tbsesion where id_usu_ses =?");
          Sql.setString(1, cod_usu);
          Sql.executeQuery();
          conx.cerrar();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Error al eliminar administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);

      }
  
  }
  
  //Metodo para consultar la tabla tbsesion por campo de Usuario y contraseña en bd.
  public void MtdbuscarUsuPass(String pass,String usu){
  try{
  conx.conectar();
  Sql=conx.confa.prepareStatement("select * from tbsesion  where pss_ses = ? and usu_ses=?");
  Sql.setString(1,pass);
  Sql.setString(2, usu);
  Sql.executeQuery();
  datos=Sql.getResultSet();
  conx.cerrar();
  }
  catch(Exception ex){
  conx.cerrar();
  System.out.print("error"+ex.getMessage());
  }
  
  }
  
  //Metodo para consultar datos en la tabla tbsesion po campo de identificacion.
  public void MtdBuscarAdm(String id){
      try {
          conx.conectar();
          Sql = conx.confa.prepareStatement("select * from tbsesion where id_usu_ses=? or usu_ses=?");
          Sql.setString(1, id);
          Sql.setString(2, id);
          Sql.executeQuery();
          datos = Sql.getResultSet();
          conx.cerrar();
          
          
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error al buscar administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);
      }
  }
  
  //Metodo para consultar la tabla tbsesion donde el usuario o contraseña sean iguales pero diferente identificacion en bd
  public void MtdValidarUsu(String id, String usu,String ema){
      try {
          conx.conectar();
            Sql = conx.confa.prepareStatement("select id_usu_ses, usu_ses,ema_ses  from tbsesion where id_usu_ses != ? and (usu_ses = ? or  ema_ses = ?)");
          Sql.setString(1, id);
          Sql.setString(2, usu);
          Sql.setString(3, ema);
          Sql.executeQuery();
          datos = Sql.getResultSet();
          conx.cerrar();
          
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Error al validar administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);

      }
  }
  
  //Metodo para consultar la tabla tbsesion trayendo la contraseña actual por campo identificacion en bd.
 public void MtdValidarPass(String id_usu){
     try {
         conx.conectar();
         Sql = conx.confa.prepareStatement("select pss_ses from tbsesion where id_usu_ses = ?");
         Sql.setString(1, id_usu);
         Sql.executeQuery();
         datos = Sql.getResultSet();
         conx.cerrar();
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Error al validar conraseña de administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);
     }
 }
 
//Metodo para actualizar el campo contraseña en tabla tbsesion en bd.
  public void MtdActuPass(String id_usu, String pss){
      try {
          conx.conectar();
          Sql = conx.confa.prepareStatement("update tbsesion set pss_ses =? where id_usu_ses = ?");
          Sql.setString(1, pss);
          Sql.setString(2, id_usu);
          Sql.executeUpdate();
          conx.cerrar();
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar contraseñade  administrador en clase Ingreso: "+e.getLocalizedMessage(),"Administrador",JOptionPane.ERROR_MESSAGE);

      }
  }
}
