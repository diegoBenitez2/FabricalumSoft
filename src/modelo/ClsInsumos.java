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
public class ClsInsumos {
    //Se declara una variable de tipo ClsConexion para establecer la conexion
    controlador.ClsConexion coninsu =  new controlador.ClsConexion();
    
    //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd.
    PreparedStatement sqlInsu;
    
    //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
    public ResultSet datosinsu;
    
    //Metodo para insertar datos a la tabla tbmateriales en bd.
    public void MtdGuardarMateriales(String nom_mat,String tip_mat, String uso_mat, String ref_mat,String col_mat,String fab_mat,int can_mat,float pre_mat,String img_mat, int cod_dpc_mat )
      {


          try{


      coninsu.conectar();
      sqlInsu= coninsu.confa.prepareStatement("INSERT INTO `tbmateriales` (`nom_mat`, `tip_mat`, `uso_mat`, `ref_mat`, `col_mat`,`fab_mat`, `can_mat`,`pre_mat`,`img_mat`,`cod_dpc_mat`) VALUES (?, ?, ?,?,?, ?, ?, ?,?,?) ");
      sqlInsu.setString(1,nom_mat );
      sqlInsu.setString(2,tip_mat);
      sqlInsu.setString(3, uso_mat);
      sqlInsu.setString(4, ref_mat);
      sqlInsu.setString(5, col_mat);
      sqlInsu.setString(6, fab_mat);
      sqlInsu.setInt(7, can_mat);
      sqlInsu.setFloat(8, pre_mat);


     if(img_mat==""){
         sqlInsu.setString(9, null);
     }
     else{
      sqlInsu.setString(9, img_mat);}
        sqlInsu.setInt(10, cod_dpc_mat);
       sqlInsu.executeUpdate();

      coninsu.cerrar();

      }
      catch(Exception e){
      System.out.println("Error al  guardar materiales "+e.getMessage());
      }

      }

    //Metodo para actualizar la tabla tbmateriales en bd.
    public void MtdActualizarMateriales(String nom_mat,String tip_mat, String uso_mat, String ref_mat,String col_mat,String fab_mat,int can_mat,float pre_mat,String img_mat,int cod_dpc_mat, int cod_mat ){

       try{

   coninsu.conectar();
   sqlInsu=coninsu.confa.prepareStatement("update tbmateriales set nom_mat=?,tip_mat=?,uso_mat=?,ref_mat=?,col_mat=?,fab_mat=?,can_mat=?,pre_mat=?,img_mat=?,cod_dpc_mat =? where cod_mat=?");
   sqlInsu.setString(1,nom_mat );
      sqlInsu.setString(2,tip_mat);
      sqlInsu.setString(3, uso_mat);
      sqlInsu.setString(4, ref_mat);
      sqlInsu.setString(5, col_mat);
      sqlInsu.setString(6, fab_mat);
      sqlInsu.setInt(7, can_mat);
      sqlInsu.setFloat(8, pre_mat);


     if(img_mat.length()==0){
         sqlInsu.setString(9, null);
     }
     else{
      sqlInsu.setString(9, img_mat);}
     sqlInsu.setInt(10, cod_dpc_mat);
      sqlInsu.setInt(11,cod_mat);
      sqlInsu.executeUpdate();

      coninsu.cerrar();

   }
   catch(Exception e){
   System.out.println("Error al actualizar materiales: "+e.getMessage());
   }
      }
   
    //Metodo para eliminar registros en la tabla tbmateriales en bd.
    public void MtdEliminarMateriales(String cod_mat){

    try{
   coninsu.conectar();
   sqlInsu=coninsu.confa.prepareStatement("delete from tbmateriales where cod_mat=?");
   sqlInsu.setInt(1, Integer.parseInt(cod_mat));

   sqlInsu.executeUpdate();

   coninsu.cerrar();
       }
   catch(NumberFormatException | SQLException exElMatfa){
   System.out.println("Error al eliminar materiales: "+exElMatfa.getMessage());
   }


   }
    
    //Metodo para consultar datos de la tabla tbmateriales por campo codigo.
    public void MtMostrarTablaInsumo(int cod){
    try{
    coninsu.conectar();
    sqlInsu=coninsu.confa.prepareStatement("select * from tbmateriales where cod_mat = ?");
    sqlInsu.setInt(1, cod);
    sqlInsu.executeQuery();
    datosinsu=sqlInsu.getResultSet();
    coninsu.cerrar();
    
    }
    catch(Exception ex){
     System.out.println("Error al mostrar tabla insumos en clase insumos: s"+ ex.getLocalizedMessage());
    }
}
}
