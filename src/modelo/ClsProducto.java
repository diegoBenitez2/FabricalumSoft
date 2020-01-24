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
 * @author DiegoB
 */
public class ClsProducto {
    //Se declara una variable de tipo ClsConexion para establecer la conexion
    controlador.ClsConexion conPro = new controlador.ClsConexion();
    //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd
    public PreparedStatement sqlPro;
    
    //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
    public ResultSet datosPro;
    

//Metodo para insertar datos en la tabla tbproducto en bd.
 public void  MtdguardarProducto(  String col_pro,Double ach_pro, Double alt_pro, int can_pro,int  tip_pro ){
    
     try{
     
 conPro.conectar();
 sqlPro= conPro.confa.prepareStatement("INSERT INTO `tbproducto` ( `col_pro`,`anc_pro`, `alt_pro`, `can_pro`, `cod_tip_pto_pro`) VALUES ( ?, ?, ?, ?,?);");
 sqlPro.setString(1, col_pro);
 sqlPro.setDouble(2,ach_pro);
 sqlPro.setDouble(3,alt_pro);
 sqlPro.setInt(4,can_pro);
 sqlPro.setInt(5,tip_pro);
 sqlPro.executeUpdate();

 conPro.cerrar();
 }
 catch(Exception errguapro){
 System.out.println("Error al guardar producto en clase producto: "+errguapro.getMessage());
 }

 }
 
//Metodo para actualizar la tabla tbproducto en bd.
public void   MtdActualizarProducto(String col_pro,Double ach_pro,Double alt_pro,int can_pro,int cod_tip_pto, int cod_pro){

    try{   
conPro.conectar();
sqlPro=conPro.confa.prepareStatement("update tbproducto set cod_tip_pto_pro=?,col_pro=?,anc_pro=?,alt_pro=?,can_pro=? where cod_pro=?");
sqlPro.setInt(1,cod_tip_pto);
sqlPro.setString(2,col_pro);
sqlPro.setDouble(3, ach_pro);
sqlPro.setDouble(4, alt_pro);
sqlPro.setInt(5, can_pro);
sqlPro.setInt(6, cod_pro);


sqlPro.executeUpdate();

conPro.cerrar();
        }
catch(Exception exActProfa){
System.out.println("Error al actualizar producto en clase producto: "+exActProfa.getMessage());}

}

   //Metodo para eliminar registros de la tabla tbproducto en bd. 
 public void  MtdEliminarProducto(int cod_pro){
 
try{
conPro.conectar();
sqlPro=conPro.confa.prepareStatement("delete from tbproducto where cod_pro=?");
sqlPro.setInt(1, cod_pro);
sqlPro.executeUpdate();

conPro.cerrar();
}
catch(Exception exEliProfa){
System.out.println("Error al eliminar Producto en clase producto: "+exEliProfa.getMessage());}

}
 
//Metodo para consultar los datos de la tabla tbproducto en bd.
public void MtdListarTablaProducto(){
        conPro.conectar();
        try {
            sqlPro = conPro.confa.prepareStatement("select cod_pro,des_tip_pto,ref_tip_pto,col_pro,anc_pro,alt_pro,can_pro from tbproducto as p inner join tbtipoproducto as tp on p.cod_tip_pto_pro = tp.cod_tip_pto ");
            sqlPro.executeQuery();
            datosPro = sqlPro.getResultSet();
            conPro.cerrar();

        } catch (Exception e) {
            System.out.println("Error al listar Producto en clase Producto"+ e.getLocalizedMessage());
        }}

//Busca el ultimo prodructo ingresado en la bd.
public void MtdListarProducto(){
        conPro.conectar();
        try {
            sqlPro = conPro.confa.prepareStatement("select cod_pro,des_tip_pto,ref_tip_pto,col_pro,anc_pro,alt_pro,can_pro from tbproducto as p inner join tbtipoproducto as tp on p.cod_tip_pto_pro = tp.cod_tip_pto order by cod_pro desc limit 1");
            sqlPro.executeQuery();
            datosPro = sqlPro.getResultSet();
            conPro.cerrar();

        } catch (Exception e) {
            System.out.println("Error al listar Producto en clase Producto"+ e.getLocalizedMessage());
        }}

  
 //Metodo para consultar los datos de l ultimo registro de la tabla tbproducto en bd.
 public void MtdTraerProducto(int cod_pro){
        conPro.conectar();
        try {
            sqlPro = conPro.confa.prepareStatement("select cod_pro,des_tip_pto,ref_tip_pto,col_pro,anc_pro,alt_pro,can_pro from tbproducto as p inner join tbtipoproducto as tp on p.cod_tip_pto_pro = tp.cod_tip_pto where cod_pro = ?" );
            sqlPro.setInt(1, cod_pro);
            sqlPro.executeQuery();
            datosPro = sqlPro.getResultSet();
            conPro.cerrar();

        } catch (Exception e) {
            System.out.println("Error al listar Producto en clase Producto"+ e.getLocalizedMessage());
        }
 
 }
        
//Metodo para consultar los datos de la tabla tbproducto por el codigo del producto.
public void MtdMostrarTablaProducto(int cod){
        conPro.conectar();
        try {
            sqlPro = conPro.confa.prepareStatement("select cod_pro,des_tip_pto,col_pro,anc_pro,alt_pro,can_pro from tbproducto as p inner join tbtipoproducto as tp on p.cod_tip_pto_pro = tp.cod_tip_pto where cod_pro = ?");
            sqlPro.setInt(1, cod);
            sqlPro.executeQuery();
            datosPro = sqlPro.getResultSet();
            conPro.cerrar();

        } catch (Exception e) {
            System.out.println("Error al mostrar Producto en clase Producto"+ e.getLocalizedMessage());
        }

 }

//Metodo para consultar la tabla tbtipoproducto trayendo los campos codigo y descpricion en bd.
public void MtdLLenarComboTipo(){
      conPro.conectar();
      try {
          sqlPro = conPro.confa.prepareStatement("select CONCAT( cod_tip_pto,'--',des_tip_pto) from tbtipoproducto");
          sqlPro.executeQuery();
          datosPro = sqlPro.getResultSet();
      } catch (Exception e) {
          System.out.println("Error al lenar combo tipo producto en clase producto: "+e.getLocalizedMessage());
          JOptionPane.showMessageDialog(null, "Error al llenar combo tipo producto en clase producto: "+e.getLocalizedMessage());
      }
  }
}
