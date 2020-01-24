/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author DiegoB
 */
public class ClsTipoProducto {
    //Se declara una variable de tipo ClsConexion para establecer la conexion
    controlador.ClsConexion conTip= new controlador.ClsConexion();
    
    //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd
    PreparedStatement sqlTip ;
    
    //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
    public ResultSet datosTip;
    
    //Metodo para insertar datos en la tabla tbtipoproducto en bd.
    public void MtdGuardarTipoProducto(String des_tip,String sis_tip, String ref_tip,String img_tip){
        
        try {
            conTip.conectar();
            sqlTip = conTip.confa.prepareStatement("insert into tbtipoproducto (des_tip_pto, sis_tip_pto,ref_tip_pto,img_tip_pto)values(?,?,?,?);");
            sqlTip.setString(1, des_tip);
            sqlTip.setString(2, sis_tip);
            sqlTip.setString(3, ref_tip);
              if(img_tip.length()==0){
                sqlTip.setString(4, null);
            }
            else{
               sqlTip.setString(4, img_tip);
            }
          
            sqlTip.executeUpdate();
            datosTip = sqlTip.getResultSet();
            conTip.cerrar();


        } catch (Exception e) {
            System.out.println("Error al guardar tipo de producto en clase ClsTipoProducto: "+e.getLocalizedMessage());
        }
    }
    
    //Metodo para actualizar la tabla tbtipoproducto en bd.
    public void MtdActualizarTipoproducto(int cod_tip ,String des_tip,String sis_tip, String ref_tip,String img_tip){
    
        try {
            conTip.conectar();
            sqlTip = conTip.confa.prepareStatement("update tbtipoproducto set des_tip_pto=?,sis_tip_pto=?,ref_tip_pto=?,img_tip_pto=? where cod_tip_pto=?;");
            sqlTip.setString(1, des_tip);
            sqlTip.setString(2, sis_tip);
            sqlTip.setString(3, ref_tip);
            if(img_tip.length()==0){
                sqlTip.setString(4, null);
            }
            else{
               sqlTip.setString(4, img_tip);
            }
            sqlTip.setInt(5, cod_tip);
            sqlTip.executeUpdate();
            datosTip = sqlTip.getResultSet();
            conTip.cerrar();

        } catch (Exception e) {
             System.out.println("Error al actuailizar tipo de producto en clase ClsTipoProducto: "+e.getLocalizedMessage());

        }
    }
    
    //Metodo para eliminar registros de la tabla tbtipoprodcuto en bd.
    public void MtdEliminarTipoProducto(int cod_tip){
        try {
            conTip.conectar();
            sqlTip = conTip.confa.prepareStatement("delete from tbtipoproducto where cod_tip_pto = ?;");
            sqlTip.setInt(1, cod_tip);
            sqlTip.executeUpdate();
            conTip.cerrar();
        } catch (Exception e) {
            System.out.println("Error al eliminar tipo de producto en clase ClsTipoProducto: "+e.getLocalizedMessage());

        }
    
    }
    
    //Metodo para consultar todos los registros de la tabla tbtipoproducto en bd.
    public void MtdListarTipPro(){
        try {
            conTip.conectar();
            sqlTip = conTip.confa.prepareStatement("select * from tbtipoproducto;");
            sqlTip.executeQuery();
            datosTip = sqlTip.getResultSet();
            conTip.cerrar();
        } catch (Exception e) {
            System.out.println("Error al listar tipo de producto en clase ClsTipoProducto: "+e.getLocalizedMessage());

        }
    }
}
