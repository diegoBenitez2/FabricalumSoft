/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiegoB
 */
public class ClsDespiece {
         //Se declara una variable de tipo ClsConexion para establecer la conexion   
        controlador.ClsConexion condpc = new controlador.ClsConexion();
        //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd
        PreparedStatement sqldpc;
        //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
        public ResultSet datosdpc;
    
    //Metodo para insertar datos a la tabla tbdespiece en bd.
    public void MtdGuatdarDespiece(String des, String sis, String ref, String fec, String form, String can, String codDpc){
        try {
            condpc.conectar();
            sqldpc = condpc.confa.prepareStatement("insert into tbdespiece (des_dpc,sis_dpc,ref_dpc,fec_dpc,for_dpc,can_dpc,cod_dpc_mat) values(?,?,?,?,?,?,?)");
            sqldpc.setString(1, des);
            sqldpc.setString(2, sis);
            sqldpc.setString(3, ref);
             sqldpc.setString(4, fec);
            sqldpc.setString(5, form);
            sqldpc.setString(6, can);
            sqldpc.setString(7,codDpc );
            sqldpc.executeUpdate();
            condpc.cerrar();
            
        } catch (Exception e) {
            System.out.println("Error al guardar despiece el clase despiece: "+e.getLocalizedMessage());
        }
    
    }
    
    //Metodo para actualizar la tabla tbdespiece en bd.
    public void MtdActualizarDespiece(String des, String sis, String ref, String fec, String form, String can, String codDpc, int cod){
        try {
            condpc.conectar();
            sqldpc = condpc.confa.prepareStatement("update tbdespiece set des_dpc = ?, sis_dpc = ?, ref_dpc = ?, fec_dpc = ?,for_dpc = ? ,can_dpc = ?, cod_dpc_mat = ? where cod_dpc =?");
            sqldpc.setString(1, des);
            sqldpc.setString(2, sis);
            sqldpc.setString(3, ref);
            sqldpc.setString(4, form);
            sqldpc.setString(5, form);
            sqldpc.setString(6, can);
            sqldpc.setString(7,codDpc );
            sqldpc.setInt(8, cod);
            sqldpc.executeUpdate();
            condpc.cerrar();
        } catch (Exception e) {
             System.out.println("Error al actualizar despiece el clase despiece: "+e.getLocalizedMessage());
        }
    }
    
    //Metodo para eliminar registros en la tabla tbdespiece en bd.
    public void MtdEliminarDespiece(int cod){
        try {
            condpc.conectar();
            sqldpc = condpc.confa.prepareStatement("delete from tbdespiece where cod_dpc = ?");
            sqldpc.setInt(1, cod);
            sqldpc.executeUpdate();
            condpc.cerrar();
        } catch (Exception e) {
             System.out.println("Error al eliminar despiece el clase despiece: "+e.getLocalizedMessage());
        }
    
    }
    
    //Metodo para consultar los datos de la tabla despiece en bd.
    public void MtdListarDespiece(){
        try {
            condpc.conectar();
            sqldpc = condpc.confa.prepareStatement("select * from tbdespiece ");
            sqldpc.executeQuery();
            datosdpc = sqldpc.getResultSet();
            condpc.cerrar();
            
        } catch (Exception e) {
            System.out.println("Error al listar despiece el clase despiece: "+e.getLocalizedMessage());
        }
    
    }
}
